package crowl.news;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class News {
	public static void main(String[] args) throws IOException, InterruptedException {
		InetAddress ia = null;		// 접속할 서버의 주소를 저장할 변수
		Socket sock = null;		// 서버에 접속할 소켓 변수
		PrintWriter out = null;		// 테이터를 전송할  Write 변수
		Pattern p = Pattern.compile("(?<=(&oid=|\\?oid=)|(&aid=|\\?aid=))[\\d]+");
		ArrayList<String> idlist = new ArrayList<>();
		String idid = "";
		int a = 1;
		int sid1 = 0;
		int sid2 = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("1.정치 2.경제 3.사회 4.문화");
		int chooese = sc.nextInt();
		if (chooese == 1) {
			sid1 = 100;
			sid2 = 269;
		}
		if (chooese == 2) {
			sid1 = 101;
			sid2 = 263;
		}
		if (chooese == 3) {
			sid1 = 102;
			sid2 = 257;
		}
		if (chooese == 4) {
			sid1 = 103;
			sid2 = 245;
		}
		System.out.println("시작날짜");
		String d1 = sc.next();
		System.out.println("끝 날짜");
		String d2 = sc.next();

		test calcal = new test(d1, d2);
		for (int i : calcal.arrayList) {
			int check = 0;
			while (check == 0) {
				String link = "https://news.naver.com/main/list.nhn?sid1=" + sid1 + "&sid2=" + sid2
						+ "&mid=shm&mode=LS2D&date=" + i + "&page=" + a;
				Document doc = Jsoup.connect(link).get();
				Elements element = doc.select("div.list_body");
				for (Element element1 : element.select("dt")) {
					if (element1.className().equals("photo")) {
						continue;
					}
					Elements element2 = element1.select("a");
					String title = element2.text();
					link = element2.attr("href");
					Matcher m = p.matcher(link);
					while (m.find()) {
						String id = m.group();
						idid = idid + id;
					}
					if (idlist.contains(idid)) {
						a = 0;
						check = 1;
						break;
					}
					idlist.add(idid);
					doc = Jsoup.connect(link).get();
					Elements article = doc.select("div._article_body_contents");
					NewsUI newsinfo = new NewsUI(title, article.text(), link, idid);
					Gson gson = new Gson();
					String json = gson.toJson(newsinfo);
					try{
						// 서버 주소생성
						ia = InetAddress.getByName("127.0.0.1");
						// 서버 연결
						sock = new Socket(ia, 9999);
						// 서버에 메세지 전송
						out = new PrintWriter(sock.getOutputStream());
						out.println(json);
						out.flush();
						// 접속 끊기
						sock.close();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					//System.out.println(json);
					idid = "";
				}
				System.out.println("현재 페이지: " + a);
				Thread.sleep(1000);
				a++;
			}
		}

		sc.close();
	}
}

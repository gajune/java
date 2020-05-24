package crowl.moive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MoiveMain {
	String URL = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
	Document doc = null;
		public List<String> getMoive() {
			List<String> ranking = new ArrayList<String>();
			try {
				doc = Jsoup.connect(URL).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements element = doc.select("div.tit3");
			for(Element el : element.select("a") ){
				ranking.add(el.text());			
			}
			return ranking;
			}
}


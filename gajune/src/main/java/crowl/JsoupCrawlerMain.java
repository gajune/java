package crowl;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * <pre>
 * crowl 
 * JsoupCrawlerMain.java
 *
 * 설명 : jsoup 이용
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class JsoupCrawlerMain {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://sports.news.naver.com/tennis/news/read.nhn?oid=001&aid=0009842744").get();
        System.out.println(doc.title());
        System.out.println(doc.getElementById("newsEndContents"));
    }
}

package crowl.moive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crowl.Collect;

/**
 * <pre>
 * crowl.moive 
 * MoiveMain.java
 *
 * 설명 : 영화순위 불러옴
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class MoiveMain extends Collect {
	String URL = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
	Document doc = null;
		public List<Object> getMoive() {
			List<Object> ranking = new ArrayList<Object>();
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


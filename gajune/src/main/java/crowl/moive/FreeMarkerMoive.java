package crowl.moive;

import static spark.Spark.get;
import static spark.Spark.modelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * crowl.moive 
 * FreeMarkerMoive.java
 *
 * 설명 : 프리마커
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class FreeMarkerMoive {
    public static void main(String args[]) throws IOException {
    	MoiveMain mm = new MoiveMain();
        get("/rank", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", mm.getMoive());

            // The hello.ftl file is located in directory:
            // src/test/resources/spark/examples/templateview/freemarker
            return modelAndView(attributes, "movierank.ftl");
        }, new FreeMarkerMoiveEngine());
    }
}
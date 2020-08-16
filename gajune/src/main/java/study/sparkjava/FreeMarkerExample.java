package study.sparkjava;

import static spark.Spark.get;
import static spark.Spark.modelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import crowl.worldcovid.WorldCovid19;

/**
 * <pre>
 * study.sparkjava 
 * FreeMarkerExample.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class FreeMarkerExample {

    public static void main(String args[]) throws IOException {
    	WorldCovid19 world = new WorldCovid19();

        get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello FreeMarker World");

            // The hello.ftl file is located in directory:
            // src/test/resources/spark/examples/templateview/freemarker
            return modelAndView(attributes, "hello.ftl");
        }, new FreeMarkerTemplateEngine());
        
        get("/covid", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", world.countryCode());

            // The hello.ftl file is located in directory:
            // src/test/resources/spark/examples/templateview/freemarker
            return modelAndView(attributes, "countrycode.ftl");
        }, new FreeMarkerTemplateEngine());
        
        
    }
}
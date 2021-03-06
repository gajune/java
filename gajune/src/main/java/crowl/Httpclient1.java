package crowl;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
/**
 * <pre>
 * crowl 
 * Httpclient1.java
 *
 * 설명 : httpclient 사용
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class Httpclient1 {
	
    
    private static final String USER_AGENT = "Mozila/5.0";
    private static final String GET_URL = "http://www.google.com";    
 
    public static void sendGet() throws ClientProtocolException, IOException {
        
        //http client 생성
        CloseableHttpClient httpClient = HttpClients.createDefault();
 
        //get 메서드와 URL 설정
        HttpGet httpGet = new HttpGet(GET_URL);
    }
}

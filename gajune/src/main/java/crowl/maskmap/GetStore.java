package crowl.maskmap;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;

import study.db.annotation.HibernateAnnotationUtil;

public class GetStore {
	public static void main(String[] args) {
		int num = 1;
		HttpClient client = HttpClients.createDefault();
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();

		while (true) {
			HttpGet request = new HttpGet(
					"https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=" + num + "&perPage=500");
			try {
				// 필요에 따라서는 헤더 추가
				// request.addHeader("Content-type", "application/json");

				// 요청
				HttpResponse response = client.execute(request);

				// 응답
				String result = EntityUtils.toString(response.getEntity());
				Gson gson = new Gson();
				MaskInfor mask = gson.fromJson(result, MaskInfor.class);
				List<StoreInfo> storeInfos = mask.getStoreInfos();
				if (storeInfos.size() == 0)
					break;
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				for (StoreInfo object : storeInfos) {
					session.save(object);
				}
				session.getTransaction().commit();
				session.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			num++;
		}

	}
}
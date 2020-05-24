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

import study.DB.hbm.annotation.HibernateAnnotationUtil;

public class GetSales {
	public static void main(String[] args) {
		int num = 1;
		HttpClient client = HttpClients.createDefault();
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();

		while (true) {
			HttpGet request = new HttpGet(
					"https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/sales/json?page=" + num + "&perPage=500");
			try {
				// 필요에 따라서는 헤더 추가
				// request.addHeader("Content-type", "application/json");

				// 요청
				HttpResponse response = client.execute(request);

				// 응답
				String result = EntityUtils.toString(response.getEntity());
				Gson gson = new Gson();
				Storestate mask = gson.fromJson(result, Storestate.class);
      		 	List<SalesList> saleslist = mask.getSales();
				if (saleslist.size() == 0)
					break;
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				for (SalesList object : saleslist) {
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
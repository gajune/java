package crowl.maskmap.model;

import java.util.List;

/**
 * <pre>
 * crowl.maskmap.model 
 * Storestate.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class Storestate {
	String count;
	String page;
	List<SalesList> sales;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public List<SalesList> getSales() {
		return sales;
	}
	public void setSales(List<SalesList> sales) {
		this.sales = sales;
	}
}

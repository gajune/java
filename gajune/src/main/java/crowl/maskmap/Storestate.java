package crowl.maskmap;

import java.util.List;

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

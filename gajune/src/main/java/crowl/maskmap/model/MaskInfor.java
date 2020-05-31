package crowl.maskmap.model;

import java.util.List;

/**
 * <pre>
 * crowl.maskmap.model 
 * MaskInfor.java
 *
 * 설명 : 
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class MaskInfor {
	int count;
	int page;
	List<StoreInfo> storeInfos;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<StoreInfo> getStoreInfos() {
		return storeInfos;
	}

	public void setStoreInfos(List<StoreInfo> storeInfos) {
		this.storeInfos = storeInfos;
	}
}

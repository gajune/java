package crowl.maskmap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * crowl.maskmap.model 
 * SalesList.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
@Entity
@Table(name = "StoreState")
public class SalesList {
	@Id
	@Column(name = "code")
	String code;

	@Column(name = "created_at")
	String created_at;

	@Column(name = "remain_stat")
	String remain_stat;

	@Column(name = "stock_at")
	String stock_at;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getRemain_stat() {
		return remain_stat;
	}

	public void setRemain_stat(String remain_stat) {
		this.remain_stat = remain_stat;
	}

	public String getStock_at() {
		return stock_at;
	}

	public void setStock_at(String stock_at) {
		this.stock_at = stock_at;
	}
}

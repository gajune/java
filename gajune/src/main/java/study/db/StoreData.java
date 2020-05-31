package study.db;

/**
 * <pre>
 * study.db 
 * StoreData.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class StoreData {
	String code;
	String lat;
	String lng;
	String remain_stat;
	String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getRemain_stat() {
		return remain_stat;
	}
	public void setRemain_stat(String remain_stat) {
		this.remain_stat = remain_stat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

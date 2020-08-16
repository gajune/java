package crowl.worldcovid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * crowl.worldcovid.model 
 * CountryStatus.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 7. 5.
 * @author : user
 * @version : v1.0
 */
@Entity
@Table(name = "CountryStatus")
public class CountryStatus {

	@Id
	@Column(name = "id")
	String id;
	
	@Column(name = "Country")
	String Country;
	
	@Column(name = "CountryCode")
	String CountryCode;
	
	@Column(name = "Province")
	String Province;
	
	@Column(name = "City")
	String City;
	
	@Column(name = "CityCode")
	String CityCode;
	
	@Column(name = "Lat")
	String Lat;
	
	@Column(name = "Lon")
	String Lon;
	
	@Column(name = "Confirmed")
	String Confirmed;
	
	@Column(name = "Deaths")
	String Deaths;
	
	@Column(name = "Recovered")
	String Recovered;
	
	@Column(name = "Active")
	String Active;
	
	@Column(name = "Date")
	String Date;
	
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCityCode() {
		return CityCode;
	}
	public void setCityCode(String cityCode) {
		CityCode = cityCode;
	}
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	public String getLon() {
		return Lon;
	}
	public void setLon(String lon) {
		Lon = lon;
	}
	public String getConfirmed() {
		return Confirmed;
	}
	public void setConfirmed(String confirmed) {
		Confirmed = confirmed;
	}
	public String getDeaths() {
		return Deaths;
	}
	public void setDeaths(String deaths) {
		Deaths = deaths;
	}
	public String getRecovered() {
		return Recovered;
	}
	public void setRecovered(String recovered) {
		Recovered = recovered;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(long l, String country) {
		this.id = l + country;
	}
	

}

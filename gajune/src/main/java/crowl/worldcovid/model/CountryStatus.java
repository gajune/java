package crowl.worldcovid.model; 


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
public class CountryStatus {
	String Country;
	String CountryCode;
	String Province;
	String City;
	String CityCode;
	String Lat;
	String Lon;
	String Confirmed;
	String Deaths;
	String Recovered;
	String Active;
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
	
	
}

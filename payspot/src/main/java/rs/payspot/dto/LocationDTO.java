package rs.payspot.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class LocationDTO implements Serializable{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7610315840660977551L;
	
	private String wordpressId;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("ORGUNIT")
	private String orgUnit;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("ZASTUPNIK")
	private String zastupnik;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("ZASTUPNIKNAZIV")
	private String zastupnikNaziv;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("ORGUNITNAME")
	private String orgUnitName;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("ADDRESS")
	private String address;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("LATITUDE")
	private String latitude;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("LONGITUDE")
	private String longitude;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("CITYID")
	private String cityId;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("CITYNAME")
	private String cityName;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("COUNTRY")
	private String country;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("PTT")
	private String ptt;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("MESSAGE")
	private String message;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("PHONE")
	private String phone;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("WEBSITE")
	private String website;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("WORKINGDAYSDESC")
	private String workingDaysDesc;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("WORKINGTIMEFROM")
	private String workingTimeFrom;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("WORKINGTIMETO")
	private String workingTimeTo;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("WORKDAYFROM2")
	private String workDayFrom2;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("WORKDAYTO2")
	private String workDayTo2;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("SATURDAYFROM")
	private String saturdayFrom;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("SATURDAYTO")
	private String saturdayTo;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("SUNDAYFROM")
	private String sundayFrom;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("SUNDAYTO")
	private String sundayTo;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("USLUGA_PLATNI_PROMET")
	private String uslugaPlatniPromet;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("USLUGA_INTERNI_TRANSFER")
	private String uslugaInterniTransfer;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("USLUGA_RIA_TRANSFER")
	private String uslugaRiaTransfer;

	public String getWordpressId() {
		return wordpressId;
	}

	public void setWordpressId(String wordpressId) {
		this.wordpressId = wordpressId;
	}

	public String getOrgUnit() {
		return orgUnit;
	}

	public void setOrgUnit(String orgUnit) {
		this.orgUnit = orgUnit;
	}

	public String getZastupnik() {
		return zastupnik;
	}

	public void setZastupnik(String zastupnik) {
		this.zastupnik = zastupnik;
	}
	
	public String getZastupnikNaziv() {
		return zastupnikNaziv;
	}

	public void setZastupnikNaziv(String zastupnikNaziv) {
		this.zastupnikNaziv = zastupnikNaziv;
	}

	public String getOrgUnitName() {
		return orgUnitName;
	}

	public void setOrgUnitName(String orgUnitName) {
		this.orgUnitName = orgUnitName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPtt() {
		return ptt;
	}

	public void setPtt(String ptt) {
		this.ptt = ptt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWorkingDaysDesc() {
		return workingDaysDesc;
	}

	public void setWorkingDaysDesc(String workingDaysDesc) {
		this.workingDaysDesc = workingDaysDesc;
	}

	public String getWorkingTimeFrom() {
		return workingTimeFrom;
	}

	public void setWorkingTimeFrom(String workingTimeFrom) {
		this.workingTimeFrom = workingTimeFrom;
	}

	public String getWorkingTimeTo() {
		return workingTimeTo;
	}

	public void setWorkingTimeTo(String workingTimeTo) {
		this.workingTimeTo = workingTimeTo;
	}

	public String getWorkDayFrom2() {
		return workDayFrom2;
	}

	public void setWorkDayFrom2(String workDayFrom2) {
		this.workDayFrom2 = workDayFrom2;
	}

	public String getWorkDayTo2() {
		return workDayTo2;
	}

	public void setWorkDayTo2(String workDayTo2) {
		this.workDayTo2 = workDayTo2;
	}

	public String getSaturdayFrom() {
		return saturdayFrom;
	}

	public void setSaturdayFrom(String saturdayFrom) {
		this.saturdayFrom = saturdayFrom;
	}

	public String getSaturdayTo() {
		return saturdayTo;
	}

	public void setSaturdayTo(String saturdayTo) {
		this.saturdayTo = saturdayTo;
	}

	public String getSundayFrom() {
		return sundayFrom;
	}

	public void setSundayFrom(String sundayFrom) {
		this.sundayFrom = sundayFrom;
	}

	public String getSundayTo() {
		return sundayTo;
	}

	public void setSundayTo(String sundayTo) {
		this.sundayTo = sundayTo;
	}

	public String getUslugaPlatniPromet() {
		return uslugaPlatniPromet;
	}

	public void setUslugaPlatniPromet(String uslugaPlatniPromet) {
		this.uslugaPlatniPromet = uslugaPlatniPromet;
	}

	public String getUslugaInterniTransfer() {
		return uslugaInterniTransfer;
	}

	public void setUslugaInterniTransfer(String uslugaInterniTransfer) {
		this.uslugaInterniTransfer = uslugaInterniTransfer;
	}

	public String getUslugaRiaTransfer() {
		return uslugaRiaTransfer;
	}

	public void setUslugaRiaTransfer(String uslugaRiaTransfer) {
		this.uslugaRiaTransfer = uslugaRiaTransfer;
	}	
	
	@Override
	public String toString() {
		return "LocationDTO [orgUnit=" + orgUnit + ", zastupnik=" + zastupnik + ", zastupnikNaziv=" + zastupnikNaziv
				+ ", orgUnitName=" + orgUnitName + ", address=" + address + ", latitude=" + latitude + ", longitude="
				+ longitude + ", cityId=" + cityId + ", cityName=" + cityName + ", country=" + country + ", ptt=" + ptt
				+ ", message=" + message + ", phone=" + phone + ", email=" + email + ", website=" + website
				+ ", workingDaysDesc=" + workingDaysDesc + ", workingTimeFrom=" + workingTimeFrom + ", workingTimeTo="
				+ workingTimeTo + ", workDayFrom2=" + workDayFrom2 + ", workDayTo2=" + workDayTo2 + ", saturdayFrom="
				+ saturdayFrom + ", saturdayTo=" + saturdayTo + ", sundayFrom=" + sundayFrom + ", sundayTo=" + sundayTo
				+ ", uslugaPlatniPromet=" + uslugaPlatniPromet + ", uslugaInterniTransfer=" + uslugaInterniTransfer
				+ ", uslugaRiaTransfer=" + uslugaRiaTransfer + "]";
	}
}

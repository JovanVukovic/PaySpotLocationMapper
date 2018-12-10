package rs.payspot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	private Long id;
	
	@Column(name="wordpressId", unique = true)
	private String wordpressId;
	
	@Column(name="sifra", unique = true)
	private String sifra;
	/**
	 * Categories => RIA money transfer,PaySpot Net (interni transfer novca),Platni Promet
	 */
	private String categories;
	/**
	 * ZASTUPNIKNAZIV + ORGUNITNAME => Title
	 */
	@Column(name="Title", unique = true)
	private String Title;
	@Column(name="Address", unique = true)
	private String address;
	@Column(name="Latitude", unique = true)
	private String latitude;
	@Column(name="Longitude", unique = true)
	private String longitude;
	/**
	 * CITYNAME => City
	 */
	@Column(name="City", unique = true)
	private String city;
	@Column(name="Country", unique = true)
	private String country;
	/**
	 * PTT =>Postal Code
	 */	
	@Column(name="Postal_Code", unique = true)
	private String postalCode;
	@Column(name="Message", unique = true)
	private String message;
	@Column(name="Telefon", unique = true)
	private String telefon;
	@Column(name="Email", unique = true)
	private String email;
	@Column(name="Website", unique = true)
	private String website;
	/**
	 * WORKINGDAYSDESC => Radni dani
	 */
	@Column(name="Radni_dani", unique = true)
	private String radniDani;	
	/**
	 * WORKINGTIMEFROM => Radnim danom od
	 */
	@Column(name="Radnim_danom_od", unique = true)
	private String radnimDanomOd;
	/**
	 * WORKINGTIMEFROM => radnim-danom-od
	 */
	@Column(name="radnimDanomOd", unique = true)
	private String radnim_Danom_Od;
	/**
	 * WORKINGTIMETO => Radnim danom do
	 */
	@Column(name="Radnim_danom_do", unique = true)
	private String radnimDanomDo;
	/**
	 * WORKINGTIMETO => radnim-danom-do
	 */
	@Column(name="radnimDanomDo", unique = true)
	private String radnim_danom_do;
	/**
	 * WORKDAYFROM2 => Radnim danom od (dvokratno)
	 */
	@Column(name="Radnim_danom_od_dvokratno", unique = true)
	private String radnimDanomOdDvokratno;
	/**
	 *  WORKDAYFROM2 => radnim-danom-od1
	 */
	@Column(name="radnimDanomOd1", unique = true)
	private String radnim_danom_od1;
	/**
	 * WORKDAYTO2 => Radnim danom do (dvokratno)
	 */
	@Column(name="Radnim_danom_do_dvokratno", unique = true)
	private String radnimDanomDoDvokratno;
	/**
	 * WORKDAYTO2 => radnim-danom-do1
	 */
	@Column(name="radnimDanomDo1", unique = true)
	private String radnim_danom_do1;
	/**
	 * SATURDAYFROM => Subotom od
	 */
	@Column(name="Subotom_od", unique = true)
	private String subotomOd;
	/**
	 * SATURDAYFROM => subotom-od
	 */
	@Column(name="subotomOd", unique = true)
	private String subotom_od;
	/**
	 * SATURDAYTO => subotom-do
	 */
	@Column(name="Subotom_do", unique = true)
	private String subotomDo;
	/**
	 * SATURDAYTO => subotom-do
	 */
	@Column(name="subotomDo", unique = true)
	private String subotom_do;
	/**
	 * SUNDAYFROM => Nedeljom od
	 */
	@Column(name="Nedeljom_od", unique = true)
	private String nedeljomOd;
	/**
	 * SUNDAYFROM => nedeljom-od
	 */
	@Column(name="nedeljomOd", unique = true)
	private String nedeljom_od;
	/**
	 * SUNDAYTO => Nedeljom do
	 */
	@Column(name="Nedeljom_do", unique = true)
	private String nedeljomDo;
	/**
	 * SUNDAYTO => nedeljom-do
	 */
	@Column(name="nedeljomDo", unique = true)
	private String nedeljom_do;			
	/**
	 * USLUGA_PLATNI_PROMET => Usluga - Platni promet		
	 */
	@Column(name="UslugaPlatni_promet", unique = true)
	private String uslugaPlatniPromet;
	/**
	 * USLUGA_PLATNI_PROMET => usluga-platni-promet	
	 */
	@Column(name="uslugaplatniPromet", unique = true)
	private String usluga_platni_promet;
	/**
	 * USLUGA_INTERNI_TRANSFER => Usluga - PaySpot NET
	 */
	@Column(name="UslugaPaySpot_NET", unique = true)
	private String uslugaPaySpotNET;
	/**
	 * USLUGA_INTERNI_TRANSFER => usluga-payspot-interni-transfer
	 */
	@Column(name="uslugaPayspotInterniTransfer", unique = true)
	private String usluga_payspot_interni_transfer;
	/**
	 * USLUGA_RIA_TRANSFER => Usluga - RIA Money Transfer	
	 */
	@Column(name="UslugaRIA_Money_Transfer", unique = true)
	private String uslugaRIAMoneyTransfer;
	/**
	 * USLUGA_RIA_TRANSFER => usluga-ria-transfer	
	 */
	@Column(name="uslugaRriaTransfer", unique = true)
	private String usluga_ria_transfer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
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
	public String getRadniDani() {
		return radniDani;
	}
	public void setRadniDani(String radniDani) {
		this.radniDani = radniDani;
	}
	public String getRadnimDanomOd() {
		return radnimDanomOd;
	}
	public void setRadnimDanomOd(String radnimDanomOd) {
		this.radnimDanomOd = radnimDanomOd;
	}
	public String getRadnim_Danom_Od() {
		return radnim_Danom_Od;
	}
	public void setRadnim_Danom_Od(String radnim_Danom_Od) {
		this.radnim_Danom_Od = radnim_Danom_Od;
	}
	public String getRadnimDanomDo() {
		return radnimDanomDo;
	}
	public void setRadnimDanomDo(String radnimDanomDo) {
		this.radnimDanomDo = radnimDanomDo;
	}
	public String getRadnim_danom_do() {
		return radnim_danom_do;
	}
	public void setRadnim_danom_do(String radnim_danom_do) {
		this.radnim_danom_do = radnim_danom_do;
	}
	public String getRadnimDanomOdDvokratno() {
		return radnimDanomOdDvokratno;
	}
	public void setRadnimDanomOdDvokratno(String radnimDanomOdDvokratno) {
		this.radnimDanomOdDvokratno = radnimDanomOdDvokratno;
	}
	public String getRadnim_danom_od1() {
		return radnim_danom_od1;
	}
	public void setRadnim_danom_od1(String radnim_danom_od1) {
		this.radnim_danom_od1 = radnim_danom_od1;
	}
	public String getRadnimDanomDoDvokratno() {
		return radnimDanomDoDvokratno;
	}
	public void setRadnimDanomDoDvokratno(String radnimDanomDoDvokratno) {
		this.radnimDanomDoDvokratno = radnimDanomDoDvokratno;
	}
	public String getRadnim_danom_do1() {
		return radnim_danom_do1;
	}
	public void setRadnim_danom_do1(String radnim_danom_do1) {
		this.radnim_danom_do1 = radnim_danom_do1;
	}
	public String getSubotomOd() {
		return subotomOd;
	}
	public void setSubotomOd(String subotomOd) {
		this.subotomOd = subotomOd;
	}
	public String getSubotom_od() {
		return subotom_od;
	}
	public void setSubotom_od(String subotom_od) {
		this.subotom_od = subotom_od;
	}
	public String getSubotomDo() {
		return subotomDo;
	}
	public void setSubotomDo(String subotomDo) {
		this.subotomDo = subotomDo;
	}
	public String getSubotom_do() {
		return subotom_do;
	}
	public void setSubotom_do(String subotom_do) {
		this.subotom_do = subotom_do;
	}
	public String getNedeljomOd() {
		return nedeljomOd;
	}
	public void setNedeljomOd(String nedeljomOd) {
		this.nedeljomOd = nedeljomOd;
	}
	public String getNedeljom_od() {
		return nedeljom_od;
	}
	public void setNedeljom_od(String nedeljom_od) {
		this.nedeljom_od = nedeljom_od;
	}
	public String getNedeljomDo() {
		return nedeljomDo;
	}
	public void setNedeljomDo(String nedeljomDo) {
		this.nedeljomDo = nedeljomDo;
	}
	public String getNedeljom_do() {
		return nedeljom_do;
	}
	public void setNedeljom_do(String nedeljom_do) {
		this.nedeljom_do = nedeljom_do;
	}
	public String getUslugaPlatniPromet() {
		return uslugaPlatniPromet;
	}
	public void setUslugaPlatniPromet(String uslugaPlatniPromet) {
		this.uslugaPlatniPromet = uslugaPlatniPromet;
	}
	public String getUsluga_platni_promet() {
		return usluga_platni_promet;
	}
	public void setUsluga_platni_promet(String usluga_platni_promet) {
		this.usluga_platni_promet = usluga_platni_promet;
	}
	public String getUslugaPaySpotNET() {
		return uslugaPaySpotNET;
	}
	public void setUslugaPaySpotNET(String uslugaPaySpotNET) {
		this.uslugaPaySpotNET = uslugaPaySpotNET;
	}
	public String getUsluga_payspot_interni_transfer() {
		return usluga_payspot_interni_transfer;
	}
	public void setUsluga_payspot_interni_transfer(String usluga_payspot_interni_transfer) {
		this.usluga_payspot_interni_transfer = usluga_payspot_interni_transfer;
	}
	public String getUslugaRIAMoneyTransfer() {
		return uslugaRIAMoneyTransfer;
	}
	public void setUslugaRIAMoneyTransfer(String uslugaRIAMoneyTransfer) {
		this.uslugaRIAMoneyTransfer = uslugaRIAMoneyTransfer;
	}
	public String getUsluga_ria_transfer() {
		return usluga_ria_transfer;
	}
	public void setUsluga_ria_transfer(String usluga_ria_transfer) {
		this.usluga_ria_transfer = usluga_ria_transfer;
	}
	public String getWordpressId() {
		return wordpressId;
	}
	public void setWordpressId(String wordpressId) {
		this.wordpressId = wordpressId;
	}
}

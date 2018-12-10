package rs.payspot.util;

import java.util.ArrayList;
import java.util.List;

import rs.payspot.dto.LocationDTO;
import rs.payspot.entity.Location;

public class PaySpotMapper {
		
	public static List<Location> mappLocations(List<LocationDTO> locationDTOs){
		List<Location> locations = new ArrayList<Location>();
		
		for (LocationDTO locationDTO : locationDTOs) {
			Location location = mappLocation(locationDTO);
			locations.add(location);
		}
		
		return locations;
	}

	private static Location mappLocation(LocationDTO locationDTO){
		Location location = new Location();

		location.setSifra(getValue(locationDTO.getOrgUnit()));
		location.setTitle(getValue(locationDTO.getZastupnikNaziv()) + " " + getValue(locationDTO.getOrgUnitName()) );
		location.setAddress(getValue(locationDTO.getAddress()));
		location.setLatitude(getValue(locationDTO.getLatitude()));
		location.setLongitude(getValue(locationDTO.getLongitude()));
		location.setCity(getValue(locationDTO.getCityName()));
		location.setCountry(getValue(locationDTO.getCountry()));
		location.setPostalCode(getValue(locationDTO.getPtt()));
		location.setMessage(getValue(locationDTO.getMessage()));
		location.setTelefon(getValue(locationDTO.getPhone()));
		location.setEmail(getValue(locationDTO.getEmail()));
		location.setWebsite(getValue(locationDTO.getWebsite()));
		location.setRadniDani(getValue(locationDTO.getWorkingDaysDesc()));
		location.setRadnimDanomOd(getValue(locationDTO.getWorkingTimeFrom()));
		location.setRadnimDanomDo(getValue(locationDTO.getWorkingTimeTo()));
		location.setRadnimDanomOdDvokratno(getValue(locationDTO.getWorkDayFrom2()));
		location.setRadnimDanomDoDvokratno(getValue(locationDTO.getWorkDayFrom2()));
		location.setSubotomOd(getValue(locationDTO.getSaturdayFrom()));
		location.setSubotomDo(getValue(locationDTO.getSaturdayTo()));
		location.setNedeljomOd(getValue(locationDTO.getSundayFrom()));
		location.setNedeljomDo(getValue(locationDTO.getSundayTo()));
		
		location.setUslugaPlatniPromet(getPlatniPromet(locationDTO.getUslugaPlatniPromet()));
		location.setUslugaPaySpotNET(getPlatniPromet(locationDTO.getUslugaInterniTransfer()));
		location.setUslugaRIAMoneyTransfer(getPlatniPromet(locationDTO.getUslugaRiaTransfer()));
		
		location.setRadnim_Danom_Od(getValue(locationDTO.getWorkingTimeFrom()));
		location.setRadnim_danom_do(getValue(locationDTO.getWorkingTimeTo()));
		location.setRadnim_danom_od1(getValue(locationDTO.getWorkDayFrom2()));
		location.setRadnim_danom_do1(getValue(locationDTO.getWorkDayTo2()));
		location.setSubotom_od(getValue(locationDTO.getSaturdayFrom()));
		location.setSubotom_do(getValue(locationDTO.getSaturdayTo()));
		location.setNedeljom_od(getValue(locationDTO.getSundayFrom()));
		location.setNedeljom_do(getValue(locationDTO.getSundayTo()));
		
		location.setUsluga_platni_promet(getPlatniPromet(locationDTO.getUslugaPlatniPromet()));
		location.setUsluga_payspot_interni_transfer(getPlatniPromet(locationDTO.getUslugaInterniTransfer()));
		location.setUsluga_ria_transfer(getPlatniPromet(locationDTO.getUslugaRiaTransfer()));
		
		location.setCategories(getCategoriesFromDto(locationDTO));
		
		return location;
	}
	
	private static String getValue(String value){
		if (value.contains("[NULL]")) {
			return "";
		}
		
		return value;
	}
	
	private static String getCategoriesFromDto(LocationDTO locationDTO){
		String categories = "";//"RIA money transfer,PaySpot Net (interni transfer novca),Platni Promet"
		if (locationDTO.getUslugaRiaTransfer().equals("ACTIVE")) {
			categories = "RIA money transfer";
		}
		if (locationDTO.getUslugaInterniTransfer().equals("ACTIVE")) {
			if (locationDTO.getUslugaRiaTransfer().equals("ACTIVE")) {
				categories = categories + ",";
			}
			categories = categories + "PaySpot Net (interni transfer novca)";
		}
		if (locationDTO.getUslugaPlatniPromet().equals("ACTIVE")) {
			if (locationDTO.getUslugaRiaTransfer().equals("ACTIVE") || locationDTO.getUslugaInterniTransfer().equals("ACTIVE")) {
				categories = categories + ",";
			}
			categories = categories + "Platni Promet";
		}
		return categories;
	}
	
	private static String getPlatniPromet(String value){
		if (getValue(value).equals("ACTIVE")) {
			return "AKTIVNA";
		}
		return "";
	}

}

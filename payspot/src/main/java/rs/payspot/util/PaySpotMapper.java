package rs.payspot.util;

import java.util.ArrayList;
import java.util.List;

import rs.payspot.dto.LocationDTO;
import rs.payspot.entity.Location;

public class PaySpotMapper {
	
	public static List<Location> mappLocations(List<LocationDTO> locationDTOs){
		List<Location> locations = new ArrayList<>();
		
		for (LocationDTO locationDTO : locationDTOs) {
			Location location = new Location();
		}
		
		return null;
	}

	private Location mappLocation(LocationDTO locationDTO){
		Location location = new Location();
		
		return null;
	}
}

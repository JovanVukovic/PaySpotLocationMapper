package rs.payspot.service;

import java.util.List;

import rs.payspot.entity.Location;

public interface CsvWritterInreface {

	void writeLocations(List<Location> locations);
}

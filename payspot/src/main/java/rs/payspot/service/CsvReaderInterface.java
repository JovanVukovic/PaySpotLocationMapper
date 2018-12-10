package rs.payspot.service;

import java.util.List;

import rs.payspot.entity.Location;

public interface CsvReaderInterface {

	List<Location> getLoactions(String filePath);
	void populateWpId(String filePath);
}

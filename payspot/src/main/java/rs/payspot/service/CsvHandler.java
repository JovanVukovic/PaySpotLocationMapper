package rs.payspot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.payspot.entity.Location;

@Component
public class CsvHandler implements CsvHandlerInterface{

	@Autowired
	private CsvReaderInterface csvRederInterface;
	@Autowired
	private CsvWritterInreface csvWritterInterface;
	
	@Override
	public void handleCsv(String filePath) {
		
		List<Location> locations = csvRederInterface.getLoactions(filePath);
		
		csvWritterInterface.writeLocations(locations);
	}

	@Override
	public void handleWpCsv(String filePath) {
		csvRederInterface.populateWpId(filePath);
		
	}

}

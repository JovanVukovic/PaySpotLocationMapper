package rs.payspot.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.payspot.repository.RepositoryContainer;
import rs.payspot.dto.LocationDTO;
import rs.payspot.entity.Location;
import rs.payspot.entity.LocationWP;
import rs.payspot.util.PaySpotMapper;

@Component
public class CsvReader implements CsvReaderInterface{

	@Autowired
	private RepositoryContainer repository;
	
	@Override
	public List<Location> getLoactions(String filePath) {

			
		
		BufferedReader reader = null;
		List<LocationDTO> locationDTOs = null;
        List<Location> locations = null;
        try {
        	/*reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));//ISO-8859-2
            CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL
            		.withDelimiter(';')
            		.withHeader()
            		);*/
            locationDTOs = new ArrayList<LocationDTO>();
            
            /*for (CSVRecord csvRecord : csvParser) {
            	LocationDTO locationDTO = new LocationDTO();            					
            	
            	locationDTO.setOrgUnit(csvRecord.get("ORGUNIT"));
            	locationDTO.setZastupnik(csvRecord.get("ZASTUPNIK"));
            	locationDTO.setZastupnikNaziv(csvRecord.get("ZASTUPNIKNAZIV"));
            	locationDTO.setOrgUnitName(csvRecord.get("ORGUNITNAME"));
            	locationDTO.setAddress(csvRecord.get("ADDRESS"));
            	locationDTO.setLatitude(csvRecord.get("LATITUDE"));
            	locationDTO.setLongitude(csvRecord.get("LONGITUDE"));
            	locationDTO.setCityId(csvRecord.get("CITYID"));
            	locationDTO.setCityName(csvRecord.get("CITYNAME"));
            	locationDTO.setCountry(csvRecord.get("COUNTRY"));
            	locationDTO.setPtt(csvRecord.get("PTT"));
            	locationDTO.setMessage(csvRecord.get("MESSAGE"));
            	locationDTO.setPhone(csvRecord.get("PHONE"));
            	locationDTO.setEmail(csvRecord.get("EMAIL"));
            	locationDTO.setWebsite(csvRecord.get("WEBSITE"));
            	locationDTO.setWorkingDaysDesc(csvRecord.get("WORKINGDAYSDESC"));
            	locationDTO.setWorkingTimeFrom(csvRecord.get("WORKINGTIMEFROM"));
            	locationDTO.setWorkingTimeTo(csvRecord.get("WORKINGTIMETO"));
            	locationDTO.setWorkDayFrom2(csvRecord.get("WORKDAYFROM2"));
            	locationDTO.setWorkDayTo2(csvRecord.get("WORKDAYTO2"));
            	locationDTO.setSaturdayFrom(csvRecord.get("SATURDAYFROM"));
            	locationDTO.setSaturdayTo(csvRecord.get("SATURDAYTO"));
            	locationDTO.setSundayFrom(csvRecord.get("SUNDAYFROM"));
            	locationDTO.setSundayTo(csvRecord.get("SUNDAYTO"));
            	locationDTO.setUslugaPlatniPromet(csvRecord.get("USLUGA_PLATNI_PROMET"));
            	locationDTO.setUslugaInterniTransfer(csvRecord.get("USLUGA_INTERNI_TRANSFER"));
            	locationDTO.setUslugaRiaTransfer(csvRecord.get("USLUGA_RIA_TRANSFER"));
            	
            	locationDTOs.add(locationDTO);
            }
            
            csvParser.close();*/
            
            Workbook workbook = WorkbookFactory.create(new File(filePath));
			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();
			
			locationDTOs = new ArrayList<LocationDTO>();
			Iterator<Row> rowIterator = sheet.rowIterator();
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();

	            if (row.getRowNum() != 0) {
	            	// Now let's iterate over the columns of the current row
	            	Iterator<Cell> cellIterator = row.cellIterator();
	            	LocationDTO locationDTO = new LocationDTO();            					
	            	
	            	locationDTO.setOrgUnit(row.getCell(0).toString());
	            	locationDTO.setZastupnik(row.getCell(1).toString());
	            	locationDTO.setZastupnikNaziv(row.getCell(2).toString());
	            	locationDTO.setOrgUnitName(row.getCell(3).toString());
	            	locationDTO.setAddress(row.getCell(4).toString());
	            	locationDTO.setLatitude(row.getCell(5).toString());
	            	locationDTO.setLongitude(row.getCell(6).toString());
	            	locationDTO.setCityId(row.getCell(7).toString());
	            	locationDTO.setCityName(row.getCell(8).toString());
	            	locationDTO.setCountry(row.getCell(9).toString());
	            	locationDTO.setPtt(row.getCell(10).toString());
	            	locationDTO.setMessage(row.getCell(11).toString());
	            	locationDTO.setPhone(row.getCell(12).toString());
	            	locationDTO.setEmail(row.getCell(13).toString());
	            	locationDTO.setWebsite(row.getCell(14).toString());
	            	locationDTO.setWorkingDaysDesc(row.getCell(15).toString());
	            	locationDTO.setWorkingTimeFrom(row.getCell(16).toString());
	            	locationDTO.setWorkingTimeTo(row.getCell(17).toString());
	            	locationDTO.setWorkDayFrom2(row.getCell(18).toString());
	            	locationDTO.setWorkDayTo2(row.getCell(19).toString());
	            	locationDTO.setSaturdayFrom(row.getCell(20).toString());
	            	locationDTO.setSaturdayTo(row.getCell(21).toString());
	            	locationDTO.setSundayFrom(row.getCell(22).toString());
	            	locationDTO.setSundayTo(row.getCell(23).toString());
	            	locationDTO.setUslugaPlatniPromet(row.getCell(24).toString());
	            	locationDTO.setUslugaInterniTransfer(row.getCell(25).toString());
	            	locationDTO.setUslugaRiaTransfer(row.getCell(26).toString());
	            	
	            	locationDTOs.add(locationDTO);
				}
	            
	            
	        } 
            
            
            System.out.println("Loca size:  " + locations.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
        locations = PaySpotMapper.mappLocations(locationDTOs);
        for (Location location : locations) {
        	LocationWP locationWP = null;        	
        	locationWP = repository.getLocationWPRepository().findBySifra(location.getSifra());
        	
			if (locationWP != null) {
				if (locationWP.getWordpressId() != null) {
					location.setWordpressId(locationWP.getWordpressId());
				}            		
			}else{
				locationWP  = new LocationWP();
				locationWP.setSifra(location.getSifra());
				//locationWP.setWordpressId("");
				repository.getLocationWPRepository().save(locationWP);
				
				location.setWordpressId("");
			}
		}
		return locations;
	}

	@Override
	public void populateWpId(String filePath) {
		BufferedReader reader = null;
       
        try {
        	reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL
            		.withDelimiter(',')
            		.withHeader()
            		);
           
            
            for (CSVRecord csvRecord : csvParser) {
            	String wordpressId = csvRecord.get("ID");
            	String sifra = csvRecord.get("Sifra");
            	
            	LocationWP locationWP = null;        	
            	locationWP = repository.getLocationWPRepository().findBySifra(sifra);            	
    			if (locationWP != null) {
    				locationWP.setWordpressId(wordpressId);
    				repository.getLocationWPRepository().save(locationWP);            		
    			}else{
    				locationWP  = new LocationWP();
    				locationWP.setSifra(sifra);
    				locationWP.setWordpressId(wordpressId);
    				repository.getLocationWPRepository().save(locationWP);
    			}
            	
            }
            
            csvParser.close();
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}

}

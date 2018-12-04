package rs.payspot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import rs.payspot.dto.LocationDTO;
import rs.payspot.entity.Location;
import rs.payspot.util.PaySpotMapper;

public class CsvReader {

	private static final String SAMPLE_CSV_FILE_PATH = "D:/test3.csv";

    public static void main(String[] args) throws IOException {
    	String csvFile = "D:/test3.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        /*try {

            //br = new BufferedReader(new FileReader(csvFile));
            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(csvFile), "ISO-8859-1"));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[0] + " , name=" + country[4] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
    	
        /*.withHeader("ORGUNIT", "ZASTUPNIK", "ZASTUPNIKNAZIV", "ORGUNITNAME", "ADDRESS", "LATITUDE", "LONGITUDE", "CITYID", 
        		"CITYNAME", "COUNTRY", "PTT", "MESSAGE","PHONE", "EMAIL", "WEBSITE", "WORKINGDAYSDESC", "WORKINGTIMEFROM", 
        		"WORKINGTIMETO", "WORKDAYFROM2", "WORKDAYTO2", "SATURDAYFROM", "SATURDAYTO", "SUNDAYFROM", "SUNDAYTO", 
        		"USLUGA_PLATNI_PROMET", "USLUGA_INTERNI_TRANSFER", "USLUGA_RIA_TRANSFER")*/
        try (
            //Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH), Charset.forName("ISO-8859-2"));
        	BufferedReader	reader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "ISO-8859-2"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL
            		.withDelimiter(';')
            		.withHeader()
            		);
        ) {
        	List<LocationDTO> locationDTOs = new ArrayList<>();
            for (CSVRecord csvRecord : csvParser) {
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
            	
                // Accessing values by the names assigned to each column
                /*String ORGUNIT = csvRecord.get("ORGUNIT");
                String ZASTUPNIK = csvRecord.get("ZASTUPNIK");
                String ZASTUPNIKNAZIV = csvRecord.get("ZASTUPNIKNAZIV");
                String ORGUNITNAME = csvRecord.get("ORGUNITNAME");*/
            	/*String ORGUNIT = csvRecord.get(0);
                String ZASTUPNIK = csvRecord.get(1);
                String ZASTUPNIKNAZIV = csvRecord.get(2);
                String ORGUNITNAME = csvRecord.get(3);*/

                /*System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("ORGUNIT : " + ORGUNIT);
                System.out.println("ZASTUPNIK : " + ZASTUPNIK);
                System.out.println("ZASTUPNIKNAZIV : " + ZASTUPNIKNAZIV);
                System.out.println("ORGUNITNAME : " + ORGUNITNAME);
                System.out.println("---------------\n\n");*/
            }
            
            for (int i = 0; i < 5; i++) {/*locationDTOs.size()*/
            	System.out.println("i: " + i + " ;" + locationDTOs.get(i));
			}
           // System.out.println("iŠŽĐČĆ: " + 200 + " ;" + locationDTOs.get(202));
            //String str = "Hello";
            //BufferedWriter writer = new BufferedWriter(new FileWriter("D:/test4.csv"));
			//BufferedWriter writer = new BufferedWriter(
			//		new OutputStreamWriter(new FileOutputStream("D:/test4.csv"), "ISO-8859-2"));
			//writer.write("iŠŽĐČĆ" + locationDTOs.get(202).toString());
             
            //writer.close();
            
            
            try (
                    //BufferedWriter writer2 = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
            		BufferedWriter writer2 = new BufferedWriter(
        					new OutputStreamWriter(new FileOutputStream("D:/testOUT.csv"), "ISO-8859-2"));

                    CSVPrinter csvPrinter = new CSVPrinter(writer2, CSVFormat.DEFAULT
                    		.withDelimiter(';')
                            .withHeader(
                            		"ID","Title","Address","Latitude","Longitude","City","State","Country","Postal Code","Message",
                            		"Categories","Telefon","Sifra","Website","Radni dani","Radnim danom od","Radnim danom do",
                            		"Radnim danom od (dvokratno)","Subotom od","Subotom do","Nedeljom od","Nedeljom do",
                            		"Usluga - Platni promet","Usluga - PaySpot NET","Usluga - RIA Money Transfer","Email",
                            		"Radnim danom do (dvokratno)","radnim-danom-od","radnim-danom-do","radnim-danom-od1",
                            		"radnim-danom-do1","subotom-od","subotom-do","nedeljom-od","nedeljom-do","usluga-platni-promet",
                            		"usluga-payspot-interni-transfer","usluga-ria-transfer"));
                ) {
            	
            		List<Location> locations = PaySpotMapper.mappLocations(locationDTOs);
            		for (Location location : locations) {
            			csvPrinter.printRecord(location.getId(),location.getTitle(),location.getAddress(),location.getLatitude(),location.getLongitude(),location.getCity(),"",location.getCountry(),location.getPostalCode(),location.getMessage(),
            					location.getCategories(),location.getTelefon(),location.getSifra(),location.getWebsite(),location.getRadniDani(),location.getRadnimDanomOd(),location.getRadnimDanomDo(),
            					location.getRadnimDanomOdDvokratno(),location.getSubotomOd(),location.getSubotomDo(),location.getNedeljomOd(),location.getNedeljomDo(),
            					location.getUslugaPlatniPromet(),location.getUslugaPaySpotNET(),location.getUslugaRIAMoneyTransfer(),location.getEmail(),
            					location.getRadnimDanomDoDvokratno(),location.getRadnim_Danom_Od(),location.getRadnim_danom_do(),location.getRadnim_danom_od1(),
            					location.getRadnim_danom_do1(),location.getSubotom_od(),location.getSubotom_do(),location.getNedeljom_od(),location.getNedeljom_do(),location.getUsluga_platni_promet(),
            					location.getUsluga_payspot_interni_transfer(),location.getUsluga_ria_transfer());
					}
            		csvPrinter.printRecord("ŠĐŽĆČSC");


                    csvPrinter.flush();            
                }
        }
    }
}
/*.withHeader("ORGUNIT", "ZASTUPNIK", "ZASTUPNIKNAZIV", "ORGUNITNAME", "ADDRESS", "LATITUDE", "LONGITUDE", "CITYID", 
		"CITYNAME", "COUNTRY", "PTT", "MESSAGE","PHONE", "EMAIL", "WEBSITE", "WORKINGDAYSDESC", "WORKINGTIMEFROM", 
		"WORKINGTIMETO", "WORKDAYFROM2", "WORKDAYTO2", "SATURDAYFROM", "SATURDAYTO", "SUNDAYFROM", "SUNDAYTO", 
		"USLUGA_PLATNI_PROMET", "USLUGA_INTERNI_TRANSFER", "USLUGA_RIA_TRANSFER")
		.withIgnoreHeaderCase()
                    .withFirstRecordAsHeader()
                    .withDelimiter(';')
                    .withTrim()
		*/

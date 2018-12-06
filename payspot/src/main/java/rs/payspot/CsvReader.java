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
import java.io.UnsupportedEncodingException;
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
import org.apache.commons.csv.QuoteMode;
import org.apache.commons.lang.StringEscapeUtils;

import rs.payspot.dto.LocationDTO;
import rs.payspot.entity.Location;
import rs.payspot.util.PaySpotMapper;

public class CsvReader {

	private static final String SAMPLE_CSV_FILE_PATH = "D:/test3.csv";
	private static String srcEncoding = "ISO-8859-2";
    private static String destEncoding = "UTF-8";

    public static void main(String[] args) throws IOException {
    	String csvFile = "D:/KVIK/csv/test.csv";
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
            
            for (int i = 0; i < 3; i++) {/*locationDTOs.size()*/
            	System.out.println("i: " + i + " ;" + locationDTOs.get(i));
			}
            System.out.println("\"Postal Code\"");
           // System.out.println("iŠŽĐČĆ: " + 200 + " ;" + locationDTOs.get(202));
            //String str = "Hello";
            //BufferedWriter writer = new BufferedWriter(new FileWriter("D:/test4.csv"));
			//BufferedWriter writer = new BufferedWriter(
			//		new OutputStreamWriter(new FileOutputStream("D:/test4.csv"), "ISO-8859-2"));
			//writer.write("iŠŽĐČĆ" + locationDTOs.get(202).toString());
             
            //writer.close();
            
            String postalCode = StringEscapeUtils.unescapeCsv("\"Postal Code\"");
            System.out.println(postalCode);
            try (
                    //BufferedWriter writer2 = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
            		BufferedWriter writer2 = new BufferedWriter(
        					new OutputStreamWriter(new FileOutputStream("D:/KVIK/csv/testOUT.csv"), "UTF-8"));
            		
                    CSVPrinter csvPrinter = new CSVPrinter(writer2, CSVFormat.DEFAULT
                    		.withEscape('\\')
                    		.withQuoteMode(QuoteMode.NONE)
                    		.withQuote('"')
                    		.withDelimiter(',')
                            .withHeader(
                            		"ID","Title","Address","Latitude","Longitude","City","State","Country","\"Postal Code\"","Message",
                            		"Categories","Telefon","Sifra","Website","\"Radni dani\"","\"Radnim danom od\"","\"Radnim danom do\"",
                            		"\"Radnim danom od (dvokratno)\"","\"Subotom od\"","\"Subotom do\"","\"Nedeljom od\"","\"Nedeljom do\"",
                            		"\"Usluga - Platni promet\"","\"Usluga - PaySpot NET\"","\"Usluga - RIA Money Transfer\"","Email",
                            		"\"Radnim danom do (dvokratno)\"","radnim-danom-od","radnim-danom-do","radnim-danom-od1",
                            		"radnim-danom-do1","subotom-od","subotom-do","nedeljom-od","nedeljom-do","usluga-platni-promet",
                            		"usluga-payspot-interni-transfer","usluga-ria-transfer"));
                ) {
            	
            	country Republika Srbija => Serbia
            			message \,
            			category \,

            			vremena ako je neradni dan moraju navodnici
            			Neradni dan
            		List<Location> locations = PaySpotMapper.mappLocations(locationDTOs);
            		for (Location location : locations) {
            			String title = convert(location.getTitle());
            			csvPrinter.printRecord(location.getId(),"\"" + title + "\"","\"" + location.getAddress() + "\"",location.getLatitude(),location.getLongitude(),"\"" + location.getCity() + "\"","",location.getCountry(),location.getPostalCode(),"\"" + location.getMessage() + "\"",
            					"\"" + location.getCategories() + "\"","\"" + location.getTelefon() + "\"",location.getSifra(),location.getWebsite(),"\"" + location.getRadniDani() + "\"",location.getRadnimDanomOd(),location.getRadnimDanomDo(),
            					location.getRadnimDanomOdDvokratno(),location.getSubotomOd(),location.getSubotomDo(),location.getNedeljomOd(),location.getNedeljomDo(),
            					location.getUslugaPlatniPromet(),location.getUslugaPaySpotNET(),location.getUslugaRIAMoneyTransfer(),location.getEmail(),
            					location.getRadnimDanomDoDvokratno(),location.getRadnim_Danom_Od(),location.getRadnim_danom_do(),location.getRadnim_danom_od1(),
            					location.getRadnim_danom_do1(),location.getSubotom_od(),location.getSubotom_do(),location.getNedeljom_od(),location.getNedeljom_do(),location.getUsluga_platni_promet(),
            					location.getUsluga_payspot_interni_transfer(),location.getUsluga_ria_transfer());
					}
            		csvPrinter.printRecord("","\"Test, FILIJALAĆČŠĐŽ ,7787\"","Branimira 2","45.255182","19.829258","\"Novi Sad\"","",
            				"\"Republika Srbija\"","21000","\", od-from   do-to\"","\"Platni Promet\"","","122001","","\"Ponedeljak - Petak\"",
            				"08:00","16:00","","\"Neradni dan\"","","\"Neradni dan\"","","AKTIVNA","AKTIVNA","AKTIVNA","","","08:00","16:00","","",
            				"\"Neradni dan\"","","\"Neradni dan\"","","AKTIVNA","AKTIVNA","AKTIVNA");

                    csvPrinter.flush();            
                }
        }
    }

    public static byte[] transcodeField(byte[] source, Charset from, Charset to) {
        return new String(source, from).getBytes(to);
    }
    public static String convert(String srcStr) {
        byte[] srcBytes;
        String destStr = null;
        try {
        	srcBytes = srcStr.getBytes(srcEncoding);
        	destStr = new String(srcBytes, destEncoding);
        	
        	byte[] out = transcodeField(srcStr.getBytes(), Charset.forName(srcEncoding), Charset.forName(destEncoding));
        } catch (UnsupportedEncodingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        return destStr;
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

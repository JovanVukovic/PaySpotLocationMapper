package rs.payspot.service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.springframework.stereotype.Component;

import rs.payspot.entity.Location;

@Component
public class CsvWritter implements CsvWritterInreface{

	private static String srcEncoding = "UTF-8";
    private static String destEncoding = "UTF-8";
    
    private static String OUTPUT_FILE = "/home/payspot/importInToWordpress.csv";// /home/payspot/testOUTKVIK.csv D:/KVIK/csv/testOUTKVIK.csv
    
	@Override
	public void writeLocations(List<Location> locations) {
		
		try {
			//BufferedWriter writer2 = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
    		BufferedWriter writer2 = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE), "UTF-8"));//D:\KVIK\code\PaySpotLocationMapper\payspot

    		CSVPrinter csvPrinter = new CSVPrinter(writer2, CSVFormat.DEFAULT
            		.withEscape('\\')
            		.withQuoteMode(QuoteMode.ALL)
            		.withQuote('"')
            		.withDelimiter(',')
                    .withHeader(
                    		"ID","Title","Address","Latitude","Longitude","City","State","Country","Postal Code","Message",
                    		"Categories","Telefon","Sifra","Website","Radni dani","Radnim danom od","Radnim danom do",
                    		"Radnim danom od (dvokratno)","Subotom od","Subotom do","Nedeljom od","Nedeljom do",
                    		"Usluga - Platni promet","Usluga - PaySpot NET","Usluga - RIA Money Transfer","Email",
                    		"Radnim danom do (dvokratno)","radnim-danom-od","radnim-danom-do","radnim-danom-od1",
                    		"radnim-danom-do1","subotom-od","subotom-do","nedeljom-od","nedeljom-do","usluga-platni-promet",
                    		"usluga-payspot-interni-transfer","usluga-ria-transfer"));
            for (Location location : locations) {
    			String title = convert(location.getTitle());
    			String wpId = resolvewWpId(location.getWordpressId());
    			csvPrinter.printRecord(wpId, title ,location.getAddress() ,location.getLatitude(),location.getLongitude(), location.getCity(),"",location.getCountry(),location.getPostalCode(),location.getMessage(),
    					location.getCategories(), location.getTelefon(), location.getSifra(), location.getWebsite(), location.getRadniDani(),location.getRadnimDanomOd(),location.getRadnimDanomDo(),
    					location.getRadnimDanomOdDvokratno(),location.getSubotomOd(),location.getSubotomDo(),location.getNedeljomOd(),location.getNedeljomDo(),
    					location.getUslugaPlatniPromet(),location.getUslugaPaySpotNET(),location.getUslugaRIAMoneyTransfer(),location.getEmail(),
    					location.getRadnimDanomDoDvokratno(),location.getRadnim_Danom_Od(),location.getRadnim_danom_do(),location.getRadnim_danom_od1(),
    					location.getRadnim_danom_do1(),location.getSubotom_od(),location.getSubotom_do(),location.getNedeljom_od(),location.getNedeljom_do(),location.getUsluga_platni_promet(),
    					location.getUsluga_payspot_interni_transfer(),location.getUsluga_ria_transfer());
			}
    		csvPrinter.printRecord("","Test, FILIJALAĆČŠĐŽ ,7787","Branimira 2","45.255182","19.829258","Novi Sad","",
    				"Republika Srbija","21000",", od-from   do-to","Platni Promet","","999999","","Ponedeljak - Petak",
    				"08:00","16:00","","Neradni dan","","Neradni dan","","AKTIVNA","AKTIVNA","AKTIVNA","","","08:00","16:00","","",
    				"Neradni dan","","Neradni dan","","AKTIVNA","AKTIVNA","AKTIVNA");

            csvPrinter.flush();
            csvPrinter.close();            
            
		} catch (Exception e) {
			// TODO: handle exception
		}		        	
        	/*country Republika Srbija => Serbia
        			message \,
        			category \,

        			vremena ako je neradni dan moraju navodnici
        			Neradni dan*/	
		
	}
	public static String resolvewWpId(String value){
		if (value == null) {
			return "";
		}
		return value;
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

	public static String removeComma(String value){
		if (value.contains(",")) {
			value = value.replace(",", "");
        }
		return value;
	}
}

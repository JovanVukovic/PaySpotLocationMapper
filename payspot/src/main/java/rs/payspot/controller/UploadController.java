package rs.payspot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import rs.payspot.service.CsvHandlerInterface;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/payspot/";// /home/payspot/ D:/KVIK/csv/
    
    @Autowired
    private CsvHandlerInterface csvhandlerInterface;

    @GetMapping("/")
    public String index() {
    	System.out.println("POGODIO INDEX!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return "index";
    }
    
    @GetMapping("/uploadPaySpot")
    public String uploadPayspot() {
    	return "uploadPaySpot";
    }
    
    @GetMapping("/uploadWordpress")
    public String uploadWordpress() {
    	return "uploadWordpress";
    }

    @PostMapping("/uploadP") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
    	System.out.println("Pocinje");
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
        	System.out.println("Pocinje1 " + file.getOriginalFilename());
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            System.out.println("Pocinje1");
            
            
            System.out.println("File name: " + file.getOriginalFilename());
            Files.write(path, bytes);

            csvhandlerInterface.handleCsv(UPLOADED_FOLDER + file.getOriginalFilename());
            
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }
    
    @PostMapping("/uploadW") // //new annotation since 4.3
    public String wordpressUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
    	System.out.println("Pocinje");
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
        	System.out.println("Pocinje1 " + file.getOriginalFilename());
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            System.out.println("Pocinje1");
            
            
            System.out.println("File name: " + file.getOriginalFilename());
            Files.write(path, bytes);

            //TODO 
            csvhandlerInterface.handleWpCsv(UPLOADED_FOLDER + file.getOriginalFilename());
            
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadWStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
    	
        return "uploadStatus";
    }
    
    @GetMapping("/uploadWStatus")
    public String uploadWStatus() {
    	
        return "uploadWStatus";
    }
    
    private final Path rootLocation = Paths.get(UPLOADED_FOLDER);
    
     /** 
      * Download Files
      * 
      * */     
	@GetMapping("/download")
	public ResponseEntity<Resource> downloadFile() throws MalformedURLException {
		
		String filename = "importInToWordpress.csv";
        Path file = rootLocation.resolve(filename);
        Resource resource = new UrlResource(file.toUri());
        
		return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
					.body(resource);	
	}

}
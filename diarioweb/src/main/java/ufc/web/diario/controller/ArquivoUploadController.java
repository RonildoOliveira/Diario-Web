package ufc.web.diario.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import ufc.web.diario.dao.ArquivoUploadDAO;
import ufc.web.diario.models.ArquivoUpload;


@Controller
public class ArquivoUploadController {

	@Autowired
	ArquivoUploadDAO arquivoUploadDAO;
	
	@RequestMapping(value = "/arquivos/form", method = RequestMethod.GET)
	//@RequestMapping(value = "/arquivos/form")
	public String showUploadForm(HttpServletRequest request) {
		return "arquivos/form";
	}
	
	//@RequestParam @ModelAttribute
	@RequestMapping(value = "/arquivos", method = RequestMethod.POST)
	//@RequestMapping(value = "/arquivos")
    public String handleFileUpload(HttpServletRequest request,
    		@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
         
		if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
                 
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                
                ArquivoUpload uploadFile = new ArquivoUpload();
                uploadFile.setNomeArquivo(aFile.getOriginalFilename());
                uploadFile.setDadoArquivo(aFile.getBytes());
                arquivoUploadDAO.save(uploadFile);                
            }
        }
		
        return "arquivos/ok";
    }
	
}

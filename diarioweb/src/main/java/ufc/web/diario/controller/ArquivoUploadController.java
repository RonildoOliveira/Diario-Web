package ufc.web.diario.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ufc.web.diario.dao.ArquivoUploadDAO;
import ufc.web.diario.models.ArquivoUpload;


@Controller
public class ArquivoUploadController {

	@Autowired
	ArquivoUploadDAO arquivoUploadDAO;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping(value = "/arquivos/form", method = RequestMethod.GET)
	public String showUploadForm(HttpServletRequest request) {
		return "arquivos/form";
	}
	
	@RequestMapping(value = "/arquivos", method = RequestMethod.POST)
	public String save(
			@ModelAttribute("document") ArquivoUpload arquivo,
			@RequestParam("file") MultipartFile file) throws IOException {
		
			        
	        arquivo.setNomeArquivo(file.getOriginalFilename());
	        
	        arquivo.setConteudoArquivo(file.getContentType());
	        arquivo.setDadoArquivo(file.getBytes());
	        
	        arquivoUploadDAO.save(arquivo);
		
		return "arquivos/ok";
	}	
	
	@RequestMapping("/arquivos/listar")
	public String listaeArqvuivos(Model model){

		List<ArquivoUpload> arquivos = this.arquivoUploadDAO.list();
		model.addAttribute("arquivos", arquivos);

		return "arquivos/listar";
	}
	
	@RequestMapping("/download/{arquivoId}")
	public String download(@PathVariable("arquivoId")
			Long arquivoId, HttpServletResponse response) throws IOException {
		
		ArquivoUpload arquivo = arquivoUploadDAO.get(arquivoId);
        response.setContentType(arquivo.getConteudoArquivo());
        response.setContentLength(arquivo.getDadoArquivo().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + arquivo.getNomeArquivo() +"\"");
  
        FileCopyUtils.copy(arquivo.getDadoArquivo(), response.getOutputStream());
		
		
		return null;
	}
}

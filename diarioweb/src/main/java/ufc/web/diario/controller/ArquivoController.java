package ufc.web.diario.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import ufc.web.diario.dao.ArquivoDAO;
import ufc.web.diario.models.Arquivo;

@Controller
public class ArquivoController {

	@Autowired
	ArquivoDAO arquivoDAO;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping(value = "/arquivos/form", method = RequestMethod.GET)
	public String showUploadForm(HttpServletRequest request) {
		return "arquivos/form";
	}
	
	@RequestMapping(value = "/arquivos", method = RequestMethod.POST)
	public String save(
			@ModelAttribute("document") Arquivo arquivo,
			@RequestParam("file") MultipartFile file) throws IOException {
			        
	        arquivo.setNomeArquivo(file.getOriginalFilename());
	        
	        arquivo.setTipoArquivo(file.getContentType());
	        arquivo.setConteudoArquivo(file.getBytes());
	        
	        arquivoDAO.save(arquivo);
		
		return "arquivos/ok";
	}	
	
	@RequestMapping("/arquivos/listar")
	public String listaeArqvuivos(Model model){

		List<Arquivo> arquivos = this.arquivoDAO.list();
		model.addAttribute("arquivos", arquivos);

		return "arquivos/listar";
	}
	
	/**
	@RequestMapping("/download/{arquivoId}")
	public String download(@PathVariable("arquivoId")
			Long arquivoId, HttpServletResponse response) throws IOException {
		
		Arquivo arquivo = arquivoDAO.get(arquivoId);
        response.setContentType(arquivo.getTipoArquivo());
        response.setContentLength(arquivo.getConteudoArquivo().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + arquivo.getNomeArquivo() +"\"");
  
        FileCopyUtils.copy(arquivo.getConteudoArquivo(), response.getOutputStream());
		
		return null;
	}
	**/
}

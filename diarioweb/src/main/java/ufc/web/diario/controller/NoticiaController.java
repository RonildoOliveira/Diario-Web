package ufc.web.diario.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import ufc.web.diario.dao.ComentarioDAO;
import ufc.web.diario.dao.NoticiaDAO;
import ufc.web.diario.dao.SecaoDAO;
import ufc.web.diario.models.Noticia;
import ufc.web.diario.models.Secao;

@Controller
@Transactional
public class NoticiaController {

	@Autowired
	private NoticiaDAO noticiaDAO;
	
	@Autowired
	private SecaoDAO secaoDAO;
	
	@Autowired
	private ComentarioDAO comentarioDAO;
	
	@RequestMapping("/noticias/form")
	public String form(Model model){
		
		List<Secao> secoes = secaoDAO.listar();
		model.addAttribute("secoes", secoes);
		
		return "noticias/form";
	}
	
	@RequestMapping(value="/noticias", method = RequestMethod.POST)
	public String save(Noticia noticia){
		
		noticia.setSecao(secaoDAO.getSecao(noticia.getSecaoId()));
		noticiaDAO.inserir(noticia);
		
		return "noticias/ok";
	}
	
	@RequestMapping("/noticias/listar")
	public String listarNoticia(Model model){
		
		List<Noticia> noticias = this.noticiaDAO.listar();
		model.addAttribute("noticias", noticias);
		
		return "noticias/listar";
	}	
	
	@RequestMapping(value = "/noticias/exibir", params = {"id"}, method = RequestMethod.GET)
	public String exibirNoticia(Model model, @RequestParam(value = "id") int id){
		
		List<Noticia> noticias = this.noticiaDAO.listar();
		
		Noticia noticiaResult = new Noticia();
		
		for (Noticia noticia : noticias) {
			if(noticia.getNoticiaId() == id){
				noticiaResult = noticia;
				break;
			}
		}
		
		model.addAttribute("noticiaResult", noticiaResult);
		
		return "noticias/exibir";
	}
}

package ufc.web.diario.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.web.diario.dao.NoticiaDAO;
import ufc.web.diario.models.Noticia;

@Controller
@Transactional
public class NoticiaController {

	@Autowired
	private NoticiaDAO noticiaDAO;

	@RequestMapping("/noticias")
	public String save(Noticia noticia){
		noticiaDAO.save(noticia);
		return "noticias/ok";
	}

	@RequestMapping("/noticias/form")
	public String form(){
		return "noticias/form";
	}
	
	@RequestMapping("/noticias/listar")
	public String listarUsuario(Model model){
		List<Noticia> noticias = this.noticiaDAO.listar();
		model.addAttribute("noticias", noticias);		
		return "noticias/listar";
	}	
	
}

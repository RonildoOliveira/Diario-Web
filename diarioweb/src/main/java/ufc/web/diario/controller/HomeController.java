package ufc.web.diario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.web.diario.dao.NoticiaDAO;
import ufc.web.diario.dao.SecaoDAO;
import ufc.web.diario.models.Noticia;
import ufc.web.diario.models.Secao;

@Controller
public class HomeController {
	
	@Autowired
	private NoticiaDAO noticiaDAO;
	
	@Autowired
	private SecaoDAO secaoDAO;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		List<Noticia> noticias = this.noticiaDAO.listarNoticiasRecentes();
		model.addAttribute("noticiasRecentes", noticias);
		
		List<Secao> secoes = this.secaoDAO.listar();
		model.addAttribute("secoes", secoes);
		
		System.out.println("Home Page");
		return "index";
	}
}

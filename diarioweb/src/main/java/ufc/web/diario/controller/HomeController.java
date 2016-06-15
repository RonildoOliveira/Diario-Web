package ufc.web.diario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.web.diario.dao.NoticiaDAO;
import ufc.web.diario.models.Noticia;

@Controller
public class HomeController {
	
	@Autowired
	private NoticiaDAO noticiaDAO;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		List<Noticia> noticias = this.noticiaDAO.listarNoticiasRecentes();
		model.addAttribute("noticiasRecentes", noticias);
		
		System.out.println("Home Page");
		return "index";
	}
}

package ufc.web.diario.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

		model.addAttribute("noticiasRecentes", noticiaDAO.listar());
		model.addAttribute("secoes", secaoDAO.listar());
		
		return "index";
	}
	
	@RequestMapping("usuarios/homeadmin")
	public String home(Model model) {
		
		model.addAttribute("noticiasRecentes", noticiaDAO.listar());
		model.addAttribute("secoes", secaoDAO.listar());
		
		return "/usuarios/homeadmin";
	}
}

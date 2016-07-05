package ufc.web.diario.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ufc.web.diario.dao.SecaoDAO;
import ufc.web.diario.models.Secao;
import ufc.web.diario.models.Usuario;

@Transactional
@Controller
public class SecaoController {

	@Autowired
	private SecaoDAO secaoDAO;

	@RequestMapping("/secoes/form")
	public String formularioSecao(HttpSession session){
		
		if(session.getAttribute("usuario") == null){
			return "404";
		}
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario.getRegraId() != 2)
			return "404";
		
		return "secoes/form";
	}

	@RequestMapping("/secoes")
	public String adicionarSecao(Secao secao, HttpSession session){
		secaoDAO.inserir(secao);
		return "redirect:secoes/form";
	}

	@RequestMapping("/secoes/listar")
	public String verCategorias (Model model, HttpSession session){
		
		if(session.getAttribute("usuario") == null){
			return "404";
		}
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario.getRegraId() != 2)
			return "404";
		
		model.addAttribute("secoes", secaoDAO.listar());
		return "secoes/listar";
	}
	
	@RequestMapping(value = "/secoes", params = {"id"}, method = RequestMethod.GET)
	public String excluirSecao(Model model, @RequestParam(value = "id") Long id){
		secaoDAO.remover(secaoDAO.getSecao(id));
		return "redirect:secoes/listar";
	}
}

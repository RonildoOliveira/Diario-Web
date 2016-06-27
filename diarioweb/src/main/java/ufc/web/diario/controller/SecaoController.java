package ufc.web.diario.controller;

import java.util.List;

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

@Transactional
@Controller
public class SecaoController {

	@Autowired
	private SecaoDAO secaoDAO;


	@RequestMapping("/secoes/form")
	public String formularioSecao(){
		return "secoes/form";
	}


	@RequestMapping("/secoes")
	public String adicionarSecao(Secao s, HttpSession session){
		this.secaoDAO.inserir(s);
		return "redirect:secoes/form";
	}

	@RequestMapping("/secoes/listar")
	public String verCategorias (Model model){

		List<Secao> secoes = this.secaoDAO.listar();
		model.addAttribute("secoes", secoes);

		return "secoes/listar";
	}
	
	@RequestMapping(value = "/secoes", params = {"id"},
			method = RequestMethod.GET)
	public String excluirNoticia(Model model, @RequestParam(value = "id") Long id){
		
		secaoDAO.remover(secaoDAO.getSecao(id));
		
		return "redirect:secoes/listar";
	}
}

package ufc.web.diario.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.web.diario.dao.SecaoDAO;
import ufc.web.diario.models.Secao;

@Transactional
@Controller
public class SecaoController {
		
	@Autowired
	private SecaoDAO secaoDao;
	
	@RequestMapping("/secoes/form")
	public String formularioSecao(){
		return "secoes/form";
	}
	
	
	@RequestMapping("/secoes")
	public String adicionarSecao(Secao s, HttpSession session){

		if(session != null && s.getTitulo() != null && s.getDescricao() != null){
			this.secaoDao.inserir(s);
			return "secoes/ok";
	    }
		
		return "";			
			
	}
	
	@RequestMapping("/secoes/listar")
	public String verCategorias (Model model){
		
		List<Secao> secoes = this.secaoDao.listar();
		
		/*
		// Insiro na lista aquelas seções que possuiem noticias
		List<Secao> secoes_permitidas = new ArrayList<Secao>();
		for (Secao secao : secoes) {
			if (secao.getNoticias().isEmpty() == false) {
				secoes_permitidas.add(secao);
			}
		}
		*/
		// Passando as seções permitidas
		//model.addAttribute("secoes", secoes_permitidas);
		model.addAttribute("secoes", secoes);
		
		return "secoes/listar";
	}
}

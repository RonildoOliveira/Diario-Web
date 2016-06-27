package ufc.web.diario.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ufc.web.diario.dao.RegraDAO;
import ufc.web.diario.dao.UsuarioDAO;
import ufc.web.diario.models.Usuario;

@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private RegraDAO regraDAO;
	
	@RequestMapping("/usuarios")
	public String save(Usuario usuario){
		usuarioDAO.adicionar(usuario);
		return "redirect:usuarios/form";
	}

	@RequestMapping("/usuarios/form")
	public String form(Model model){
		return "usuarios/form";
	}
	
	@RequestMapping("/usuarios/login")
	public String login(Model model){
		model.addAttribute("regras", regraDAO.listar());
		return "usuarios/login";
	}
	
	@RequestMapping("/usuarios/listar")
	public String listarUsuario(Model model){
		model.addAttribute("usuarios",usuarioDAO.listar());
		return "usuarios/listar";
	}	
	
	@RequestMapping("/usuarios/homeadmin")
	public String homeAdmin(){
		
		return "usuarios/homeadmin";
	}
	
	@RequestMapping(value = "/usuarios", params = {"id"},
			method = RequestMethod.GET)
	public String excluirNoticia(Model model, @RequestParam(value = "id") Long id){
		
		usuarioDAO.remover(usuarioDAO.getUserId(id));
		
		return "redirect:usuarios/listar";
	}
}

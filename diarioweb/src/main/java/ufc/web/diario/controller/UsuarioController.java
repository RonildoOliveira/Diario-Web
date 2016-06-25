package ufc.web.diario.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.web.diario.dao.UsuarioDAO;
import ufc.web.diario.models.Usuario;

@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping("/usuarios")
	public String save(Usuario usuario){
		usuarioDAO.adicionar(usuario);
		return "usuarios/ok";
	}

	@RequestMapping("/usuarios/form")
	public String form(Model model){
		return "usuarios/form";
	}
	
	@RequestMapping("/usuarios/login")
	public String login(Model model){
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
}

package ufc.web.diario.controller;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Transactional
public class UsuarioController {

	@RequestMapping("/usuarios")
	public String save(){
		
		return "usuarios/ok";
	}

	@RequestMapping("/usuarios/login")
	public String form(Model model){

		return "usuarios/login";
	}
}

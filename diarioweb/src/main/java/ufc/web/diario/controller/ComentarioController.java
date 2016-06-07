package ufc.web.diario.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.web.diario.dao.ComentarioDAO;
import ufc.web.diario.dao.NoticiaDAO;
import ufc.web.diario.models.Comentario;
import ufc.web.diario.models.Noticia;

@Controller
@Transactional
public class ComentarioController {

	@Autowired
	private ComentarioDAO comentarioDAO;

	@RequestMapping("/comentarios")
	public String save(Comentario comentario){
		comentarioDAO.inserir(comentario);
		return "comentarios/ok";
	}

	@RequestMapping("/comentarios/form")
	public String form(){
		return "comentarios/form";
	}
	
	@RequestMapping("/comentarios/listar")
	public String listarUsuario(Model model){
		List<Comentario> comentarios = this.comentarioDAO.listar();
		model.addAttribute("comentarios", comentarios);		
		return "comentarios/listar";
	}	
	
}

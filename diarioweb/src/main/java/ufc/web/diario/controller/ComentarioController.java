package ufc.web.diario.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.web.diario.dao.ComentarioDAO;
import ufc.web.diario.dao.NoticiaDAO;
import ufc.web.diario.dao.UsuarioDAO;
import ufc.web.diario.models.Comentario;
import ufc.web.diario.models.Usuario;

@Controller
@Transactional
public class ComentarioController {

	@Autowired 
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private ComentarioDAO comentarioDAO;

	@Autowired
	private NoticiaDAO noticiaDAO;

	@RequestMapping("/comentarios")
	public String save(Comentario comentario, HttpSession session){
		Usuario user = (Usuario) session.getAttribute("usuario");
		comentario.setAutorComentario(usuarioDAO.getUserLogin(user.getLogin()));
		comentario.setNoticiaDeOrigem(noticiaDAO.getNoticia(comentario.getNoticiaId()));
		comentarioDAO.inserir(comentario);
		return "redirect:noticias/exibir?id="+noticiaDAO.getNoticia(comentario.getNoticiaId()).getNoticiaId();
	}

	@RequestMapping("/comentarios/listar")
	public String listarUsuario(Model model){
		model.addAttribute("comentarios", comentarioDAO.listar());		
		return "comentarios/listar";
	}	

}

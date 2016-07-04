package ufc.web.diario.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ufc.web.diario.dao.NoticiaDAO;
import ufc.web.diario.dao.RegraDAO;
import ufc.web.diario.dao.SecaoDAO;
import ufc.web.diario.dao.UsuarioDAO;
import ufc.web.diario.models.RegraUsuario;
import ufc.web.diario.models.Usuario;
import ufc.web.diario.security.Criptografar;

@Transactional
@Controller
public class HomeController {
	
	@Autowired
	private NoticiaDAO noticiaDAO;
	
	@Autowired
	private SecaoDAO secaoDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private RegraDAO regraDAO;
	
	private Usuario adm;
	
	
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
	
	 // Controlador de Cadastro de Jornalista
	 
	 @RequestMapping("/usuarios/formulario_jornalista")
	 public String formularioJornalista(HttpSession session){
		 adm = (Usuario) session.getAttribute("usuario");
		 return "/usuarios/formulario_jornalista"; 
	 }
	 
	 @RequestMapping(value = "/usuarios/formulario_jornalista", 
			 method = RequestMethod.POST)
	 public String adicionarJornalista(Usuario usuario, @RequestParam("file") MultipartFile file, HttpSession session, Model model) throws IOException{
		 
		 // Criando instância da classe para criptografar a senha do usuario
		 Criptografar crip = new Criptografar();
		 
		 // Pegando senha passada do usuário para criptografar
		 String senha = usuario.getSenha();
		 String senha_criptografada = crip.criptografar(senha);
		 
		 Usuario u = usuarioDAO.getUserLogin(usuario.getLogin());
		 
		 // Pegando o ID referente ao papel de Jornalista
		 Long id_ref_jornalista = regraDAO.getRegraNome("Jornalista");
		 
		 // Caso em que o Usuário está no banco, atualiza e seta um novo papel
		  if(u != null){ 
			  
			  	 RegraUsuario userPapel = regraDAO.getRoleById(id_ref_jornalista); 
				 List<RegraUsuario> regras = regraDAO.usuarioRegras(u.getId());
				 regras.add(userPapel);
				 
				 usuario.setId(u.getId());
				 usuario.setRegraId(id_ref_jornalista);
			 	 usuario.setRegras(regras);
			 	 
				 // Alterando a senha do usuario
				 usuario.setSenha(senha_criptografada);
				 
				 usuario.setNomeArquivo(file.getOriginalFilename());        
		 		 usuario.setConteudoArquivo(file.getBytes());
		 		 usuario.setTipoArquivo(file.getContentType());
			 	 
			 	 this.usuarioDAO.alterar(usuario);
			 	 
			 	session.setAttribute("usuario", adm);
			 	 
			 	 return "/usuarios/formulario_jornalista";   

		  }else{	 // Caso em que o Usuário não está no banco, atualiza os papéis do usuário e inseri o mesmo
	
  		         RegraUsuario papel = regraDAO.getRoleById(id_ref_jornalista); 
		         List<RegraUsuario> regras = regraDAO.usuarioRegras(usuario.getId());
		         regras.add(papel);
		         
                 usuario.setRegraId(id_ref_jornalista);
	 	         usuario.setRegras(regras);
	 	         
		 
	 			 // Alterando a senha do usuario
	 			 usuario.setSenha(senha_criptografada);
	 			 
	 			 usuario.setNomeArquivo(file.getOriginalFilename());        
	 			 usuario.setConteudoArquivo(file.getBytes());
	 			 usuario.setTipoArquivo(file.getContentType());
	 			 
		         this.usuarioDAO.adicionar(usuario); 
		         
		         session.setAttribute("usuario", adm);
		
		         return "/usuarios/formulario_jornalista";  
	       }
	 }

}

package ufc.web.diario.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ufc.web.diario.dao.NoticiaDAO;
import ufc.web.diario.dao.RegraDAO;
import ufc.web.diario.dao.SecaoDAO;
import ufc.web.diario.dao.UsuarioDAO;
import ufc.web.diario.models.Noticia;
import ufc.web.diario.models.RegraUsuario;
import ufc.web.diario.models.Secao;
import ufc.web.diario.models.Usuario;
import ufc.web.diario.security.Criptografar;

@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private RegraDAO regraDAO;
	
	@Autowired
	private NoticiaDAO noticiaDAO;
	
	@Autowired
	private SecaoDAO secaoDAO;
	
	// Controlador Login
	@RequestMapping("/usuarios/login")
	public String formularioLogin(Model model){
		model.addAttribute("regras", regraDAO.listar());
		return "usuarios/login";
	}
	
	@RequestMapping(value = "/usuarios/login" , params = {"senha"}, method = RequestMethod.POST)
	public String efetuarLogin(Usuario user, HttpSession session, Model model){ 
		// Criando instância da classe para criptografar a senha do usuario
		Criptografar crip = new Criptografar();

		// Pegando senha passada do usuário para criptografar
		String senha = user.getSenha();
		String senha_criptografada = crip.criptografar(senha);		
		String login = user.getLogin();
		long regraId = user.getRegraId();
						
        Usuario  userRef = usuarioDAO.getUserLogin(login); 
		
        if (userRef != null ) {
        	
            // Lista de Papeis do Usuário
            List<RegraUsuario> usuario_regras = userRef.getRegras();
            List<Long> id_regras = new ArrayList<Long>();            
            
            // Pecorrendo lista de roles para setar os ID dos papeis
            for (RegraUsuario r : usuario_regras) {
    			id_regras.add(regraDAO.getRegraNome(r.getNome()));
    		}
                                    
            // Usuário cadastrado pelo Sistema
    		if(userRef.getSenha().equals(senha_criptografada) && id_regras.contains(regraId) && regraId == 1){
                userRef.setRegraId(regraId);          
    			session.setAttribute("usuario", userRef);
    			model.addAttribute("usuario", userRef);
    			
    			// Dados 
    			List<Noticia> noticias = this.noticiaDAO.listar();
    			model.addAttribute("noticiasRecentes", noticias);
    			
    			List<Secao> secoes = this.secaoDAO.listar();
    			model.addAttribute("secoes", secoes);
    			
    			return "/usuarios/logado";
    		
    		} else if(userRef.getSenha().equals(senha_criptografada) && id_regras.contains(regraId) && regraId != 1){   		
    			session.setAttribute("usuario", userRef);
    			model.addAttribute("usuario", userRef);
    			// Dados 
    			List<Noticia> noticias = this.noticiaDAO.listar();
    			model.addAttribute("noticiasRecentes", noticias);
    			
    			List<Secao> secoes = this.secaoDAO.listar();
    			model.addAttribute("secoes", secoes);
    			
    			return "/usuarios/homeadmin";
    			
    		}else{

    			// Usuario cadastrado manualmente
        		if(userRef.getSenha().equals(senha) && id_regras.contains(regraId) && regraId == 1){
                    userRef.setRegraId(regraId);          
        			session.setAttribute("usuario", userRef);
        			model.addAttribute("usuario", userRef);
        			
        			// Dados 
        			List<Noticia> noticias = this.noticiaDAO.listar();
        			model.addAttribute("noticiasRecentes", noticias);
        			
        			List<Secao> secoes = this.secaoDAO.listar();
        			model.addAttribute("secoes", secoes);
        			
        			return "/usuarios/login"; // Coloquei um processo de redirecionamento nela.. Só foi necessário o 
        			// caso do leitor. O homeadmin não teve problema com o css e js.
        		
        		} else if(userRef.getSenha().equals(senha) && id_regras.contains(regraId) && regraId != 1){   		
        			session.setAttribute("usuario", userRef);
        			model.addAttribute("usuario", userRef);
        			// Dados 
        			List<Noticia> noticias = this.noticiaDAO.listar();
        			model.addAttribute("noticiasRecentes", noticias);
        			
        			List<Secao> secoes = this.secaoDAO.listar();
        			model.addAttribute("secoes", secoes);
        			
        			return "/usuarios/homeadmin";
        			
        		}else{
        	        return "redirect:/usuarios/login";		
        		}

    		}
    		
		}
		
        return "redirect:/usuarios/login";		
        
	}	
	
	// Controlador Usuário 	
	 @RequestMapping("/usuarios/form") // Cadastro
	 public String formularioUsuario(){
		 return "/usuarios/form";
	 }
	 
	 @RequestMapping(value = "/usuarios/form", headers=("content-type=multipart/*") , 
			 params = {"senha"}, method = RequestMethod.POST)
	 public String inserirUsuario(Usuario usuario, 
				@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
		 
		 // Criando instância da classe para criptografar a senha do usuario
		 Criptografar crip = new Criptografar();
		 // Pegando senha passada do usuário para criptografar
		 String senha = usuario.getSenha();
		 String senha_criptografada = crip.criptografar(senha);
		 
		// Pegando o ID referente ao papel de Jornalista
   	    Long id_ref_leitor = regraDAO.getRegraNome("Leitor");
		 
		 // Testa se o Usuário já está cadastrado..
		 if(usuarioDAO.getUserLogin(usuario.getLogin()) != null){ 
			 return "/usuarios/form";
		 }
	  
		 RegraUsuario papel = regraDAO.getRoleById(id_ref_leitor); 
		 List<RegraUsuario> regras = regraDAO.usuarioRegras(usuario.getId());
		 regras.add(papel);
		 
		 usuario.setRegraId(id_ref_leitor);
		 usuario.setRegras(regras);
		 // Alterando a senha do usuario
		 usuario.setSenha(senha_criptografada);
		 
		 usuario.setNomeArquivo(file.getOriginalFilename());        
		 usuario.setConteudoArquivo(file.getBytes());
		 usuario.setTipoArquivo(file.getContentType());
			
		 this.usuarioDAO.adicionar(usuario); 
		 	
		 return "redirect:/usuarios/login";     
	 
	 }
     
	 @RequestMapping("usuarios/listar")
	 public String listarUsuario(Model model, HttpSession session){

		 if(session.getAttribute("usuario") == null){
			 return "404";
		 }
		 
		 Usuario user = (Usuario) session.getAttribute("usuario");
		 
		 if(user.getRegraId() == 1){
			 return "404";
		 }
		 
		 List<Usuario> users = this.usuarioDAO.listar();
		 model.addAttribute("usuarios", users);
		 model.addAttribute("quantidade", users.size());
		 
		 return "/usuarios/listar";		 
	 }
	 
	 
	 @RequestMapping("alterarUsuario")
	 public String editarUsuario(Usuario user){
		 
		 this.usuarioDAO.alterar(user);
		 
		 return "redirect:listarUsuario";
	 }
	 
	 @RequestMapping(value = "/usuarios", params = {"id"},
				method = RequestMethod.GET)
	 public String excluirUsuario(Usuario user){
		 
		 this.usuarioDAO.remover(user);
		 
		 return "redirect:/usuarios/listar";
	 }

	 
	 // Caso o usuário queira sair da sua seção atual     
	 @RequestMapping("/usuarios/sair")
	 public String sair(Model model, HttpSession session){	 
			
		 session.invalidate();
  		 // Dados 
 		 List<Noticia> noticias = this.noticiaDAO.listar();
		 model.addAttribute("noticiasRecentes", noticias);
			
		 List<Secao> secoes = this.secaoDAO.listar();
		 model.addAttribute("secoes", secoes);
		 
		 return "/usuarios/sair";
	 
	 }

	 @RequestMapping("/profile/{arquivoId}")
	 public String download(@PathVariable("arquivoId")
	 Long arquivoId, HttpServletResponse response) throws IOException {
		 
		 
		 response.setContentLength(usuarioDAO.getUserId(arquivoId).getConteudoArquivo().length);
		 response.setHeader("Content-Disposition","attachment; filename=\"" + 
				 usuarioDAO.getUserId(arquivoId).getNomeArquivo() +"\"");
		 
		 FileCopyUtils.copy(usuarioDAO.getUserId(arquivoId).getConteudoArquivo(), response.getOutputStream());
		 
		 return null;
	 } 
}

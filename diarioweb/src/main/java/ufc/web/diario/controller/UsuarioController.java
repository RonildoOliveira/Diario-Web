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
		List<RegraUsuario> regras = regraDAO.listar();
		model.addAttribute("regras", regras);
		return "usuarios/login";
	}
	
	@RequestMapping(value = "/usuarios/login" , params = {"senha"}, method = RequestMethod.GET)
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
    			
    			return "index";
    		
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
    	        //return "redirect:formularioLogin";
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
        			
        			return "index";
        		
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
		 System.out.println("SOLTa");
		 return "/usuarios/form";
	 }
	 
	 @RequestMapping(value = "/usuarios/form", params = ("file"), method = RequestMethod.GET)
	 public String inserirUsuario(Usuario usuario, 
				@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
		 
		 System.out.println("SOLTO");
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
		 
		 System.out.println("HERE_____________!!!!");
	
		 return "redirect:/usuarios/login";     
	 
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
	 @RequestMapping("usuarios/listar")
	 public String listarUsuario(Model model){
		
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
	 
	 @RequestMapping("excluirUsuario")
	 public String excluirUsuario(Usuario user){
		 
		 this.usuarioDAO.remover(user);
		 
		 return "redirect:listarUsuario";
	 }

	 // Controlador de Cadastro de Jornalista
	 
	 @RequestMapping("formularioJornalista")
	 public String formularioJornalista(){
		return "/usuarios/formulario_jornalista"; 
	 }
	 
	 @RequestMapping(value= "adicionarJornalista", method=RequestMethod.POST)
	 public String adicionarJornalista(Usuario usuario, HttpSession session){
		
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
			 	 
			 	 this.usuarioDAO.alterar(usuario);
			 	 
			 	 return "/usuarios/homeadmin";   

		  }else{	 // Caso em que o Usuário não está no banco, atualiza os papéis do usuário e inseri o mesmo
	
   		         RegraUsuario papel = regraDAO.getRoleById(id_ref_jornalista); 
		         List<RegraUsuario> regras = regraDAO.usuarioRegras(usuario.getId());
		         regras.add(papel);
		         
                 usuario.setRegraId(id_ref_jornalista);
	 	         usuario.setRegras(regras);
	 	         
		 
	 			 // Alterando a senha do usuario
	 			 usuario.setSenha(senha_criptografada);
	 			 
		         this.usuarioDAO.adicionar(usuario); 
		
		         return "/usuarios/homeadmin";  
	       }
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
		 
		 return "index";
	 
	 }
}

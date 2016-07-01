package ufc.web.diario.controller;



import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ufc.web.diario.dao.ClassificadoDAO;
import ufc.web.diario.dao.RegraDAO;
import ufc.web.diario.dao.UsuarioDAO;
import ufc.web.diario.models.Classificado;
import ufc.web.diario.models.RegraUsuario;
import ufc.web.diario.models.Usuario;


@Transactional
@Controller
public class ClassificadoController {

	@Autowired
	private ClassificadoDAO classificadoDao;
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private RegraDAO roleDao;
	
    @RequestMapping("formularioClassificado")
    public String formularioClassificado(Model model){

    	List<RegraUsuario> regras = roleDao.listar();
    	model.addAttribute("regras", regras);
    	
    	List<Classificado> classificados = this.classificadoDao.listar();
    	model.addAttribute("classificados", classificados);
       
		
    	return "/classificado/formulario_classificado";
    }
    
    @RequestMapping("adicionarClassificado")
    public String adicionarClassificado(Classificado c, HttpSession session){
    	
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        List<Classificado> classificados = classificadoDao.listar();        
        
        for (Classificado cass : classificados) {
        	if(cass.equals(c) ){
            	return "redirect:formularioClassificado";
            }
		}
        
        
        Timestamp data = new Timestamp(System.currentTimeMillis());
        c.setData_oferta(data);
        float oferta = 0;
        c.setMelhor_oferta(oferta);
        // Não possuo um autor de oferta ao inserir um Usuário. Porém o cara que cadastrou é responsável por tudo no cadastro
        c.setAutorOferta(usuarioDao.getUserLogin(usuario.getLogin()));
        
        this.classificadoDao.inserir(c);  	
        
    	return "/classificado/listar_classificados"; // página de sucesso caso ele seja a maior oferta..
    }
    
    @RequestMapping("classificado/listar_classificados")
    public String listarClassificado(Model model, HttpSession session){
    	
    	// Pegando o Usuário que está logado
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
    	
    	List<Classificado> classificados = this.classificadoDao.listar();
    	model.addAttribute("classificados", classificados);
        
    	// Atibuindo o Usuário..
    	model.addAttribute("usuario", usuario);

    	return "/classificado/listar_classificados"; 
    }
    
    @RequestMapping("/classificado")
    public String realizarCompra(Model model, float oferta, Classificado classificado, HttpSession session){
    	
    	
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
    	
    	Classificado cas = classificadoDao.getCass(classificado.getClassificadoId());
    	
    	
    	if (usuario != null && usuario.getRegraId() == 1) {

			   if (oferta > cas.getPreco() && oferta > cas.getMelhor_oferta() ) {
				   cas.setData_oferta(new Timestamp(System.currentTimeMillis()));
				   cas.setMelhor_oferta(oferta);
				   cas.setAutorOferta(usuarioDao.getUserLogin(usuario.getLogin()));
				   
				   return "redirect:exibirClassificado?id="+cas.getClassificadoId();
			   }
		}
        
    	
    	return "redirect:/classificado/listar_classificados";
    }
    
    @RequestMapping(value = "exibirClassificado", params = {"id"},
			method = RequestMethod.GET)
    public String exibirClassificado(Model model, @RequestParam(value = "id") Long id){
    	
    	
    	fazer_oferta(model, classificadoDao.getCass(id));
    	model.addAttribute("classificadoResult", classificadoDao.getCass(id));
    	
    	return "/classificado/exibir_classificado";
    }
    
    @RequestMapping("/classificado/fazer_oferta")
    public String fazer_oferta(Model model, Classificado classificado){
    	model.addAttribute("classificado", classificado);
    	return "/classificado";
    }
    
    @RequestMapping("alterarClassificado")
    public String alterarClassificado(Classificado c){
    	this.classificadoDao.alterar(c);
    	return "redirect:listarClassificado";
    }
    
    @RequestMapping("excluirClassificado")
    public String excluirClassificado(Classificado c){
    	this.classificadoDao.remover(c);
    	return "redirect:listarClassificado";
    }

    
}
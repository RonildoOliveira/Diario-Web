package ufc.web.diario.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ufc.web.diario.dao.ClassificadoDAO;
import ufc.web.diario.dao.RegraDAO;
import ufc.web.diario.dao.UsuarioDAO;
import ufc.web.diario.models.Arquivo;
import ufc.web.diario.models.Classificado;
import ufc.web.diario.models.RegraUsuario;
import ufc.web.diario.models.Usuario;

@Transactional
@Controller
public class ClassificadoController {

	@Autowired
	private ClassificadoDAO classificadoDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private RegraDAO roleDAO;
	
    @RequestMapping("classificados/form")
    public String formularioClassificado(Model model){

    	model.addAttribute("regras", roleDAO.listar());
    	model.addAttribute("classificados", classificadoDAO.listar());
		
    	return "/classificados/form";
    }
    
    @RequestMapping("classificados/adicionarClassificado")
    public String adicionarClassificado(Classificado classificado,
		@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
    	
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        for (Classificado cl : classificadoDAO.listar()) {
        	if(cl.equals(classificado) ){
            	return "redirect:/classificados/form";
            }
		}
        
        classificado.setNomeArquivo(file.getOriginalFilename());        
        classificado.setTipoArquivo(file.getContentType());
        classificado.setConteudoArquivo(file.getBytes());
		
        Timestamp data = new Timestamp(System.currentTimeMillis());
        classificado.setData_oferta(data);
        float oferta = 0;
        classificado.setMelhor_oferta(oferta);
        
        // Não possuo um autor de oferta ao inserir um Usuário. Porém o cara que cadastrou é responsável por tudo no cadastro
        classificado.setAutorOferta(usuarioDAO.getUserLogin(usuario.getLogin()));
        
        this.classificadoDAO.inserir(classificado);  	
        
    	return "/classificados/listar"; // página de sucesso caso ele seja a maior oferta..
    }
    
    @RequestMapping("/downloadcl/{arquivoId}")
	public String download(@PathVariable("arquivoId")
	Long arquivoId, HttpServletResponse response) throws IOException {

		response.setContentType(classificadoDAO.getCass(arquivoId).getTipoArquivo());
		response.setContentLength(classificadoDAO.getCass(arquivoId).getConteudoArquivo().length);
		response.setHeader("Content-Disposition","attachment; filename=\"" + classificadoDAO.getCass(arquivoId).getNomeArquivo() +"\"");

		FileCopyUtils.copy(classificadoDAO.getCass(arquivoId).getConteudoArquivo(), response.getOutputStream());

		return null;
	}
    
    @RequestMapping("classificados/listar")
    public String listarClassificado(Model model, HttpSession session){
    	
    	// Pegando o Usuário que está logado
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
    	
    	model.addAttribute("classificados", classificadoDAO.listar());
        
    	// Atibuindo o Usuário..
    	model.addAttribute("usuario", usuario);

    	return "/classificados/listar"; 
    }
    
    @RequestMapping("/classificados")
    public String realizarCompra(Model model, float oferta, Classificado classificado, HttpSession session){
    	
    	
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
    	
    	Classificado cas = classificadoDAO.getCass(classificado.getClassificadoId());
    	
    	
    	if (usuario != null && usuario.getRegraId() == 1) {

			   if (oferta > cas.getPreco() && oferta > cas.getMelhor_oferta() ) {
				   cas.setData_oferta(new Timestamp(System.currentTimeMillis()));
				   cas.setMelhor_oferta(oferta);
				   cas.setAutorOferta(usuarioDAO.getUserLogin(usuario.getLogin()));
				   
				   return "redirect:/classificado/exibir?id="+cas.getClassificadoId();
			   }
		}
        
    	
    	return "redirect:/classificados/listar";
    }
    
    @RequestMapping(value = "classificados/exibir", params = {"id"},
			method = RequestMethod.GET)
    public String exibirClassificado(Model model, @RequestParam(value = "id") Long id){
    	
    	
    	fazer_oferta(model, classificadoDAO.getCass(id));
    	model.addAttribute("classificadoResult", classificadoDAO.getCass(id));
    	
    	return "/classificados/exibir";
    }
    
    @RequestMapping("/classificados/ofertar")
    public String fazer_oferta(Model model, Classificado classificado){
    	model.addAttribute("classificado", classificado);
    	return "/classificados";
    }
    
    @RequestMapping("alterarClassificado")
    public String alterarClassificado(Classificado c){
    	this.classificadoDAO.alterar(c);
    	return "redirect:/classificados/listar";
    }
    
    @RequestMapping("excluirClassificado")
    public String excluirClassificado(Classificado c){
    	this.classificadoDAO.remover(c);
    	return "redirect:/classificados/listar";
    }

    
}
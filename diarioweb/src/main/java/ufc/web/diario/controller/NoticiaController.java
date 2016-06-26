package ufc.web.diario.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ufc.web.diario.dao.ArquivoDAO;
import ufc.web.diario.dao.ComentarioDAO;
import ufc.web.diario.dao.NoticiaDAO;
import ufc.web.diario.dao.SecaoDAO;
import ufc.web.diario.models.Arquivo;
import ufc.web.diario.models.Noticia;
import ufc.web.diario.models.Secao;

@Controller
@Transactional
public class NoticiaController {

	@Autowired
	private NoticiaDAO noticiaDAO;

	@Autowired
	private SecaoDAO secaoDAO;

	@Autowired
	private ComentarioDAO comentarioDAO;

	@Autowired
	private ArquivoDAO arquivoDAO;
	
	@RequestMapping(value="/noticias/form", method = RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("secoes", secaoDAO.listar());
		return "noticias/form";
	}

	@RequestMapping(value="/noticias", method = RequestMethod.POST)
	public String save(Noticia noticia,
			@ModelAttribute("document") Arquivo arquivo,
			@RequestParam("file") MultipartFile file) throws IOException {

		noticia.setNomeArquivo(file.getOriginalFilename());        
		noticia.setTipoArquivo(file.getContentType());
		noticia.setConteudoArquivo(file.getBytes());
        
		noticia.setSecao(secaoDAO.getSecao(noticia.getSecaoId()));
		noticiaDAO.inserir(noticia);
		return "noticias/ok";
	}

	@RequestMapping("/noticias/listar")
	public String listarNoticia(Model model){
		model.addAttribute("noticias", noticiaDAO.listar());
		model.addAttribute("secoes",secaoDAO.listar());
		return "noticias/listar";
	}	

	@RequestMapping(value = "/noticias/exibir", params = {"id"},
			method = RequestMethod.GET)
	public String exibirNoticia(Model model, @RequestParam(value = "id") int id){

		List<Noticia> noticias = this.noticiaDAO.listar();
		Noticia noticiaResult = new Noticia();

		for (Noticia noticia : noticias) {
			if(noticia.getNoticiaId() == id){
				noticiaResult = noticia;
				break;
			}
		}

		comentar(model, noticiaResult);

		model.addAttribute("noticiaResult", noticiaResult);
		model.addAttribute("secoes", secaoDAO.listar());

		if(noticiaResult.getComentarios().size() > 0){
			model.addAttribute("comentarios", noticiaResult.getComentarios());
		}

		return "noticias/exibir";
	}

	@RequestMapping("/comentarios/form")
	public String comentar(Model model, Noticia noticia){
		model.addAttribute("noticia", noticia);
		return "comentarios/form";
	}

	@RequestMapping(value = "/noticias/listarsec", params = {"id"}, method = RequestMethod.GET)
	public String exibirNoticiaPorSecao(Model model, @RequestParam(value = "id") int id){

		List<Noticia> noticias = this.noticiaDAO.listar();

		List<Noticia> noticiaResult = new ArrayList<Noticia>();

		Secao secao = new Secao();

		System.out.println("HUE------");
		for (Noticia noticia : noticias) {
			if(noticia.getSecaoId() == id){
				noticiaResult.add(noticia);
				secao = secaoDAO.getSecao((long) id);
			}
		}

		model.addAttribute("secao",secao);
		model.addAttribute("secoes",secaoDAO.listar());
		model.addAttribute("noticias", noticiaResult);

		return "noticias/listarsec";
	}
	
	@RequestMapping("/download/{arquivoId}")
	public String download(@PathVariable("arquivoId")
			Long arquivoId, HttpServletResponse response) throws IOException {
				
        response.setContentType(noticiaDAO.getNoticia(arquivoId).getTipoArquivo());
        response.setContentLength(noticiaDAO.getNoticia(arquivoId).getConteudoArquivo().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + noticiaDAO.getNoticia(arquivoId).getNomeArquivo() +"\"");
  
        FileCopyUtils.copy(noticiaDAO.getNoticia(arquivoId).getConteudoArquivo(), response.getOutputStream());
		
		return null;
	}
}

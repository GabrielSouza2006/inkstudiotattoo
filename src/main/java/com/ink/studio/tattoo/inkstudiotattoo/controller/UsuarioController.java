package com.ink.studio.tattoo.inkstudiotattoo.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ink.studio.tattoo.inkstudiotattoo.model.Usuario;
import com.ink.studio.tattoo.inkstudiotattoo.model.UsuarioDTO;
import com.ink.studio.tattoo.inkstudiotattoo.repositories.UsuarioRepository;

@Controller
@RequestMapping("/inkstudiotattoo/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository ur;

	// carregar as páginas referente ao usuário
	@RequestMapping("/listar")
	public ModelAndView  listarUsuario() {
		
		ModelAndView mv = new ModelAndView("index");
		Iterable<Usuario> usuario = ur.findAll();
		mv.addObject("usuario", usuario);
		
		return mv;
	}

	
	// Carregar o formulário de cadastro do usuário (método)
	@GetMapping("/novo-usuario")
	public String novoUsuario() {
		return "cadastro";
	}

	
	// inserir usuário (método)
	@PostMapping("/novo-usuario")
	public String gravarNovoUsuario(Usuario usuario) {

		ur.save(usuario);	
		
		return "redirect:/inkstudiotattoo/usuario/login";
	}
	
	
	// Altarar Usuario
	@GetMapping("/alterar")
	public String alterarUsuario() {
		return "editar-cliente";
	}

	
	// Alterar dados do Usuário
	@PutMapping("/alterar-usuario/{id}")
	public String alterarUsuario(@RequestBody UsuarioDTO usuario,
		@PathVariable Long id) {

		Optional<Usuario> user = ur.findById(id);
		Usuario user2;
		user2 = user.orElseThrow(() -> new NoSuchElementException("usuario não encontrado para alteração"));
		
		user2.setUsuarioDTO(usuario);
		ur.save(user2);
		
		return "redirect:/inkstudiotattoo/usuario/perfil-cliente";
	}
	
	// Deletar usuário
	@GetMapping("/deletar-usuario/{id}")
	public String deletarUsuario(@PathVariable long id) {

		ur.deleteById(id);
			
		return "redirect:/inkstudiotattoo/usuario/login";
	}
}

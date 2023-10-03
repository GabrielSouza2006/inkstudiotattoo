package com.ink.studio.tattoo.inkstudiotattoo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ink.studio.tattoo.inkstudiotattoo.model.Usuario;
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
}

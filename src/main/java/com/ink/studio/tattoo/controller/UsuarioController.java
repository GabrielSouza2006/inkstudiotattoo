package com.ink.studio.tattoo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ink.studio.tattoo.model.Usuario;

@Controller
@RequestMapping("/inkstudiotattoo/usuario")
public class UsuarioController {
	
	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	//carregar as páginas referente ao usuário
	@GetMapping("/listar")
	public String listarUsuario(Model model) {
		Usuario u1 = new Usuario();
		
		u1.setId(123l);
		u1.setNome("João da Silva");
		u1.setEmail("joao@gmail.com");
		u1.setCpf("321.213.425-65");
		u1.setSenha("Jão");
		u1.setCodStatusUsuario(true);
		u1.setFone("4002-8922");
		
		listaUsuarios.add(u1);
		model.addAttribute("listaUsuario", listaUsuarios);
		
		return "usuario";
	}
	
	//Carregar o formulário de cadastro do usuário (método)
	@GetMapping("/novo-usuario")
	public String novoUsuario(Usuario usuario, Model model) {
		model.addAttribute("produto", usuario);
		return "novo-usuario";
	}
	
	//inserir usuário (método)
	@PostMapping("/add-usuario")
	public String gravarNovoUsuario(Usuario usuario) {
		
		listaUsuarios.add(usuario);
		
		return "redirect:/inkstudiotattoo/usuario/listar";
	}
		
	//alterar usuário (método)
	
	//excluir usuário (método)
	@PostMapping("/remove-usuario")
	public String excluirUsuario(Usuario usuario) {
		
		listaUsuarios.remove(usuario);
		
		return "redirect:/inkstudiotattoo/usuario/listar";
	}
	
	//tabela de usuário (método)
	
	//selecionar usuário (método)
		
}

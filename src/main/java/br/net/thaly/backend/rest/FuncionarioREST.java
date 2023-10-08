package br.net.thaly.backend.rest;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import br.net.thaly.backend.model.Funcionario;

@CrossOrigin
@RestController
public class FuncionarioREST {
	public static List<Funcionario> lista = new ArrayList<>();

	@GetMapping("/funcionarios")
	public List<Funcionario> obterTodosFuncionarios() {
		return lista;
	}

	@GetMapping("/funcionarios/{id}")
	public Funcionario obterTodosFuncionarios(@PathVariable("id") int id) {
		Funcionario u = lista.stream().filter(func -> func.getId() == id).findAny().orElse(null);
		return u;
	}

	@PostMapping("/funcionarios")
	public Funcionario inserirFuncionario(@RequestBody Funcionario funcionario) {
		Funcionario u = lista.stream().max(Comparator.comparing(Funcionario::getId)).orElse(null);
		if (u == null)
			funcionario.setId(1);
		else
			funcionario.setId(u.getId() + 1);
		lista.add(funcionario);
		return funcionario;
	}

	@PutMapping("/funcionarios/{id}")
	public Funcionario alterarFuncionario(@PathVariable("id") int id, @RequestBody Funcionario funcionario) {
		Funcionario u = lista.stream().filter(func -> func.getId() == id).findAny().orElse(null);
		if (u != null) {
			u.setNome(funcionario.getNome());
			u.setEmail(funcionario.getEmail());
			u.setdataDeNasc(funcionario.getdataDeNasc());
			u.setSenha(funcionario.getSenha());
			u.setPerfil(funcionario.getPerfil());
		}
		return u;
	}
	@DeleteMapping("/funcionarios/{id}")
	public Funcionario removerFuncionario(@PathVariable("id")int id) {
		Funcionario funcionario = lista.stream().filter(func -> func.getId() == id).findAny().orElse(null);
		if(funcionario != null)
			lista.removeIf(u -> u.getId()==id);
		return funcionario;
	}

	static {
		lista.add(new Funcionario(1, "xd@xd.com", "func-teste", new Date(), "1234", "FUNC"));
		lista.add(new Funcionario(2, "xd@xd.com", "func-teste2", new Date(), "12343", "FUNC"));
		lista.add(new Funcionario(3, "xd@xd.com", "func-teste3", new Date(), "12345", "FUNC"));
	}
}

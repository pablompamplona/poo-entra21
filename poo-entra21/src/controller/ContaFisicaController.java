package controller;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.CpfOuCnpjException;
import exception.DataNascAberturaException;
import exception.IdException;
import exception.SexoException;
import exception.TitularException;
import model.entidade.ContaFisica;
import model.entidade.PessoaFisica;
import model.repository.ContaFisicaRepository;

@RestController
@RequestMapping("/api/conta-fisica")
public class ContaFisicaController {
	
	ContaFisicaRepository cfr = new ContaFisicaRepository();
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContaFisica inserirContaFisica(@RequestBody ContaFisica novaContaFisica) throws TitularException {
		if (novaContaFisica.getTitular() == null) {
			throw new TitularException("Informe um titular para inserir a conta");
		}
		return cfr.inserirContaFisica(novaContaFisica);
	}
	
	@GetMapping
	public ArrayList<ContaFisica> listarContasFisicas() {
	
		return cfr.listarContasFisicas();
		
	}
	
	@GetMapping("/{id}")
	public ContaFisica consultarContaFisica(@PathVariable Integer id) throws IdException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para consulta.");
		}
		
		return cfr.consultarContaFisica(id);
	}
	@PutMapping("/{id}")
	public ContaFisica alterarContaFisica(@RequestBody PessoaFisica novoTitular, @PathVariable Integer id) throws TitularException, 
								CpfOuCnpjException, DataNascAberturaException, SexoException, IdException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para alteracao.");
		}
		if (novoTitular.getNome() == null || novoTitular.getNome().trim().isEmpty()) {
			throw new TitularException("Informe o nome do novo titular.");
		}
		if (novoTitular.getCpf() == null || novoTitular.getCpf().trim().isEmpty()) {
			throw new CpfOuCnpjException("Informe um CPF valido para o novo titular");
		}
		if (novoTitular.getDataNascimento() == null) {
			throw new DataNascAberturaException("Informe uma data de nascimento valida para o novo titular.");
		}
		if (novoTitular.getSexo() == null || novoTitular.getSexo().trim().isEmpty()) {
			throw new SexoException("Informe o sexo do novo titular.");
		}
		return (ContaFisica) cfr.alterarContaFisica(novoTitular, id);
		
	}
	
	@DeleteMapping("/{id}")
	public boolean excluirContaFisica(Integer id) throws IdException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para exclusao.");
		}
		return cfr.excluirContaFisica(id);
		
	}

}

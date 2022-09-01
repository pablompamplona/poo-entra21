package controller;

import java.util.ArrayList;

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
import exception.TitularException;
import model.entidade.ContaJuridica;
import model.entidade.PessoaJuridica;
import model.repository.ContaJuridicaRepository;

@RestController
@RequestMapping("/api/conta-juridica")
public class ContaJuridicaController {
	
	ContaJuridicaRepository cjr = new ContaJuridicaRepository();
	
	@PostMapping
	public ContaJuridica inserirContaJuridica(@RequestBody ContaJuridica novaContaJuridica) throws TitularException {
		if (novaContaJuridica.getTitular() == null) {
			throw new TitularException("Informe um titular para inserir a conta");
		}
		return cjr.inserirContaJuridica(novaContaJuridica);
	}
	
	@GetMapping
	public ArrayList<ContaJuridica> listarContasJuridicas() {
	
		return cjr.listarContasJuridicas();
		
	}
	
	@GetMapping("/{id}")
	public ContaJuridica consultarContaJuridica(@PathVariable Integer id) throws IdException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para consulta.");
		}
		return cjr.consultarContaJuridica(id);
	}
	
	@PutMapping("/{id}")
	public ContaJuridica alterarContaJuridica(@RequestBody PessoaJuridica novoTitular, @PathVariable Integer id) throws TitularException, 
										CpfOuCnpjException, DataNascAberturaException, IdException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para alteracao.");
		}
		if (novoTitular.getNome() == null || novoTitular.getNome().trim().isEmpty()) {
			throw new TitularException("Informe o nome do novo titular.");
		}
		if (novoTitular.getCnpj() == null || novoTitular.getCnpj().trim().isEmpty()) {
			throw new CpfOuCnpjException("Informe um CNPJ valido para o novo titular");
		}
		if (novoTitular.getDataAbertura() == null) {
			throw new DataNascAberturaException("Informe uma data de abertura valida para o novo titular.");
		}
		
		return (ContaJuridica) cjr.alterarContaJuridica(novoTitular, id);

	}
	
	@DeleteMapping("/{id}")
	public boolean excluirContaJuridica(@PathVariable Integer id) throws IdException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para exclusao.");
		}
		return cjr.excluirContaJuridica(id);
		
	}
}

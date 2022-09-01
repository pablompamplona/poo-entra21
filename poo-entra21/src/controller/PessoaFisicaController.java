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
import exception.NomeClienteException;
import exception.SexoException;
import model.entidade.Pessoa;
import model.entidade.PessoaFisica;
import model.repository.PessoaFisicaRepository;


@RestController
@RequestMapping("/api/pessoa-fisica")
public class PessoaFisicaController {
	
	PessoaFisicaRepository pfr = new PessoaFisicaRepository();
	
	@PostMapping
	public PessoaFisica inserirPessoaFisica(@RequestBody PessoaFisica novaPessoaFisica) throws NomeClienteException, 
										 	CpfOuCnpjException, DataNascAberturaException, SexoException {
		if (novaPessoaFisica.getNome() == null || novaPessoaFisica.getNome().trim().isEmpty()) {
			throw new NomeClienteException("Informe o nome do cliente.");
		}
		if (novaPessoaFisica.getCpf() == null || novaPessoaFisica.getCpf().trim().isEmpty()) {
			throw new CpfOuCnpjException("Informe CPF do cliente.");
		}
		if (novaPessoaFisica.getDataNascimento() == null) {
			throw new DataNascAberturaException("Informe data de nascimento do cliente.");
		}
		if (novaPessoaFisica.getSexo() == null || novaPessoaFisica.getSexo().trim().isEmpty()) {
			throw new SexoException("Informe o sexo do cliente.");
		}
		
		return pfr.inserirPessoaFisica(novaPessoaFisica);
	}
	
	@GetMapping
	public ArrayList<PessoaFisica> listarPessoasFisicas() {
	
		return pfr.listarPessoasFisicas();
		
	}
	
	@GetMapping("/{id}")
	public PessoaFisica consultarPessoaFisica(@PathVariable Integer id) throws IdException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para consulta.");
		}
		
		return pfr.consultarPessoaFisica(id);
	}
	
	@PutMapping("/{id}")
	public Pessoa alterarPessoaFisica(@RequestBody PessoaFisica novaPessoaFisica, @PathVariable Integer id) 
			throws IdException, NomeClienteException, CpfOuCnpjException, DataNascAberturaException, SexoException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para alteracao.");
		}
		if (novaPessoaFisica.getNome() == null || novaPessoaFisica.getNome().trim().isEmpty()) {
			throw new NomeClienteException("Informe o nome do cliente.");
		}
		if (novaPessoaFisica.getCpf() == null || novaPessoaFisica.getCpf().trim().isEmpty()) {
			throw new CpfOuCnpjException("Informe CPF do cliente.");
		}
		if (novaPessoaFisica.getDataNascimento() == null) {
			throw new DataNascAberturaException("Informe data de nascimento do cliente.");
		}
		if (novaPessoaFisica.getSexo() == null || novaPessoaFisica.getSexo().trim().isEmpty()) {
			throw new SexoException("Informe o sexo do cliente.");
		}
		
		return pfr.alterarPessoaFisica(novaPessoaFisica, id);
		
	}
	
	@DeleteMapping("/{id}")
	public boolean excluirPessoaFisica (@PathVariable Integer id) throws IdException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para exclusao.");
		}
		return pfr.excluirPessoaFisica(id);
		
	}

}

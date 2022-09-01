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
import model.entidade.PessoaJuridica;
import model.repository.PessoaJuridicaRepository;


@RestController
@RequestMapping("/api/pessoa-juridica")
public class PessoaJuridicaController {
	
	PessoaJuridicaRepository pjr = new PessoaJuridicaRepository();
	
	@PostMapping
	public PessoaJuridica inserirPessoaFisica(@RequestBody PessoaJuridica novaPessoaJuridica) throws NomeClienteException, 
										 	CpfOuCnpjException, DataNascAberturaException {
		if (novaPessoaJuridica.getNome() == null || novaPessoaJuridica.getNome().trim().isEmpty()) {
			throw new NomeClienteException("Informe o nome do cliente.");
		}
		if (novaPessoaJuridica.getCnpj() == null || novaPessoaJuridica.getCnpj().trim().isEmpty()) {
			throw new CpfOuCnpjException("Informe CNPJ do cliente.");
		}
		if (novaPessoaJuridica.getDataAbertura() == null) {
			throw new DataNascAberturaException("Informe data de abertura do cliente.");
		}
	
		return pjr.inserirPessoaJuridica(novaPessoaJuridica);
	}
	
	@GetMapping
	public ArrayList<PessoaJuridica> listarPessoasJuridicas() {
	
		return pjr.listarPessoasJuridicas();
		
	}
	
	@GetMapping("/{id}")
	public PessoaJuridica consultarPessoaJuridica(@PathVariable Integer id) throws IdException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para consulta.");
		}
		
		return pjr.consultarPessoaJuridica(id);
	}
	
	@PutMapping("/{id}")
	public PessoaJuridica alterarPessoaJuridica (@RequestBody PessoaJuridica novaPessoaJuridica, @PathVariable Integer id) throws IdException,
			NomeClienteException, CpfOuCnpjException, DataNascAberturaException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para consulta.");
		}
		if (novaPessoaJuridica.getNome() == null || novaPessoaJuridica.getNome().trim().isEmpty()) {
			throw new NomeClienteException("Informe o nome do cliente.");
		}
		if (novaPessoaJuridica.getCnpj() == null || novaPessoaJuridica.getCnpj().trim().isEmpty()) {
			throw new CpfOuCnpjException("Informe CNPJ do cliente.");
		}
		if (novaPessoaJuridica.getDataAbertura() == null) {
			throw new DataNascAberturaException("Informe data de abertura do cliente.");
		}
		
		return pjr.alterarPessoaJuridica(novaPessoaJuridica, id);
		
	}
	
	@DeleteMapping("/{id}")
	public boolean excluirPessoaJuridica (@PathVariable Integer id) throws IdException {
		if (id == null || id == 0) {
			throw new IdException("Informe um ID valido para exclusao.");
		}
		return pjr.excluirPessoaJuridica(id);
		
	}

}

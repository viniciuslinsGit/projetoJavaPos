package br.com.unipe.posweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.posweb.entity.Aluno;
import br.com.unipe.posweb.repository.AlunoRepository;

@Service
public class AlunoService implements CrudInterface<Aluno> {

    @Autowired
    private AlunoRepository alunoRepository;
    
	public AlunoService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno findById(long id) {
		return alunoRepository.findById(id).get();
	}

	public Aluno findByNome(String nome) {
		return alunoRepository.findByNomeIgnoreCase(nome);
	}

	@Override
	public void delete(Aluno aluno) {
		alunoRepository.delete(aluno);		
	}

}

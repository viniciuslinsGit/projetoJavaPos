package br.com.unipe.posweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.posweb.entity.Disciplina;
import br.com.unipe.posweb.repository.DisciplinaRepository;

@Service
public class DisciplinaService implements CrudInterface<Disciplina> {

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    
	public DisciplinaService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Disciplina> findAll() {
		return disciplinaRepository.findAll();
	}

	@Override
	public Disciplina save(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	@Override
	public Disciplina findById(long id) {
		return disciplinaRepository.findById(id).get();
	}

	public Disciplina findByNome(String nome) {
		return disciplinaRepository.findByNomeIgnoreCase(nome);
	}

	@Override
	public void delete(Disciplina disciplina) {
		disciplinaRepository.delete(disciplina);		
	}
}

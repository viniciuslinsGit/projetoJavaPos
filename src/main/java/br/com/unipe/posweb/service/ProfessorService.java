package br.com.unipe.posweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.posweb.entity.Professor;
import br.com.unipe.posweb.repository.ProfessorRepository;

@Service
public class ProfessorService implements CrudInterface<Professor> {

    @Autowired
    private ProfessorRepository professorRepository;
    
	public ProfessorService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	@Override
	public Professor save(Professor professor) {
		return professorRepository.save(professor);
	}

	@Override
	public Professor findById(long id) {
		return professorRepository.findById(id).get();
	}

	public Professor findByNome(String nome) {
		return professorRepository.findByNomeIgnoreCase(nome);
	}

	@Override
	public void delete(Professor professor) {
		professorRepository.delete(professor);		
	}
}

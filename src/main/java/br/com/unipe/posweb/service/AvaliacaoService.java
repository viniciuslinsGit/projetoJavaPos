package br.com.unipe.posweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.posweb.entity.Aluno;
import br.com.unipe.posweb.entity.Avaliacao;
import br.com.unipe.posweb.entity.Disciplina;
import br.com.unipe.posweb.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService implements CrudInterface<Avaliacao> {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    
	public AvaliacaoService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Avaliacao> findAll() {
		return avaliacaoRepository.findAll();
	}

	@Override
	public Avaliacao save(Avaliacao avaliacao) {
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public Avaliacao findById(long id) {
		return avaliacaoRepository.findById(id).get();
	}

	@Override
	public void delete(Avaliacao avaliacao) {
		avaliacaoRepository.delete(avaliacao);		
	}
	
	public List<Avaliacao> listarPorAluno(Long idAluno) {
		Aluno aluno = new Aluno();
		aluno.setId(idAluno);
		return avaliacaoRepository.findByAluno(aluno);
	}
	
	public List<Avaliacao> listarPorDisciplina(Long idDisciplina) {
		Disciplina disciplina = new Disciplina();
		disciplina.setId(idDisciplina);
		return avaliacaoRepository.findByDisciplina(disciplina);
	}

}

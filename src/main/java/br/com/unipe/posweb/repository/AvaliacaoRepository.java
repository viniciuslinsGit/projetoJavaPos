package br.com.unipe.posweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipe.posweb.entity.Aluno;
import br.com.unipe.posweb.entity.Avaliacao;
import br.com.unipe.posweb.entity.Disciplina;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

	List<Avaliacao> findByAluno(Aluno aluno);
	List<Avaliacao> findByDisciplina(Disciplina disciplina);
}

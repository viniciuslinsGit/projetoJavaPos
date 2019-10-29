package br.com.unipe.posweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipe.posweb.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	Aluno findByNomeIgnoreCase(String nome);
}

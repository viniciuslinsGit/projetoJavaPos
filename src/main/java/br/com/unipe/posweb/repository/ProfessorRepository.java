package br.com.unipe.posweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipe.posweb.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	Professor findByNomeIgnoreCase(String nome);
}

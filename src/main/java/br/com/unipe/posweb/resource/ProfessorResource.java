package br.com.unipe.posweb.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipe.posweb.entity.Professor;
import br.com.unipe.posweb.service.ProfessorService;

@RestController
@RequestMapping("/api")
public class ProfessorResource {

	@Autowired
	private ProfessorService professorService;

	@GetMapping("/professor/listar")
	public List<Professor> getAll() {
		return professorService.findAll();
	}

	@GetMapping("/professor/buscar/{id}")
	public Professor getById(@PathVariable Long id) {
		return professorService.findById(id);
	}

	@GetMapping("/professor/buscarPorNome/{nome}")
	public Professor getByNome(@PathVariable String nome) {
		return professorService.findByNome(nome);
	}

    @PostMapping("/professor/cadastrar")
    public ResponseEntity<Professor>
    save(@Valid @RequestBody Professor professor) {
    	professorService.save(professor);
        return ResponseEntity.ok(professor);
    }

    @PutMapping("/professor/alterar")
    public ResponseEntity update(@Valid @RequestBody Professor professor) {
    	professorService.save(professor);
        return ResponseEntity.ok().body(professor);
    }

    @DeleteMapping("/professor/deletar")
    public ResponseEntity<String> delete(@Valid @RequestBody Professor professor) {
    	professorService.delete(professor);
       return  ResponseEntity.ok().body("Professor de id " + professor.getId() + " excluido.");
    }
}

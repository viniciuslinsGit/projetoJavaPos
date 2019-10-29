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

import br.com.unipe.posweb.entity.Disciplina;
import br.com.unipe.posweb.service.DisciplinaService;

@RestController
@RequestMapping("/api")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService disciplinaService;

	@GetMapping("/disciplina/listar")
	public List<Disciplina> getAll() {
		return disciplinaService.findAll();
	}

	@GetMapping("/disciplina/buscar/{id}")
	public Disciplina getById(@PathVariable Long id) {
		return disciplinaService.findById(id);
	}

	@GetMapping("/disciplina/buscarPorNome/{nome}")
	public Disciplina getByNome(@PathVariable String nome) {
		return disciplinaService.findByNome(nome);
	}

    @PostMapping("/disciplina/cadastrar")
    public ResponseEntity<Disciplina>
    save(@Valid @RequestBody Disciplina disciplina) {
    	disciplinaService.save(disciplina);
        return ResponseEntity.ok(disciplina);
    }

    @PutMapping("/disciplina/alterar")
    public ResponseEntity update(@Valid @RequestBody Disciplina disciplina) {
    	disciplinaService.save(disciplina);
        return ResponseEntity.ok().body(disciplina);
    }

    @DeleteMapping("/disciplina/deletar")
    public ResponseEntity<String> delete(@Valid @RequestBody Disciplina disciplina) {
    	disciplinaService.delete(disciplina);
       return  ResponseEntity.ok().body("Disciplina de id " + disciplina.getId() + " excluido.");
    }
}

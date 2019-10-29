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

import br.com.unipe.posweb.entity.Aluno;
import br.com.unipe.posweb.service.AlunoService;

@RestController
@RequestMapping("/api")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/aluno/listar")
	public List<Aluno> getAll() {
		return alunoService.findAll();
	}

	@GetMapping("/aluno/buscar/{id}")
	public Aluno getById(@PathVariable Long id) {
		return alunoService.findById(id);
	}

	@GetMapping("/aluno/buscarPorNome/{nome}")
	public Aluno getByNome(@PathVariable String nome) {
		return alunoService.findByNome(nome);
	}

    @PostMapping("/aluno/cadastrar")
    public ResponseEntity<Aluno>
    save(@Valid @RequestBody Aluno aluno) {
    	alunoService.save(aluno);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/aluno/alterar")
    public ResponseEntity update(@Valid @RequestBody Aluno aluno) {
    	alunoService.save(aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/aluno/deletar")
    public ResponseEntity<String> delete(@Valid @RequestBody Aluno aluno) {
    	alunoService.delete(aluno);
       return  ResponseEntity.ok().body("Aluno de id " + aluno.getId() + " excluido.");
    }

}

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

import br.com.unipe.posweb.entity.Avaliacao;
import br.com.unipe.posweb.service.AvaliacaoService;

@RestController
@RequestMapping("/api")
public class AvaliacaoResource {

	@Autowired
	private AvaliacaoService avaliacaoService;

	@GetMapping("/avaliacao/listar")
	public List<Avaliacao> getAll() {
		return avaliacaoService.findAll();
	}

	@GetMapping("/avaliacao/buscarPorAluno/{idAluno}")
	public List<Avaliacao> getByAluno(@PathVariable Long idAluno) {
		return avaliacaoService.listarPorAluno(idAluno);
	}

	@GetMapping("/avaliacao/buscarPorDisciplina/{idDisciplina}")
	public List<Avaliacao> getByDisciplina(@PathVariable Long idDisciplina) {
		return avaliacaoService.listarPorDisciplina(idDisciplina);
	}

    @PostMapping("/avaliacao/cadastrar")
    public ResponseEntity<Avaliacao>
    save(@Valid @RequestBody Avaliacao avaliacao) {
    	avaliacaoService.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    @PutMapping("/avaliacao/alterar")
    public ResponseEntity update(@Valid @RequestBody Avaliacao avaliacao) {
    	avaliacaoService.save(avaliacao);
        return ResponseEntity.ok().body(avaliacao);
    }

    @DeleteMapping("/avaliacao/deletar")
    public ResponseEntity<String> delete(@Valid @RequestBody Avaliacao avaliacao) {
    	avaliacaoService.delete(avaliacao);
       return  ResponseEntity.ok().body("Avaliacao de id " + avaliacao.getId() + " excluido.");
    }
}

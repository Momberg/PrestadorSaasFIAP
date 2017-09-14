package br.com.fiap.notepadsaas.controller;

import br.com.fiap.notepadsaas.model.Nota;
import br.com.fiap.notepadsaas.repository.NotaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {

    private NotaRepository notaRepository;

    public NotaController(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @GetMapping
    private List<Nota> findAll() {
        return notaRepository.findAll();
    }

    @GetMapping(value = "/titulo={titulo}")
    private List<Nota> findByTitulo(@PathVariable(value = "titulo") String q) {
        return notaRepository.findByTitulo(q);
    }

    @GetMapping(value = "/id={id}")
    private Nota findById(@PathVariable(value = "id") String q) {
        return notaRepository.findById(q);
    }

    @PostMapping
    private void save(@RequestBody Nota nota) {
        notaRepository.save(nota);
    }
}

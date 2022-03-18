package com.br.alan.spring.api.controller;

import com.br.alan.spring.api.controller.dto.EstadoDto;
import com.br.alan.spring.api.controller.form.EstadoForm;
import com.br.alan.spring.api.modelo.Estado;
import com.br.alan.spring.api.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public Page<EstadoDto> listar(@RequestParam(required = false) String nome,
                                  @PageableDefault(sort = "id",direction = Sort.Direction.ASC, page = 0, size = 27) Pageable pagina) {

        if (nome == null) {
            Page<Estado> estados = estadoRepository.findAll(pagina);
            return EstadoDto.converte(estados);
        } else {
            Page<Estado> estados = estadoRepository.findByNome(nome, pagina);
            return EstadoDto.converte(estados);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoDto> cadastrar(@RequestBody EstadoForm estadoForm, UriComponentsBuilder uribuilder){
        Estado estado = estadoForm.converter();
        estadoRepository.save(estado);
        URI uri = uribuilder.path("/api/states/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).body(new EstadoDto(estado));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id){

        estadoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDto> buscarPeloId(@PathVariable Long id){

        Optional<Estado> estado = estadoRepository.findById(id);
        if (estado.isPresent()) {
            return ResponseEntity.ok(new EstadoDto(estado.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EstadoDto> atualizar(@PathVariable Long id,@RequestBody EstadoForm estadoForm){
        Estado estado = estadoForm.atualizar(id, estadoRepository);

        return ResponseEntity.ok(new EstadoDto(estado));
    }

}

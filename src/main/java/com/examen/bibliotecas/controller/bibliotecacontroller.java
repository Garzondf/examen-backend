package com.examen.bibliotecas.controller;

import com.examen.bibliotecas.dto.bibliotecadto;
import com.examen.bibliotecas.service.bibliotecaservice;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bibliotecas")
public class bibliotecacontroller {

    private final bibliotecaservice service;

    public bibliotecacontroller(bibliotecaservice service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<bibliotecadto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<bibliotecadto> create(@Valid @RequestBody bibliotecadto dto) {
        bibliotecadto created = service.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
}
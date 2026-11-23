package com.examen.bibliotecas.service;

import com.examen.bibliotecas.dto.bibliotecadto;
import com.examen.bibliotecas.entity.biblioteca;
import com.examen.bibliotecas.repository.bibliotecarepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class bibliotecaservice {

    private final bibliotecarepository bibliotecarepository;
    private final ModelMapper modelMapper;

    public bibliotecaservice(bibliotecarepository bibliotecarepository, ModelMapper modelMapper) {
        this.bibliotecarepository = bibliotecarepository;
        this.modelMapper = modelMapper;
    }

    @Transactional(readOnly = true)
    public List<bibliotecadto> getAll() {
        return bibliotecarepository.findAll()
                .stream()
                .map(b -> modelMapper.map(b, bibliotecadto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public bibliotecadto create(bibliotecadto dto) {
        biblioteca biblioteca = modelMapper.map(dto, biblioteca.class);
        biblioteca.setId(null);
        biblioteca guardada = bibliotecarepository.save(biblioteca);
        return modelMapper.map(guardada, bibliotecadto.class);
    }
}
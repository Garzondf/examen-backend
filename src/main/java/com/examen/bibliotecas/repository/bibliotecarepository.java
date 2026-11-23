package com.examen.bibliotecas.repository;

import com.examen.bibliotecas.entity.biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bibliotecarepository extends JpaRepository<biblioteca, Long> {
}
package com.examen.bibliotecas.repository;

import com.examen.bibliotecas.entity.libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface librorepository extends JpaRepository<libro, Long> {
}
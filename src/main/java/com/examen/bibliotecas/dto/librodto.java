package com.examen.bibliotecas.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class librodto {
    private Long id;
    private String titulo;
    private String autor;
    private Integer añoPublicacion;
}
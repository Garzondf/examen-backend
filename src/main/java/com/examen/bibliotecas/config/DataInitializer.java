package com.examen.bibliotecas.config;

import com.examen.bibliotecas.entity.biblioteca;
import com.examen.bibliotecas.entity.libro;
import com.examen.bibliotecas.repository.bibliotecarepository;
import com.examen.bibliotecas.repository.librorepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
//crear datos para ver pq no hize postgre xd lit copia del ejemplo
    @Bean
    CommandLineRunner initData(bibliotecarepository bibliotecarepo, librorepository librorepo) {
        return args -> {
            if (bibliotecarepo.count() == 0) {
                biblioteca central = new biblioteca();
                central.setNombre("biblioteca Central");
                central.setDireccion("Ubicacion B");
                central.setCiudad("Bogotá");
                central = bibliotecarepo.save(central);

                biblioteca norte = new biblioteca();
                norte.setNombre("biblioteca Norte");
                norte.setDireccion("Ubicacion A");
                norte.setCiudad("Bogotá");
                norte = bibliotecarepo.save(norte);

                libro libro1 = new libro();
                libro1.setTitulo("Cien años de soledad");
                libro1.setAutor("Gabriel García Márquez");
                libro1.setAñoPublicacion(1967);
                libro1.setBiblioteca(central);
                librorepo.save(libro1);

                libro libro2 = new libro();
                libro2.setTitulo("El coronel no tiene quien le escriba");
                libro2.setAutor("Gabriel García Márquez");
                libro2.setAñoPublicacion(1961);
                libro2.setBiblioteca(norte);
                librorepo.save(libro2);
            }
        };
    }
}
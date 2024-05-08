package com.aluracursos.games.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosJuegos(@JsonAlias("name") String nombre,
                          @JsonAlias("playtime") Double duracion,
                          @JsonAlias("released") String fechaDeLanzamiento,
                          @JsonAlias("metacritic") Double calificacion,
                          @JsonAlias("genres") List<DatosGeneros> generos
                          ) {
    @Override
    public String toString() {
        return "***************************************************************\n" +
                "Nombre del juego: " + nombre + "\n" +
                "Duración: " + (duracion != 0 ? duracion : "Sin Limite") + "\n" +
                "Fecha de lanzamiento: " + (fechaDeLanzamiento != null ? fechaDeLanzamiento : "No disponible") + "\n" +
                "Calificación: " + (calificacion != null ? calificacion : "No disponible") + "\n" +
                "Géneros: " + (generos != null && !generos.isEmpty() ? generos : "No disponible"+
                "***************************************************************\n");
    }
}

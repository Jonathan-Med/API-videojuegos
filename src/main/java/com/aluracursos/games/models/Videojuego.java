package com.aluracursos.games.models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Videojuego {
    private String nombre;
    private Double duracion;
    private LocalDate fechaDeLanzamiento;
    private Double calificacion;
    private List<DatosGeneros> generos;

    public Videojuego(DatosJuegos d) {
        this.nombre = d.nombre();
        this.duracion = d.duracion();
        try{
            this.fechaDeLanzamiento = LocalDate.parse(d.fechaDeLanzamiento());
        } catch (DateTimeParseException e){
            this.fechaDeLanzamiento = null;
        }
        try {
            this.calificacion = d.calificacion();
        } catch (NumberFormatException e){
            this.calificacion = 0.0;
        }
        this.generos = d.generos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public List<DatosGeneros> getGeneros() {
        return generos;
    }

    public void setGeneros(List<DatosGeneros> generos) {
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "Videojuego:" + '\n' +
                "nombre: " + nombre + '\n' +
                "duracion: " + duracion + '\n' +
                "fechaDeLanzamiento: " + fechaDeLanzamiento + '\n' +
                "calificacion: " + calificacion + '\n' +
                "generos: " + generos;
    }
}

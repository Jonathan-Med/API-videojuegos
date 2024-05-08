package com.aluracursos.games.services;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}

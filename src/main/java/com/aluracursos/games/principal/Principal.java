package com.aluracursos.games.principal;

import com.aluracursos.games.models.Datos;
import com.aluracursos.games.models.DatosJuegos;
import com.aluracursos.games.services.ConsumoAPI;
import com.aluracursos.games.services.ConvierteDatos;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Principal  {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://api.rawg.io/api/games";
    private final String API_KEY = "API-KEY-HERE";
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    Menu menu = new Menu();

    public void muetraElMenu() throws InputMismatchException, IOException{
        var opc = 4;
        while (opc != 0) {
            try {
                menu.desplegarMenu();
                opc = Integer.valueOf(teclado.nextLine());
                switch (opc) {
                    case 1:
                        System.out.println("Escribe el nombre del videojuego que desea buscar:");
                        // Busqueda de videojuegos por nombre
                        var juego = teclado.nextLine();
                        var json = consumoAPI.obtenerDatos(URL_BASE + API_KEY + "&search=" + juego.replace(" ", "-"));
                        var datos = convierteDatos.obtenerDatos(json, Datos.class);
                        Optional<DatosJuegos> videojuegoBuscado = datos.juegos().stream()
                                .filter(v -> v.nombre().toLowerCase().contains(juego.toLowerCase()))
                                .findFirst();
                        if (videojuegoBuscado.isPresent()) {
                            System.out.println("Titulo encontrado:\n" + videojuegoBuscado.get());
                        } else {
                            System.out.println("Error en la busqueda.");
                        }
                        break;
                    case 2:
                        menu.menuMejoresJuegos();
                        var opc2 = Integer.valueOf(teclado.nextLine());
                        String extension = menu.resultadoIfMejores(opc2);
                        System.out.println("TOP 10 mejores juegos por Metacritic:");
                        var jsonMejores = consumoAPI.obtenerDatos(URL_BASE + API_KEY + extension);
                        var datosMejores = convierteDatos.obtenerDatos(jsonMejores, Datos.class);
                        datosMejores.juegos().stream()
                                .limit(10)
                                .forEach(System.out::println);
                        break;
                    case 3:
                        menu.menuPeoresJuegos();
                        var opc3 = Integer.valueOf(teclado.nextLine());
                        var extension1 = menu.resultadoIfPeores(opc3);
                        System.out.println("TOP 10 peores juegos por Metacritic:");
                        var jsonPeores = consumoAPI.obtenerDatos(URL_BASE + API_KEY + extension1);
                        var datosPeores = convierteDatos.obtenerDatos(jsonPeores, Datos.class);
                        datosPeores.juegos().stream()
                                .limit(10)
                                .forEach(System.out::println);
                        break;
                    case 0:
                        System.out.println("Finalizó la aplicación.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                        break;
                }
            }catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Ocurrió un error: " + e);
            }
        }
    }
}
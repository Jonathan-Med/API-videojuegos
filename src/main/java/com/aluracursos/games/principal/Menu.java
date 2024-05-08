package com.aluracursos.games.principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner teclado = new Scanner(System.in);

    public void desplegarMenu(){
        System.out.println("""
                
                |---------BUSCADOR DE JUEGOS---------|
                |1.Buscar un videojuego.             |
                |2.Mostrar Top mejores videojuegos.  |
                |3.Mostrar Top peores videojuegos.   |
                |0. Salir.                           |
                |Seleccione una opción:              |
                |------------------------------------|""");
    }

    public void menuMejoresJuegos(){
        System.out.println("""
                
                <------------TOP MEJORES VIDEOJUEGOS------------>
                1.Mostrar Top 10 mejores videojuegos.
                2.Mostrar Top 10 mejores videojuegos por año.
                3.Mostrar Top 10 mejores videojuegos por nombre.
                4.Mostrar Top 10 mejores videojuegos por genero.""");
    }


    public String resultadoIfMejores(int opc2) {
        try {
            if (opc2 == 1) {
                return "&metacritic=80,100&ordering=-metacritic";
            } else if (opc2 == 2) {
                System.out.println("""
                        
                        |--------------------------------
                        |Ingrese el año que desea buscar:
                        |--------------------------------""");
                var anno = teclado.nextLine();
                return "&metacritic=05,100&ordering=-metacritic&dates=" + anno.replace(" ", "") + "-01-01," + anno.replace(" ", "") + "-12-31";
            } else if (opc2 == 3) {
                System.out.println("""
                        
                        |-----------------------------------
                        |Ingrese el título que desea buscar:
                        |-----------------------------------""");
                var titulo = teclado.nextLine();
                return "&search=" + titulo.replace(" ", "-").toLowerCase() + "&metacritic=05,100&ordering=-metacritic";
            } else if (opc2 == 4) {
                System.out.println("""
                        
                        |-----------------------------------
                        |Ingrese el género que desea buscar:
                        |-----------------------------------""");
                var genero = teclado.nextLine();
                return "&metacritic=05,100&ordering=-metacritic&genres=" + genero.replace(" ", "-").toLowerCase();
            }
        }catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Ocurrió un error: " + e);
            return "";
        } catch (Exception e){
        System.out.println("Ocurrió un error: " + e);
        return "";
    }
        return "";
    }

    public void menuPeoresJuegos(){
        System.out.println("""
                
                <------------TOP PEORES VIDEOJUEGOS------------>
                1.Mostrar Top 10 peores videojuegos.
                2.Mostrar Top 10 peores videojuegos por año.
                3.Mostrar Top 10 peores videojuegos por nombre.
                4.Mostrar Top 10 peores videojuegos por genero.""");
    }

    public String resultadoIfPeores(int opc2) {
        try {
            if (opc2 == 1) {
                return "&metacritic=05,50&ordering=metacritic";
            } else if (opc2 == 2) {
                System.out.println("""
                        
                        |--------------------------------
                        |Ingrese el año que desea buscar:
                        |--------------------------------""");
                var anno = teclado.nextLine();
                return "&metacritic=05,100&ordering=metacritic&dates=" + anno.replace(" ", "") + "-01-01," + anno.replace(" ", "") + "-12-31";
            } else if (opc2 == 3) {
                System.out.println("""
                        
                        |-----------------------------------
                        |Ingrese el título que desea buscar:
                        |-----------------------------------""");
                var titulo = teclado.nextLine();
                return "&search=" + titulo.replace(" ", "-").toLowerCase() + "&metacritic=05,100&ordering=metacritic";
            } else if (opc2 == 4) {
                System.out.println("""
                                                
                        |-----------------------------------
                        |Ingrese el género que desea buscar:
                        |-----------------------------------""");
                var genero = teclado.nextLine();
                return "&metacritic=05,100&ordering=metacritic&genres=" + genero.replace(" ", "-").toLowerCase();
            }
        }catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Ocurrió un error: " + e);
            return "";
        }catch (Exception e){
            System.out.println("Ocurrió un error: " + e);
            return "";
        }
        return "";
    }


}

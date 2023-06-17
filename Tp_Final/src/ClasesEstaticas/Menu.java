package ClasesEstaticas;

import Exepciones.ValorNoValidoExeption;

import java.util.Scanner;

public class Menu {

    private static Scanner teclado=new Scanner(System.in);
    public static void menu(){
        System.out.println("A que menu quiere acceder?");
        System.out.println("1. Pokedex");
        System.out.println("2. Gestor de Equipo");
        System.out.println("3. Mochila");
        int opc = teclado.nextInt();
        while (opc!=0)
        switch (opc){
            case 1: menuPokedex();
            case 2:

        }

    }
    private static void menuPokedex(){
        System.out.println("Ingrese pokemon a buscar");
        try{
            Pokedex.buscarPokemon(teclado.nextLine());
        }
        catch (NullPointerException e){
            System.out.println("Pokemon no encontrado");
        }
    }

    private static void menuEquipo(){
        System.out.println("1. Crear Equipos");
        System.out.println("2. Ver Equipos");
        System.out.println("3. Consular un Equipo");
        System.out.println("4. Modificar Equipo");

    }

}

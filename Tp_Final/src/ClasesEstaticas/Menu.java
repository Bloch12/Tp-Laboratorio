package ClasesEstaticas;

import Almacenamiento.Equipo;
import Exepciones.EquipoLlenoExeption;
import Exepciones.MaximaCantidadDeMovimientosSobrepasadaExeption;
import Exepciones.MovimientoNoPermitidoExeption;
import Exepciones.ValorNoValidoExeption;
import Pokemones.Pokemon;

import java.util.Scanner;

public class Menu {

    private static Scanner teclado=new Scanner(System.in);
    public static void menu(){
        int opc
        do {
            System.out.println("A que menu quiere acceder?");
            System.out.println("1. Pokedex");
            System.out.println("2. Gestor de Equipo");
            System.out.println("3. Mochila");
            System.out.println("0. Salir");
            opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    menuPokedex();
                    break;
                case 2:
                    menuEquipo();
                    break;

            }
        }while (opc != 0);

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

    private static void menuEquipo() {
        int opc;
        do{
        System.out.println("1. Crear Equipos");
        System.out.println("2. Ver Equipos");
        System.out.println("3. Consular un Equipo");
        System.out.println("4. Modificar Equipo");
        System.out.println("0. Salir");
        opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese nombre para el equipo");
                    teclado.nextLine();
                    try {
                        GestorDeEquipo.crearEquipo(teclado.nextLine());
                    }catch (ValorNoValidoExeption e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println(GestorDeEquipo.listarEquipo());
                    break;
                case 3:
                    //Funcion ToStringFachero
                    break;
                case 4:
                    System.out.println(GestorDeEquipo.listarEquipo());
                    System.out.println("Ingrese el nombre del equipo a modificar");
                    try{
                        teclado.nextLine();
                        menuModificar(GestorDeEquipo.getEquipo(teclado.nextLine()));
                    }catch (ValorNoValidoExeption e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }while (opc != 0);
    }

    private static void menuModificar(Equipo equipo) {
        int opc;
        do {
            System.out.println(equipo.toString());
            System.out.println("1. Modificar Nombre");
            if (equipo.isEstado()) {
                System.out.println("2. Dar de baja");
            } else {
                System.out.println("2. Dar de alta");
            }
            System.out.println("3. Agregar Pokemon");
            System.out.println("4. Eliminar Pokemon");
            System.out.println("5. Modificar Pokemon");
            System.out.println("0. Salir");
            opc = teclado.nextInt();
            switch (opc){
                case 1:
                    try{
                        teclado.nextLine();
                        GestorDeEquipo.modificarEquipo(teclado.nextLine(),equipo);
                    }catch (ValorNoValidoExeption e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    GestorDeEquipo.cambiarEstadoEquipo(equipo);
                    break;
                case 3:
                    try {
                        equipo.agregarPokemon(crearPokemon());
                    }catch (ValorNoValidoExeption e){
                    }catch (EquipoLlenoExeption e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Ingrerse la posicion del pokemon a eliminar");
                    try {
                        equipo.quitarPokemon(teclado.nextInt());
                    }catch (ValorNoValidoExeption e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Ingrerse la posicion del pokemon a modificar");
                    try {
                        modificarPokemon(equipo.getPokemon(teclado.nextInt()));
                    }catch (ValorNoValidoExeption e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }while (opc != 0);

    }

    private static Pokemon crearPokemon()throws ValorNoValidoExeption{
        System.out.println("Ingrese la especie del pokemon");
        teclado.nextLine();
        String especie = teclado.nextLine();
        int opc;
        do
            try {
                Pokedex.buscarPokemon(especie);
                opc = 0;
            }catch (NullPointerException e){
                System.out.println("No existe esa especie");
                System.out.println("presione 0 para salir O Cualquier otro numero para continuar");
                opc = teclado.nextInt();
                if(opc == 0 ){
                    throw new ValorNoValidoExeption("");
                }
            }
        while (opc != 0);
        return new Pokemon(especie);
    }

    private static void modificarPokemon(Pokemon pokemon){
        int opc;
        do {
            System.out.println(pokemon.toString());
            System.out.println("1. Agregar Movimiento");
            System.out.println("2. Eliminar Movimieto");
            System.out.println("3. Modificar Nombre");
            System.out.println("4. Modificar Nivel");
            System.out.println("5. Modificar Evs");
            System.out.println("6. Modificar Ivs");
            System.out.println("7. Modificar Naturaleza");
            System.out.println("8. Modificar Habilidad");
            System.out.println("9. Evolucionar");
            System.out.println("0. Salir");
            opc = teclado.nextInt();
            switch (opc){
                case 1:
                    System.out.println("Ingrese el movimiento a aprender");
                    teclado.nextLine();
                    String movimiento;
                    try{
                        movimiento = teclado.nextLine();
                        pokemon.setMovimientos(movimiento);
                    }catch (MovimientoNoPermitidoExeption e){
                        System.out.println(e.toString());
                    }catch (MaximaCantidadDeMovimientosSobrepasadaExeption e){
                        System.out.println("");
                    }

                    break;
                case 2:
                    GestorDeEquipo.cambiarEstadoEquipo(equipo);
                    break;
                case 3:
                    try {
                        equipo.agregarPokemon(crearPokemon());
                    }catch (ValorNoValidoExeption e){
                    }catch (EquipoLlenoExeption e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Ingrerse la posicion del pokemon a eliminar");
                    try {
                        equipo.quitarPokemon(teclado.nextInt());
                    }catch (ValorNoValidoExeption e){
                        System.out.println(e.getMessage());
                    }
                case 5:


            }

        }while (opc != 0);
    }

}

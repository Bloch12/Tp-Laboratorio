package ClasesEstaticas;

import Almacenamiento.Equipo;
import Enums.IE;
import Enums.Naturaleza;
import Exepciones.*;
import Pokemones.Pokemon;

import java.util.Scanner;

public class Menu {

    private static Scanner teclado=new Scanner(System.in);
    public static void menu(){
        int opc;
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
                    movimiento = teclado.nextLine();
                    try{
                        pokemon.setMovimientos(movimiento);
                        System.out.println(pokemon.getNombreParticular() + " Aprendio " + movimiento);
                    }catch (MovimientoNoPermitidoExeption e){
                        System.out.println(e.toString());
                    }catch (MaximaCantidadDeMovimientosSobrepasadaExeption e){
                        System.out.println(pokemon.getNombreParticular() + " Intenta aprender " + movimiento + ". \nPero, " +pokemon.getNombreParticular() +
                                " ya conoce cuatro movimientos.\n Deseas remplazar un movimiento ya existente con  " + movimiento);
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        do
                            opc = teclado.nextInt();
                        while (opc != 1 && opc != 2);
                        if(opc == 1){
                            eliminarMovimiento(pokemon);
                            try {
                                pokemon.setMovimientos(movimiento);
                                System.out.println(pokemon.getNombreParticular() + " Aprendio " + movimiento);
                            }catch(MaximaCantidadDeMovimientosSobrepasadaExeption e1){
                                System.out.println(pokemon.getNombreParticular() + "No aprendio " + movimiento);
                            }catch(MovimientoNoPermitidoExeption e1){
                            }
                        }
                    }
                    break;
                case 2:
                    eliminarMovimiento(pokemon);
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo mote");
                    teclado.nextLine();
                    pokemon.setNombreParticular(teclado.nextLine());
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo nivel");
                    try{
                        pokemon.setNivel(teclado.nextInt());
                    }catch (ValorNoValidoExeption e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("ingrese la estadistica a cambiar \n1.Hp \n2.Atq \n3.Deff \n4.EspAtq \n5.EspDeff \n6.Vel");
                    do {
                        opc = teclado.nextInt();
                    }while (opc < 1 || opc > 6);
                    IE estadisticaEv = IE.No;
                    switch (opc){
                        case 1: estadisticaEv = IE.Hp;
                            break;
                        case 2: estadisticaEv = IE.Atq;
                            break;
                        case 3: estadisticaEv = IE.Deff;
                            break;
                        case 4: estadisticaEv = IE.EspAtq;
                            break;
                        case 5: estadisticaEv = IE.EspDeff;
                            break;
                        case 6: estadisticaEv = IE.Vel;
                            break;
                    }
                    System.out.println("Ingrese el nuevo valor del ev");
                    try {
                        pokemon.setEvs(teclado.nextInt(),estadisticaEv);
                    }catch (ValorNoValidoExeption e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("ingrese la estadistica a cambiar \n1.Hp \n2.Atq \n3.Deff \n4.EspAtq \n5.EspDeff \n6.Vel");
                    do {
                        opc = teclado.nextInt();
                    }while (opc < 1 || opc > 6);
                    IE estadisticaIv = IE.No;
                    switch (opc){
                        case 1: estadisticaIv = IE.Hp;
                            break;
                        case 2: estadisticaIv = IE.Atq;
                            break;
                        case 3: estadisticaIv = IE.Deff;
                            break;
                        case 4: estadisticaIv = IE.EspAtq;
                            break;
                        case 5: estadisticaIv = IE.EspDeff;
                            break;
                        case 6: estadisticaIv = IE.Vel;
                            break;
                    }
                    System.out.println("Ingrese el nuevo valor del iv");
                    try {
                        pokemon.setIvs(teclado.nextInt(),estadisticaIv);
                    }catch (ValorNoValidoExeption e){
                        System.out.println(e.getMessage());
                    }
                case 7:
                    System.out.println("Ingrese la nueva naturaleza");
                    teclado.nextLine();
                    try {
                        pokemon.setNaturaleza(Naturaleza.valueOf(teclado.nextLine()));
                    }catch(IllegalArgumentException e){
                        System.out.println("No existe esa naturaleza");
                    }
                    break;
                case 8:
                    System.out.println("Ingrese la nueva habilidad");
                    teclado.nextLine();
                    try {
                        pokemon.setHabilidad(teclado.nextLine());
                    }catch (HabilidadNoPermitidaExeption e){
                        System.out.println(e.getMessage());
                    }
            }

        }while (opc != 0);
    }

    private static void eliminarMovimiento(Pokemon pokemon){
        System.out.println(pokemon.listarMovimientos());
        System.out.println("Ingrese el numero del movimiento a olvidar O 0 para cancelar");
        int opc;
        opc = teclado.nextInt();
        do {
            try {
                pokemon.eliminarMovimiento(opc - 1);
                System.out.println("movimiento olvidado correctamente");
                opc = 0;
            } catch (ValorNoValidoExeption e) {
                System.out.println("Ingrese un numero valido o 0 para cancelar");
                opc = teclado.nextInt();
            }
        }while(opc != 0);

    }

}

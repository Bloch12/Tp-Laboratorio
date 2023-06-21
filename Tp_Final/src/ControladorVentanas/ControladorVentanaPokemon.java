package ControladorVentanas;
import ClasesEstaticas.GestorDeEquipo;
import ClasesEstaticas.Pokedex;
import Exepciones.HabilidadNoPermitidaExeption;
import Exepciones.MovimientoNoPermitidoExeption;
import Exepciones.ValorNoValidoExeption;
import Poderes.Movimiento;
import Pokemones.EspeciePokemon;
import Ventana.VentanaPokemon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Pokemones.Pokemon;

import javax.swing.*;

public class ControladorVentanaPokemon implements ActionListener {
    private VentanaPokemon ventana;
    private static ControladorVentanaPokemon instance = null;
    private static Pokemon pokemon;
    private int pos;

    private ControladorVentanaPokemon(){
        this.ventana = new VentanaPokemon();
        this.ventana.setActionListener(this);
    }

    public static ControladorVentanaPokemon getInstance(Pokemon pokemonAux) {
        if(instance == null) {
            instance = new ControladorVentanaPokemon();
        }
        pokemon = pokemonAux;
        return instance;
    }

    public static ControladorVentanaPokemon getInstance() {
        if(instance == null) {
            instance = new ControladorVentanaPokemon();
        }
        return instance;
    }


    /**
     * El boton Guardar guarda los cambios eliminados, el boton volvert vuelve a la ventana del equipo, el boton eliminar elimina el pokemon, el boton crear crea nuevos movimientos y los botones de los movimientos te muestran mas informacion de estos
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String comando = e.getActionCommand();
        if(comando.equalsIgnoreCase("Guardar")) {
            try {
                pokemon.setNaturaleza(ventana.getNaturaleza());
                pokemon.setHabilidad(ventana.getHabilidad());
                pokemon.setNombreParticular(ventana.getMote());
                pokemon.setNivel(ventana.getNivel());
                pokemon.setIvs(ventana.getIvs());
                pokemon.setEvs(ventana.getEvs());
                JOptionPane.showMessageDialog(null,"Cambios Guardados");
            }catch (ValorNoValidoExeption ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }catch (HabilidadNoPermitidaExeption ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }catch (NullPointerException ex){
                JOptionPane.showMessageDialog(null,"Por favor seleccione una habilidad");
            }
            GestorDeEquipo.subir();
        }
        if(comando.equalsIgnoreCase("Eliminar")){
            ControladorVentanaEditorEquipo aux = ControladorVentanaEditorEquipo.getInstance();
            aux.eliminarPokemon();
            aux.setDatos();
            aux.setVentana(true);
            setVentana(false);
            GestorDeEquipo.subir();
        }else if(comando.equalsIgnoreCase("Volver")) {
            ControladorVentanaEditorEquipo aux = ControladorVentanaEditorEquipo.getInstance();
            aux.setDatos();
            aux.setVentana(true);
            setVentana(false);
        }else  if(comando.equalsIgnoreCase("Crear")){
            ControladorVentanaCrearMovimiento aux= ControladorVentanaCrearMovimiento.getInstance();
            aux.setVentana(true);
            setVentana(false);
        }else{
            int i = 0;
            try {
                while (!comando.equalsIgnoreCase(pokemon.getMovimiento(i).getNombre())){
                   i++;
                }
                pos = i;
                ControladorVentanaMovimiento aux = ControladorVentanaMovimiento.getInstance(pokemon.getMovimiento(pos));
                aux.setDatos();
                aux.setVentana(true);
                setVentana(false);
            }catch (ValorNoValidoExeption ex){
            }
        }



    }

    public void setVentana(boolean b) {
        ventana.setVisible(b);
    }

    public void setDatos(){
        EspeciePokemon especie = Pokedex.buscarPokemon(pokemon.getEspecie());
        ventana.setNivel(pokemon.getNivel());
        ventana.setMote(pokemon.getNombreParticular());
        ventana.setHabilidad(pokemon.getHabilidad(),especie.getHabilidades());
        ventana.setEspecie(pokemon.getEspecie());
        ventana.setEvs(pokemon.getEvs());
        ventana.setIvs(pokemon.getIvs());
        ventana.setNaturaleza(pokemon.getNaturaleza());
        ventana.setLblImagen(especie.getSprite());
        ventana.setMovimientos(pokemon);
    }

    public void eliminarMovimiento(){
        try {
           pokemon.eliminarMovimiento(pos);
        }catch (ValorNoValidoExeption ex){
        }
    }

    public Pokemon getPokemon(){return pokemon;}

}

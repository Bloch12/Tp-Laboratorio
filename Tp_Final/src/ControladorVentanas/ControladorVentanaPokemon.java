package ControladorVentanas;
import ClasesEstaticas.Pokedex;
import Exepciones.HabilidadNoPermitidaExeption;
import Exepciones.ValorNoValidoExeption;
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
        }
        if(comando.equalsIgnoreCase("Eliminar")){
            ControladorVentanaEditorEquipo aux = ControladorVentanaEditorEquipo.getInstance();
            aux.eliminarPokemon();
            aux.setDatos();
            aux.setVentana(true);
            setVentana(false);
        }
        if(comando.equalsIgnoreCase("Volver")) {
            ControladorVentanaEditorEquipo aux = ControladorVentanaEditorEquipo.getInstance();
            aux.setDatos();
            aux.setVentana(true);
            setVentana(false);
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
    }

}

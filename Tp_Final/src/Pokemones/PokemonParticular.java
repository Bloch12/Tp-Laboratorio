package Pokemones;

import Enums.Naturaleza;
import Exepciones.HabilidadNoPermitidaExeption;
import Exepciones.MaximaCantidadDeMovimientosSobrepasadaExeption;
import Exepciones.MovimientoNoPermitidoExeption;
import Exepciones.ValorNoValidoExeption;
import Poderes.Habilidad;
import Poderes.Movimiento;

import java.util.ArrayList;

public class PokemonParticular extends Pokemon{
    private String nombreParticular;
    private Integer nivel;
    private Habilidad habilidad;
    private ArrayList<Movimiento> movimientos;
    private PokemonDatos datos;
    private ArrayList<Integer> ivs;
    private ArrayList<Integer> evs;
    private Naturaleza naturaleza;




    public PokemonParticular(String url, String especie,PokemonDatos datos) {
        super(url, especie);
        this.nombreParticular = especie;
        this.nivel = 100;
        this.datos= datos;
        this.habilidad = datos.getHabilidades().get(0);
        movimientos = new ArrayList<>();
        this.evs = new ArrayList<>();
        for(int i=0; i<6;i++){
            evs.add(0);
        }
        this.ivs = new ArrayList<>();
        for(int i=0; i<6;i++){
            ivs.add(31);
        }
        this.naturaleza = Naturaleza.Docil;
    }

    public String getNombreParticular() {
        return nombreParticular;
    }

    public void setNombreParticular(String nombreParticular) {
        this.nombreParticular = nombreParticular;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) throws HabilidadNoPermitidaExeption{
        boolean flag = false;
        int i = 0;
        Habilidad aux;
        while(i < datos.getHabilidades().size() && !flag){
            aux = datos.getHabilidades().get(i);
            if(aux.getNombre().equals(habilidad)){
                this.habilidad = aux;
                flag = true;
            }
        }
        if(!flag)
            throw new HabilidadNoPermitidaExeption(getEspecie(),habilidad);
    }

    public void setMovimientos(String movimiento) throws MaximaCantidadDeMovimientosSobrepasadaExeption,MovimientoNoPermitidoExeption {
        if(datos.getMovimientos().containsKey(movimiento)){
            if(datos.getMovimientos().size() < 4){
                movimientos.add(datos.getMovimientos().get(movimiento));
            }else{
                throw new MaximaCantidadDeMovimientosSobrepasadaExeption();
            }
        }else{
            throw new MovimientoNoPermitidoExeption(getEspecie(),movimiento);
        }
    }

    public void setIvs(int iv,int estadistica) throws ValorNoValidoExeption {
        if(estadistica > 5 || estadistica < 0){
            throw new ValorNoValidoExeption("el valor de Estadistica tiene que estar entre 0 & 5");
        }else if(iv > 31 || iv < 0){
            throw new ValorNoValidoExeption("el valor del iv tiene que estar entre 0 & 31");
        }else{
            ivs.remove(estadistica);
            ivs.add(estadistica,iv);
        }
    }

    public void setEvs(int ev,int estadistica) throws ValorNoValidoExeption {
        if(estadistica > 5 || estadistica < 0){
            throw new ValorNoValidoExeption("el valor de Estadistica tiene que estar entre 0 & 5");
        }else if(ev > 252 || ev < 0 /* crear objeto estatico que sume todo un arreglo */){
            throw new ValorNoValidoExeption("el valor del ev tiene que estar entre 0 & 252 y la suma total de los evs no puede superar 508");
        }else{
            evs.remove(estadistica);
            evs.add(estadistica,ev);
        }
    }

    public void setNaturaleza(Naturaleza naturaleza) {
        this.naturaleza = naturaleza;
    }
}

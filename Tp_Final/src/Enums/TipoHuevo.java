package Enums;

public enum TipoHuevo {
    monster("monstruo"),water1("agua 1"),bug("bicho"),flying("volador"),ground("campo"),fairy("hada"),plant("planta"),humanshape("humanoide"),water3("agua 3"),mineral("mineral"),indeterminate("no determinado"),water2("agua 2"),ditto("ditto"),dragon("dragon"),noeggs("sin huevos");

    private String tipoHuevo;

    TipoHuevo(String tipoHuevo) {
        this.tipoHuevo = tipoHuevo;
    }

    @Override
    public String toString() {
        return tipoHuevo;
    }
}

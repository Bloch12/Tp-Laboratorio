package Enums;

public enum IE {
    No("NoEstadistica",-1),Hp("Vida",0),Atq("Ataque",1),Deff("Defensa",2),EspAtq("Ataque Especial",3),EspDeff("Defensa Especial",4),Vel("Velocidad",5);
    private int i;
    private String estadistica;

    IE(String estadistica,int i) {
        this.estadistica = estadistica;
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public String getEstadistica() {
        return estadistica;
    }
}

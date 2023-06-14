package Enums;

public enum Naturaleza {
    Fuerte("fuerte",-1,-1), Osada("osada",1,2),Miedosa("miedosa",1,5),Modesta("modesta",1,3),Serena("serena",1,4),Huraña("Huraña",2,1),Docil("docil",-1,-1),Activa("activa",2,5),Afable("afable",2,3),Amable("amable",2,4),Audaz("audaz",2,1),Placida("placida",5,2),Seria("seria",-1,-1);

    private String nombre;
    private int baja;
    private int sube;

    Naturaleza(String nombre, int baja, int sube) {
        this.nombre = nombre;
        this.baja = baja;
        this.sube = sube;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBajaSube(){
        if(baja != -1){
            return "Baja: " + stats(baja) + "Sube: " + stats(sube);
        }else{
            return "Neutra";
        }

    }

    private String stats(int opc){
        switch (opc){
            case 1: return "Ataque";
            case 2: return "Defensa";
            case 3: return "Ataque especial";
            case 4: return "Defensa especial";
            case 5: return "Velocidad";
            default: return "Neutra";
        }
    }
}

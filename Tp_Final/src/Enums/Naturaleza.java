package Enums;

public enum Naturaleza {
    fuerte("fuerte", IE.No, IE.No), osada("osada", IE.Atq, IE.Deff),Miedosa("miedosa",IE.Atq,IE.Vel),Modesta("modesta",IE.Atq,IE.EspAtq),Serena("serena",IE.Atq,IE.EspDeff), Huraña("Huraña",IE.Deff,IE.Atq),
    Docil("docil",IE.No,IE.No),Activa("activa",IE.Deff,IE.Vel),Afable("afable",IE.Deff,IE.EspAtq),Amable("amable",IE.Deff,IE.EspDeff),Audaz("audaz",IE.Deff,IE.Atq),Placida("placida",IE.Vel,IE.Deff),
    Seria("seria",IE.No,IE.No),Mansa("mansa",IE.Vel,IE.EspAtq);

    private String nombre;
    private IE baja;
    private IE sube;

    Naturaleza(String nombre, IE baja, IE sube) {
        this.nombre = nombre;
        this.baja = baja;
        this.sube = sube;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBajaSube(){
        if(baja.getI() != -1){
            return "Baja: " + baja.getEstadistica() + "Sube: " + sube.getEstadistica();
        }else{
            return "Neutra";
        }

    }


}

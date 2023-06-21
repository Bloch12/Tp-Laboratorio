package Enums;

public enum Naturaleza {
    Fuerte("fuerte", IE.No, IE.No), Osada("osada", IE.Atq, IE.Deff),Miedosa("miedosa",IE.Atq,IE.Vel),Modesta("modesta",IE.Atq,IE.EspAtq),Serena("serena",IE.Atq,IE.EspDeff), Huraña("Huraña",IE.Deff,IE.Atq),
    Docil("docil",IE.No,IE.No),Activa("activa",IE.Deff,IE.Vel),Afable("afable",IE.Deff,IE.EspAtq),Amable("amable",IE.Deff,IE.EspDeff),Audaz("audaz",IE.Deff,IE.Atq),Placida("placida",IE.Vel,IE.Deff),
    Seria("seria",IE.No,IE.No),Mansa("mansa",IE.Vel,IE.EspAtq),Grosera("grosera",IE.Vel,IE.EspDeff),Firme("firme",IE.EspAtq,IE.Atq),Agitada("agitada",IE.EspAtq,IE.Deff),Alegre("alegre",IE.EspAtq,IE.Vel),
    Timida("timida",IE.No,IE.No),Cauta("cauta",IE.EspAtq,IE.EspDeff),Picara("picara",IE.EspDeff,IE.Atq),Floja("floja",IE.EspDeff,IE.Deff),Ingenua("ingenua",IE.EspDeff,IE.Vel), Alocada("alocada",IE.EspDeff,IE.EspAtq),Rara("rara",IE.No,IE.No);
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

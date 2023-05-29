package Poderes;

public class Habilidad extends Poder{
    private boolean oculta;

    public Habilidad(String nombre, String url, boolean oculta) {
        super(nombre, url);
        this.oculta = oculta;
    }

    public boolean isOculta() {
        return oculta;
    }

    public void setOculta(boolean oculta) {
        this.oculta = oculta;
    }
}

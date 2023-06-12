package Enums;

public enum TipoDeDaño {
    status("estado"),physical("fisico"),special("especial");
    private String tipoDeDaño;

    TipoDeDaño(String tipoDeDaño) {
        this.tipoDeDaño = tipoDeDaño;
    }

    public String getTipoDeDaño() {
        return tipoDeDaño;
    }
}

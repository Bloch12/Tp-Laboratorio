package Enums;

public enum Color {
    black("Negro"),blue("Azul"),brown("marron"),gray("gris"),green("verde"),pink("rosa"),purple("violeta"),red("rojo"),white("blanco"),yellow("amarillo");

    private String color;

    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color ;
    }
}

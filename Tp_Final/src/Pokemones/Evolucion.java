package Pokemones;

public class Evolucion  {
    private int etapa;
    private String especie;
    private String trigger;
    private int minNivel;
    private int minFel;
    private int bellezaMinima;
    private String objeto;
    private String objetoEquipado;
    private String horario;

    public Evolucion() {
        this.etapa = -1;
        this.especie = "";
        this.trigger = "";
        this.minNivel = 0;
        this.minFel = 0;
        this.bellezaMinima = 0;
        this.objeto = "";
        this.objetoEquipado = "";
        this.horario = "";
    }
    public Evolucion(int etapa) {
        this.etapa = etapa;
        this.especie = "";
        this.trigger = "";
        this.minNivel = 0;
        this.minFel = 0;
        this.bellezaMinima = 0;
        this.objeto = "";
        this.objetoEquipado = "";
        this.horario = "";
    }
    public Evolucion(int etapa, String especie, String trigger, int minNivel, int minFel, int bellezaMinima, String objeto, String objetoEquipado, String horario) {
        this.etapa = etapa;
        this.especie = especie;
        this.trigger = trigger;
        this.minNivel = minNivel;
        this.minFel = minFel;
        this.bellezaMinima = bellezaMinima;
        this.objeto = objeto;
        this.objetoEquipado = objetoEquipado;
        this.horario = horario;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public int getMinNivel() {
        return minNivel;
    }

    public void setMinNivel(int minNivel) {
        this.minNivel = minNivel;
    }

    public int getMinFel() {
        return minFel;
    }

    public void setMinFel(int minFel) {
        this.minFel = minFel;
    }

    public int getBellezaMinima() {
        return bellezaMinima;
    }

    public void setBellezaMinima(int bellezaMinima) {
        this.bellezaMinima = bellezaMinima;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getObjetoEquipado() {
        return objetoEquipado;
    }

    public void setObjetoEquipado(String objetoEquipado) {
        this.objetoEquipado = objetoEquipado;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Evolucion{" +
                "etapa=" + etapa +
                ", especie='" + especie + '\'' +
                ", trigger='" + trigger + '\'' +
                ", minNivel=" + minNivel +
                ", minFel=" + minFel +
                ", bellezaMinima=" + bellezaMinima +
                ", objeto='" + objeto + '\'' +
                ", objetoEquipado='" + objetoEquipado + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }

}

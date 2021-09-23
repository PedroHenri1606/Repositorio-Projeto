package Main;


public class Corrida {
    String horario;
    String numeroPassageiro;

    public Corrida() {

    }

    public Corrida(String horario, String numeroPassageiro) {
        this.horario = horario;
        this.numeroPassageiro = numeroPassageiro;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNumeroPassageiro() {
        return numeroPassageiro;
    }

    public void setNumeroPassageiro(String numeroPassageiro) {
        this.numeroPassageiro = numeroPassageiro;
    }
}

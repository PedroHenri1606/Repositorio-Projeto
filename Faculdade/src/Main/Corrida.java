package Main;

public class Corrida {
    private String horario;//Instant
    private String numeroPassageiro;
    private int id;
    Trajeto rota = new Trajeto();
    ValorCorrida valor = new ValorCorrida();

    @Override
    public String toString() {
        return "Corrida{" +
                "horario='" + horario + '\'' +
                ", numeroPassageiro='" + numeroPassageiro + '\'' +
                ", id=" + id +
                ", rota=" + rota +
                '}';
    }

    public Corrida() {

    }

    public Corrida(String horario, String numeroPassageiro) {
        this.horario = horario;
        this.numeroPassageiro = numeroPassageiro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

package Main;
import java.util.ArrayList;
import java.util.List;
public class Corrida {
    private String horario;//Instant
    private String numeroPassageiro;
    private int id;
    private List<Rota> trajetos = new ArrayList<Rota>();
    private Pagemento valor = new Pagemento();

    public Corrida() {
    }

    public Corrida(String horario, String numeroPassageiro, int id, List<Rota> trajetos, Pagemento valor) {
        this.horario = horario;
        this.numeroPassageiro = numeroPassageiro;
        this.id = id;
        this.trajetos = trajetos;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Corrida{" +
                "horario='" + horario + '\'' +
                ", numeroPassageiro='" + numeroPassageiro + '\'' +
                ", id=" + id +
                ", trajetos=" + trajetos +
                ", valor=" + valor +
                '}';
    }

    public Pagemento getValor() {
        return valor;
    }

    public void setValor(Pagemento valor) {
        this.valor = valor;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Rota> getTrajetos() {
        return trajetos;
    }

    public void setTrajetos(List<Rota> trajetos) {
        this.trajetos = trajetos;
    }
}

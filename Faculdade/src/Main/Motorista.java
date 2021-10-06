package Main;
import java.util.ArrayList;
import java.util.List;
public class Motorista {
    private Cliente dados = new Cliente();
    private Veiculo dadosVeiculo = new Veiculo();
    private List<Mensagens> mens = new ArrayList<Mensagens>();
    private Mensagens mensagens = new Mensagens();
    @Override
    public String toString() {
        return "Motorista{" +
                "dados=" + dados +
                ", dadosVeiculo=" + dadosVeiculo +
                ", mens=" + mens +
                '}';
    }

    public Cliente getDados() {
        return dados;
    }

    public void setDados(Cliente dados) {
        this.dados = dados;
    }

    public Veiculo getDadosVeiculo() {
        return dadosVeiculo;
    }

    public void setDadosVeiculo(Veiculo dadosVeiculo) {
        this.dadosVeiculo = dadosVeiculo;
    }

    public List<Mensagens> getMens() {
        return mens;
    }

    public void setMens(List<Mensagens> mens) {
        this.mens = mens;
    }
}

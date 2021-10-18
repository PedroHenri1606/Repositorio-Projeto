package Main;
import java.util.ArrayList;
import java.util.List;

public class Motorista extends Cliente{
    private Veiculo dadosVeiculo = new Veiculo();


    public Veiculo getDadosVeiculo() {
        return dadosVeiculo;
    }

    public void setV1(Veiculo dadosVeiculo) {
        this.dadosVeiculo = dadosVeiculo;
    }

}

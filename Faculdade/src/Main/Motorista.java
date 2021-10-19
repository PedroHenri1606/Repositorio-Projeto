package Main;

public class Motorista extends Pessoa {
    private Veiculo dadosVeiculo = new Veiculo();

    public Veiculo getDadosVeiculo() {
        return dadosVeiculo;
    }

    public void setDadosVeiculo(Veiculo dadosVeiculo) {
        this.dadosVeiculo = dadosVeiculo;
    }
}

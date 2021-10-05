package Main;

public class Veiculo {
    private String nomeVeiculo;
    private String placaVeiculo;
    private String corVeiculo;

    public Veiculo() {
    }


    @Override
    public String toString() {
        return "Veiculo{" +
                "nomeVeiculo='" + nomeVeiculo + '\'' +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                ", corVeiculo='" + corVeiculo + '\'' +
                '}';
    }

    public Veiculo(String nomeVeiculo, String placaVeiculo, String corVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.corVeiculo = corVeiculo;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getCorVeiculo() {
        return corVeiculo;
    }

    public void setCorVeiculo(String corVeiculo) {
        this.corVeiculo = corVeiculo;
    }
}

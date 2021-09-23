package Main;

public class Trajeto {
    String enderecoOrigem;
    String enderecoDestino;

    public Trajeto() {

    }

    public Trajeto(String enderecoOrigem, String enderecoDestino) {
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(String enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }
}

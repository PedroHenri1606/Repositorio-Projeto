package Main;

public class Trajeto {
    private String enderecoOrigem;
    private String enderecoDestino;
    private int id;
    //criar um atributo codigo;

    @Override
    public String toString() {
        return "Trajeto{" +
                "enderecoOrigem='" + enderecoOrigem + '\'' +
                ", enderecoDestino='" + enderecoDestino + '\'' +
                '}';
    }

    public Trajeto() {

    }

    public Trajeto(String enderecoOrigem, String enderecoDestino) {
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

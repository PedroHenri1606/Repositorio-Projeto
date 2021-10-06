package Main;

public class Rota {
    private String enderecoOrigem;
    private String enderecoDestino;
    private double custo;
    private int id;
    //criar um atributo codigo;


    @Override
    public String toString() {
        return "Rota{" +
                "enderecoOrigem='" + enderecoOrigem + '\'' +
                ", enderecoDestino='" + enderecoDestino + '\'' +
                ", custo=" + custo +
                ", id=" + id +
                '}';
    }

    public Rota() {

    }

    public Rota(String enderecoOrigem, String enderecoDestino) {
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

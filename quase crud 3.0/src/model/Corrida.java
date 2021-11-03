package model;

public class Corrida {
    private String idUser;
    private String nome;
    private String preco;
    private String id;

    public Corrida() {
    }

    public Corrida(String nome, String id, String idUser, String preco) {
        this.nome = nome;
        this.id = id;
        this.idUser = idUser;
        this.preco = preco;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package model;

public class corrida {
    private String idUser;
    private String nome;
    private String id;

    public corrida() {
    }

    public corrida(String nome, String id, String idUser) {
        this.nome = nome;
        this.id = id;
        this.idUser = idUser;
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

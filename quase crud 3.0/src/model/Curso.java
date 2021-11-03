package model;

public class Curso {

    private String nome;
    private String id;

    public Curso(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public Curso() {
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

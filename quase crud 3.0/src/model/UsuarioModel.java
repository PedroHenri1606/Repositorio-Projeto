package model;
public class UsuarioModel {
    String nome;
    String senha;
    String bairro;
    String id;
    String destino;
    String email;
    String curso;

    public UsuarioModel(String nome, String senha, String bairro, String destino, String email, String id, String curso) {
        this.nome = nome;
        this.senha = senha;
        this.bairro = bairro;
        this.id = id;
        this.destino = destino;
        this.email = email;
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}

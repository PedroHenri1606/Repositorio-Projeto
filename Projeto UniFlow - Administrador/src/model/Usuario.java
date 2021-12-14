package model;

public class Usuario {
    private long idUsuario;
    private String nome;
    private String senha;
    private long codigoAcesso;

    public Usuario() {
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
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

    public long getCodigoAcesso() {
        return codigoAcesso;
    }

    public void setCodigoAcesso(long codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
    }

}

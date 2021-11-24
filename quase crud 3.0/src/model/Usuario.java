package model;
public class Usuario {
    String nome;
    String sobrenome;
    String senha;
    String email;
    long idbairro;
    long idUsuario;
    String destino;
    Long idcurso;

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", idbairro=" + idbairro +
                ", idUsuario=" + idUsuario +
                ", destino='" + destino + '\'' +
                ", idcurso=" + idcurso +
                '}';
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public long getIdbairro() {
        return idbairro;
    }

    public void setIdbairro(long idbairro) {
        this.idbairro = idbairro;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Long getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Long idcurso) {
        this.idcurso = idcurso;
    }
}

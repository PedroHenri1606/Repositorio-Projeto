package Main;

public class Motorista {
    protected String nomeCompleto;
    protected String senha;
    protected String curso;
    protected String nomeVeiculo;
    protected String placaVeiculo;
    protected String corVeiculo;
    protected boolean login;
    protected String ra;

    public Motorista(String nomeCompleto, String senha, String curso, String nomeVeiculo, String placaVeiculo, String corVeiculo, boolean login) {
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.curso = curso;
        this.nomeVeiculo = nomeVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.corVeiculo = corVeiculo;
        this.login = login;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCurso() {
        return curso;
        }

    public void setCurso(String curso) {
        this.curso = curso;
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

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
}

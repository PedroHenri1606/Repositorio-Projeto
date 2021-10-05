package Main;

public class Passageiro {
    protected String nomeCompleto;
    protected String senha;
    protected String curso;
    protected String ra;
    protected boolean login;

    @Override
    public String toString() {
        return "Passageiro{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", senha='" + senha + '\'' +
                ", curso='" + curso + '\'' +
                ", ra='" + ra + '\'' +
                ", login=" + login +
                '}';
    }

    public Passageiro(String nomeCompleto, String senha, String curso, String ra, boolean login) {
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.curso = curso;
        this.ra = ra;
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

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}

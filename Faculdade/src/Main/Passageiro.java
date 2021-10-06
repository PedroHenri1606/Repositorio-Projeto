package Main;
import java.util.ArrayList;
import java.util.List;
public class Passageiro {
    protected String nomeCompleto;
    protected String senha;
    protected String curso;
    protected String ra;
    protected boolean login;
    private List<Mensagens> mens = new ArrayList<Mensagens>();

    @Override
    public String toString() {
        return "Passageiro{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", senha='" + senha + '\'' +
                ", curso='" + curso + '\'' +
                ", ra='" + ra + '\'' +
                ", login=" + login +
                ", mens=" + mens +
                '}';
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

    public List<Mensagens> getMens() {
        return mens;
    }

    public void setMens(List<Mensagens> mens) {
        this.mens = mens;
    }

    public Passageiro() {
    }

    public Passageiro(String nomeCompleto, String senha, String curso, String ra, boolean login, List<Mensagens> mens) {
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.curso = curso;
        this.ra = ra;
        this.login = login;
        this.mens = mens;
    }
}

package Main;
public class Mensagens {

    private String mensagemEnviar;
    private String mensagemReceber;

    public Mensagens() {

    }

    public Mensagens(String mensagemEnviar, String mensagemReceber) {
        this.mensagemEnviar = mensagemEnviar;
        this.mensagemReceber = mensagemReceber;
    }

    public String getMensagemEnviar() {
        return mensagemEnviar;
    }

    public void setMensagemEnviar(String mensagemEnviar) {
        this.mensagemEnviar = mensagemEnviar;
    }

    public String getMensagemReceber() {
        return mensagemReceber;
    }

    public void setMensagemReceber(String mensagemReceber) {
        this.mensagemReceber = mensagemReceber;
    }

    @Override
    public String toString() {
        return "Mensagens{" +
                "mensagemEnviar='" + mensagemEnviar + '\'' +
                ", mensagemReceber='" + mensagemReceber + '\'' +
                '}';
    }

}

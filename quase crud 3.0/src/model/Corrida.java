package model;

public class Corrida {
    private long idUser;
    private String hora;
    private int dia;
    private int mes;
    private int ano;
    private double preco;
    private long idCorrida;

    public Corrida() {
    }

    @Override
    public String toString() {
        return "Corrida{" +
                "idUser=" + idUser +
                ", hora='" + hora + '\'' +
                ", dia=" + dia +
                ", mes=" + mes +
                ", ano=" + ano +
                ", preco=" + preco +
                ", idCorrida=" + idCorrida +
                '}';
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public long getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(long idCorrida) {
        this.idCorrida = idCorrida;
    }
}

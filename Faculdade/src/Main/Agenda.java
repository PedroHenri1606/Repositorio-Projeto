public class Agenda {

    private int dia;
    private int mes;
    private int ano;
    private double hora;
    private String lugar;

    public Agenda(int dia, int mes, int ano, double hora, String lugar) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.lugar = lugar;
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

    public double getHora() {
        return hora;
    }

    public void setHora(double hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", ano=" + ano +
                ", hora=" + hora +
                ", lugar='" + lugar + '\'' +
                '}';
    }

}



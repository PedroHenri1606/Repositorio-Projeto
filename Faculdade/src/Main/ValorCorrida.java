package Main;

public class ValorCorrida{

    private double precoMedia;
    private double gastoPorLitro;
    private double valorTotal;
    private double valorPagarPassageiro;

    public ValorCorrida() {
    }

    public ValorCorrida(double precoMedia, double gastoPorLitro, double valorTotal, double valorPagarPassageiro) {
        this.precoMedia = precoMedia;
        this.gastoPorLitro = gastoPorLitro;
        this.valorTotal = valorTotal;
        this.valorPagarPassageiro = valorPagarPassageiro;
    }

    public double getPrecoMedia() {
        return precoMedia;
    }

    public void setPrecoMedia(double precoMedia) {
        this.precoMedia = precoMedia;
    }

    public double getGastoPorLitro() {
        return gastoPorLitro;
    }

    public void setGastoPorLitro(double gastoPorLitro) {
        this.gastoPorLitro = gastoPorLitro;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorPagarPassageiro() {
        return valorPagarPassageiro;
    }

    public void setValorPagarPassageiro(double valorPagarPassageiro) {
        this.valorPagarPassageiro = valorPagarPassageiro;
    }

    @Override
    public String toString() {
        return "ValorCorrida{" +
                "precoMedia=" + precoMedia +
                ", gastoPorLitro=" + gastoPorLitro +
                ", valorTotal=" + valorTotal +
                ", valorPagarPassageiro=" + valorPagarPassageiro +
                '}';
    }

}


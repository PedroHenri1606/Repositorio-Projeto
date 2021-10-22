package view;

import controller.BairroController;
import controller.IdBairroController;
import model.Bairro;

import java.util.Scanner;

public class BairroView {

    IdBairroController id = new IdBairroController();
    BairroController x = new BairroController();

    public void cadastrarBairro() {
        Scanner scan = new Scanner(System.  in);
        System.out.print("nome do bairro: ");
        String tmp1 = scan.nextLine();
        String tmp2 = id.determinarID();
        Bairro aux = new Bairro(tmp1,tmp2);
        x.cadastrar(aux);
    }
    public void visualizar() {
        x.visualizar();
    }
    public void carregarDados() {
        x.carregar();
    }

}

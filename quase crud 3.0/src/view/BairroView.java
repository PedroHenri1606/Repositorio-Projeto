package view;

import controller.BairroController;
import controller.IdBairroController;
import model.Bairro;

import java.util.List;
import java.util.Scanner;

public class BairroView {

    IdBairroController idBairroController = new IdBairroController();
    BairroController bairroController = new BairroController();
    Scanner scan = new Scanner(System.in);
    public void cadastrarBairro() {
        Bairro bairro = new Bairro();
        System.out.println("==============================================");
        System.out.print(" Nome do bairro: ");
        bairro.setNome(scan.nextLine());
        System.out.println("==============================================\n");
        bairro.setId(idBairroController.determinarID());
        bairroController.cadastrar(bairro);
    }

    public void visualizar() {
        List<Bairro> bairros = bairroController.visualizar();
        int i = 0;
        for (Bairro bairro : bairros) {
            System.out.println("[" + i + "] " + bairro.getNome());
            i++;
        }
    }

    public void carregarDados() {
        bairroController.carregar();
    }

    public String escolherBairro(int escolha) {
        return bairroController.escolherBairro(escolha);
    }
}

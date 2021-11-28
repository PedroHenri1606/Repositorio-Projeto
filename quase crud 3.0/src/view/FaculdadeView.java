package view;

import controller.FaculdadeController;
import model.Faculdade;

import java.util.List;
import java.util.Scanner;

public class FaculdadeView {
    FaculdadeController faculdadeController = new FaculdadeController();
    public void cadastrar() {
        this.linha();
        Scanner scanner = new Scanner(System.in);
        Faculdade faculdade = new Faculdade();
        System.out.print("Digite a faculdade: ");
        faculdade.setNome(scanner.nextLine());
        faculdadeController.SalvarFaculdade(faculdade);
    }
    public void linha() {
        System.out.println("==============================");
    }
    public Faculdade selecionarFaculdade() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            this.linha();
            List<Faculdade> faculdades = faculdadeController.listarFaculdade();
            for (int i = 0; i<faculdades.size(); i++) {
                System.out.println(faculdades.get(i).toString());
            }
            System.out.println("digite o id da faculdade");
            long tmp = Long.parseLong(scanner.nextLine());
            for (int i = 0; i< faculdades.size(); i++) {
                if (faculdades.get(i).getIdFaculdade() == tmp) {
                    return faculdades.get(i);
                }
            }
            System.out.println("nenhum id encontrado, digite novamente");
        }
    }
}

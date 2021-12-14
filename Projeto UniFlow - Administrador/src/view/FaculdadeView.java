package view;

import controller.FaculdadeController;
import model.Faculdade;

import javax.swing.*;

public class FaculdadeView {

    public void adicionarFaculdade(){

        FaculdadeController faculdadeController = new FaculdadeController();
        Faculdade faculdade = new Faculdade();

        String faculdadeCad = JOptionPane.showInputDialog(null,"      CADASTRO FACULDADE\n\n"+"Nome: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        faculdade.setNome(faculdadeCad);
        faculdadeController.adicionarFaculdade(faculdade);
    }
}

package view;

import controller.BairroController;
import model.Bairro;

import javax.swing.*;

public class BairroView {

    public void adicionarBairro(){

        BairroController bairroController = new BairroController();
        Bairro bairro = new Bairro();

        String bairroCad = JOptionPane.showInputDialog(null,"      CADASTRO BAIRRO\n\n"+"Nome: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        bairro.setNome(bairroCad);
        bairroController.adicionarBairro(bairro);
    }
}

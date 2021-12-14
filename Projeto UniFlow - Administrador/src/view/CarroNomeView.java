package view;

import controller.CarroNomeController;
import model.CarroNome;

import javax.swing.*;

public class CarroNomeView {

    public void adicionarNomeCarro(){

        CarroNomeController carroNomeController = new CarroNomeController();
        CarroNome carroNome = new CarroNome();

        String nomeCad = JOptionPane.showInputDialog(null,"      CADASTRO NOME MODELO\n\n"+"Nome: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        carroNome.setNome(nomeCad);
        carroNomeController.adicionarNome(carroNome);
    }
}

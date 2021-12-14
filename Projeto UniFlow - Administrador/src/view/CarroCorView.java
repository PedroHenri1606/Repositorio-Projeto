package view;

import controller.CarroCorController;
import model.CarroCor;

import javax.swing.*;

public class CarroCorView {

    public void adicionarCorCarro(){

        CarroCorController carroCorController = new CarroCorController();
        CarroCor carroCor = new CarroCor();

        String corCad = JOptionPane.showInputDialog(null,"      CADASTRO COR VEICULO\n\n"+"Nome: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        carroCor.setNome(corCad);
        carroCorController.adicionarCor(carroCor);
    }
}

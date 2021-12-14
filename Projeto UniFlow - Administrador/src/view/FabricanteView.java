package view;

import controller.FabricanteController;
import model.CarroFabricante;

import javax.swing.*;

public class FabricanteView {

    public void adicionarFabricante(){

        FabricanteController fabricanteController = new FabricanteController();
        CarroFabricante carroFabricante = new CarroFabricante();

        String fabricanteCad = JOptionPane.showInputDialog(null,"      CADASTRO FABRICANTE\n\n"+"Nome: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        carroFabricante.setNome(fabricanteCad);
        fabricanteController.adicionarFabricante(carroFabricante);
    }
}

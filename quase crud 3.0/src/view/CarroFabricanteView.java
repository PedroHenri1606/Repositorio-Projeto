package view;

import controller.CarroFabricanteController;
import model.CarroFabricante;
import java.util.List;

public class CarroFabricanteView {

    public List<CarroFabricante>visualizarFabricante(){
        CarroFabricanteController carroFabricanteController = new CarroFabricanteController();
       return carroFabricanteController.listar();
    }
}

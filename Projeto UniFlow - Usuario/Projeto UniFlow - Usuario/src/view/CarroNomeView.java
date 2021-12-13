package view;

import controller.CarroNomeController;
import model.CarroNome;
import java.util.List;

public class CarroNomeView {

    public List<CarroNome> visualizarNome(){
        CarroNomeController carroNomeController = new CarroNomeController();
        return carroNomeController.listar();
    }
}

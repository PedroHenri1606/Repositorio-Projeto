package view;

import controller.CarroCorController;
import model.CarroCor;
import java.util.List;

public class CarroCorView {

    public List<CarroCor> visualizarCor(){
        CarroCorController carroCorController = new CarroCorController();
        return carroCorController.listar();
    }
}


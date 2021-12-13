package view;

import controller.BairroController;
import model.Bairro;
import java.util.List;

public class BairroView {

    public List<Bairro> visualizar() {
        BairroController bairroController = new BairroController();
         return  bairroController.listar();
    }
}
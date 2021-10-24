package view;

import controller.CorridaController;
import controller.IdCorridaController;
import model.corrida;

import java.util.*;

public class CorridaView {

    IdCorridaController id = new IdCorridaController();
    CorridaController x = new CorridaController();

    public void cadastrarCorrida(String idUser) {
        Scanner scan = new Scanner(System.in);
        System.out.println("horario da corrida: ");
        String tmp1 = scan.nextLine();
        String tmp2 = id.determinarID();
        corrida aux = new corrida(tmp1, tmp2, idUser);
        x.cadastrar(aux);
    }

    public void visualizar(String userID) {
        x.visualizar(userID);
    }

    public void carregarDados() {
        x.carregar();
    }
}

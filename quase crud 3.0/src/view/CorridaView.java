package view;

import controller.CorridaController;
import controller.IdCorridaController;
import model.corrida;

import java.util.*;

public class CorridaView {

    IdCorridaController id = new IdCorridaController();
    CorridaController x = new CorridaController();
    Scanner scan = new Scanner(System.in);
    public void cadastrarCorrida(String idUser) {
        System.out.println("==============================================");
        System.out.print(" Horario da corrida: ");
        String tmp1 = scan.nextLine();
        System.out.print("quanto foi a corrida: ");
        String tmp2 = scan.nextLine();
        System.out.println("==============================================\n");
        String tmp3 = id.determinarID();
        corrida aux = new corrida(tmp1, tmp3, idUser, tmp2);
        x.cadastrar(aux);
    }


    public void visualizar(String userID) {
        List<String> aux =  x.visualizar(userID);
        for(String tmp : aux) {
            System.out.println(tmp);
        }
    }

    public void carregarDados() {
        x.carregar();
    }
}

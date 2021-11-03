package view;

import controller.CorridaController;
import controller.IdCorridaController;
import model.Corrida;

import java.util.*;

public class CorridaView {

    IdCorridaController id = new IdCorridaController();
    CorridaController corridaController = new CorridaController();
    Scanner scan = new Scanner(System.in);

    public void cadastrarCorrida(String idUser) {
        System.out.println("==============================================");
        System.out.print(" Horario da corrida: ");
        String tmp1 = scan.nextLine();
        System.out.print("quanto foi a corrida: ");
        String tmp2 = scan.nextLine();
        System.out.println("==============================================\n");
        String tmp3 = id.determinarID();
        Corrida aux = new Corrida(tmp1, tmp3, idUser, tmp2);
        corridaController.cadastrar(aux);
    }


    public void visualizar(String userID) {
        this.linha();
        System.out.println("[1] escolher corrida");
        System.out.println("[2] sair");
        switch (Integer.parseInt(scan.nextLine())) {
            case 1 -> this.escolherCorrida(userID);
            case 2 -> {
                return;
            }
        }
    }

    public void escolherCorrida(String userId) {
        this.linha();
        List<Corrida> aux = corridaController.visualizar(userId);
        for (int i = 0; i < aux.size(); i++) {
            System.out.println("[" + i + "] " + aux.get(i).getNome());
        }
        this.linha();
        System.out.println("escolha a corrida: ");
        int escolha = Integer.parseInt(scan.nextLine());
        corridaController.determinarCorridaAtual(aux.get(escolha).getId());

    }

    public void carregarDados() {
        corridaController.carregar();
    }

    public void linha() {
        System.out.println("--------------------------------");
    }
}

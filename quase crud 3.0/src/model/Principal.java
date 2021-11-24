package model;

import controller.CorridaController;
import controller.UsuarioController;
import view.BairroView;
import view.CursoView;
import view.UsuarioView;
import view.CorridaView;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        //Objetos
        UsuarioView vuser = new UsuarioView();
        BairroView vbairro = new BairroView();
        CorridaController corridaController = new CorridaController();
        CursoView vCurso = new CursoView();
        UsuarioController usuarioController = new UsuarioController();

        //Inicialização
        vbairro.carregarDados();
        //vuser.carregarDados();
        corridaController.criarTabelaCorrida();
        vCurso.carregarDados();
        usuarioController.CriarTabela();

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("==============================================");
            System.out.println("          [Escolha uma opção] \n");
            System.out.println("     [1]- Realizar Login ");
            System.out.println("     [2]- Cadastrar novo Usuario\n");
            System.out.println("==============================================");
            System.out.print(" Opção: ");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1 -> vuser.realizarlogin();
                case 2 -> vuser.cadastroUsuario();
            }
        }
    }
}

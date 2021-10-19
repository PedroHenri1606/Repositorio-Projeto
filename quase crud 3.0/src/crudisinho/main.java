package crudisinho;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        arquivo user = new arquivo();
        user.carregar();
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("adicionar usuario - 1");
            System.out.println("salvar - 2");
            System.out.println("editar - 3");
            System.out.println("remover - 4");
            System.out.print("digite a opcao: ");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1:
                    user.adicionar();
                    break;
                case 2:
                    user.salvar();
                    break;
                case 3:
                    user.editar();
                    break;
                case 4:
                    user.remover();
                    break;
            }
        }
    }
}

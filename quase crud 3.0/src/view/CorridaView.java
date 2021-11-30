package view;

import controller.CorridaController;
import model.Corrida;
import model.Usuario;

import java.util.*;

public class CorridaView {

    CorridaController corridaController = new CorridaController();
    Scanner scan = new Scanner(System.in);

    public void visualizarCorrida(Usuario usuario) {
        List<Corrida> corridas = corridaController.visualizar(usuario);
        System.out.println("==============================================");
        for (Corrida corrida : corridas) {
            System.out.println("Id: "+ corrida.getIdCorrida() + " Dia da corrida: " + corrida.getDia() + " Preço da corrida: " + corrida.getPreco());
        }
        System.out.println("==============================================");
    }

    public void cadastrarCorrida(Usuario usuario) {
        Corrida corrida = new Corrida();
        System.out.println("==============================================");
        System.out.print  ("Horario da corrida: "); corrida.setHora(scan.nextLine());
        System.out.print  ("Dia da corrida: ");     corrida.setDia(Integer.parseInt(scan.nextLine()));
        System.out.print  ("Mês da corrida: ");     corrida.setMes(Integer.parseInt(scan.nextLine()));
        System.out.print  ("Ano da corrida: ");     corrida.setAno(Integer.parseInt(scan.nextLine()));
        System.out.print  ("Preço da corrida: ");   corrida.setPreco(Double.parseDouble(scan.nextLine()));
        corrida.setUser(usuario);
        System.out.println("==============================================\n");
        corridaController.cadastrarCorrida(corrida);
    }


    public void escolherCorrida(Usuario usuario) {
        this.visualizarCorrida(usuario);
        System.out.println(" Digite o id da corrida: "); long idCorrida = Long.parseLong(scan.nextLine());
        System.out.println("==============================================");
        Corrida corridaAtual = corridaController.determinarCorridaAtual(idCorrida, usuario);
        this.menuCorrida(corridaAtual, usuario);
    }

    public void menuCorrida(Corrida corridaAtual, Usuario usuario) {

        while (true) {
            System.out.println("==============================================\n");
            System.out.println("    [1] - Visualizar informacoes ");
            System.out.println("    [2] - Editar informacoes ");
            System.out.println("    [3] - Sair");
            System.out.println("==============================================");
            System.out.println(" Opção: "); int opcaoEscolhida = Integer.parseInt(scan.nextLine());
            switch (opcaoEscolhida) {
                case 1 -> {this.visualizarInformacoesCorridaAtual(corridaAtual, usuario);}
                case 2 -> {corridaAtual = this.editarCorridaAtual(corridaAtual, usuario);}
                case 3 -> {return;}
            }
        }
    }

    public void visualizarInformacoesCorridaAtual(Corrida corridaAtual, Usuario usuario) {
        System.out.println("==============================================");
        System.out.println("Id do dono da corrida: " + usuario.getIdUsuario());
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Horario: " + corridaAtual.getHora());
        System.out.println("Dia da corrida: " + corridaAtual.getDia());
        System.out.println("Mes da corrida: " + corridaAtual.getMes());
        System.out.println("Ano da corrida: " + corridaAtual.getAno());
        System.out.println("Preço: " + corridaAtual.getPreco());
        System.out.println("==============================================");
    }

    public Corrida editarCorridaAtual(Corrida corridaAtual, Usuario usuario) {
        while (true) {

            Corrida tmp = corridaAtual;
            System.out.println("==============================================");
            System.out.println("      [1] - Editar hora");
            System.out.println("      [2] - Editar dia");
            System.out.println("      [3] - Editar mes");
            System.out.println("      [4] - Editar ano");
            System.out.println("      [5] - Editar preco");
            System.out.println("      [6] - Ealvar alteracoes");
            System.out.println("      [7] - Sair");
            System.out.println("==============================================");
            System.out.print  (" Opção: "); int escolha = Integer.parseInt(scan.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> tmp = this.editarHora(tmp);
                case 2 -> tmp = this.editarDia(tmp);
                case 3 -> tmp = this.editarMes(tmp);
                case 4 -> tmp = this.editarAno(tmp);
                case 5 -> tmp = this.editarPreco(tmp);
                case 6 -> {
                    System.out.print("Informe a senha para salvar: "); String senha = scan.nextLine();
                    if (usuario.getSenha().equals(senha)) {
                        System.out.println("==============================================");
                        System.out.println("               Senha correta!!");
                        System.out.println("==============================================");
                        corridaAtual = tmp;
                        this.salvarAlteracoes(corridaAtual);
                    }
                }
                case 7 -> {return corridaAtual;}
            }
        }
    }

    public void salvarAlteracoes(Corrida corridaAtual) {
        this.corridaController.salvarAlteracoes(corridaAtual);
    }

    public Corrida editarHora(Corrida corrida) {
        System.out.println("==============================================");
        System.out.println("Hora atual: " + corrida.getHora());
        System.out.print  ("Digite a nova hora: "); corrida.setHora(scan.nextLine());
        System.out.println("==============================================");
        return corrida;
    }
    public Corrida editarDia(Corrida tmp) {
        System.out.println("==============================================");
        System.out.println("Dia atual: " + tmp.getDia());
        System.out.print  ("Digite o novo dia: "); tmp.setDia(Integer.parseInt(scan.nextLine()));
        System.out.println("==============================================");
        return tmp;
    }
    public Corrida editarMes(Corrida corrida) {
        System.out.println("==============================================");
        System.out.println("Mês atual: " + corrida.getMes());
        System.out.print  ("Digite o novo mês: "); corrida.setMes(Integer.parseInt(scan.nextLine()));
        System.out.println("==============================================");
        return corrida;
    }
    public Corrida editarAno(Corrida corrida) {
        System.out.println("==============================================");
        System.out.println("Ano atual: " + corrida.getAno());
        System.out.print  ("Digite o novo ano: "); corrida.setAno(Integer.parseInt(scan.nextLine()));
        System.out.println("==============================================");
        return corrida;
    }
    public Corrida editarPreco(Corrida tmp) {
        System.out.println("==============================================");
        System.out.println("Preço atual: " + tmp.getPreco());
        System.out.print  ("Digite o preco novo: "); tmp.setPreco(Double.parseDouble(scan.nextLine()));
        System.out.println("==============================================");
        return tmp;
    }

}

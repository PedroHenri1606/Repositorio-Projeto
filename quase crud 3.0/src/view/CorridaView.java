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
        System.out.println("===========================================");
        for (Corrida corrida : corridas) {
            System.out.println("id da corrida: "+ corrida.getIdCorrida() + " dia da corrida: " + corrida.getDia() + " preco da corrida: " + corrida.getPreco());
        }

    }

    public void cadastrarCorrida(Usuario usuario) {
        Corrida corrida = new Corrida();
        System.out.println("==============================================");

        System.out.print("horario da corrida: ");
        corrida.setHora(scan.nextLine());
        System.out.print("dia da corrida: ");
        corrida.setDia(Integer.parseInt(scan.nextLine()));
        System.out.print("mes da corrida: ");
        corrida.setMes(Integer.parseInt(scan.nextLine()));
        System.out.print("ano da corrida: ");
        corrida.setAno(Integer.parseInt(scan.nextLine()));
        System.out.print("preco da corrida: ");
        corrida.setPreco(Double.parseDouble(scan.nextLine()));
        corrida.setIdUser(usuario.getIdUsuario());
        System.out.println("==============================================\n");
        corridaController.cadastrarCorrida(corrida);
    }


    public void escolherCorrida(Usuario usuario) {
        this.visualizarCorrida(usuario);
        System.out.println("===========================================");
        System.out.println("digite o id da corrida: ");
        long idCorrida = Long.parseLong(scan.nextLine());
        Corrida corridaAtual = corridaController.determinarCorridaAtual(idCorrida, usuario);
        this.menuCorrida(corridaAtual, usuario);
    }
    public void menuCorrida(Corrida corridaAtual, Usuario usuario) {
        System.out.println("==========================");
        System.out.println("[1] visualizar informacoes ");
        System.out.println("[2] editar informacoes ");
        System.out.println("[3] sair");

        int opcaoEscolhida = Integer.parseInt(scan.nextLine());
        switch (opcaoEscolhida) {
            case 1 -> this.visualizarInformacoesCorridaAtual(corridaAtual, usuario);
        }
    }

    public void visualizarInformacoesCorridaAtual(Corrida corridaAtual, Usuario usuario) {
        System.out.println("===================");
        System.out.println("id do dono da corrida: " + usuario.getIdUsuario() + " nome do usuario: " + usuario.getNome());
        System.out.println("horario da carrida: " + corridaAtual.getHora());
        System.out.println("dia da corrida: " + corridaAtual.getDia());
        System.out.println("mes da corrida: " + corridaAtual.getMes());
        System.out.println("ano da corrida: " + corridaAtual.getAno());
        System.out.println("preco da corrida: " + corridaAtual.getPreco());
    }

    public void editarCorridaAtual(Corrida corridaAtual, Usuario usuario) {
        Corrida tmp = corridaAtual;
        System.out.println("===============================");
        System.out.println("[1] editar hora");
        System.out.println("[2] editar dia");
        System.out.println("[3] editar mes");
        System.out.println("[4] editar ano");
        System.out.println("[5] editar preco");
        System.out.println("[6] salvar alteracoes");
        System.out.println("[7] sair");
        int escolha = Integer.parseInt(scan.nextLine());
        switch (escolha) {
            case 1 -> tmp = this.editarHora(tmp);
            case 2 -> tmp = this.editarDia(tmp);
            case 3 ->tmp = this.editarMes(tmp);
            case 4 ->tmp = this.editarAno(tmp);
            case 5 ->tmp = this.editarPreco(tmp);
            case 6 ->{
                System.out.print("digite a senha atual para salvar: ");
                String senha = scan.nextLine();
                if (usuario.getSenha().equals(senha)) {
                    System.out.println("senha correta!!");
                    corridaAtual = tmp;
                    this.salvarAlteracoes(corridaAtual);
                }
            }
        }
    }
    public void salvarAlteracoes(Corrida corridaAtual) {

    }
    public Corrida editarHora(Corrida corrida) {
        System.out.println("================");
        System.out.println("hora atual: " + corrida.getHora());
        System.out.print("digite a nova hora: ");
        corrida.setHora(scan.nextLine());
        return corrida;
    }
    public Corrida editarDia(Corrida tmp) {
        System.out.println("=============");
        System.out.println("dia atual: " + tmp.getDia());
        System.out.print("digite o novo dia: ");
        tmp.setDia(Integer.parseInt(scan.nextLine()));
        return tmp;
    }
    public Corrida editarMes(Corrida corrida) {
        System.out.println("=================");
        System.out.println("mes atual: " + corrida.getMes());
        System.out.print("digite o novo mes: ");
        corrida.setMes(Integer.parseInt(scan.nextLine()));
        return corrida;
    }
    public Corrida editarAno(Corrida corrida) {
        System.out.println("================");
        System.out.print("ano atual: " + corrida.getAno());
        System.out.print("digite o novo ano ");
        corrida.setAno(Integer.parseInt(scan.nextLine()));
        return corrida;
    }
    public Corrida editarPreco(Corrida tmp) {
        System.out.println("===============");
        System.out.println("preco atual: " + tmp.getPreco());
        System.out.print("digite o preco novo: ");
        tmp.setPreco(Double.parseDouble(scan.nextLine()));
        return tmp;
    }

    public void linha() {
        System.out.println("--------------------------------");
    }
}

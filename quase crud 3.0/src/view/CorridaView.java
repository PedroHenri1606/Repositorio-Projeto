package view;

import controller.CarroController;
import controller.CorridaController;
import model.Corrida;
import model.Usuario;
import model.Carro;
import javax.swing.*;
import java.util.*;

public class CorridaView {

    CorridaController corridaController = new CorridaController();
    CarroController carroController = new CarroController();

    public void visualizarMinhasCorrida(Usuario usuario,Carro carro) {
        List<Corrida> corridas = corridaController.visualizar(usuario, carro);
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        String output = "==============================================\n";

        for (Corrida corrida : corridas) {
         String tmp1=   "Id: "+ corrida.getIdCorrida()+"\n"+
                        "Criador: " + corrida.getUser()+"\n"+
                        "Data: " + corrida.getDia()+ "/" + corrida.getMes() + "/" + corrida.getAno() +"\n"+
                        "Carro: " + corrida.getCarro()+"\n"+
                        "Preço: R$" + corrida.getPreco()+"\n"+
                        "==============================================\n";
                        output+=tmp1+"\n";
        }
        if (corridas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma Corrida encontrada!", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(frame,"      Selecione um ID"+output,"UniFlow",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void visualizarCorridasPendentes() {
        List<Corrida> corridas = corridaController.visualizarPendentes();
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        String output = "==============================================\n";

        for (Corrida corrida : corridas) {
            String tmp1=   "Id: "+ corrida.getIdCorrida()+"\n"+
                           "Criador: " + corrida.getUser()+"\n"+
                           "Data: " + corrida.getDia()+ "/" + corrida.getMes() + "/" + corrida.getAno() +"\n"+
                           "Carro: " + corrida.getCarro()+"\n"+
                           "Preço: R$" + corrida.getPreco()+"\n"+
                           "==============================================\n";
                           output+=tmp1+"\n";
        }
        if (corridas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma Corrida encontrada!", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(frame,"      Selecione um ID"+output,"UniFlow",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void cadastrarCorrida(Usuario usuario) {

        Corrida corrida = new Corrida();

        String horario = JOptionPane.showInputDialog(null, "      Realizando Cadastro de Corrida\n\n" + "Horario da Corrida: ", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
        corrida.setHora(horario);

        String dia = JOptionPane.showInputDialog(null, "      Realizando Cadastro do Carro\n\n" + "Dia da Corrida: ", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
        corrida.setDia(Integer.parseInt(dia));

        String mes = JOptionPane.showInputDialog(null, "      Realizando Cadastro do Carro\n\n" + "Mês da Corrida: ", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
        corrida.setMes(Integer.parseInt(mes));

        String ano = JOptionPane.showInputDialog(null, "      Realizando Cadastro do Carro\n\n" + "Ano da Corrida: ", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
        corrida.setAno(Integer.parseInt(ano));

        String preco = JOptionPane.showInputDialog(null, "      Realizando Cadastro do Carro\n\n" + "Preço da Corrida: ", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
        corrida.setPreco(Double.parseDouble(preco));

        corrida.setUser(usuario);
        corrida.setCarro(carroController.retornarDadosCorrida(usuario.getIdUsuario()));
        corridaController.cadastrarCorrida(corrida);
    }

    public void escolherCorrida(Usuario usuario, Carro carro) {
        this.visualizarMinhasCorrida(usuario, carro);
        String id = JOptionPane.showInputDialog(null,"Digite o id da Corrida: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        Corrida corridaAtual = corridaController.determinarCorridaAtual(Long.parseLong(id), usuario);
        this.menuCorrida(corridaAtual, usuario);
    }

    public void escolherCorridaPassageiro(Usuario usuario) {
       String id = JOptionPane.showInputDialog(null,"Digite o id da Corrida: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        Corrida corridaAtual = corridaController.determinarCorridaAtual(Long.parseLong(id), usuario);
        this.menuCorrida(corridaAtual, usuario);
    }

    public String menuCorridaExibir(){
        String[] escolhas = {"1", "2"};
        String menuCorrida = "[1] - Visualizar Informações\n[2] - Sair";
        return (String) JOptionPane.showInputDialog(null, "              Menu Corrida\n\n" + menuCorrida, "UniFlow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }

    public void menuCorrida(Corrida corridaAtual, Usuario usuario) {

        while (true) {
            String opcao = menuCorridaExibir();
            switch (opcao) {
                case "1" -> this.visualizarInformacoesCorridaAtual(corridaAtual, usuario);
                case "2" -> {return;}
            }
        }
    }

    public void visualizarInformacoesCorridaAtual(Corrida corridaAtual, Usuario usuario) {
        CarroController carroController = new CarroController();

       JOptionPane.showMessageDialog(null,"              Corrida Atual\n\n" +
               "Criador: "+ usuario.getIdUsuario()+"\n"+
               "Horario: " + corridaAtual.getHora()+"\n"+
               "Data: "+ corridaAtual.getDia()+"/"+corridaAtual.getMes()+"/"+corridaAtual.getAno()+"\n"+
               "Carro: "+ carroController.determinarCarro(usuario.getIdUsuario())+"\n"+
               "Preço: "+ corridaAtual.getPreco(),"UniFlow",JOptionPane.INFORMATION_MESSAGE);
    }

}

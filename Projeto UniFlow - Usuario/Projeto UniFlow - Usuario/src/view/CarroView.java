package view;

import controller.*;
import model.*;
import javax.swing.*;
import java.util.List;
import java.util.StringTokenizer;

public class CarroView {

    public Carro cadastrarCarro(Usuario user) {

        Carro carro = new Carro();

        int id = 0;
        id = this.escolhendoFabricante(id);
        CarroFabricanteController carroFabricanteController = new CarroFabricanteController();
        carro.setFabricante(carroFabricanteController.selecionarFabricante(id));

        int id2 = 0;
        id2 = this.escolhendoNomeCarro(id2);
        CarroNomeController carroNomeController = new CarroNomeController();
        carro.setNome(carroNomeController.selecionarNome(id2));

        int id3 = 0;
        id3 = this.escolhendoCor(id3);
        CarroCorController carroCorController = new CarroCorController();
        carro.setCor(carroCorController.selecionarCor(id3));

        String ano = JOptionPane.showInputDialog(null, "      Realizando Cadastro do Carro\n\n" + "Ano de Fabricação: ", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
        carro.setAno(Long.parseLong(ano));

        String placa = JOptionPane.showInputDialog(null, "      Realizando Cadastro do Carro\n\n" + "Placa do Veiculo: ", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
        carro.setPlaca(placa);

        UsuarioController usuarioController = new UsuarioController();
        carro.setDono(usuarioController.retornarDado(user.getIdUsuario()));

        CarroController carroController = new CarroController();
        carroController.cadastrarCarro(carro);
        return carro;
    }

    public int escolhendoFabricante(int id) {

        List<CarroFabricante> list;
        CarroFabricanteView carroFabricanteView = new CarroFabricanteView();
        list = carroFabricanteView.visualizarFabricante();
        String[] object = new String[list.size()];
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        int i = 0;

        try {
            for (CarroFabricante fabricante : list) {
                object[i] = (fabricante.getId() + "|" + fabricante.getNome());
                i++;
            }

            Object selectionObjetec = JOptionPane.showInputDialog(frame, "Escolha um Fabricante:", "UniFlow", JOptionPane.QUESTION_MESSAGE, null, object, object[0]);
            String tmp = selectionObjetec.toString();
            StringTokenizer st = new StringTokenizer(tmp);
            id = Integer.valueOf(st.nextToken("|"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public int escolhendoNomeCarro(int id2) {

        List<CarroNome> list;
        CarroNomeView carroNomeView = new CarroNomeView();
        list = carroNomeView.visualizarNome();
        String[] object = new String[list.size()];
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        int i = 0;

        try {
            for (CarroNome carroNome : list) {
                object[i] = (carroNome.getId() + "|" + carroNome.getNome());
                i++;
            }

            Object selectionObjetec = JOptionPane.showInputDialog(frame, "Escolha um Modelo:", "UniFlow", JOptionPane.QUESTION_MESSAGE, null, object, object[0]);
            String tmp = selectionObjetec.toString();
            StringTokenizer st = new StringTokenizer(tmp);
            id2 = Integer.valueOf(st.nextToken("|"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id2;
    }

    public int escolhendoCor(int id3) {

        List<CarroCor> list;
        CarroCorView carroCorView = new CarroCorView();
        list = carroCorView.visualizarCor();
        String[] object = new String[list.size()];
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        int i = 0;

        try {
            for (CarroCor carroCor : list) {
                object[i] = (carroCor.getId() + "|" + carroCor.getNome());
                i++;
            }

            Object selectionObjetec = JOptionPane.showInputDialog(frame, "Escolha uma Cor:", "UniFlow", JOptionPane.QUESTION_MESSAGE, null, object, object[0]);
            String tmp = selectionObjetec.toString();
            StringTokenizer st = new StringTokenizer(tmp);
            id3 = Integer.valueOf(st.nextToken("|"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id3;
    }
}



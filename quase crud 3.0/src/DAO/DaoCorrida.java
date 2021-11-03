package DAO;

import model.Corrida;

import java.io.*;
import java.util.*;

public class DaoCorrida {
    static List<Corrida> corridas = new ArrayList<>();
    static int posicaoCorridaAtual;

    public void carregar() {
        try {
            BufferedReader carregar = new BufferedReader(new FileReader("corridas.txt"));
            while (true) {
                String linha = carregar.readLine();
                if (linha == null) {
                    break;
                } else {
                    StringTokenizer separador = new StringTokenizer(linha, "|");
                    Corrida corrida = new Corrida();
                    corrida.setNome(separador.nextToken());
                    corrida.setId(separador.nextToken());
                    corrida.setIdUser(separador.nextToken());
                    corrida.setPreco(separador.nextToken());
                    corridas.add(corrida);
                }
            }
            carregar.close();
        } catch (Exception e) {
            System.out.println("==============================================");
            System.out.println("         Erro ao abrir o arquivo!             ");
            System.out.println("==============================================");
        }
    }

    public void salvar() {
        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("corridas.txt"));
            for (int i = 0; i < corridas.size(); i++) {
                salvar.write(corridas.get(i).getNome() + "|" + corridas.get(i).getId() + "|" + corridas.get(i).getIdUser() + "|" + corridas.get(i).getPreco());
                salvar.newLine();
            }
            salvar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void determinarCorridaAtual(String idEscolhido) {
        for (int i = 0; i < corridas.size(); i++) {
            if (corridas.get(i).getId().equals(idEscolhido)) {
                posicaoCorridaAtual = i;
            }
        }
    }

    public List<Corrida> visualizar(String idUser) {
        List<Corrida> aux = new ArrayList<>();
        if (corridas.size() > 0) {
            for (int i = 0; i < corridas.size(); i++) {
                if (corridas.get(i).getIdUser().equals(idUser)) {
                    aux.add(corridas.get(i));
                }
            }
        } else {
            System.out.println("==============================================");
            System.out.println("     Ainda nao existe corrida alguma!         ");
            System.out.println("==============================================");
        }
        return aux;
    }

    public void adicionar(Corrida aux) {
        corridas.add(aux);
        this.salvar();
    }

}
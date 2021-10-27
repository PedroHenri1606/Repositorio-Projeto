package DAO;

import model.corrida;

import java.io.*;
import java.util.*;

public class DaoCorrida {
    static List<String> nomes = new ArrayList<>();
    static List<String> ids = new ArrayList<>();
    static List<String> idsUser = new ArrayList<>();
    static List<String> precos = new ArrayList<>();

    public String escolha(int opcao) {
        return nomes.get(opcao);
    }

    public void carregar() {
        try {
            BufferedReader carregar = new BufferedReader(new FileReader("corridas.txt"));
            while (true) {
                String linha = carregar.readLine();
                if (linha == null) {
                    break;
                } else {
                    StringTokenizer separador = new StringTokenizer(linha, "|");
                    nomes.add(separador.nextToken());
                    ids.add(separador.nextToken());
                    idsUser.add(separador.nextToken());
                    precos.add(separador.nextToken());
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
            for (int i = 0; i < nomes.size(); i++) {
                salvar.write(nomes.get(i) + "|" + ids.get(i) + "|" + idsUser.get(i) + "|" + precos.get(i));
                salvar.newLine();
            }
            salvar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> visualizar(String idUser) {
        List<String> aux = new ArrayList<>();
        if (nomes.size() > 0) {
            System.out.println("==============================================");
            for (int i = 0; i < nomes.size(); i++) {
                if (idsUser.get(i).equals(idUser)) {
                    aux.add(nomes.get(i) + " " + precos.get(i));
                }
            }
            System.out.println("==============================================");
        } else {
            System.out.println("==============================================");
            System.out.println("     Ainda nao existe corrida alguma!         ");
            System.out.println("==============================================");
        }
        return aux;
    }

    public void adicionar(corrida aux) {
        nomes.add(aux.getNome());
        ids.add(aux.getId());
        idsUser.add(aux.getIdUser());
        precos.add(aux.getPreco());
        this.salvar();
    }

    public boolean validar(String nome) {
        for(String aux : nomes) {
            if (nome.equals(aux)) {
                return false;
            }
        }

        return true;
    }
}
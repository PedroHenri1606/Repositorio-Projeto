package DAO;

import model.Bairro;
import java.io.*;
import java.util.*;

public class DaoBairro {
    static List<String> nomes = new ArrayList<String>();
    static List<String> ids = new ArrayList<String>();

    public String escolha(int opcao) {
        return nomes.get(opcao);
    }

    public void carregar() {
        try {
            BufferedReader carregar = new BufferedReader(new FileReader("bairros.txt"));
            while (true) {
                String linha = carregar.readLine();
                if (linha == null) {
                    break;
                } else {
                    StringTokenizer sepador = new StringTokenizer(linha, "|");
                    nomes.add(sepador.nextToken());
                    ids.add(sepador.nextToken());
                }
            }
            carregar.close();
        } catch (Exception e) {
            System.out.println("arquivo ainda nao existe ou nao foi encontrado");
        }
    }

    public void visualizar() {
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("[" + nomes.get(i) +"]" + " " + " Posicao: [" + i + "]");
        }
    }
    public void salvar() {
        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("bairros.txt"));
            for (int i = 0; i < nomes.size(); i++) {
                salvar.write(nomes.get(i) + "|" + ids.get(i));
                salvar.newLine();
            }
            salvar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionar(Bairro aux) {
        nomes.add(aux.getNome());
        ids.add(aux.getId());
        this.salvar();
    }
    public boolean validar(String nome) {
        for (int i = 0; i < nomes.size(); i++) {
            if (nome.equals(nomes.get(i))) {
                return false;
            }
        }
        return true;
    }
}

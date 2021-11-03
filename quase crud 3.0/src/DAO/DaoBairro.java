package DAO;

import model.Bairro;

import java.io.*;
import java.util.*;

public class DaoBairro {
    static List<Bairro> bairros = new ArrayList<>();


    public String escolha(int opcao) {
        return bairros.get(opcao).getNome();
    }

    public void carregar() {
        try {
            BufferedReader carregar = new BufferedReader(new FileReader("bairros.txt"));
            while (true) {
                String linha = carregar.readLine();
                if (linha == null) {
                    break;
                } else {
                    StringTokenizer stringTokenizer = new StringTokenizer(linha, "|");
                    Bairro bairro = new Bairro();
                    bairro.setNome(stringTokenizer.nextToken());
                    bairro.setId(stringTokenizer.nextToken());
                    bairros.add(bairro);
                }
            }
            carregar.close();
        } catch (Exception e) {
            System.out.println("==============================================");
            System.out.println("  Arquivo não existe ou não foi encontrado    ");
            System.out.println("==============================================");
        }
    }

    public List<Bairro> visualizar() {
        return bairros;
    }

    public void salvar() {
        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("bairros.txt"));
            for (Bairro bairro : bairros) {
                salvar.write(bairro.getNome() + "|" + bairro.getId());
                salvar.newLine();
            }
            salvar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionar(Bairro aux) {
        bairros.add(aux);
        this.salvar();
    }

    public boolean validar(String nome) {
        for (Bairro bairro : bairros) {
            if (nome.equals(bairro.getNome())) {
                return false;
            }
        }
        return true;
    }
}

package DAO;

import model.Curso;

import java.util.*;
import java.io.*;

public class DaoCurso {
    static List<String> nome = new ArrayList<String>();
    static List<String> ids = new ArrayList<String>();

    public String escolha(int opcao) {
        return nome.get(opcao);
    }

    public void carregar() {
        try {
            BufferedReader carregar = new BufferedReader(new FileReader("cursos.txt"));
            while (true) {
                String linha = carregar.readLine();
                if (linha == null) {
                    break;
                } else {
                    StringTokenizer separador = new StringTokenizer(linha, "|");
                    nome.add(separador.nextToken());
                    ids.add(separador.nextToken());
                }
            }
            carregar.close();
        } catch (Exception e) {
            System.out.println("Arquivo ainda não existe ou não encontrado");
        }
    }

    public void visualizar() {
        for (int i = 0; i < nome.size(); i++) {
            System.out.println("[" + nome.get(i) + "]" + " " + " Posição: [" + i + "]");
        }
    }

    public void salvar() {
        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("cursos.txt"));
            for (int i = 0; i < nome.size(); i++) {
                salvar.write(nome.get(i) + "|" + ids.get(i));
                salvar.newLine();
            }
            salvar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionar(Curso aux) {
        nome.add(aux.getNome());
        ids.add(aux.getId());
        this.salvar();
    }

    public boolean validar(String nome1) {
        for (int i = 0; i < nome.size(); i++) {
            if (nome.equals(nome.get(i))) {
                return false;
            }
        }
        return true;
    }
}

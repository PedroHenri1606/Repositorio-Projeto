package DAO;

import model.Curso;

import java.util.*;
import java.io.*;

public class DaoCurso {
    static List<String> nomes = new ArrayList<String>();
    static List<String> ids = new ArrayList<String>();

<<<<<<< HEAD
    public String escolha(int opcao){return nomes.get(opcao);}
=======
    public String escolha(int opcao) {
        return nome.get(opcao);
    }
>>>>>>> 26b594ed504e5880dfafb9dac68191890365a6d1

    public void carregar() {
        try {
            BufferedReader carregar = new BufferedReader(new FileReader("cursos.txt"));
            while (true) {
                String linha = carregar.readLine();
                if (linha == null) {
                    break;
                } else {
<<<<<<< HEAD
                    StringTokenizer separador = new StringTokenizer(linha,"|");
                    nomes.add(separador.nextToken());
=======
                    StringTokenizer separador = new StringTokenizer(linha, "|");
                    nome.add(separador.nextToken());
>>>>>>> 26b594ed504e5880dfafb9dac68191890365a6d1
                    ids.add(separador.nextToken());
                }
            }
            carregar.close();
<<<<<<< HEAD
        } catch (Exception e){
            System.out.println("==============================================");
            System.out.println("     Arquivo não existe ou não encontrado     ");
            System.out.println("==============================================");
        }
    }

    public void visualizarCurso(){
        for (int i = 0; i < nomes.size(); i++){
            System.out.println(nomes.get(i) +"   |   " + " Posição: " + i);
=======
        } catch (Exception e) {
            System.out.println("Arquivo ainda não existe ou não encontrado");
        }
    }

    public void visualizar() {
        for (int i = 0; i < nome.size(); i++) {
            System.out.println("[" + nome.get(i) + "]" + " " + " Posição: [" + i + "]");
>>>>>>> 26b594ed504e5880dfafb9dac68191890365a6d1
        }
    }

    public void salvar() {
        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("cursos.txt"));
<<<<<<< HEAD
            for (int i= 0 ;i < nomes.size(); i++){
                salvar.write(nomes.get(i) + "|" + ids.get(i));
=======
            for (int i = 0; i < nome.size(); i++) {
                salvar.write(nome.get(i) + "|" + ids.get(i));
>>>>>>> 26b594ed504e5880dfafb9dac68191890365a6d1
                salvar.newLine();
            }
            salvar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    public void adicionar (Curso aux){
        nomes.add(aux.getNome());
=======
    public void adicionar(Curso aux) {
        nome.add(aux.getNome());
>>>>>>> 26b594ed504e5880dfafb9dac68191890365a6d1
        ids.add(aux.getId());
        this.salvar();
    }

<<<<<<< HEAD
    public boolean validar(String nome){
        for(int i = 0; i < nomes.size(); i++){
            if (nome.equals(nomes.get(i))){
=======
    public boolean validar(String nome1) {
        for (int i = 0; i < nome.size(); i++) {
            if (nome.equals(nome.get(i))) {
>>>>>>> 26b594ed504e5880dfafb9dac68191890365a6d1
                return false;
            }
        }
        return true;
    }
}

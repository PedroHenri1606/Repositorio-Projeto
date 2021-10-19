package crudisinho;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class arquivo {
    static List<String> usuario = new ArrayList<String>();
    static List<String> senha = new ArrayList<String>();
    Scanner scan = new Scanner(System.in);
    public void carregar() {
        try {
            BufferedReader carregar = new BufferedReader(new FileReader("lista.txt"));
            while(true) {
                String linha = carregar.readLine();
                if(linha == null) {
                    break;
                } else {
                    StringTokenizer sepador = new StringTokenizer(linha,"|");
                    usuario.add(sepador.nextToken());
                    senha.add(sepador.nextToken());
                }
            }
            carregar.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void adicionar() {
        System.out.print("digite o nome do usuario: ");
        usuario.add(scan.nextLine());
        System.out.print("digite a senha do usuario: ");
        senha.add(scan.nextLine());
    }
    public void editar() {
        System.out.println("--------------------------------------");
        System.out.println("lista atual");
        for(int i = 0; i<usuario.size(); i++) {
            System.out.println("usuario: " + usuario.get(i) + " senha: " + senha.get(i) + " posicao: " + i);
        }
        System.out.println("");
        System.out.print("digite a posicao: ");
        int posicao = Integer.parseInt(scan.nextLine());
        System.out.print("digite 1 - usuario; 2 - senha: ");
        int escolha = Integer.parseInt(scan.nextLine());
        if(escolha == 1) {
            System.out.print("digite o novo usuario: ");
            usuario.set(posicao, scan.nextLine());
        } else {
            System.out.print("digite a nova senha: ");
            senha.set(posicao, scan.nextLine());
        }
        System.out.println("--------------------------------------");
        System.out.println("nova lista de usuario: ");
        for(int i = 0; i<usuario.size(); i++) {
            System.out.println("usuario: " + usuario.get(i) + " senha: " + senha.get(i) + " posicao: " + i);
        }
        System.out.println("");
    }
    public void remover() {
        System.out.println("--------------------------------------");
        System.out.println("lista atual");
        for(int i = 0; i<usuario.size(); i++) {
            System.out.println("usuario: " + usuario.get(i) + " senha: " + senha.get(i) + " posicao: " + i);
        }
        System.out.println("");
        System.out.print("digite a posicao a ser removida: ");
        int posicao = Integer.parseInt(scan.nextLine());
        usuario.remove(posicao);
        senha.remove(posicao);
        System.out.println("--------------------------------------");
        System.out.println("nova lista de usuario: ");
        for(int i = 0; i<usuario.size(); i++) {
            System.out.println("usuario: " + usuario.get(i) + " senha: " + senha.get(i) + " posicao: " + i);
        }
        System.out.println("");
    }
    public void salvar() {
       try {
           BufferedWriter salvar = new BufferedWriter(new FileWriter("lista.txt"));
           for (int i = 0; i<usuario.size(); i++) {
               salvar.write(usuario.get(i) + "|" + senha.get(i));
               salvar.newLine();
           }
           salvar.close();
           System.out.println("");
           System.out.println("usuarios salvos com sucesso!!!");
           System.out.println("");
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}

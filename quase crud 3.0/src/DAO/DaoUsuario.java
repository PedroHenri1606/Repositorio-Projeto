package DAO;

import model.UsuarioModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DaoUsuario {
    static List<UsuarioModel> usuarios = new ArrayList<>();
    static int usuarioAtual;
    Scanner scan = new Scanner(System.in);
    public boolean login(String tmp1, String tmp2) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (tmp1.equals(usuarios.get(i).getEmail()) && tmp2.equals(usuarios.get(i).getSenha())) {
                System.out.println("\n==============================================");
                System.out.println("        Login realizado com sucesso           ");
                System.out.println("==============================================\n");
                usuarioAtual = i;
                return true;
            }
        }
        return false;

    }

    public List<UsuarioModel> visualizarUsuariosProximos() {
        List<UsuarioModel> aux = new ArrayList<>();
        System.out.println("\n\n");
        System.out.println("==============================================");
        System.out.println("     Usuarios que moram perto de você         ");
        System.out.println("==============================================");
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(usuarioAtual).getBairro().equals(usuarios.get(i).getBairro()) && usuarios.get(usuarioAtual).getNome() != usuarios.get(i).getNome()) {
                aux.add(usuarios.get(i));
            }
        }
        return aux;
    }

    public String getMeuNome() {
        return usuarios.get(usuarioAtual).getNome();
    }

    public String getMeuID() {
        return usuarios.get(usuarioAtual).getId();
    }

    public void setMeuNome(String novoNome) {
        usuarios.get(usuarioAtual).setNome(novoNome);
        this.salvar();
    }

    public String getMinhaSenha() {
        return usuarios.get(usuarioAtual).getSenha();
    }

    public void setMinhaSenha(String novaSenha) {
        usuarios.get(usuarioAtual).setSenha(novaSenha);
        this.salvar();
    }

    public String getMeuEmail() {
        return usuarios.get(usuarioAtual).getEmail();
    }

    public void carregar() {
        try {
            BufferedReader carregar = new BufferedReader(new FileReader("lista.txt"));
            while (true) {
                String linha = carregar.readLine();
                if (linha == null) {
                    break;
                } else {
                    StringTokenizer sepador = new StringTokenizer(linha, "|");
                    UsuarioModel usuarioModel = new UsuarioModel();
                    usuarioModel.setNome(sepador.nextToken());
                    usuarioModel.setSenha(sepador.nextToken());
                    usuarioModel.setBairro(sepador.nextToken());
                    usuarioModel.setDestino(sepador.nextToken());
                    usuarioModel.setEmail(sepador.nextToken());
                    usuarioModel.setId(sepador.nextToken());
                    usuarioModel.setCurso(sepador.nextToken());
                    usuarios.add(usuarioModel);
                }
            }
            carregar.close();
        } catch (Exception e) {
            System.out.println("==============================================");
            System.out.println(" Arquivo não existe - não foi encontrado ");
            System.out.println("==============================================\n");
        }
    }

    public void adicionar(UsuarioModel user) {
        usuarios.add(user);
        this.salvar();
    }


    public boolean verificarEmail(String email) {
        if (usuarios.size() > 0) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (email.equals(usuarios.get(i).getEmail())) {
                    System.out.println("==============================================");
                    System.out.println("     Email invalidou ou já em uso!");
                    System.out.println("==============================================\n");
                    return false;
                }
            }
        } else {
            return true;
        }
        return true;
    }


    public void salvar() {
        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("lista.txt"));
            for (int i = 0; i < usuarios.size(); i++) {
                salvar.write(usuarios.get(i).getNome() + "|" + usuarios.get(i).getSenha() + "|" + usuarios.get(i).getBairro() + "|" + usuarios.get(i).getDestino() + "|" + usuarios.get(i).getEmail() + "|" + usuarios.get(i).getId() + "|" + usuarios.get(i).getCurso());
                salvar.newLine();
            }
            salvar.close();
            System.out.println("\n==============================================");
            System.out.println("         Dados salvos com sucesso!           \n");
            System.out.println("==============================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

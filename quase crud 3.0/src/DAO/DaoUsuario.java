package DAO;

import model.UsuarioModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DaoUsuario {
    static List<String> usuario = new ArrayList<String>();
    static List<String> senha = new ArrayList<String>();
    static List<String> bairro = new ArrayList<String>();
    static List<String> destino = new ArrayList<String>();
    static List<String> emails = new ArrayList<String>();
    static List<String> ids = new ArrayList<>();
    static List<String> cursos = new ArrayList<>();
    static int usuarioAtual;
    Scanner scan = new Scanner(System.in);

    public boolean login(String tmp1, String tmp2) {
        for (int i = 0; i < usuario.size(); i++) {
            if (tmp1.equals(emails.get(i)) && tmp2.equals(senha.get(i))) {
                System.out.println("\n==============================================");
                System.out.println("        Login realizado com sucesso           ");
                System.out.println("==============================================\n");
                usuarioAtual = i;
                return true;
            }
        }
        return false;

    }

    public void visualizarUsuariosProximos() {
        System.out.println("\n\n");
               System.out.println("==============================================");
               System.out.println("     Usuarios que moram perto de você         ");
               System.out.println("==============================================");
        for (int i = 0; i < usuario.size(); i++) {
           if(bairro.get(usuarioAtual).equals(bairro.get(i)) && usuario.get(usuarioAtual) != usuario.get(i)) {
               System.out.println("[usuarios: " + usuario.get(i) + "]");
           }
        }

    }
    public String getMeuNome() {
        return usuario.get(usuarioAtual);
    }
    public String getMeuID() {
        return ids.get(usuarioAtual);
    }
    public void setMeuNome(String novoNome) {
        usuario.set(usuarioAtual, novoNome);
        this.salvar();
    }
    public String getMinhaSenha() {
        return senha.get(usuarioAtual);
    }
    public void setMinhaSenha(String novaSenha) {
        senha.set(usuarioAtual, novaSenha);
        this.salvar();
    }
    public String getMeuEmail() {
        return emails.get(usuarioAtual);
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
                    usuario.add(sepador.nextToken());
                    senha.add(sepador.nextToken());
                    bairro.add(sepador.nextToken());
                    destino.add(sepador.nextToken());
                    emails.add(sepador.nextToken());
                    ids.add(sepador.nextToken());
                    cursos.add(sepador.nextToken());
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
        usuario.add(user.getNome());
        senha.add(user.getSenha());
        bairro.add(user.getBairro());
        destino.add(user.getDestino());
        emails.add(user.getEmail());
        ids.add(user.getId());
        cursos.add(user.getCurso());
        this.salvar();
    }


   public boolean verificarEmail(String email) {
        if (usuario.size() > 0) {
            for (int i = 0; i<usuario.size();i++) {
                if(email.equals(emails.get(i))) {
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
            for (int i = 0; i < usuario.size(); i++) {
                salvar.write(usuario.get(i) + "|" + senha.get(i) + "|" + bairro.get(i) + "|" + destino.get(i) + "|" + emails.get(i) + "|" + ids.get(i) + "|" + cursos.get(i));
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

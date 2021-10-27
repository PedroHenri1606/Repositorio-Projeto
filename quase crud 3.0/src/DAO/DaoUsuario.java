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
    static int usuarioAtual;
    Scanner scan = new Scanner(System.in);

    public boolean login(String tmp1, String tmp2) {
        for (int i = 0; i < usuario.size(); i++) {
            if (tmp1.equals(usuario.get(i)) && tmp2.equals(senha.get(i))) {
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
        System.out.println("==============================================");
        System.out.println("     Usuarios que moram perto de você         ");
        System.out.println("==============================================");

        for (int i = 0; i < usuario.size(); i++) {
           if(bairro.get(usuarioAtual).equals(bairro.get(i)) && usuario.get(usuarioAtual) != usuario.get(i)) {
               System.out.println("| Usuarios | " + usuario.get(i));
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
        this.salvar();
    }


   public boolean verificarEmail(String email) {
        for (int i = 0; i<usuario.size();i++) {
            if(email.equals(emails.get(i))) {
                System.out.println("==============================================");
                System.out.println("     Email invalidou ou já em uso!");
                System.out.println("==============================================\n");
                return false;
            }
        }
        return true;
   }


//-----------------------------------------------------


    /*public void editar() {
        System.out.println("--------------------------------------");
        System.out.println("lista atual");
        for (int i = 0; i < usuario.size(); i++) {
            System.out.println("usuario: " + usuario.get(i) + " senha: " + senha.get(i) + " bairro: " + bairro.get(i) + " destino: " + destino.get(i) + " posicao: " + i);
        }
        System.out.println("");
        System.out.print("digite a posicao: ");
        int posicao = Integer.parseInt(scan.nextLine());
        System.out.print("digite 1 - usuario; 2 - senha: ");
        int escolha = Integer.parseInt(scan.nextLine());
        if (escolha == 1) {
            System.out.print("digite o novo usuario: ");
            usuario.set(posicao, scan.nextLine());
        } else {
            System.out.print("digite a nova senha: ");
            senha.set(posicao, scan.nextLine());
        }
        System.out.println("--------------------------------------");
        System.out.println("nova lista de usuario: ");
        for (int i = 0; i < usuario.size(); i++) {
            System.out.println("usuario: " + usuario.get(i) + " senha: " + senha.get(i) + " posicao: " + i);
        }
        System.out.println("");
        this.salvar();
    }*/

    /*public void remover() {
        System.out.println("--------------------------------------");
        System.out.println("lista atual");
        for (int i = 0; i < usuario.size(); i++) {
            System.out.println("usuario: " + usuario.get(i) + " senha: " + senha.get(i) + " posicao: " + i);
        }
        System.out.println("");
        System.out.print("digite a posicao a ser removida: ");
        int posicao = Integer.parseInt(scan.nextLine());
        usuario.remove(posicao);
        senha.remove(posicao);
        System.out.println("--------------------------------------");
        System.out.println("nova lista de usuario: ");
        for (int i = 0; i < usuario.size(); i++) {
            System.out.println("usuario: " + usuario.get(i) + " senha: " + senha.get(i) + " posicao: " + i);
        }
        System.out.println("");
        this.salvar();
    }*/




    public void salvar() {
        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("lista.txt"));
            for (int i = 0; i < usuario.size(); i++) {
                salvar.write(usuario.get(i) + "|" + senha.get(i) + "|" + bairro.get(i) + "|" + destino.get(i) + "|" + emails.get(i) + "|" + ids.get(i));
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

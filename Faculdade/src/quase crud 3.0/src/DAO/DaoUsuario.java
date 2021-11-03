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
    static int usuarioAtual;
    Scanner scan = new Scanner(System.in);

    public boolean login(String tmp1, String tmp2) {
        for (int i = 0; i < usuario.size(); i++) {
            if (tmp1.equals(usuario.get(i)) && tmp2.equals(senha.get(i))) {
                System.out.println("login realizado com sucesso");
                usuarioAtual = i;
                return true;
            }
        }
        return false;

    }

    public void visualizarUsuariosProximos() {
        System.out.println("");
        System.out.println("");
        System.out.println("usuarios que moram perto de vc: ");
        System.out.println(" ");
        for (int i = 0; i < usuario.size(); i++) {
            if (bairro.get(i).equals(bairro.get(usuarioAtual)) && destino.get(i).equals(destino.get(usuarioAtual)) && usuario.get(i) != usuario.get(usuarioAtual)) {
                System.out.println("usuario: " + usuario.get(i));
            }
        }

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
                }
            }
            carregar.close();
        } catch (Exception e) {
            System.out.println("arquivo ainda nao existe ou nao foi encontrado");
        }
    }

    public void adicionar(UsuarioModel user) {
        boolean disponivel = true;
        usuario.add(user.getNome());
        senha.add(user.getSenha());
        bairro.add(user.getBairro());
        destino.add(user.getDestino());
        emails.add(user.getEmail());
        this.salvar();
    }

    public boolean validar(String email) { //verifica se ja existe alguem com esse email.
        for (int i = 0; i < usuario.size(); i++) {
            if (email.equals(emails.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void editar() {
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
    }

    public void remover() {
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
    }

    public void salvar() {
        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("lista.txt"));
            for (int i = 0; i < usuario.size(); i++) {
                salvar.write(usuario.get(i) + "|" + senha.get(i) + "|" + bairro.get(i) + "|" + destino.get(i));
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

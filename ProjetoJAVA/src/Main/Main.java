
package Main;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        //Arquivos
        String arq = "Teste1.txt";
        String arq2 = "config.txt";


        //Variaveis
        String opcao = "0";
        String testeSenha = "";
        String testeEmail = "";
        String texto = "";
        int i = 3;

        //Objetos
        Scanner ler = new Scanner(System.in);
        Usuario u1 = new Usuario("pedrohenri1606@gmail.com");

        //Salva senha
        String salvaSenha = Arquivo.Read(arq);
        u1.setSenha(salvaSenha);

        //Salva Dados
        String conteudo = Arquivo.Read(arq2);
        String c1 = conteudo.split(";")[0]; u1.setUsuario(c1);
        String c2 = conteudo.split(";")[1]; u1.setCargo(c2);
        String c3 = conteudo.split(";")[2]; u1.setEmail(c3);

        while(i >= 0) {
            System.out.print(" Email: ");
            testeEmail = ler.nextLine();
            System.out.print(" Senha: ");
            testeSenha = ler.nextLine();
            if (testeSenha.equals(u1.getSenha()) && testeEmail.equals(c3)) {
                while(true) {
                    u1.telaMenu();
                    opcao = ler.nextLine();
                    if (opcao.equals("3")) {
                        return;
                    }

                    if (opcao.equals("1")) {
                        u1.telaMenuDados();
                        opcao = ler.nextLine();
                        if (opcao.equals("1")) {
                            u1.telaAlteraDados();
                            opcao = ler.nextLine();
                            if (opcao.equals("1")) {
                                u1.telaMudaNome();
                                texto = ler.nextLine();
                                u1.setUsuario(texto);
                            }

                            if (opcao.equals("2")) {
                                u1.telaMudaEmail();
                                texto = ler.nextLine();
                                u1.setEmail(texto);
                            }

                            if (opcao.equals("3")) {
                                u1.telaMudaCargo();
                                texto = ler.nextLine();
                                u1.setCargo(texto);
                            }

                            String frase;
                            if (opcao.equals("4")) {
                                u1.testeSenha();
                                testeSenha = ler.nextLine();
                                if (testeSenha.equals(u1.getSenha())) {
                                    System.out.print(" Digite a nova senha: ");
                                    frase = ler.nextLine();
                                    u1.setSenha(frase);
                                    if (Arquivo.Write(arq, frase)) {
                                        System.out.println("\nSenha alterada com sucesso!\n");
                                    }
                                } else {
                                    u1.senhaIncorreta(i);
                                }
                            }

                            if (opcao.equals("5")) {
                                String var10000 = u1.getUsuario();
                                frase = var10000 + ";" + u1.getCargo() + ";" + u1.getEmail();
                                Arquivo.Write(arq2, frase);
                            }
                        }
                    }
                }
            }
            u1.senhaIncorreta(i);
            --i;
        }

    }
}

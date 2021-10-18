package Main;

import java.util.Scanner;

public class Usuario {
    private String email;
    private String senha;
    private String usuario;
    private String cargo;
    Scanner leitor;

    void telaMenu() {
        System.out.println("---------------------------------------------");
        System.out.println("\n   BOM DIA: " + this.usuario + "\n");
        System.out.println("   [1]- Meus Dados");
        System.out.println("   [2]- Mecanica");
        System.out.println("   [3]- SAIR\n");
        System.out.println("---------------------------------------------");
    }

    void telaMenuDados() {
        System.out.println("---------------------------------------------");
        System.out.println("                                             ");
        System.out.println(" Usuario : " + this.usuario);
        System.out.println(" Email : " + this.email);
        System.out.println(" Cargo : " + this.cargo);
        System.out.println(" ");
        System.out.println("    [1]-Alterar Dados                        ");
        System.out.println("    [2]-Retornar                           \n");
        System.out.println("---------------------------------------------");
    }

    void telaAlteraDados() {
        System.out.println("---------------------------------------------");
        System.out.println("                                             ");
        System.out.println("  [1]- Nome                                  ");
        System.out.println("  [2]- Email                                 ");
        System.out.println("  [3]- Cargo                                 ");
        System.out.println("  [4]- Senha                                 ");
        System.out.println("  [5]- SALVAR ALTERAÇÕES                     ");
        System.out.println("  [6]- Retornar                              \n");
        System.out.println("---------------------------------------------");
    }

    void telaMudaNome() {
        System.out.println("---------------------------------------------");
        System.out.print(" Nome: ");
    }

    void telaMudaEmail() {
        System.out.println("---------------------------------------------");
        System.out.print(" Email: ");
    }

    void telaMudaCargo() {
        System.out.println("---------------------------------------------");
        System.out.print(" Cargo: ");
    }

    void testeSenha() {
        System.out.println("---------------------------------------------");
        System.out.print(" Informe sua senha: ");
    }

    void telaSenha() {
        System.out.println("1- Trocar senha");
        System.out.println("2- Verificar senha");
    }

    void senhaIncorreta(int i) {
        System.out.println("---------------------------------------------");
        System.out.println("             SENHA INCORRETA               ");
        System.out.println("         [" + i + "] TENTATIVAS RESTANTES             ");
        System.out.println("---------------------------------------------");
    }

    public Usuario() {
        this.leitor = new Scanner(System.in);
    }

    public Usuario(String email) {
        this.leitor = new Scanner(System.in);
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}


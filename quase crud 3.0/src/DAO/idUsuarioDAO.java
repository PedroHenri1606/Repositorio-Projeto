package DAO;

import java.io.*;

public class idUsuarioDAO {
    public int usuarioID() {
        int aux = 0;
        try {
            BufferedReader carregar = new BufferedReader(new FileReader("idUsuario.txt"));
            String linha = carregar.readLine();
            if(linha == null) {
                aux = 0;
            } else {
                aux = Integer.parseInt(linha);
                aux++;
            }
            carregar.close();
        } catch (Exception e) {
            System.out.println("arquivo ainda nao existe ou nao foi encontrado");
        }
        this.salvar(Integer.toString(aux));
        return aux;
    }
    public void salvar(String tmp1) {
        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("idUsuario.txt"));
            salvar.write(tmp1);
            salvar.newLine();
            salvar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

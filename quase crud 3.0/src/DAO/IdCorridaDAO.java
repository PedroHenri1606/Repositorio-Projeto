package DAO;

import java.io.*;
import java.util.StringTokenizer;

public class IdCorridaDAO {
    public int determinarID(){
        int aux = 0;
        try{
            BufferedReader carregar = new BufferedReader(new FileReader("idCorrida.txt"));
            String linha = carregar.readLine();
            if(linha == null){
                aux = 0;
            } else {
                aux = Integer.parseInt(linha);
                aux++;
            }
            carregar.close();
        } catch (Exception e){
            System.out.println("Arquivo ainda não existe ou não foi encontrado!");
        }
        this.salvar(Integer.toString(aux));
        return aux;
    }

    public void salvar(String tmp1){
        try{
            BufferedWriter salvar = new BufferedWriter(new FileWriter("idCorrida.txt"));
            salvar.write(tmp1);
            salvar.newLine();
            salvar.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

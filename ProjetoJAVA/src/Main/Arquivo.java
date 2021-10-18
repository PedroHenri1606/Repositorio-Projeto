package Main;

import java.util.*;
import java.io.*;

public class Arquivo {
    String senhaSalva;

    public Arquivo() {
    }

    public static String Read(String Caminho) {
        String conteudo = "";

        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";

            try {
                for(linha = lerArq.readLine(); linha != null; linha = lerArq.readLine()) {
                    conteudo = conteudo + linha;
                }

                arq.close();
                return conteudo;
            } catch (IOException var6) {
                System.out.println("Erro: Não foi possivel ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException var7) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    public static boolean Write(String Caminho, String Texto) {
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        } catch (IOException var4) {
            System.out.println(var4.getMessage());
            return false;
        }
    }
}

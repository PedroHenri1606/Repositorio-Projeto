package DAO;

import model.corrida;
import java.io.*;
import java.util.*;

public class DaoCorrida {
   static List<String> nomes = new ArrayList<String>();
   static List<String> ids = new ArrayList<String>();
   static List<String> idsUser = new ArrayList<String>();
   public String escolha(int opcao){
     return nomes.get(opcao);
   }

   public void carregar(){
       try{
           BufferedReader carregar = new BufferedReader(new FileReader("corridas.txt"));
           while(true) {
               String linha = carregar.readLine();
               if (linha == null) {
                   break;
               } else {
                   StringTokenizer separador = new StringTokenizer(linha, "|");
                   nomes.add(separador.nextToken());
                   ids.add(separador.nextToken());
                   idsUser.add(separador.nextToken());
               }
           }
           carregar.close();
       } catch (Exception e){
           System.out.println("Erro ao abrir o arquivo!");
       }
   }

   public void salvar(){
       try{
           BufferedWriter salvar = new BufferedWriter(new FileWriter("corridas.txt"));
           for(int i = 0;  i < nomes.size(); i++){
               salvar.write(nomes.get(i) +  "|" + ids.get(i) + "|" + idsUser.get(i));
               salvar.newLine();
           }
           salvar.close();
       } catch (IOException e){
           e.printStackTrace();
       }
   }

   public void visualizar(String idUser){
       if(nomes.size() > 0 ) {
           for (int i = 0; i < nomes.size(); i++){
               if (idsUser.get(i).equals(idUser)) {
                   System.out.println("suas corridas: " + nomes.get(i));
               }
           }
       } else {
           System.out.println("ainda nao existe corrida alguma");
       }

   }

   public void adicionar(corrida aux){
       nomes.add(aux.getNome());
       ids.add(aux.getId());
       idsUser.add(aux.getIdUser());
       this.salvar();
   }

   public boolean validar(String nome){
       for (int i = 0; i < nomes.size(); i++){
           if (nome.equals(nomes.get(i))){
           return false;
       }
   }
   return true;
  }
}
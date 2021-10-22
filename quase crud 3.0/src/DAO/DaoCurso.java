package DAO;

import model.Curso;
import java.io.*;
import java.util.*;

public class DaoCurso {
   List<String> nomes = new ArrayList<String>();
   List<String> ids = new ArrayList<String>();

   public String escolha(int opcao){
     return nomes.get(opcao);
   }

   public void carregar(){
       try{
           BufferedReader carregar = new BufferedReader(new FileReader("Cursos.txt"));
           while(true) {
               String linha = carregar.readLine();
               if (linha == null) {
                   break;
               } else {
                   StringTokenizer separador = new StringTokenizer(linha, "|");
                   nomes.add(separador.nextToken());
                   ids.add(separador.nextToken());
               }
           }
           carregar.close();
       } catch (Exception e){
           System.out.println("Erro ao abrir o arquivo!");
       }
   }

   public void salvar(){
       try{
           BufferedWriter salvar = new BufferedWriter(new FileWriter("Cursos.txt"));
           for(int i = 0;  i < nomes.size(); i++){
               salvar.write(nomes.get(i) +  "|" + ids.get(i));
               salvar.newLine();
           }
       } catch (IOException e){
           e.printStackTrace();
       }
   }

   public void visualizar(){
       for (int i = 0; i < nomes.size(); i++){
           System.out.println(nomes.get(i) + "Posição: " + i);
       }
   }

   public void adicionar(Curso aux){
       nomes.add(aux.getNome());
       ids.add(aux.getId());
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
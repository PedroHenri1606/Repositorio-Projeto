package DAO;

import model.Curso;

import java.util.*;
import java.io.*;

public class DaoCurso {

    static List<Curso> cursos = new ArrayList<>();

    public String escolha(int opcao) {
        return cursos.get(opcao).getNome();
    }

    public Curso retornarDados(long idCurso) {//temporaria
        for (int i = 0; i< cursos.size(); i++) {
            if (Long.parseLong(cursos.get(i).getId()) == idCurso) {
                return cursos.get(i);
            }
        }
        return null;
    }

    public void carregar() {
        try {
            BufferedReader carregar = new BufferedReader(new FileReader("cursos.txt"));
            while (true) {
                String linha = carregar.readLine();
                if (linha == null) {
                    break;
                } else {
                    StringTokenizer separador = new StringTokenizer(linha, "|");
                    Curso curso = new Curso();
                    curso.setNome(separador.nextToken());
                    curso.setId(separador.nextToken());
                    cursos.add(curso);
                }
            }
            carregar.close();
        } catch (Exception e) {
            System.out.println("==============================================");
            System.out.println("     Arquivo não existe ou não encontrado     ");
            System.out.println("==============================================");
        }
    }

    public List<Curso> visualizarCurso() {
        return cursos;
    }

    public void salvar() {
        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("cursos.txt"));
            for (Curso curso : cursos) {
                salvar.write(curso.getNome() + "|" + curso.getId());
                salvar.newLine();
            }
            salvar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void adicionar(Curso aux) {
        cursos.add(aux);
        this.salvar();
    }

    public boolean validar(String nome) {
        for (Curso curso : cursos) {
            if (nome.equals(curso.getNome())) {
                return false;
            }
        }
        return true;
    }
}

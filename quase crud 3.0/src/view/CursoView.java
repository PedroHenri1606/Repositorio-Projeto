package view;

import controller.CursoController;
import controller.IdCursoController;
import model.Curso;

import java.util.Scanner;

public class CursoView {

    IdCursoController id = new IdCursoController();
    CursoController x = new CursoController();

    public void cadastrarCurso() {
        System.out.println("==============================================");
        Scanner scan = new Scanner(System.in);
        System.out.print(" nome do curso: ");
        System.out.println("==============================================");
        String tmp1 = scan.nextLine();
        String tmp2 = id.determinarID();
        Curso aux = new Curso(tmp1, tmp2);
        x.cadastrar(aux);
    }

    public String escolherCurso(int escolha) {
        return x.escolherCurso(escolha);
    }

    public void visualizar() {
        x.visualizar();
    }

    public void carregarDados() {
        x.carregar();
    }

}
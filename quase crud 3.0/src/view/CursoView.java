package view;

import controller.CursoController;
import controller.IdCursoController;
import model.Curso;

import java.util.List;
import java.util.Scanner;

public class CursoView {

    IdCursoController id = new IdCursoController();
    CursoController cursoController = new CursoController();

    public void cadastrarCurso() {
        Scanner scan = new Scanner(System.in);
        System.out.println("==============================================");
        System.out.print  (" Nome do curso: ");
        String tmp1 = scan.nextLine();
        System.out.println("==============================================\n");
        String tmp2 = id.determinarID();
        Curso aux = new Curso(tmp1, tmp2);
        cursoController.cadastrar(aux);
    }

    public String escolherCurso(int idcurso) {
        return cursoController.escolherCurso(idcurso);
    }

    public List<Curso> visualizar() {
        List<Curso> cursos = cursoController.visualizar();
        for (Curso curso : cursos) {
            System.out.println("id curso: " + curso.getId() + " nome do curso: " + curso.getNome());
        }
        return cursos;
    }

    public void carregarDados() {
        cursoController.carregar();
    }

}
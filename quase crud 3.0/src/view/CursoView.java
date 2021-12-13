package view;

import controller.CursoController;
import model.Curso;

import java.util.List;
import java.util.Scanner;

public class CursoView {

    public List<Curso> listar() {
        CursoController cursoController = new CursoController();
        return cursoController.listar();
    }


}
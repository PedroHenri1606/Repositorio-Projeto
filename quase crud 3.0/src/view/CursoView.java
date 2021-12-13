package view;

import controller.CursoController;
import model.Curso;
import java.util.List;

public class CursoView {

    public List<Curso> listar() {
        CursoController cursoController = new CursoController();
        return cursoController.listar();
    }


}
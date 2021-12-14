package controller;

import dao.CursoDAO;
import model.Curso;

public class CursoController {

    public void criarTabelaCurso(){CursoDAO cursoDAO = new CursoDAO(); cursoDAO.criarTabelaCurso();}
    public Curso adicionarCurso(Curso curso){CursoDAO cursoDAO = new CursoDAO(); return cursoDAO.adicionar(curso);}
}

package controller;

import DAO.DaoCurso;
import model.Curso;
import java.util.List;

public class CursoController {

    public void criarTabelaCurso(){DaoCurso daoCurso = new DaoCurso(); daoCurso.criarTabelaCurso();}
    public List<Curso> listar(){DaoCurso daoCurso = new DaoCurso(); return daoCurso.listar();}
    public Curso retornarDados(long id){DaoCurso daoCurso = new DaoCurso(); return daoCurso.retornarDados(id);}
    public Curso selecionaCurso(int id){DaoCurso daoCurso = new DaoCurso(); return daoCurso.determinaCurso(id);}
}

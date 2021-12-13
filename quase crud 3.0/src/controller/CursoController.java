package controller;

import DAO.DaoCurso;
import model.Curso;

import java.util.List;


public class CursoController {
    DaoCurso daoCurso = new DaoCurso();

    public void criarTabelaCurso(){ this.daoCurso.criarTabelaCurso();}
    public Curso adicionar(Curso curso){ return this.daoCurso.adicionar(curso);}
    public String escolherCurso(int id){ return this.daoCurso.escolherCurso(id);}
    public List<Curso> listar(){ return this.daoCurso.listar();}
    public Curso retornarDados(long id){ return daoCurso.retornarDados(id);}
    public Curso selecionaCurso(int id){ return daoCurso.determinaCurso(id);}
}

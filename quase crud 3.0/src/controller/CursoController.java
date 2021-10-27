    package controller;

import DAO.DaoCurso;
import model.Curso;

import java.util.List;

public class CursoController {
    DaoCurso a = new DaoCurso();

    public void carregar() {
        a.carregar();
    }

    public void cadastrar(Curso aux) {
        if (this.verificar(aux.getNome())) {
            a.adicionar(aux);
        } else {
            System.out.println("\n==============================================");
            System.out.println("         Curso invalido ou ja existe");
            System.out.println("\n==============================================");
        }
    }
    public void visualizar() {a.visualizarCurso();}
    public String escolherCurso(int escolha) {return a.escolha(escolha);}


    public boolean verificar(String nome) {
        if (a.validar(nome)) {
            return true;
        } else {
            return false;
        }
    }
}

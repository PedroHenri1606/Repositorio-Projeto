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

<<<<<<< HEAD
    public void visualizar() {a.visualizarCurso();}
    public String escolherCursoText(int escolha) {return a.escolha(escolha);}
=======
    public void visualizar() {
        a.visualizar();
    }

    public String escolherCurso(int escolha) {
        return a.escolha(escolha);
    }
>>>>>>> 26b594ed504e5880dfafb9dac68191890365a6d1


    public boolean verificar(String nome) {
        if (a.validar(nome)) {
            return true;
        } else {
            return false;
        }
    }
}

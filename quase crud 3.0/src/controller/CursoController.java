package controller;

import DAO.DaoCurso;
import model.Curso;
import java.util.*;

public class CursoController {
    DaoCurso c = new DaoCurso();

    public void carregar() {
        c.carregar();
    }

    public boolean verificar(String nome){
        if(c.validar(nome)){
            return true;
        } else{
            return false;
        }
    }

    public void cadastrar(Curso aux){
        if(this.verificar(aux.getNome())){
            c.adicionar(aux);
        } else {
            System.out.println("Curso invalida ou já existente!");
        }
    }

    public void visualizar(){
        c.visualizar();
    }

    public String escolherCurso(int escolha){
        return c.escolha(escolha);
    }

}

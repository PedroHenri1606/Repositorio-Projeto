package controller;

import DAO.DaoCorrida;
import model.corrida;

public class CorridaController {
    DaoCorrida c = new DaoCorrida();

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

    public void cadastrar(corrida aux){
        c.adicionar(aux);
    }

    public void visualizar(String idUser){
        c.visualizar(idUser);
    }

    public String escolherCurso(int escolha){
        return c.escolha(escolha);
    }

}

package controller;

import DAO.DaoCorrida;
import model.corrida;

import java.util.List;

public class CorridaController {
    DaoCorrida c = new DaoCorrida();

    public void carregar() {
        c.carregar();
    }

    public void cadastrar(corrida aux){
        c.adicionar(aux);
    }

    public List<String> visualizar(String idUser){
       return c.visualizar(idUser);
    }

    public String escolherCurso(int escolha){
        return c.escolha(escolha);
    }

}

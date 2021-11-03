package controller;

import DAO.DaoCorrida;
import model.Corrida;

import java.util.List;

public class CorridaController {
    DaoCorrida daoCorrida = new DaoCorrida();

    public void carregar() {
        daoCorrida.carregar();
    }

    public void cadastrar(Corrida aux) {
        daoCorrida.adicionar(aux);
    }

    public List<Corrida> visualizar(String idUser) {
        return daoCorrida.visualizar(idUser);
    }

    public void determinarCorridaAtual(String idEscolhido) {
        daoCorrida.determinarCorridaAtual(idEscolhido);
    }

}

package controller;

import DAO.DaoCorrida;
import model.Corrida;
import model.Usuario;
import model.Carro;

import java.util.List;

public class CorridaController {
    DaoCorrida daoCorrida = new DaoCorrida();

    public void criarTabelaCorrida() {this.daoCorrida.criarTabelaCorrida();}
    public List<Corrida> visualizar(Usuario usuario, Carro carro) {return this.daoCorrida.visualizar(usuario,carro);}
    public List<Corrida> visualizarPendentes() {return this.daoCorrida.visualizarPendentes();}
    public void cadastrarCorrida(Corrida corrida) {this.daoCorrida.cadastrarCorrida(corrida);}
    public Corrida determinarCorridaAtual(long idCorrida, Usuario usuario) {return this.daoCorrida.determinarCorridaAtual(idCorrida, usuario);}

}

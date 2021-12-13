package controller;

import DAO.DaoCorrida;
import model.Corrida;
import model.Usuario;
import model.Carro;
import java.util.List;

public class CorridaController {

    public void criarTabelaCorrida() {DaoCorrida daoCorrida = new DaoCorrida();daoCorrida.criarTabelaCorrida();}
    public List<Corrida> visualizar(Usuario usuario, Carro carro) {DaoCorrida daoCorrida = new DaoCorrida();return daoCorrida.visualizar(usuario,carro);}
    public List<Corrida> visualizarPendentes() {DaoCorrida daoCorrida = new DaoCorrida();return daoCorrida.visualizarPendentes();}
    public void cadastrarCorrida(Corrida corrida) {DaoCorrida daoCorrida = new DaoCorrida();daoCorrida.cadastrarCorrida(corrida);}
    public Corrida determinarCorridaAtual(long idCorrida, Usuario usuario) {DaoCorrida daoCorrida = new DaoCorrida();return daoCorrida.determinarCorridaAtual(idCorrida, usuario);}

}

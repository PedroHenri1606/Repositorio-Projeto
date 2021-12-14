package controller;

import DAO.DaoBairro;
import model.Bairro;
import java.util.List;

public class BairroController {

    public void criarTabelaBairro(){DaoBairro daoBairro = new DaoBairro(); daoBairro.criaTabelaBairro();}
    public List<Bairro> listar(){DaoBairro daoBairro = new DaoBairro(); return daoBairro.listar();}
    public Bairro retornarDados(long id){ DaoBairro daoBairro = new DaoBairro();return daoBairro.retornarDados(id);}
    public Bairro selecionaBairro(int id){ DaoBairro daoBairro = new DaoBairro();return daoBairro.determinaBairro(id);}
}

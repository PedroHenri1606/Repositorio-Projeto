package controller;

import DAO.DaoBairro;
import model.Bairro;

import java.util.List;

public class BairroController {
    DaoBairro b = new DaoBairro();
    public void carregar() {b.carregar();}

    public void cadastrar(Bairro aux) {
        if(this.verificar(aux.getNome())) {
            b.adicionar(aux);
        } else {
            System.out.println("\n==============================================");
            System.out.println("       Bairro invalido ou ja existe");
            System.out.println("==============================================\n");
        }
    }
    public List<Bairro> visualizar() {
       return b.visualizar();
    }
    public String escolherBairro(int escolha) {
        return b.escolha(escolha);
    }


    public boolean verificar(String nome) {
        return b.validar(nome);
    }
}

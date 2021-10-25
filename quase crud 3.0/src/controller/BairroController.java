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
            System.out.println("       Bairro invalido - ja existe");
            System.out.println("==============================================\n");
        }
    }

    public void visualizar() {
        b.visualizar();
    }
    public String escolherBairro(int escolha) {
        return b.escolha(escolha);
    }


    public boolean verificar(String nome) {
        if(b.validar(nome)) {
            return true;
        } else {
            return false;
        }
    }
}

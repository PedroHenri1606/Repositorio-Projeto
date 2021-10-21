package controller;

import DAO.DaoBairro;
import model.Bairro;

import java.util.List;

public class BairroController {
    DaoBairro b = new DaoBairro();
    public void carregar() {
        b.carregar();
    }
    public void cadastrar(Bairro aux) {
        if(this.verificar(aux.getNome())) {
            b.adicionar(aux);
        } else {
            System.out.println("bairro invalido - ja existe");
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
            //System.out.println("valido");
            return true;
        } else {
            //System.out.println("invalido");
            return false;
        }
    }
}

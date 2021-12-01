package model;

import controller.*;
import view.UsuarioView;

public class Principal {

    public static void main(String[] args) {

        UsuarioView usuarioView = new UsuarioView();
        BairroController bairroController = new BairroController();
        CorridaController corridaController = new CorridaController();
        UsuarioController usuarioController = new UsuarioController();
        CursoController cursoController = new CursoController();
        FaculdadeController faculdadeController = new FaculdadeController();

        faculdadeController.criarTabelaFaculdade();
        cursoController.criarTabelaCurso();
        bairroController.criarTabelaBairro();
        usuarioController.CriarTabelaUsuario();
        corridaController.criarTabelaCorrida();

        usuarioView.menuInicio();
    }
}


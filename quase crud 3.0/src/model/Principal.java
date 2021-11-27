package model;

import controller.BairroController;
import controller.CorridaController;
import controller.CursoController;
import controller.UsuarioController;
import view.UsuarioView;

public class
Principal {

    public static void main(String[] args) {

        UsuarioView usuarioView = new UsuarioView();
        BairroController bairroController = new BairroController();
        CorridaController corridaController = new CorridaController();
        UsuarioController usuarioController = new UsuarioController();
        CursoController cursoController = new CursoController();

        corridaController.criarTabelaCorrida();
        cursoController.criarTabelaCurso();
        usuarioController.CriarTabelaUsuario();
        bairroController.criarTabelaBairro();

        usuarioView.menuInicio();
    }
}


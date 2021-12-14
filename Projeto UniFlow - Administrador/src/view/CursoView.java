package view;

import controller.CursoController;
import model.Curso;

import javax.swing.*;

public class CursoView {

    public void adicionarCurso(){

        CursoController cursoController = new CursoController();
        Curso curso = new Curso();

        String cursoCad = JOptionPane.showInputDialog(null,"      CADASTRO CURSO\n\n"+"Nome: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        curso.setNome(cursoCad);
        cursoController.adicionarCurso(curso);
    }
}

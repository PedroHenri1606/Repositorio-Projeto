package view;

import controller.FaculdadeController;
import model.Faculdade;

import java.util.List;
import java.util.Scanner;

public class FaculdadeView {


    public List<Faculdade> listarFaculdades(){
        FaculdadeController faculdadeController = new FaculdadeController();
        return faculdadeController.listarFaculdade();
    }
}

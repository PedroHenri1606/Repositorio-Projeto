package view;

import controller.CarroController;
import model.Carro;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class CarroView {

    CarroController carroController = new CarroController();

    public void cadastrarCarro(){

        Carro carro = new Carro();
        Scanner scan = new Scanner(System.in);

            System.out.print(" Nome do carro: "); carro.setNome(scan.nextLine());
            System.out.print(" Nome da Fabricante: "); carro.setFabricante(scan.nextLine());
            System.out.print(" Nome da Cor: "); carro.setCor(scan.nextLine());
            System.out.print(" Ano de fabricação: "); carro.setAno(scan.nextLong());
            String tmp1 = scan.nextLine();
            System.out.print(" Placa do carro: "); carro.setPlaca(scan.nextLine());
            System.out.println("==============================================\n");
            this.carroController.cadastrarCarro(carro);
    }

    public List<Carro> visualizar(){
        List <Carro> carros = carroController.listarCarro();

        for (Carro carro: carros){
            System.out.println("|Id: " + carro.getId() + "| Carro: " + carro.getNome());
        }
        return carros;
    }
}



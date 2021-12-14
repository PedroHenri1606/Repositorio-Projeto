package dao;

import factory.Factory;
import model.CarroFabricante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FabricanteDAO {

    Connection connection;

    public FabricanteDAO(){ this.connection = new Factory().getConection();}

    public void criarTabelaCarroFabricante(){

        String sql = "CREATE TABLE IF NOT EXISTS carroFabricante("+
                "id_fabricante bigint primary key auto_increment,"+
                "nome VARCHAR(45))";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public CarroFabricante adicionar (CarroFabricante carroFabricante){

        String sql = "INSERT INTO uniflow.carroFabricante (nome) value (?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, carroFabricante.getNome());
            statement.execute();
            statement.close();
            return carroFabricante;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

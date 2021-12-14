package dao;

import factory.Factory;
import model.CarroCor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarroCorDAO {

    Connection connection;

    public CarroCorDAO(){ this.connection = new Factory().getConection();}

    public void criarTabelaCarroCor(){
        String sql = "CREATE TABLE IF NOT EXISTS carroCor("+
                "id_cor bigint primary key auto_increment,"+
                "nome VARCHAR(45))";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public CarroCor adicionar(CarroCor carroCor){

        String sql = "INSERT INTO uniflow.carroCor (nome) value (?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,carroCor.getNome());
            statement.execute();
            statement.close();
            return carroCor;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

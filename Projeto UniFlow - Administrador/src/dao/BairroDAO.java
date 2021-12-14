package dao;

import factory.Factory;
import model.Bairro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BairroDAO {

    Connection connection;

    public BairroDAO() {this.connection = new Factory().getConection();}

    public void criaTabelaBairro() {
        String sql = "CREATE TABLE IF NOT EXISTS bairro(" +
                "id_bairro bigint primary key auto_increment," +
                "nome_bairro VARCHAR(45));";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Bairro adicionar(Bairro bairro) {

        String sql = "INSERT INTO uniflow.bairro (nome_bairro) value (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bairro.getNome());
            statement.execute();
            statement.close();
            return bairro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

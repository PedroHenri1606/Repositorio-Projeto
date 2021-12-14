package dao;

import factory.Factory;
import model.CarroNome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NomeCarroDAO {

    Connection connection;

    public NomeCarroDAO() {
        this.connection = new Factory().getConection();
    }

    public void criarTabelaCarroNome() {

        String sql = "CREATE TABLE IF NOT EXISTS carroNome(" +
                "id_nomeCarro bigint primary key auto_increment," +
                "nomeModelo VARCHAR(45))";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CarroNome adicionar(CarroNome carroNome) {

        String sql = "INSERT INTO uniflow.carroNome (nomeModelo) value (?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, carroNome.getNome());
            statement.execute();
            statement.close();
            return carroNome;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

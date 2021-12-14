package DAO;

import fabrica.Factory;
import model.CarroNome;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCarroNome {

    Connection connection;

    public DaoCarroNome() {
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

    public List<CarroNome> listar() {

        String sql = "SELECT * FROM uniflow.carronome";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList nomes = new ArrayList();

            while (resultSet.next()) {
                CarroNome carroNome = new CarroNome();
                carroNome.setId(resultSet.getLong("id_nomeCarro"));
                carroNome.setNome(resultSet.getString("nomeModelo"));
                nomes.add(carroNome);
            }
            return nomes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CarroNome retornarNome(long id) {

        String sql = "SELECT * from uniflow.carronome where id_nomeCarro = " + id;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CarroNome carroNome = new CarroNome();
                carroNome.setId(resultSet.getLong("id_nomeCarro"));
                carroNome.setNome(resultSet.getString("nomeModelo"));
                return carroNome;
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public CarroNome determinaCurso(int id) {

        String sql = "SELECT * FROM carronome where id_nomeCarro = " + id;
        List<CarroNome> modelos = new ArrayList();
        CarroNome carroNome = new CarroNome();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                carroNome.setId(resultSet.getInt("id_nomeCarro"));
                carroNome.setNome(resultSet.getString("nomeModelo"));
                modelos.add(carroNome);
            }
            statement.execute();
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carroNome;
    }
}

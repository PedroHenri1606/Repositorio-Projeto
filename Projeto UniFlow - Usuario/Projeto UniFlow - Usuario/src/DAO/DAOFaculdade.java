package DAO;

import fabrica.Factory;
import model.Faculdade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOFaculdade {

    Connection connection;

    public DAOFaculdade() {this.connection = new Factory().getConection();}

    public void criarTabelaFaculdade() {
        String sql = "create table if not exists faculdade(" +
                "idFaculdade bigint primary key auto_increment, " +
                "nome varchar(50));";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Faculdade> listarFaculdade() {
        String sql = "select * from uniflow.faculdade";
        try {
            List<Faculdade> faculdades = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Faculdade faculdade;
            while (resultSet.next()) {
                faculdade = new Faculdade();
                faculdade.setIdFaculdade(resultSet.getLong("idFaculdade"));
                faculdade.setNome(resultSet.getString("nome"));
                faculdades.add(faculdade);
            }
            return faculdades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Faculdade selecionarPorId(long idFaculdade) {
        String sql = "select * from uniflow.faculdade where idFaculdade = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idFaculdade);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Faculdade faculdade = new Faculdade();
                faculdade.setIdFaculdade(resultSet.getLong("idFaculdade"));
                faculdade.setNome(resultSet.getString("nome"));
                return faculdade;
            }
            statement.close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public Faculdade determinaFaculdade(int id) {

        String sql = "SELECT * FROM faculdade where idFaculdade = " + id;
        List<Faculdade> faculdades = new ArrayList();
        Faculdade faculdade = new Faculdade();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                faculdade.setIdFaculdade(resultSet.getInt("idFaculdade"));
                faculdade.setNome(resultSet.getString("nome"));
                faculdades.add(faculdade);
            }
            statement.execute();
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return faculdade;
    }
}





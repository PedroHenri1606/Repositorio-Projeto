package DAO;

import  fabrica.Factory;
import model.Bairro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DaoBairro {

    Connection connection;

    public DaoBairro() {
        this.connection = new Factory().getConection();
    }

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

    public List<Bairro> listar() {

        String sql = "SELECT * FROM uniflow.bairro";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList bairros = new ArrayList();

            while (resultSet.next()) {
                Bairro bairro = new Bairro();
                bairro.setId(resultSet.getInt("id_bairro"));
                bairro.setNome(resultSet.getString("nome_bairro"));
                bairros.add(bairro);
            }
            return bairros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Bairro retornarDados(long id) {

        String sql = "SELECT id_bairro from bairro where id_bairro = " + id;

        List<Bairro> bairros = new ArrayList();
        Bairro bairro = new Bairro();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                bairro.setId(resultSet.getInt("id_bairro"));
                bairros.add(bairro);
            }
            statement.execute();
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bairro;
    }

    public Bairro determinaBairro(int id) {

        String sql = "SELECT * FROM bairro where id_bairro = " + id;
        List<Bairro> bairros = new ArrayList();
        Bairro bairro = new Bairro();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                bairro.setId(resultSet.getInt("id_bairro"));
                bairro.setNome(resultSet.getString("nome_bairro"));
                bairros.add(bairro);
            }
            statement.execute();
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bairro;
    }
}

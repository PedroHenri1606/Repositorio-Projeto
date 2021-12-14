package dao;

import factory.Factory;
import model.Faculdade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FaculdadeDAO {

    Connection connection;

    public FaculdadeDAO() {this.connection = new Factory().getConection();}

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

    public Faculdade cadastrarFaculdade(Faculdade faculdade) {
        String sql = "insert into uniflow.faculdade(nome) value (?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, faculdade.getNome());
            statement.execute();
            statement.close();
            return faculdade;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

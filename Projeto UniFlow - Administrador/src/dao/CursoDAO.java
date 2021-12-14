package dao;

import factory.Factory;
import model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CursoDAO {

    Connection connection;

    public CursoDAO() {
        this.connection = new Factory().getConection();
    }

    public void criarTabelaCurso() {
        String sql = "CREATE TABLE IF NOT EXISTS curso(" +
                "id_curso bigint primary key auto_increment," +
                "nome_curso VARCHAR(45));";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Curso adicionar(Curso curso) {

        String sql = "INSERT INTO uniflow.curso  (nome_curso) value(?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, curso.getNome());
            statement.execute();
            statement.close();
            return curso;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

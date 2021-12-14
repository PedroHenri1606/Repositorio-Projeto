package DAO;

import fabrica.Factory;
import model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DaoCurso {

    Connection connection;

    public DaoCurso() {
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

    public List<Curso> listar() {


        String sql = "select * from uniflow.curso";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList cursos = new ArrayList();

            while (resultSet.next()) {
                Curso curso = new Curso();
                curso.setId(resultSet.getInt("id_curso"));
                curso.setNome(resultSet.getString("nome_curso"));
                cursos.add(curso);
            }
            return cursos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Curso retornarDados(long id) {

        String sql = "SELECT id_curso from curso where id_curso = " + id;

        List<Curso> cursos = new ArrayList();
        Curso curso = new Curso();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                curso.setId(resultSet.getInt("id_curso"));
                cursos.add(curso);
            }
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return curso;
    }

    public Curso determinaCurso(int id) {

        String sql = "SELECT * FROM curso where id_curso = " + id;
        List<Curso> cursos = new ArrayList();
        Curso curso = new Curso();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                curso.setId(resultSet.getInt("id_curso"));
                curso.setNome(resultSet.getString("nome_curso"));
                cursos.add(curso);
            }
            statement.execute();
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return curso;
    }
}



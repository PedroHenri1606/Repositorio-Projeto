package DAO;

import fabrica.Factory;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {

    public boolean login(String email, String senha) {
        boolean status;
        String sql = "select * from uniflow.usuario where (email = ? AND senha = ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();
            status = resultSet.next();
            statement.close();
            return status;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario determinarUsuarioAtual(String email, String senha) {
        boolean status;
        String sql = "select * from uniflow.usuario where (email = ? AND senha = ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();
            status = resultSet.next();
            Usuario tmp = new Usuario();
            if (status) {
                tmp.setIdUsuario(resultSet.getLong("id_usuario"));
                tmp.setNome(resultSet.getString("nome"));
                tmp.setSobrenome(resultSet.getString("sobrenome"));
                tmp.setEmail(resultSet.getString("email"));
                tmp.setDestino(resultSet.getString("destino"));
                tmp.setIdcurso(resultSet.getLong("id_curso"));
                tmp.setIdbairro(resultSet.getLong("id_bairro"));
                tmp.setSenha(resultSet.getString("senha"));
            }
            statement.close();
            return tmp;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> visualizarUsuariosProximos(Usuario usuarioAtual) {
        List<Usuario> usuariosProximos = new ArrayList<>();
        String sql = "SELECT * FROM uniflow.usuario where (id_bairro = ? and id_usuario <> ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, usuarioAtual.getIdbairro());
            statement.setLong(2, usuarioAtual.getIdUsuario());
            ResultSet resultSet = statement.executeQuery();
            Usuario usuario;
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getLong("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSobrenome(resultSet.getString("sobrenome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setDestino(resultSet.getString("destino"));
                usuario.setIdcurso(resultSet.getLong("id_curso"));
                usuario.setIdbairro(resultSet.getLong("id_bairro"));
                usuariosProximos.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuariosProximos;
    }

    Connection connection = null;

    public DaoUsuario() {
        this.connection = new Factory().getConection();
    }

    public void criarTabelaUsuario() {
        String sql = "CREATE TABLE IF NOT EXISTS usuario(" +
                "id_usuario bigint primary key auto_increment," +
                "nome VARCHAR(50)," +
                "sobrenome VARCHAR(50)," +
                "email VARCHAR(100) UNIQUE," +
                "senha VARCHAR (50)," +
                "destino VARCHAR (50), " +
                "id_curso bigint, " +
                "id_bairro bigint); ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario editar(Usuario usuario) {
        String sql = "update uniflow.usuario set nome = ?, sobrenome = ?, email = ?, senha = ?, destino = ?, id_curso = ?, id_bairro = ? where id_usuario = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSobrenome());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getSenha());
            statement.setString(5, usuario.getDestino());
            statement.setLong(6, usuario.getIdcurso());
            statement.setLong(7, usuario.getIdbairro());
            statement.setLong(8, usuario.getIdUsuario());
            statement.execute();
            statement.close();
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void adicionar(Usuario user) {
        String sql = "INSERT INTO uniflow.usuario(nome, sobrenome, email, senha, destino, id_curso, id_bairro) value(?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getNome());
            statement.setString(2, user.getSobrenome());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getSenha());
            statement.setString(5, user.getDestino());
            statement.setLong(6, user.getIdcurso());
            statement.setLong(7, user.getIdbairro());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

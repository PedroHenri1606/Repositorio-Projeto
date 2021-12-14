package DAO;

import controller.BairroController;
import controller.CursoController;
import fabrica.Factory;
import model.Faculdade;
import model.Usuario;
import java.sql.*;
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
                tmp.setEscolha(resultSet.getLong("escolha"));

                DAOFaculdade daoFaculdade = new DAOFaculdade();
                Faculdade faculdade = daoFaculdade.selecionarPorId(resultSet.getLong("idFaculdade"));
                tmp.setDestino(faculdade);

                CursoController cursoController = new CursoController();
                tmp.setCurso(cursoController.retornarDados(resultSet.getLong("id_curso")));
                BairroController bairroController = new BairroController();
                tmp.setBairro(bairroController.retornarDados(resultSet.getLong("id_bairro")));

                tmp.setSenha(resultSet.getString("senha"));
            }
            statement.close();
            return tmp;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario retornaDados(long id){

        String sql = "SELECT id_usuario from usuario where id_usuario = " + id;

        Usuario usuario = new Usuario();
        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                usuario.setIdUsuario(resultSet.getLong("id_usuario"));

            }
            statement.execute();
            statement.close();

            return usuario;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> visualizarUsuariosProximos(Usuario usuarioAtual) {
        List<Usuario> usuariosProximos = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM uniflow.usuario where (id_bairro = ? and id_usuario <> ? and escolha <> ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, usuarioAtual.getBairro().getId());
            statement.setLong(2, usuarioAtual.getIdUsuario());
            statement.setLong(3, usuarioAtual.getEscolha());
            ResultSet resultSet = statement.executeQuery();
            Usuario usuario;
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getLong("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSobrenome(resultSet.getString("sobrenome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));

                DAOFaculdade daoFaculdade = new DAOFaculdade();
                Faculdade faculdade = daoFaculdade.selecionarPorId(resultSet.getLong("idFaculdade"));
                usuario.setDestino(faculdade);

                CursoController cursoController = new CursoController();
                usuario.setCurso(cursoController.retornarDados(resultSet.getLong("id_curso")));
                BairroController bairroController = new BairroController();
                usuario.setBairro(bairroController.retornarDados(resultSet.getLong("id_bairro")));
                usuariosProximos.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuariosProximos;
    }

    Connection connection;

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
                "escolha BIGINT," +
                "idFaculdade bigint," +
                "sexo bigint,"+
                "foreign key (idFaculdade) references faculdade(idFaculdade)," +
                "id_curso bigint," +
                "foreign key (id_curso) references curso(id_curso)," +
                "id_bairro bigint," +
                "foreign key (id_bairro) references bairro(id_bairro))";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario editar(Usuario usuario) {
        String sql = "update uniflow.usuario set nome = ?, sobrenome = ?, email = ?, senha = ?, idFaculdade = ?, id_curso = ?, id_bairro = ? where id_usuario = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSobrenome());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getSenha());
            statement.setLong(5, usuario.getDestino().getIdFaculdade());
            statement.setLong(6, usuario.getCurso().getId());//temporario
            statement.setLong(7, usuario.getBairro().getId());
            statement.setLong(8, usuario.getIdUsuario());
            statement.execute();
            statement.close();
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adicionar(Usuario user) {

        String sql = "INSERT INTO uniflow.usuario(nome, sobrenome, email, senha, idFaculdade, escolha ,sexo, id_curso, id_bairro) value(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getNome());
            statement.setString(2, user.getSobrenome());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getSenha());
            statement.setLong(5, user.getDestino().getIdFaculdade());
            statement.setLong(6, user.getEscolha());
            statement.setLong(7, user.getSexo());
            statement.setLong(8, user.getCurso().getId());
            statement.setLong(9, user.getBairro().getId());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

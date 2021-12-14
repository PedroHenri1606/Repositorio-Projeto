package dao;

import factory.Factory;
import model.Usuario;
import view.UsuarioView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Connection connection;

    public UsuarioDAO(){this.connection = new Factory().getConection();}

    public void criarTabelaADM(){

        String sql = "CREATE TABLE IF NOT EXISTS usuarioADM("+
                     "id_usuarioADM bigint primary key auto_increment,"+
                     "nomeADM VARCHAR(45),"+
                     "senhaADM VARCHAR(45),"+
                     "codigoAcessoADM bigint)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void adicionarUsuario(Usuario usuario){

        String sql = "INSERT INTO uniflow.usuarioADM (nomeADM, senhaADM, codigoAcessoADM) value (?,?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,usuario.getNome());
            statement.setString(2,usuario.getSenha());
            statement.setLong(3,usuario.getCodigoAcesso());
            statement.execute();
            statement.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean login(long codigoAcesso, String senha){

        boolean status;

        String sql = "SELECT * FROM uniflow.usuarioADM where (codigoAcessoADM = ? AND senhaADM = ?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,codigoAcesso);
            statement.setString(2,senha);
            ResultSet resultSet = statement.executeQuery();
            status = resultSet.next();
            statement.close();
            return status;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Usuario determinarUsuarioAtual(long codigo,String senha){

        boolean status;

        String sql = "select * from uniflow.usuarioADM where (codigoAcessoADM = ? AND senhaADM = ?);";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1,codigo);
            statement.setString(2,senha);

            ResultSet resultSet = statement.executeQuery();
            status = resultSet.next();
            Usuario tmp = new Usuario();

            if(status){
                tmp.setIdUsuario(resultSet.getLong("id_usuarioADM"));
                tmp.setNome(resultSet.getString("nomeADM"));
                tmp.setSenha(resultSet.getString("senhaADM"));
                tmp.setCodigoAcesso(resultSet.getLong("codigoAcessoADM"));
            }
            statement.close();
            return tmp;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean sistemaDeSeguranca(){

        boolean status;
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();

        String sql = "SELECT * FROM uniflow.usuarioADM";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                usuario.setIdUsuario(resultSet.getLong("id_usuarioADM"));
                usuarios.add(usuario);
                return true;
            }
            statement.execute();
            statement.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

}

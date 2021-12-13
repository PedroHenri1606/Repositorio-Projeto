package DAO;

import controller.*;
import fabrica.Factory;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCarro {

    Connection connection;

    public DaoCarro() {
        this.connection = new Factory().getConection();
    }

    public void criarTabelaCarro() {
        String sql = "CREATE TABLE IF NOT EXISTS carro(" +
                "id_carro bigint primary key auto_increment," +
                "modelo bigint," +
                "foreign key(modelo) references carronome(id_nomeCarro),"+
                "fabricante bigint," +
                "foreign key(fabricante) references carrofabricante(id_fabricante),"+
                "cor bigint," +
                "foreign key(cor) references carrocor(id_cor),"+
                "ano_carro bigint," +
                "placa_carro VARCHAR(45)," +
                "dono bigint,"+
                "foreign key(dono) references usuario(id_usuario))";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Carro adicionar(Carro carro) {

        String sql = "INSERT INTO uniflow.carro (modelo,fabricante,cor,ano_carro,placa_carro,dono) value (?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,   carro.getNome().getId());
            statement.setLong(2,   carro.getFabricante().getId());
            statement.setLong(3,   carro.getCor().getId());
            statement.setLong(4,   carro.getAno());
            statement.setString(5, carro.getPlaca());
            statement.setLong(6,   carro.getDono().getIdUsuario());
            statement.execute();
            statement.close();
            return carro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Carro retornarDados(long id) {

        String sql = "SELECT id_carro from carro where id_carro = " + id;

        List<Carro> carros = new ArrayList<>();
        Carro carro = new Carro();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                carro.setId(resultSet.getLong("id_carro"));
                carros.add(carro);
            }
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carro;
    }

    public Carro retornarDadosCorrida(long id){

        String sql = "SELECT id_carro from carro where dono = " + id;

        List<Carro> carros = new ArrayList<>();
        Carro carro = new Carro();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                carro.setId(resultSet.getLong("id_carro"));
                carros.add(carro);
            }
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carro;
    }

    public Carro determinarCarro(long id){

        boolean status;
        String sql = "SELECT * FROM uniflow.carro where dono = " + id;
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            status = resultSet.next();
            Carro tmp1 = new Carro();

            if(status){
                tmp1.setId(resultSet.getLong("id_carro"));
                CarroNomeController carroNomeController = new CarroNomeController();
                tmp1.setNome(carroNomeController.retornarNome(resultSet.getLong("modelo")));
                CarroFabricanteController carroFabricanteController = new CarroFabricanteController();
                tmp1.setFabricante(carroFabricanteController.retornarNome(resultSet.getLong("fabricante")));
                CarroCorController carroCorController = new CarroCorController();
                tmp1.setCor(carroCorController.retornarCor(resultSet.getLong("cor")));
                tmp1.setAno(resultSet.getLong("ano_carro"));
                tmp1.setPlaca(resultSet.getString("placa_carro"));
                UsuarioController usuarioController = new UsuarioController();
                tmp1.setDono(usuarioController.retornarDado(resultSet.getLong("dono")));
            }
            statement.close();
            return tmp1;
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Multas;
import model.Usuario;
import nota3.MenuAdm;

public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Usuario usuario) throws SQLException {

        String sql = "insert into usuario(nome,email,cpf,senha,celular,veiculo,placa,unidade,bloco) values('" + usuario.getNome() + "','" + usuario.getEmail() + "','" + usuario.getCpf() + "','" + usuario.getSenha() + "','" + usuario.getCelular() + "','" + usuario.getVeiculo() + "','" + usuario.getPlaca() + "','" + usuario.getUnidade() + "','" + usuario.getBloco() + "');";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();

    }

    public void inserirMultas(Multas multas) throws SQLException {

        String sql = "insert into multas (descricao,valor) values ('" + multas.getDescricao() + "','" + multas.getValor() + "');";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();

    }

    public boolean existeNoBancoPorNomeESenha(Usuario usuario) throws SQLException {
        String sql = "select * from usuario where nome = ? and senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        return resultSet.next();
    }

}

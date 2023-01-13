package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Multas;
import model.Sessao;
import model.Usuario;

public class SessaoDAO {
    
    private final Connection connection;
    
    public SessaoDAO(Connection connection) {
        this.connection = connection;
    }
    
     public void insert(Sessao sessao) throws SQLException {

        String sql = "insert into sessao(nome_usuario) values('" + sessao.getNome_usuario() + "');";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();

    }
     /*
     public void insert(Sessao sessao) throws SQLException {

        String sql = "insert into sessao(nome_usuario) values('" + sessao.getNome_usuario() + "');";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();

    }
     */
}

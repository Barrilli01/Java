package controller;

import dao.Conexao;
import dao.SessaoDAO;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Multas;
import model.Sessao;
import model.Usuario;
import nota3.MenuAdm;
import nota3.MenuCadastro;

public class MenuCadastroController {

    private MenuCadastro view;
    private MenuAdm view1;

    public MenuCadastroController(MenuCadastro view) {
        this.view = view;
    }

    public MenuCadastroController(MenuAdm view1) {
        this.view1 = view1;
    }

    public void salvaUsuario() {
        String nome = view.getTextFieldNome().getText();
        String email = view.getTextFieldEmail().getText();
        String cpf = view.getTextFieldCpf().getText();
        String senha = view.getTextFieldSenha().getText();
        String celular = view.getTextFieldCelular().getText();
        String veiculo = view.getTextFieldVeiculo().getText();
        String placa = view.getTextFieldPlaca().getText();
        String unidade = view.getTextFieldUnidade().getText();
        String bloco = view.getTextFieldBloco().getText();

        Usuario novoUsuario = new Usuario(nome, email, cpf, senha, celular, veiculo, placa, unidade, bloco);

        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(novoUsuario);
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(MenuCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvaMulta() throws SQLException {
        String descricao = view1.getjTextFieldDescricao().getText();
        String valor = view1.getjTextFieldValor().getText();
        Multas novaMulta = new Multas(descricao, valor);
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        usuarioDao.inserirMultas(novaMulta);
        JOptionPane.showMessageDialog(null, "Multa salva com sucesso!");

    }

/*
    public void salvaMulta() throws SQLException {
        String nome_usuario = view1.getjTextFieldDescricao().getText();
        Sessao novaSessao = new Sessao(nome_usuario);
        Connection conexao = new Conexao().getConnection();
        SessaoDAO sessaoDao = new SessaoDAO(conexao);
        sessaoDao.insert(novaSessao);
        JOptionPane.showMessageDialog(null, "Sessão salva com sucesso!");

    }
*/
}

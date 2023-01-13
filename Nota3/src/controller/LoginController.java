package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import dao.SessaoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import nota3.Login;
import nota3.MenuAdm;
import nota3.MenuUsuario;

public class LoginController {

    private Login view;

    public LoginController(Login view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        boolean existe;
        String nome = view.getTextFieldNome().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        String sessao = view.getTextFieldNome().getText();
        
        MenuAdm menuAdm = new MenuAdm();
        MenuUsuario menuUsuario = new MenuUsuario();
        Usuario usuarioAutenticar = new Usuario(nome, senha, nome, senha, senha, senha, senha, nome, nome);

        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        SessaoDAO sessaoDao = new SessaoDAO(conexao);
        existe = usuarioDao.existeNoBancoPorNomeESenha(usuarioAutenticar);

        if (existe) {
            if (usuarioAutenticar.getNome().equals("admin")) {
                
                menuAdm.adm.setText(nome);
                menuUsuario.setVisible(false);
                menuAdm.setVisible(true);
            } else {
                menuUsuario.usuario.setText(nome);
                menuUsuario.setVisible(true);
                menuAdm.setVisible(false);
                
            }

        } else {
            JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos!    ");
            Login login = new Login();
            login.setVisible(true);
        }
    }
    
}

   



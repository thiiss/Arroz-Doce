package Controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.TelaPrincipal;



public class LoginController{    
    private final String usuario;
    private final String senha;
    private final Usuario usuarioLogin;
    
    public LoginController(String usuario, String senha) throws SQLException {
        this.usuario = usuario;
        this.senha = senha;
        this.usuarioLogin = new Usuario(usuario, senha);    
    }
    
    private boolean verificarUsuarioESenha() throws SQLException{
        boolean consultaUsuario = usuarioLogin.exiteUsuarioeSenha();
        return consultaUsuario ;
    }
    
    public void entrar() throws SQLException {
        if(verificarUsuarioESenha()){
            usuarioLogin.usuarioParamentro();
            TelaPrincipal telaprincipal = new TelaPrincipal(usuarioLogin);
            telaprincipal.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Usuario ou Senha Inválido!!!");
        }       
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.UsuarioM;
import view.TelaPrincipal;

/**
 *
 * @author joelmir
 */
public abstract class UsuarioDao implements Dao{
    public conn con = new conn();
    public void inserir(Object o) {
        UsuarioM u = (UsuarioM) o;
       String sql = "INSERT INTO Usuario (cpf,senha,nome,email,telefone,endereco) VALUES(?,?,?,?,?,?)";
       try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setString(1,u.getCpf());
           ps.setString(2,u.getSenha());
           ps.setString(3,u.getNome());
           ps.setString(4, u.getEmail());
           ps.setString(5, u.getTelefone());
           ps.setString(6,u.getEndereco());
           ps.execute();
           ps.close();
           JOptionPane.showMessageDialog(null,"Cadastro Realizado!");
          // con.FecharConexao();
       }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       }
       
    }

    @Override
    public void atualizar(Object o) {
        UsuarioM u = (UsuarioM) o;
         String sql = "UPDATE Usuario SET cpf=?,senha=?,nome=?,email=?,telefone=?,endereco=? WHERE id=?";
         try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setString(1,u.getCpf());
           ps.setString(2,u.getSenha());
           ps.setString(3,u.getNome());
           ps.setString(4, u.getEmail());
           ps.setString(5, u.getTelefone());
           ps.setString(6,u.getEndereco());
           ps.setString(7,u.getId());
           ps.execute();
           ps.close(); 
           JOptionPane.showMessageDialog(null,"Cadastro Atualizado!");
         } catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       } 
    }

    @Override
    public void excluir(int o) {
        String sql = "DELETE FROM Usuario WHERE id=" + o;
        try{
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null,"Cadastro Excluido!");
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       } 
    }
    
    public void VerifLogin(UsuarioM u){
        String sql = "SELECT cpf,senha FROM Usuario WHERE cpf=? AND senha=?";
        try{
            PreparedStatement ps =conn.getConexao().prepareStatement(sql);
            ps.setString(1,u.getCpf());
            ps.setString(2, u.getSenha());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run() {
                      new TelaPrincipal().setVisible(true);
                    }
                });  
                
            }else{
                JOptionPane.showMessageDialog(null,"Usuário ou Senha inválido!");
            }
         
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
}

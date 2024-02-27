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
import model.FazendaM;
import view.TelaPrincipal;

/**
 *
 * @author joelmir
 */
public abstract class FazendaDao implements Dao{
    public conn con = new conn();
    public void inserir(Object o) {
        FazendaM f = (FazendaM) o;
       String sql = "INSERT INTO Fazenda (nome,proprietariofazenda,car,email,telefonef,endereco) VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.setString(1,f.getNome());
            ps.setString(2,f.getProprietario());
            ps.setString(3,f.getCAR());
            ps.setString(4, f.getEmail());
            ps.setString(5, f.getTelefone());
            ps.setString(6,f.getEndereco());
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
        FazendaM f = (FazendaM) o;
        String sql = "UPDATE Fazenda SET nome=?,proprietario=?,car=?,email=?,telefone=?,endereco=? WHERE idfazenda=?";
            try{
              PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.setString(1,f.getNome());
            ps.setString(2,f.getProprietario());
            ps.setString(3,f.getCAR());
            ps.setString(4, f.getEmail());
            ps.setString(5, f.getTelefone());
            ps.setString(6,f.getEndereco());
            ps.setString(7,f.getId());
            ps.execute();
            ps.close(); 
            JOptionPane.showMessageDialog(null,"Cadastro Atualizado!");
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
          } 
    }

    @Override
    public void excluir(int o) {
        String sql = "DELETE FROM Fazenda WHERE idfazenda=" + o;
        try{
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null,"Cadastro Excluido!");
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       } 
    }
    
}

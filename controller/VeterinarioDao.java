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
import model.VeterinarioM;
import view.TelaPrincipal;

/**
 *
 * @author joelmir
 */
public abstract class VeterinarioDao implements Dao{
    public conn con = new conn();
    public void inserir(Object o) {
        VeterinarioM v = (VeterinarioM) o;
       String sql = "INSERT INTO Veterinario (nome,crmv,cpf,especilaidade,email,telefone,endereco) VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.setString(1,v.getNome());
            ps.setString(2,v.getCrm());
            ps.setString(3,v.getCpf());
            ps.setString(4, v.getEspecialidade());
            ps.setString(5, v.getEmail());
            ps.setString(6, v.getTelefone());
            ps.setString(7,v.getEndereco());
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
        VeterinarioM v = (VeterinarioM) o;
        String sql = "UPDATE Veterinario SET nome=?,crmv=?,cpf=?,especilaidade=?,email=?,telefone=?,endereco=? WHERE idveterinario=?";
            try{
              PreparedStatement ps = conn.getConexao().prepareStatement(sql);
              ps.setString(1,v.getNome());
              ps.setString(2,v.getCrm());
              ps.setString(3,v.getCpf());
              ps.setString(4, v.getEspecialidade());
              ps.setString(5, v.getEmail());
              ps.setString(6, v.getTelefone());
              ps.setString(7,v.getEndereco());
              ps.setString(8,v.getId());
              ps.execute();
              ps.close(); 
              JOptionPane.showMessageDialog(null,"Cadastro Atualizado!");
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
          } 
    }

    @Override
    public void excluir(int o) {
        String sql = "DELETE FROM Veterinario WHERE idveterinario=" + o;
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

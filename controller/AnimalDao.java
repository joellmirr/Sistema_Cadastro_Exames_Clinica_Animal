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
import model.AnimalM;

/**
 *
 * @author joelmir
 */
public abstract class AnimalDao implements Dao{
    public conn con = new conn();
    public void inserir(Object o) {
       AnimalM a = (AnimalM) o;
       String sql = "INSERT INTO Animal(nomeanimal,especie,datanascimente,sexo,descricaoanimal,Fazendaanimal) VALUES(?,?,?,?,?,?)";
       try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.setString(1,a.getNomeAnimal());
            ps.setString(2,a.getEspecie());
            ps.setString(3,a.getDataNas());
            ps.setString(4,a.getSexo());
            ps.setString(5,a.getDescricaoAnimal());
            ps.setInt(6,a.getFazenda());
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
        AnimalM a = (AnimalM) o;
        String sql = "UPDATE Animal SET nomeanimal=?,especie=?,datanascimente=?,sexo=?,descricaoanimal=?,Fazendaanimal=? WHERE idanimal=?";
            try{
              PreparedStatement ps = conn.getConexao().prepareStatement(sql);
              ps.setString(1,a.getNomeAnimal());
              ps.setString(2,a.getEspecie());
              ps.setString(3,a.getDataNas());
              ps.setString(4,a.getSexo());
              ps.setString(5,a.getDescricaoAnimal());
              ps.setInt(6,a.getFazenda());
              ps.setString(7,a.getIdanimal());
              ps.execute();
              ps.close(); 
              JOptionPane.showMessageDialog(null,"Cadastro Atualizado!");

            } catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);      
            } 
    }

    @Override
    public void excluir(int o) {
        String sql = "DELETE FROM Animal WHERE idanimal=" + o;
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

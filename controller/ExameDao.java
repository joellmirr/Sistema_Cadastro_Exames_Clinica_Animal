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
import model.ExameM;
/**
 *
 * @author joelmir
 */
public abstract class ExameDao implements Dao{
    public conn con = new conn();
    public void inserir(Object o) {
       ExameM e = (ExameM) o;
       String sql = "INSERT INTO ExamesAnimal(tipoexame,resultadoexame,vacina,datavacina,pesoanimal,datapeso,veterinario,animal) VALUES(?,?,?,?,?,?,?,?)";
       try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setString(1,e.getTipoExame());
           ps.setString(2,e.getResulExame());
           ps.setString(3,e.getVacina());
           ps.setString(4,e.getDataVacina());
           ps.setString(5,e.getPeso());
           ps.setString(6, e.getDataPeso());
           ps.setInt(7,e.getVeterinario());
           ps.setInt(8,e.getAnimal());
           ps.execute();
           ps.close();
           JOptionPane.showMessageDialog(null,"Cadastro Realizado!");
          // con.FecharConexao();
       }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);       }
       
    }

    @Override
    public void atualizar(Object o) {
        ExameM e = (ExameM) o;
         String sql = "UPDATE ExamesAnimal SET tipoexame=?,resultadoexame=?,vacina=?,datavacina=?,pesoanimal=?,datapeso=?,"
                 + "veterinario=?,animal=? WHERE idexameeanimal=?";
         try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setString(1,e.getTipoExame());
           ps.setString(2,e.getResulExame());
           ps.setString(3,e.getVacina());
           ps.setString(4,e.getDataVacina());
           ps.setString(5,e.getPeso());
           ps.setString(6, e.getDataPeso());
           ps.setInt(7,e.getVeterinario());
           ps.setInt(8,e.getAnimal());
           ps.setString(9,e.getIdExame());
           ps.execute();
           ps.close(); 
           JOptionPane.showMessageDialog(null,"Cadastro Atualizado!");

         } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);       } 
    }

    @Override
    public void excluir(int o) {
        String sql = "DELETE FROM ExamesAnimal WHERE idexameeanimal=" + o;
        try{
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null,"Cadastro Excluido!");
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);       } 
    }
}

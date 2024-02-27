/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joelmir
 */
public class UsuarioM extends PessoaFisica{
    private String id;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

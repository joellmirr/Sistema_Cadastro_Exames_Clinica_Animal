/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joelmir
 */
public class FazendaM extends PessoaJuridica {
    private String id;
    private String Proprietario;
    private String CAR;//CAR-CADASTRO AMBIENTAL RURAL

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProprietario() {
        return Proprietario;
    }

    public void setProprietario(String Proprietario) {
        this.Proprietario = Proprietario;
    }

    public String getCAR() {
        return CAR;
    }

    public void setCAR(String CAR) {
        this.CAR = CAR;
    }
    
              
}

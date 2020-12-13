/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;

/**
 *
 * @author Utilizador
 */
public class Medico extends Pessoa{
    //variaveis de instancia
    //construtor
    public Medico()
    {
        super();
    }
    
    //metodos
    
    //getters e setters
    //toString
    @Override
    public String toString()
    {
        String info;
        info = "MEDICO: " + super.getId() + "\n";
        return info;
    }
    //equals
}

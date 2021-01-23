/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrincipaisClasses;

/**
 *
 * @author jcupi
 */
public class EnfermeiroChefe extends Enfermeiro{
    //variaveis de instancia
    //construtor
    public EnfermeiroChefe(String nome, int anoscarreira)
    {
        super(nome, anoscarreira);
    }
    //metodos
    //getters e setters
    //toString
    @Override
    public String toString()
    {
        String info;
        info = "ENFERMEIRO: " + getClass().getSimpleName() + "\n";
        info += "NOME: " + getNome() + "\n";
        info += "ID: " + getId() + "\n";
        info += "ANOS DE EXPERIENCIA: " + getAnosCarreira() + "\n";
        // medico a qual está alocado (??)
        return info;
    }
    //equals
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        EnfermeiroChefe ec = (EnfermeiroChefe) obj;
        return getId().equals(ec.getId());
    }
}

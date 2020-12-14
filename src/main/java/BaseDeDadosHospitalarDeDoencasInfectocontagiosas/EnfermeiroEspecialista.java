/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;

/**
 *
 * @author jcupi
 */
public class EnfermeiroEspecialista extends Enfermeiro{
    //variaveis de instancia
    //construtor
    public EnfermeiroEspecialista(String nome, int anoscarreira)
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
        info = "ENFERMEIRO: " + super.getClass().getSimpleName() + "\n";
        info += "ID: " + super.getId() + "\n";
        info += "ANOS DE EXPERIENCIA: " + super.getAnosCarreira() + "\n";
        // medico a qual está alocado
        return info;
    }
    //equals
}

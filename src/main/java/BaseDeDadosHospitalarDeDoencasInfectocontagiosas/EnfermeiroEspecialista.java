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
    public void promoverChefe(Object obj){
        Hospital hospital = (Hospital) obj;
        if(this.getAnosCarreira() == hospital.getAnosCarreiraMinimo()){
            //EnfermeiroChefe enfermeirochefe = (EnfermeiroChefe) this;
        }
    }
    //getters e setters
    //toString
    //equals
}

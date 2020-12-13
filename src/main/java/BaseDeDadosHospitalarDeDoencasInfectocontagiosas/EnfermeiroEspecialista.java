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
    public void promoverChefe(){
        if(this.getAnosCarreira() == 25){ //substituir 25 por minimo do hospital
            //promoverachefe
        }
    }
    //getters e setters
    //toString
    //equals
}

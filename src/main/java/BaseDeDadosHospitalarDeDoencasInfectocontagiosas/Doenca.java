/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
import java.util.Random;
/**
 *
 * @author jcupi
 */
public class Doenca {
    //variaveis de instancia
    Random gerador = new Random();
    private boolean covid, hiv, ebola;
    //construtor
    public Doenca(){
        combinacaoDoenca(gerador.nextInt(7) + 1);
    }
    //metodos
    public void combinacaoDoenca(int combinacao){
        switch(combinacao){
            case 1:
                covid = true; hiv = false; ebola = false;
                break;
            case 2:
                covid = false; hiv = true; ebola = false;
                break;
            case 3:
                covid = false; hiv = false; ebola = true;
                break;
            case 4:
                covid = true; hiv = true; ebola = false;
                break;
            case 5:
                covid = false; hiv = true; ebola = true;
                break;
            case 6:
                covid = true; hiv = false; ebola = true;
                break;
            case 7:
                covid = true; hiv = true; ebola = true;
                break;
            default:
                covid = false; hiv = false; ebola = false;
                break;
        }       
    }
    //getters e setters
    public boolean getCovid(){
        return covid;
    }
    public boolean getEbola(){
        return ebola;
    }
    public boolean getHiv(){
        return hiv;
    }
    public void setCovid(boolean covid){
        this.covid = covid;
    }
    public void setEbola(boolean ebola){
        this.ebola = ebola;
    }
    public void setHiv(boolean hiv){
        this.hiv = hiv;
    }
    //toString
    //equals
}

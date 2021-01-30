/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrincipaisClasses;
import java.util.Random;
/**
 *
 * @author jcupi
 */
public class Doenca {
    //variaveis de instancia
    /**
     * numerovezes: o número de vezes consecutivos que o paciente já obteve o curativo
     */
    private int numerovezes;
    private boolean covid, hiv, ebola;
    //construtor
    /**
     * Construtor de Doenca
     */
    public Doenca(){
        numerovezes = 0;
        Random gerador = new Random();
        combinacaoDoenca(gerador.nextInt(7) + 1);
    }
    //metodos
    /**
     * combinacaoDoenca: vai ser adicionado patologia(s) na Doenca
     * @param combinacao 
     */
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
    /**
     * getCovid: retorna o booleano covid
     * @return 
     */
    public boolean getCovid(){
        return covid;
    }
    /**
     * getCovid: retorna o booleano ebola
     * @return 
     */
    public boolean getEbola(){
        return ebola;
    }
    /**
     * getCovid: retorna o booleano hiv
     * @return 
     */
    public boolean getHiv(){
        return hiv;
    }
    /**
     * Setter da variável de instância covid
     * @param covid 
     */
    public void setCovid(boolean covid){
        this.covid = covid;
    }
    /**
     * Setter da variável de instância ebola
     * @param ebola 
     */
    public void setEbola(boolean ebola){
        this.ebola = ebola;
    }
    /**
     * Setter da variável de instância hiv
     * @param hiv 
     */
    public void setHiv(boolean hiv){
        this.hiv = hiv;
    }
    /**
     * Getter da variável de instância numerovezes
     * @return 
     */
    public int getNumerovezes() {
        return numerovezes;
    }
    /**
     * Setter da variável de instância numerovezes
     * @param numerovezes 
     */
    public void setNumerovezes(int numerovezes) {
        this.numerovezes = numerovezes;
    }
    //toString
    //equals
}

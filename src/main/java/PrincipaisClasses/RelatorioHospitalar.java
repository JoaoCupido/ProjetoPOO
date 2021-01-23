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
public class RelatorioHospitalar {
    //variaveis de instancia
    private String idpaciente;
    private int anonascimentopaciente;
    
    private static int numobitos;
    private static int numrecuperados;
    
    private static int casospositivoscovid, totalpacientestestados;
    private static double raciopacientespositivoscovid;
    
    private static int casospositivosebola;
    private static double raciopacientespositivosebola;
    
    private static int casospositivoshiv;
    private static double raciopacientespositivoshiv;
    
    //construtor
    public RelatorioHospitalar(){
        idpaciente = "----";
        anonascimentopaciente = 0;
        numobitos = 0;
        numrecuperados = 0;
        casospositivoscovid = 0;
        totalpacientestestados = 0;
        raciopacientespositivoscovid = 0.0;
        casospositivosebola = 0;
        raciopacientespositivosebola = 0.0;
        casospositivoshiv = 0;
        raciopacientespositivoshiv = 0.0;
    }
    public RelatorioHospitalar(Paciente paciente){
        idpaciente = paciente.getId();
        anonascimentopaciente = paciente.getAnoNascimento();
        
        criarRelatorioPaciente(paciente);
        //relatorioTestarPaciente(paciente);
        raciopacientespositivoscovid = (double)casospositivoscovid/totalpacientestestados;
        raciopacientespositivosebola = (double)casospositivosebola/totalpacientestestados;
        raciopacientespositivoshiv = (double)casospositivoshiv/totalpacientestestados;
    }
    //metodos
    public void criarRelatorioPaciente(Paciente paciente){
        if(!(paciente.getDoenca().getCovid() || paciente.getDoenca().getEbola() || paciente.getDoenca().getHiv())){
            numrecuperados += 1;
        }
        else{
            numobitos += 1;
        }
    }
    
    public void relatorioTestarPaciente(Paciente paciente){
        if(paciente.getDoenca().getCovid()){
            casospositivoscovid += 1;
        }
        if(paciente.getDoenca().getEbola()){
            casospositivosebola += 1;
        }
        if(paciente.getDoenca().getHiv()){
            casospositivoshiv += 1;
        }
        totalpacientestestados += 1;
        raciopacientespositivoscovid = (double)casospositivoscovid/totalpacientestestados;
        raciopacientespositivosebola = (double)casospositivosebola/totalpacientestestados;
        raciopacientespositivoshiv = (double)casospositivoshiv/totalpacientestestados;
    }
    
    public String pacienteNaoExistente(RelatorioHospitalar relatorio){
        String texto;
        texto = "ÚLTIMO PACIENTE A TER ALTA OU A CONTAR COMO ÓBITO: \n";
        if(relatorio.getAnonascimentopaciente() == 0){
            texto += "Ainda não houve nenhum paciente que teve alta ou que foi declarado como óbito de momento.\n";
        }
        else{
            texto += "ID: " + relatorio.getIdpaciente() + " ANO NASCIMENTO: " + relatorio.getAnonascimentopaciente() + "\n";
        }
        return texto;
    }
    //getters e setters

    public String getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(String idpaciente) {
        this.idpaciente = idpaciente;
    }

    public int getAnonascimentopaciente() {
        return anonascimentopaciente;
    }

    public void setAnonascimentopaciente(int anonascimentopaciente) {
        this.anonascimentopaciente = anonascimentopaciente;
    }
    
    //toString
    @Override
    public String toString() {
        String texto;
        texto = "-- RELATÓRIO HOSPITALAR: --\n";
        texto += pacienteNaoExistente(this);
        texto += "NÚMERO DE ÓBITOS: " + numobitos + "\n";
        texto += "NÚMERO DE RECUPERADOS: " + numrecuperados + "\n";
        texto += "\n";
        texto += "NÚMERO DE PACIENTES TESTADOS: " + totalpacientestestados + "\n";
        texto += "\n";
        texto += "* COVID *" + "\n";
        texto += "CASOS POSITIVOS: " + casospositivoscovid + "\n";
        texto += "RÁCIO COVID: " + raciopacientespositivoscovid + "\n";
        texto += "\n";
        texto += "* EBOLA *" + "\n";
        texto += "CASOS POSITIVOS: " + casospositivosebola + "\n";
        texto += "RÁCIO EBOLA: " + raciopacientespositivosebola + "\n";
        texto += "\n";
        texto += "* HIV *" + "\n";
        texto += "CASOS POSITIVOS: " + casospositivoshiv + "\n";
        texto += "RÁCIO HIV: " + raciopacientespositivoshiv + "\n";
        return texto;
    }
    //equals
}

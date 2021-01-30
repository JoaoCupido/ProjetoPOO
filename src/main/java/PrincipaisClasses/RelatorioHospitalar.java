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
    /**
     * Construtor de RelatorioHospitalar com parâmetro vazio
     */
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
    /**
     * Construtor de RelatorioHospitalar com parâmetro paciente (Overloading)
     * @param paciente 
     */
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
    /**
     * criarRelatorioPaciente: Se paciente não tiver nenhuma patologia, numrecuperados aumenta +1.
     * Caso contrário, numobitos aumenta +1.
     * @param paciente 
     */
    public void criarRelatorioPaciente(Paciente paciente){
        if(!(paciente.getDoenca().getCovid() || paciente.getDoenca().getEbola() || paciente.getDoenca().getHiv())){
            numrecuperados += 1;
        }
        else{
            numobitos += 1;
        }
    }
    /**
     * relatorioTestarPaciente: Se tiver uma certa patologia, é adicionado +1 à varíavel
     * de instância da patologia pretendida. Também é adicionado +1 no número total de
     * pacientes testados e é atualizado as variáveis de instância raciopacientespositivoscovid,
     * raciopacientespositivosebola e raciopacientespositivoshiv.
     * @param paciente 
     */
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
    
    /**
     * pacienteNaoExistente: Se anosnascimento do paciente for igual a 0 (isto é a mesma coisa que 
     * dizer se não houver nenhum paciente no relatoriohospitalar), retorna um texto
     * a avisar que não houve nenhum paciente que teve alta ou que foi declarado como óbito de momento.
     * Caso contrário, retorna um texto com o ID e o anonascimento do paciente.
     * @param relatorio
     * @return 
     */
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
    /**
     * Getter da variável de instância idpaciente
     * @return 
     */
    public String getIdpaciente() {
        return idpaciente;
    }
    /**
     * Setter da variável de instância idpaciente
     * @param idpaciente 
     */
    public void setIdpaciente(String idpaciente) {
        this.idpaciente = idpaciente;
    }
    /**
     * Getter da variável de instância anonascimentopaciente
     * @return 
     */
    public int getAnonascimentopaciente() {
        return anonascimentopaciente;
    }
    /**
     * Setter da variável de instância anonascimentopaciente
     * @param anonascimentopaciente 
     */
    public void setAnonascimentopaciente(int anonascimentopaciente) {
        this.anonascimentopaciente = anonascimentopaciente;
    }
    
    //toString
    /**
     * toString: texto do relatório hospitalar
     * @return 
     */
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

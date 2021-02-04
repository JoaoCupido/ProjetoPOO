/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;
import PrincipaisClasses.*;

import java.util.Map;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author jcupi
 */
public class MenuEnfermeiro {
    //variaveis de instancia
    //construtor
    //metodos
    /**
     * Método em que contêm várias opções de enfermeiro
     * @param hospital 
     */
     public void menuOpcoesEnfermeiro(Hospital hospital){
        int opcao;
        System.out.println("***SubMenu Enfermeiro***");
        System.out.println("1) Listar Enfermeiros de Médico");
        System.out.println("2) Listar Pacientes a aguardar Curativo");
        System.out.println("3) Atribuir Enfermeiro Especialista a Médico");
        System.out.println("4) Aplicar Curativo a Paciente");
        Scanner escolha = new Scanner(System.in);
        System.out.println("Digite uma opção. Digite nenhuma das opções apresentadas para sair do SubMenu Enfermeiro: ");
        opcao = escolha.nextInt();

        switch(opcao)
            {
                case 1:
                    System.out.println("\nEscolhido a opção Listar Enfermeiros de Médico...\n");
                    listarEnfermeiros(hospital);
                    break;
                case 2:
                    System.out.println("\nEscolhido a opção Listar Pacientes a aguardar Curativo...\n");
                    listarPacientesCurativo(hospital);
                    break;
                case 3:
                    System.out.println("\nEscolhido a opção Atribuir Enfermeiro Especialista a Médico...\n");
                    atribuirEnfermeiroEspecialista(hospital);
                    break;
                case 4:
                    System.out.println("\nEscolhido a opção Aplicar Curativo a Paciente...\n");
                    aplicarCurativo(hospital);
                    break;
                default:
                    System.out.println("\nNão foi escolhido nenhuma das opções que foram apresentadas! Voltando para Menu...\n");
                    break;
        }
    }
    /**
     * listarEnfermeiros: listar enfermeiros acompanhados por um certo médico na consola.
     * @param hospital 
     */
    public void listarEnfermeiros(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do médico a selecionar: ");
        String medicoid = scanner.nextLine();
        if(!hospital.getListaPessoas().containsKey(medicoid)){
            System.out.println("O ID a procurar não existe na ListaPessoas.");
        }
        else{
            for(Map.Entry<String,Pessoa> elementonalista : hospital.getListaPessoas().entrySet()){
                if(elementonalista.getKey().equals(medicoid) && elementonalista.getValue().getClass().getSimpleName().equals("Medico")){
                    System.out.println("LISTA DE ENFERMEIROS ACOMPANHADOS DO MÉDICO " + elementonalista.getValue().getId() + " :");
                        for(EnfermeiroAuxiliar ea : ((Medico)elementonalista.getValue()).getAuxiliaresAcompanhados().values()){
                            System.out.println(ea);
                        }
                        for(EnfermeiroEspecialista ee : ((Medico)elementonalista.getValue()).getEspecialistasAcompanhados().values()){
                            System.out.println(ee);
                        }
                    break;
                    }
                else if(elementonalista.getKey().equals(medicoid) && !(elementonalista.getValue().getClass().getSimpleName().equals("Medico"))){
                    System.out.println("O ID foi encontrado, mas não pertence a um médico.");
                    break;
                }
            }
        }
    }
    /**
     * listarPacientesCurativo: listar pacientes que aguardam o curativo para um dado enfermeiro acompanhado
     * @param hospital 
     */
    public void listarPacientesCurativo(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do enfermeiro auxiliar ou especialista a selecionar: ");
        String enfermeiroid = scanner.nextLine();
        if(!hospital.getListaPessoas().containsKey(enfermeiroid)){
            System.out.println("O ID a procurar não existe na ListaPessoas.");
        }
        else {
            for(Map.Entry<String,Pessoa> elementonalista : hospital.getListaPessoas().entrySet()){
                if(elementonalista.getKey().equals(enfermeiroid) && elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
                    System.out.println("LISTA DE PACIENTES A AGUARDAR CURATIVO DO ENFERMEIRO AUXILIAR " + elementonalista.getValue().getId() + " DE NOME " + ((EnfermeiroAuxiliar) elementonalista.getValue()).getNome() + " :");
                    EnfermeiroAuxiliar auxiliar = (EnfermeiroAuxiliar) elementonalista.getValue();
                    for (Paciente paciente : auxiliar.getAgenda()) {
                        System.out.println(paciente);
                    }
                    break;
                }
                else if(elementonalista.getKey().equals(enfermeiroid) && elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroEspecialista")){
                    System.out.println("LISTA DE PACIENTES A AGUARDAR CURATIVO DO ENFERMEIRO ESPECIALISTA " + elementonalista.getValue().getId() + " DE NOME " + ((EnfermeiroEspecialista) elementonalista.getValue()).getNome() + " :");
                    EnfermeiroEspecialista especialista = (EnfermeiroEspecialista) elementonalista.getValue();
                    for (Paciente paciente : especialista.getAgenda()) {
                        System.out.println(paciente);
                    }
                    break;
                }
                else if(elementonalista.getKey().equals(enfermeiroid) && !(elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroEspecialista")) && !(elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroAuxiliar"))){
                    System.out.println("O ID foi encontrado, mas não pertence nem a um enfermeiro auxiliar nem a um enfermeiro especialista.");
                    break;
                }
            }
        }
    }
    /**
     * atribuirEnfermeiroEspecialista: O enfermeiro-chefe atribui o enfermeiro-especialista que não tem médico acompanhado
     * ao médico pedido, caso isto exista.
     * @param hospital 
     */
    public void atribuirEnfermeiroEspecialista(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do enfermeiro chefe a selecionar: ");
        String chefeid = scanner.nextLine();
        if(!hospital.getListaPessoas().containsKey(chefeid)){
            System.out.println("O ID do chefe a procurar não existe na ListaPessoas.");
        }
        else {
            for(Map.Entry<String,Pessoa> elementonalista : hospital.getListaPessoas().entrySet()){
                if(elementonalista.getKey().equals(chefeid) && !(elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroChefe"))){
                    System.out.println("O ID foi encontrado, mas não pertence a um enfermeiro chefe.");
                }
                else if(elementonalista.getKey().equals(chefeid) && elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroChefe")){
                    System.out.println("Insira o ID do enfermeiro-especialista a ser atribuído: ");
                    String enfermeiroid = scanner.nextLine();
                    System.out.println("Insira o ID do médico a receber o enfermeiro-especialista: ");
                    String medicoid = scanner.nextLine();
                    if(!hospital.getListaPessoas().containsKey(enfermeiroid)){
                        System.out.println("O ID do enfermeiro-especialista a ser atribuído não existe na ListaPessoas.");
                    }
                    else if(!hospital.getListaPessoas().containsKey(medicoid)){
                        System.out.println("O ID do médico a receber o enfermeiro-especialista não existe na ListaPessoas.");
                    }
                    else{
                        for(Map.Entry<String,Pessoa> especialistanalista : hospital.getListaPessoas().entrySet()){
                            if(especialistanalista.getKey().equals(enfermeiroid) && !(especialistanalista.getValue().getClass().getSimpleName().equals("EnfermeiroEspecialista"))){
                                System.out.println("O ID foi encontrado, mas não pertence a um enfermeiro-especialista.");
                            }
                            else if(especialistanalista.getKey().equals(enfermeiroid) && especialistanalista.getValue().getClass().getSimpleName().equals("EnfermeiroEspecialista")){
                                for(Map.Entry<String,Pessoa> mediconalista : hospital.getListaPessoas().entrySet()){
                                    if(mediconalista.getKey().equals(medicoid) && !(mediconalista.getValue().getClass().getSimpleName().equals("Medico"))){
                                        System.out.println("O ID foi encontrado, mas não pertence a um médico.");
                                        break;
                                    }
                                    else if(mediconalista.getKey().equals(medicoid) && mediconalista.getValue().getClass().getSimpleName().equals("Medico")){
                                        if(((EnfermeiroEspecialista)especialistanalista.getValue()).getMedicoAcompanhado()==null){
                                            ((EnfermeiroEspecialista)especialistanalista.getValue()).setMedicoAcompanhado((Medico)mediconalista.getValue());
                                            ((Medico)mediconalista.getValue()).atualizarEnfermeirosAcompanhados(hospital);
                                        }
                                        else{
                                            System.out.println("O ID foi encontrado e pertence a um enfermeiro-especialista, mas este já tem médico acompanhado.");
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * aplicarCurativo: o enfermeiro acompanhado pedido aplica o curativo ao paciente, se este não for a 5ª vez consecutiva e caso estes existam.
     * Se for a 5ª vez consecutiva ou mais, é declarado o óbito do paciente e é adicionado ao relatório hospitalar.
     * @param hospital 
     */
    public void aplicarCurativo(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do enfermeiro auxiliar ou especialista a selecionar: ");
        String enfid = scanner.nextLine();
        if(!hospital.getListaPessoas().containsKey(enfid)){
            System.out.println("O ID do enfermeiro auxiliar ou especialista a procurar não existe na ListaPessoas.");
        }
        else {
            for(Map.Entry<String,Pessoa> elementonalista : hospital.getListaPessoas().entrySet()){
                if(elementonalista.getKey().equals(enfid) && !(elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroEspecialista")) && !(elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroAuxiliar"))){
                    System.out.println("O ID foi encontrado, mas não pertence nem a um enfermeiro auxiliar nem a um enfermeiro especialista.");
                    break;
                }
                else if(elementonalista.getKey().equals(enfid) && elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
                    EnfermeiroAuxiliar ea = (EnfermeiroAuxiliar) elementonalista.getValue();
                    System.out.println("Insira o ID do paciente a ser aplicado o curativo: ");
                    String pacid = scanner.nextLine();
                    if(ea.getMedicoAcompanhado()==null){
                        System.out.println("O enfermeiro-auxiliar não tem um médico acompanhado.");
                        break;
                    }
                    else if(ea.isEmptyPacienteAgenda()){
                        System.out.println("A agenda do enfermeiro-auxiliar está vazia.");
                        break;
                    }
                    else if(ea.getMedicoAcompanhado().isFullPacienteAlta()){
                        System.out.println("O médico acompanhado já tem o máximo de 3 pacientes.");
                        break;
                    }
                    else if(!hospital.getListaPessoas().containsKey(pacid)){
                        System.out.println("O ID do paciente a ser aplicado o curativo não existe na ListaPessoas nem na Agenda.");
                        break;
                    }
                    else{
                        for (Paciente paciente : ea.getAgenda()) {
                            if(paciente.getId().equals(pacid)){
                                if(paciente.getDoenca().getNumerovezes()>=5){
                                    //adicionar no relatorio hospitalar
                                    hospital.setRelatorio(new RelatorioHospitalar(paciente));
                                    for(EnfermeiroAuxiliar auxiliarnalista : ea.getMedicoAcompanhado().getAuxiliaresAcompanhados().values()){
                                        auxiliarnalista.removePacienteAgenda(paciente);
                                    }
                                    for(EnfermeiroEspecialista especialistanalista : ea.getMedicoAcompanhado().getEspecialistasAcompanhados().values()){
                                        especialistanalista.removePacienteAgenda(paciente);
                                    }
                                    hospital.removerPessoa(paciente);
                                    break;
                                }
                                else{
                                    Random gerador = new Random();
                                    if(paciente.getDoenca().getCovid()){
                                        if(gerador.nextBoolean()){
                                            paciente.getDoenca().setCovid(false);
                                        }
                                    }
                                    if(paciente.getDoenca().getEbola()){
                                        if(gerador.nextBoolean()){
                                            paciente.getDoenca().setEbola(false);
                                        }
                                    }
                                    if(paciente.getDoenca().getHiv()){
                                        if(gerador.nextBoolean()){
                                            paciente.getDoenca().setHiv(false);
                                        }
                                    }
                                    for(EnfermeiroAuxiliar auxiliarnalista : ea.getMedicoAcompanhado().getAuxiliaresAcompanhados().values()){
                                        auxiliarnalista.removePacienteAgenda(paciente);
                                    }
                                    for(EnfermeiroEspecialista especialistanalista : ea.getMedicoAcompanhado().getEspecialistasAcompanhados().values()){
                                        especialistanalista.removePacienteAgenda(paciente);
                                    }
                                    paciente.getDoenca().setNumerovezes(paciente.getDoenca().getNumerovezes()+1);
                                    ea.getMedicoAcompanhado().addPacienteAlta(paciente);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
                else if(elementonalista.getKey().equals(enfid) && elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroEspecialista")){
                    EnfermeiroEspecialista ee = (EnfermeiroEspecialista) elementonalista.getValue();
                    System.out.println("Insira o ID do paciente a ser aplicado o curativo: ");
                    String pacid = scanner.nextLine();
                    if(ee.getMedicoAcompanhado()==null){
                        System.out.println("O enfermeiro-especialista não tem um médico acompanhado.");
                        break;
                    }
                    else if(ee.isEmptyPacienteAgenda()){
                        System.out.println("A agenda do enfermeiro-especialista está vazia.");
                        break;
                    }
                    else if(ee.getMedicoAcompanhado().isFullPacienteAlta()){
                        System.out.println("O médico acompanhado já tem o máximo de 3 pacientes.");
                        break;
                    }
                    else if(!hospital.getListaPessoas().containsKey(pacid)){
                        System.out.println("O ID do paciente a ser aplicado o curativo não existe na ListaPessoas nem na Agenda.");
                        break;
                    }
                    else{
                        for (Paciente paciente : ee.getAgenda()) {
                            if(paciente.getId().equals(pacid)){
                                if(paciente.getDoenca().getNumerovezes()>=5){
                                    //adicionar no relatorio hospitalar
                                    hospital.setRelatorio(new RelatorioHospitalar(paciente));
                                    for(EnfermeiroAuxiliar auxiliarnalista : ee.getMedicoAcompanhado().getAuxiliaresAcompanhados().values()){
                                        auxiliarnalista.removePacienteAgenda(paciente);
                                    }
                                    for(EnfermeiroEspecialista especialistanalista : ee.getMedicoAcompanhado().getEspecialistasAcompanhados().values()){
                                        especialistanalista.removePacienteAgenda(paciente);
                                    }
                                    hospital.removerPessoa(paciente);
                                    break;
                                }
                                else{
                                    Random gerador = new Random();
                                    if(paciente.getDoenca().getCovid()){
                                        if(gerador.nextBoolean()){
                                            paciente.getDoenca().setCovid(false);
                                        }
                                    }
                                    if(paciente.getDoenca().getEbola()){
                                        if(gerador.nextBoolean()){
                                            paciente.getDoenca().setEbola(false);
                                        }
                                    }
                                    if(paciente.getDoenca().getHiv()){
                                        if(gerador.nextBoolean()){
                                            paciente.getDoenca().setHiv(false);
                                        }
                                    }
                                    for(EnfermeiroAuxiliar auxiliarnalista : ee.getMedicoAcompanhado().getAuxiliaresAcompanhados().values()){
                                        auxiliarnalista.removePacienteAgenda(paciente);
                                    }
                                    for(EnfermeiroEspecialista especialistanalista : ee.getMedicoAcompanhado().getEspecialistasAcompanhados().values()){
                                        especialistanalista.removePacienteAgenda(paciente);
                                    }
                                    paciente.getDoenca().setNumerovezes(paciente.getDoenca().getNumerovezes()+1);
                                    ee.getMedicoAcompanhado().addPacienteAlta(paciente);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
    //getters e setters
    //toString
    //equals
}

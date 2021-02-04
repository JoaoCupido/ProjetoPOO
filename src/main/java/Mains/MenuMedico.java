/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;
import PrincipaisClasses.*;
import CustomException.*;
import java.util.InputMismatchException;

import java.util.Scanner;
import java.util.Map;
/**
 *
 * @author Utilizador
 */
public class MenuMedico {
    //variaveis de instancia
    //construtor
    //metodos
    /**
     * Método em que contêm várias opções de médico.
     * @param hospital 
     */
    public void menuOpcoesMedico(Hospital hospital){
        int opcao;
        System.out.println("***SubMenu Médico***");
        System.out.println("1) Listar Pacientes em espera no Hospital");
        System.out.println("2) Listar Pacientes a aguardar Alta");
        System.out.println("3) Diagnóstico ao Paciente");
        System.out.println("4) Dar Alta Hospitalar");
        System.out.println("5) Requerimento de Auxiliares");
        Scanner escolha = new Scanner(System.in);
        System.out.println("Digite uma opção. Digite nenhuma das opções apresentadas para sair do SubMenu Médico: ");
        opcao = escolha.nextInt();

        switch(opcao)
            {
                case 1:
                    System.out.println("\nEscolhido a opção Listar Pacientes em espera no Hospital...\n");
                    listarPacientesEspera(hospital);
                    break;
                case 2:
                    System.out.println("\nEscolhido a opção Listar Pacientes a aguardar Alta...\n");
                    listarPacientesAlta(hospital);
                    break;
                case 3:
                    System.out.println("\nEscolhido a opção Diagnóstico ao Paciente...\n");
                    diagnosticoPacientePrimeiraVez(hospital);
                    break;
                case 4:
                    System.out.println("\nEscolhido a opção Dar Alta Hospitalar...\n");
                    altaHospitalar(hospital);
                    break;
                case 5:
                    System.out.println("\nEscolhido a opção Requerimento de Auxiliares...\n");
                    try{
                        requerimentoAuxiliares(hospital);
                    }
                    catch(InvalidNumberOfAuxiliaresException exc){
                        System.out.println(exc.getMessage());
                    }
                    break;
                default:
                    System.out.println("\nNão foi escolhido nenhuma das opções que foram apresentadas! Voltando para Menu...\n");
                    break;
        }
    }
    /**
     * pacientesEsperanoHospital: listar todos os pacientes em espera do hospital na consola
     * @param hospital 
     */
    public void listarPacientesEspera(Hospital hospital)
    {
        if(hospital.getListaPacientes().isEmpty()){
            System.out.println("ListaPacientes está vazio.");
        }
        else{
            for(Paciente pacienteespera : hospital.getListaPacientes().values()){
                System.out.println(pacienteespera);
            }
        }
    }
    
    /*
    Lista de Pacientes que aguardam alta por parte do médico, apos o enfermeiro aplicar o curativo!
    */
    public void listarPacientesAlta(Hospital hospital)
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
                    System.out.println("LISTA DE PACIENTES A AGUARDAR ALTA DO MÉDICO " + elementonalista.getValue().getId() + " :");
                    if(((Medico) elementonalista.getValue()).isEmptyPacienteAlta()){
                        System.out.println("ListaPacientesAlta está vazio.");
                    }
                    else{
                        for(Paciente listaPacientesAlta : ((Medico) elementonalista.getValue()).getlistaPacientesAlta()) {
                            System.out.println(listaPacientesAlta);
                        }
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
     * Paciente que deu entrada no hospital pela primeira vez.
     * Será feito um diagnóstico caso dê positivo de patologia vai para diagnosticoPaciente
     * @param hospital
     */
    public void diagnosticoPacientePrimeiraVez(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do médico a selecionar: ");
        String medicoid = scanner.nextLine();
        System.out.println("Insira o ID do paciente a ser diagnosticado: ");
        String pacienteid = scanner.nextLine();
        if(!hospital.getListaPessoas().containsKey(medicoid)){
            System.out.println("O ID do médico a procurar não existe na ListaPessoas.");
        }
        else if(!hospital.getListaPacientes().containsKey(pacienteid)){
            System.out.println("O ID do paciente a ser diagnosticado não existe na ListaPacientes.");
        }
        else{
            for(Map.Entry<String,Pessoa> mediconalista : hospital.getListaPessoas().entrySet()){
                if(mediconalista.getKey().equals(medicoid) && !(mediconalista.getValue().getClass().getSimpleName().equals("Medico"))){
                    System.out.println("O ID foi encontrado, mas não pertence a um médico.");
                }
                else if(mediconalista.getKey().equals(medicoid) && mediconalista.getValue().getClass().getSimpleName().equals("Medico")){
                    if(!((Medico)mediconalista.getValue()).getAuxiliaresAcompanhados().isEmpty() && !((Medico)mediconalista.getValue()).getEspecialistasAcompanhados().isEmpty()){
                        System.out.println("O médico não tem nenhum enfermeiro-auxiliar nem enfermeiro-especialista a acompanhar no diagnóstico.");
                        break;
                    }
                    else if(((Medico)mediconalista.getValue()).getAuxiliaresAcompanhados().isEmpty() && !((Medico)mediconalista.getValue()).getEspecialistasAcompanhados().isEmpty()){
                        System.out.println("O médico não tem nenhum enfermeiro-auxiliar a acompanhar no diagnóstico.");
                        break;
                    }
                    else if(!((Medico)mediconalista.getValue()).getAuxiliaresAcompanhados().isEmpty() && ((Medico)mediconalista.getValue()).getEspecialistasAcompanhados().isEmpty()){
                        System.out.println("O médico não tem nenhum enfermeiro-especialista a acompanhar no diagnóstico.");
                        break;
                    }
                    //caso a listapacientesalta do medico estiver cheio (pois pode acontecer que listapacientesalta está cheia e agenda dos enfermeiros tenha 1 espaço livre
                    //aí se o paciente do diagnostico entrar na agenda dos enfermeiros, ambas as listas ficam cheias e pode ocorrer que nunca se vai sair dali (ficam presos)
                    else if(((Medico)mediconalista.getValue()).isFullPacienteAlta()){ 
                        System.out.println("A lista de pacientes à espera de alta do médico está cheia.");
                        break;
                    }
                    else if(!((Medico)mediconalista.getValue()).getAuxiliaresAcompanhados().isEmpty() && !((Medico)mediconalista.getValue()).getEspecialistasAcompanhados().isEmpty() && !((Medico)mediconalista.getValue()).isFullPacienteAlta()){
                        diagnosticoPaciente(hospital, (Medico)mediconalista.getValue(),(Paciente) (hospital.getListaPacientes().get(pacienteid)));
                        break;
                    }
                }
            }
        }
    }
    /**
     * altaHospitalar: O médico tenta dar alta ao paciente a aguardar alta do médico. Se ainda tiver patologias,
     * o paciente é outra vez feito o diagnóstico. Caso não tenha patologias, vai entrar no diagnóstico ao paciente
     * e este é dado como alta e é inserido no relatório hospitalar.
     * @param hospital 
     */
    public void altaHospitalar(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do médico a selecionar: ");
        String medicoid = scanner.nextLine();
        System.out.println("Insira o ID do paciente a ser diagnosticado: ");
        String pacienteid = scanner.nextLine();
        if(!hospital.getListaPessoas().containsKey(medicoid)){
            System.out.println("O ID do médico a procurar não existe na ListaPessoas.");
        }
        else if(!hospital.getListaPessoas().containsKey(pacienteid)){
            System.out.println("O ID do paciente a ser avaliado não existe na ListaPessoas.");
        }
        else{
            for(Map.Entry<String,Pessoa> mediconalista : hospital.getListaPessoas().entrySet()){
                if(mediconalista.getKey().equals(medicoid) && !(mediconalista.getValue().getClass().getSimpleName().equals("Medico"))){
                    System.out.println("O ID foi encontrado, mas não pertence a um médico.");
                }
                else if(mediconalista.getKey().equals(medicoid) && mediconalista.getValue().getClass().getSimpleName().equals("Medico")){
                    if(((Medico)mediconalista.getValue()).isEmptyPacienteAlta()){
                        System.out.println("O médico selecionado tem a lista de pacientes a aguardar alta como vazia.");
                    }
                    else{
                        for(int i = 0; i < ((Medico)mediconalista.getValue()).getlistaPacientesAlta().length; i++){
                            if(((Medico)mediconalista.getValue()).getlistaPacientesAlta()[i]!=null){
                                for(Map.Entry<String,Pessoa> pacientenalista : hospital.getListaPessoas().entrySet()){
                                    if(((Medico)mediconalista.getValue()).getlistaPacientesAlta()[i].equals((Paciente)pacientenalista.getValue()) && pacientenalista.getKey().equals(pacienteid)){
                                        diagnosticoPaciente(hospital,(Medico)mediconalista.getValue(),(Paciente)pacientenalista.getValue());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * requerimentoAuxiliares: O médico pede ao enfermeiro-chefe para haver n enfermeiros-auxiliares acompanhados.
     * Caso n seja menor ou igual que o número total de enfermeiros-auxiliares, o enfermeiro-chefe junta os
     * auxiliares disponíveis na lista de pessoas do hospital (isto é, os auxiliares que não têm médico
     * acompanhado) e estes vão ser acompanhados pelo médico pedido.
     * Caso contrário, vai ocorrer uma exceção e é criado vários pedidos de auxiliares de acordo com a diferença
     * entre o número de auxiliares disponíveis na lista de pessoas do hospital com o número de auxiliares pedidos
     * do médico.
     * @param hospital
     * @throws InvalidNumberOfAuxiliaresException 
     */
    public void requerimentoAuxiliares(Hospital hospital) throws InvalidNumberOfAuxiliaresException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do médico a selecionar: ");
        String medicoid = scanner.nextLine();
        System.out.println("Insira o ID do enfermeiro-chefe a ser comunicado: ");
        String chefeid = scanner.nextLine();
        if(!hospital.getListaPessoas().containsKey(medicoid)){
            System.out.println("O ID do médico a procurar não existe na ListaPessoas.");
        }
        else if(!hospital.getListaPessoas().containsKey(chefeid)){
            System.out.println("O ID do chefe a ser comunicado não existe na ListaPessoas.");
        }
        else{
            for(Map.Entry<String,Pessoa> mediconalista : hospital.getListaPessoas().entrySet()){
                if(mediconalista.getKey().equals(medicoid) && !(mediconalista.getValue().getClass().getSimpleName().equals("Medico"))){
                    System.out.println("O ID do suposto médico foi encontrado, mas não pertence a um médico.");
                }
                else if(mediconalista.getKey().equals(medicoid) && mediconalista.getValue().getClass().getSimpleName().equals("Medico")){
                    for(Map.Entry<String,Pessoa> chefenalista : hospital.getListaPessoas().entrySet()){
                        if(chefenalista.getKey().equals(chefeid) && !(chefenalista.getValue().getClass().getSimpleName().equals("EnfermeiroChefe"))){
                            System.out.println("O ID do suposto enfermeiro-chefe foi encontrado, mas não pertence a um enfermeiro-chefe.");
                        }
                        else if(chefenalista.getKey().equals(chefeid) && chefenalista.getValue().getClass().getSimpleName().equals("EnfermeiroChefe")){
                            try{
                                System.out.println("Insira o número de auxiliares para acompanhar o médico: ");
                                int numeroauxiliares = scanner.nextInt();
                                int totalauxiliaresdis = contadorAuxiliaresDisponiveis(hospital);
                                if(numeroauxiliares>totalauxiliaresdis){
                                    int diferenca = numeroauxiliares-totalauxiliaresdis;
                                    while(diferenca>0){
                                        String nome;
                                        Scanner inserirnome = new Scanner(System.in);
                                        System.out.println("Insere o nome: ");
                                        nome = inserirnome.nextLine();
                                        Pessoa enfermeiroauxiliar = new EnfermeiroAuxiliar(nome, 0);
                                        hospital.addPedido(enfermeiroauxiliar);
                                        diferenca--;
                                    }
                                    //atender ao pedido de mais enfermeiros-auxiliares
                                    throw new InvalidNumberOfAuxiliaresException("O número de auxiliares pedido pelo médico é maior do que o número de auxiliares disponíveis na ListaPessoas.");
                                    //System.out.println("O número de auxiliares pedido pelo médico é maior do que o número de auxiliares disponíveis na ListaPessoas.");
                                }
                                else{
                                    for(Map.Entry<String,Pessoa> auxiliarnalista : hospital.getListaPessoas().entrySet()){
                                        if(auxiliarnalista.getValue().getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
                                            if(((EnfermeiroAuxiliar)auxiliarnalista.getValue()).getMedicoAcompanhado()==null && numeroauxiliares>0){
                                                ((EnfermeiroAuxiliar)auxiliarnalista.getValue()).setMedicoAcompanhado((Medico)mediconalista.getValue());
                                                ((EnfermeiroAuxiliar)auxiliarnalista.getValue()).getMedicoAcompanhado().atualizarEnfermeirosAcompanhados(hospital);
                                                numeroauxiliares = numeroauxiliares - 1;
                                            }
                                        }
                                    }
                                }
                            }
                            catch(InputMismatchException e){
                                System.out.println("Input inválido!");
                                scanner.nextLine();
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * diagnosticoPaciente: Se o paciente for diagnosticado pela primeira vez, o paciente sai da lista de espera
     * e entra na agenda dos enfermeiros acompanhados, caso isto seja possível (pode ocorrer casos em que a agenda esteja cheia
     * ou que a lista de pacientes à espera de ter alta do médico esteja cheia)
     * Se o paciente não for diagnosticado pela primeira vez, este pode ter alta (caso não tenha patologias) e consequentemente, é
     * adicionado no relatório hospitalar, ou é passado outra vez para a agenda dos enfermeiros acompanhados.
     * @param hospital
     * @param medico
     * @param paciente 
     */
    public void diagnosticoPaciente(Hospital hospital, Medico medico, Paciente paciente){
        for(Map.Entry<String,Pessoa> enfermeironalista : hospital.getListaPessoas().entrySet()){
            switch(enfermeironalista.getValue().getClass().getSimpleName()){
                case "EnfermeiroAuxiliar":
                    EnfermeiroAuxiliar ea = (EnfermeiroAuxiliar) enfermeironalista.getValue();
                    if(medico.equals(ea.getMedicoAcompanhado()) && ea.isFullPacienteAgenda()){
                        if(hospital.getListaPacientes().containsValue(paciente) || medico.containsPacienteInPacienteAlta(paciente)){
                            System.out.println("O(s) enfermeiro(s) que acompanha(m) o médico têm a agenda cheia.");
                        }
                    }
                    else if(medico.equals(ea.getMedicoAcompanhado()) && !ea.isFullPacienteAgenda()){
                        if(paciente.getDoenca().getCovid() || paciente.getDoenca().getEbola() || paciente.getDoenca().getHiv()){
                            if(hospital.getListaPacientes().containsValue(paciente)){
                                hospital.getRelatorio().relatorioTestarPaciente(paciente);
                                ea.addPacienteAgenda(hospital, paciente);
                                hospital.removerPaciente(paciente);
                            }
                            else{
                                ea.addPacienteAgenda(hospital, paciente);
                                medico.removePacienteAlta(paciente);
                            }
                        }
                        else if(!(paciente.getDoenca().getCovid() || paciente.getDoenca().getEbola() || paciente.getDoenca().getHiv())){
                            if(hospital.getListaPacientes().containsValue(paciente) || medico.containsPacienteInPacienteAlta(paciente)){
                                //adicionar dados do paciente que teve alta no relatorio hospitalar
                                hospital.setRelatorio(new RelatorioHospitalar(paciente));
                            }
                            paciente.getDoenca().setNumerovezes(0);
                            medico.removePacienteAlta(paciente);
                            ea.removePacienteAgenda(paciente);
                        }
                    }
                    break;
                case "EnfermeiroEspecialista":
                    EnfermeiroEspecialista ee = (EnfermeiroEspecialista) enfermeironalista.getValue();
                    if(medico.equals(ee.getMedicoAcompanhado()) && ee.isFullPacienteAgenda()){
                        if(hospital.getListaPacientes().containsValue(paciente) || medico.containsPacienteInPacienteAlta(paciente)){
                            System.out.println("O(s) enfermeiro(s) que acompanha(m) o médico têm a agenda cheia.");
                        }
                    }
                    else if(medico.equals(ee.getMedicoAcompanhado()) && !ee.isFullPacienteAgenda()){
                        if(paciente.getDoenca().getCovid() || paciente.getDoenca().getEbola() || paciente.getDoenca().getHiv()){
                            if(hospital.getListaPacientes().containsValue(paciente)){
                                hospital.getRelatorio().relatorioTestarPaciente(paciente);
                                ee.addPacienteAgenda(hospital, paciente);
                                hospital.removerPaciente(paciente);
                            }
                            else{
                                ee.addPacienteAgenda(hospital, paciente);
                                medico.removePacienteAlta(paciente);
                            }
                        }
                        else if(!(paciente.getDoenca().getCovid() || paciente.getDoenca().getEbola() || paciente.getDoenca().getHiv())){
                            if(hospital.getListaPacientes().containsValue(paciente) || medico.containsPacienteInPacienteAlta(paciente)){
                                //adicionar dados do paciente que teve alta no relatorio hospitalar
                                hospital.setRelatorio(new RelatorioHospitalar(paciente));
                            }
                            paciente.getDoenca().setNumerovezes(0);
                            medico.removePacienteAlta(paciente);
                            ee.removePacienteAgenda(paciente);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * contadorAuxiliaresDisponiveis: retorna o número de auxiliares sem médico acompanhado da lista de pessoas
     * do hospital.
     * @param hospital
     * @return 
     */
    public int contadorAuxiliaresDisponiveis(Hospital hospital){
        int conta = 0;
        for(Map.Entry<String,Pessoa> auxiliarnalista : hospital.getListaPessoas().entrySet()){
            if(auxiliarnalista.getValue().getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
                if(((EnfermeiroAuxiliar)auxiliarnalista.getValue()).getMedicoAcompanhado()==null){
                    conta += 1;
                }
            }
        }
        return conta;
    }
    //getters e setters
    //toString
    //equals
}

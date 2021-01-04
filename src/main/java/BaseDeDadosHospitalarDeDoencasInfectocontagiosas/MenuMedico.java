/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
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
                    requerimentoAuxiliares(hospital);
                    break;
                default:
                    System.out.println("\nNão foi escolhido nenhuma das opções que foram apresentadas! Voltando para Menu...\n");
                    break;
        }
    }
    /*
    Lista de Pacientes em espera!
    */
    public void listarPacientesEspera(Hospital hospital)
    {
        if(hospital.getListaPacientes().isEmpty()){
            throw new ArrayIndexOutOfBoundsException("ListaPacientes está vazio.");
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
        String medicoid = scanner.next();
        if(!hospital.getListaPessoas().containsKey(medicoid)){
            throw new ArrayIndexOutOfBoundsException("O ID a procurar não existe na ListaPessoas.");
        }
        else{
            for(Map.Entry<String,Pessoa> elementonalista : hospital.getListaPessoas().entrySet()){
                if(elementonalista.getKey().equals(medicoid) && elementonalista.getValue().getClass().getSimpleName().equals("Medico")){
                    System.out.println("LISTA DE PACIENTES A AGUARDAR ALTA DO MÉDICO " + elementonalista.getValue().getId() + " :");
                    if(((Medico) elementonalista.getValue()).isEmptyPacienteAlta()){
                        throw new ArrayIndexOutOfBoundsException("ListaPacientesAlta está vazio.");
                    }
                    else{
                        for(Paciente listaPacientesAlta : ((Medico) elementonalista.getValue()).getlistaPacientesAlta()) {
                            System.out.println(listaPacientesAlta);
                        }
                    }
                    break;
                }
                else if(elementonalista.getKey().equals(medicoid) && !(elementonalista.getValue().getClass().getSimpleName().equals("Medico"))){
                    throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence a um médico.");
                    //break;
                }
            }
        }
    }
    
    /*
    Paciente que deu entrada no hospital. Sera feito um diagnostico caso de positivo de patologia sera colocado na agenda dos enfermeiros alocados ao medico
    */
    public void diagnosticoPacientePrimeiraVez(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do médico a selecionar: ");
        String medicoid = scanner.next();
        System.out.println("Insira o ID do paciente a ser diagnosticado: ");
        String pacienteid = scanner.next();
        if(!hospital.getListaPessoas().containsKey(medicoid)){
            throw new ArrayIndexOutOfBoundsException("O ID do médico a procurar não existe na ListaPessoas.");
        }
        else if(!hospital.getListaPacientes().containsKey(pacienteid)){
            throw new ArrayIndexOutOfBoundsException("O ID do paciente a ser diagnosticado não existe na ListaPessoas.");
        }
        else{
            for(Map.Entry<String,Pessoa> mediconalista : hospital.getListaPessoas().entrySet()){
                if(mediconalista.getKey().equals(medicoid) && !(mediconalista.getValue().getClass().getSimpleName().equals("Medico"))){
                    throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence a um médico.");
                }
                else if(mediconalista.getKey().equals(medicoid) && mediconalista.getValue().getClass().getSimpleName().equals("Medico")){
                    if(!((Medico)mediconalista).getAuxiliaresAcompanhados().isEmpty() && !((Medico)mediconalista).getEspecialistasAcompanhados().isEmpty()){
                        for(Map.Entry<String,Paciente> pacientenalista : hospital.getListaPacientes().entrySet()){
                            if(pacientenalista.getKey().equals(pacienteid) && !(pacientenalista.getValue().getClass().getSimpleName().equals("Paciente"))){
                                throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence a um paciente.");
                            }
                            else if(pacientenalista.getKey().equals(pacienteid) && pacientenalista.getValue().getClass().getSimpleName().equals("Paciente")){
                                diagnosticoPaciente(hospital, (Medico)mediconalista.getValue(),(Paciente)pacientenalista.getValue());
                            }
                        }
                    }
                    else{
                        throw new ArrayIndexOutOfBoundsException("O médico não tem nenhum enfermeiro a acompanhar no diagnóstico.");
                    }
                }
            }
        }
    }
    
    public void altaHospitalar(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do médico a selecionar: ");
        String medicoid = scanner.next();
        System.out.println("Insira o ID do paciente a ser diagnosticado: ");
        String pacienteid = scanner.next();
        if(!hospital.getListaPessoas().containsKey(medicoid)){
            throw new ArrayIndexOutOfBoundsException("O ID do médico a procurar não existe na ListaPessoas.");
        }
        else if(!hospital.getListaPessoas().containsKey(pacienteid)){
            throw new ArrayIndexOutOfBoundsException("O ID do paciente a ser avaliado não existe na ListaPessoas.");
        }
        else{
            for(Map.Entry<String,Pessoa> mediconalista : hospital.getListaPessoas().entrySet()){
                if(mediconalista.getKey().equals(medicoid) && !(mediconalista.getValue().getClass().getSimpleName().equals("Medico"))){
                    throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence a um médico.");
                }
                else if(mediconalista.getKey().equals(medicoid) && mediconalista.getValue().getClass().getSimpleName().equals("Medico")){
                    if(((Medico)mediconalista.getValue()).isEmptyPacienteAlta()){
                        throw new ArrayIndexOutOfBoundsException("O médico selecionado tem a lista de pacientes a aguardar alta como vazia.");
                    }
                    else{
                        for(int i = 0; i < ((Medico)mediconalista.getValue()).getlistaPacientesAlta().length; i++){
                            if(((Medico)mediconalista.getValue()).getlistaPacientesAlta()[i]!=null){
                                for(Map.Entry<String,Pessoa> pacientenalista : hospital.getListaPessoas().entrySet()){
                                    if(((Medico)mediconalista.getValue()).getlistaPacientesAlta()[i].equals((Paciente)pacientenalista) && pacientenalista.getKey().equals(pacienteid)){
                                        diagnosticoPaciente(hospital,(Medico)mediconalista,(Paciente)pacientenalista);
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
    
    public void requerimentoAuxiliares(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do médico a selecionar: ");
        String medicoid = scanner.next();
        System.out.println("Insira o ID do enfermeiro-chefe a ser comunicado: ");
        String chefeid = scanner.next();
        if(!hospital.getListaPessoas().containsKey(medicoid)){
            throw new ArrayIndexOutOfBoundsException("O ID do médico a procurar não existe na ListaPessoas.");
        }
        else if(!hospital.getListaPessoas().containsKey(chefeid)){
            throw new ArrayIndexOutOfBoundsException("O ID do chefe a ser comunicado não existe na ListaPessoas.");
        }
        else{
            for(Map.Entry<String,Pessoa> mediconalista : hospital.getListaPessoas().entrySet()){
                if(mediconalista.getKey().equals(medicoid) && !(mediconalista.getValue().getClass().getSimpleName().equals("Medico"))){
                    throw new ArrayIndexOutOfBoundsException("O ID do suposto médico foi encontrado, mas não pertence a um médico.");
                }
                else if(mediconalista.getKey().equals(medicoid) && mediconalista.getValue().getClass().getSimpleName().equals("Medico")){
                    for(Map.Entry<String,Pessoa> chefenalista : hospital.getListaPessoas().entrySet()){
                        if(chefenalista.getKey().equals(chefeid) && !(mediconalista.getValue().getClass().getSimpleName().equals("EnfermeiroChefe"))){
                            throw new ArrayIndexOutOfBoundsException("O ID do suposto enfermeiro-chefe foi encontrado, mas não pertence a um enfermeiro-chefe.");
                        }
                        else if(chefenalista.getKey().equals(chefeid) && mediconalista.getValue().getClass().getSimpleName().equals("EnfermeiroChefe")){
                            System.out.println("Insira o número de auxiliares para acompanhar o médico: ");
                            int numeroauxiliares = scanner.nextInt();
                            int totalauxiliaresdis = contadorAuxiliaresDisponiveis(hospital);
                            if(numeroauxiliares>totalauxiliaresdis){
                                //atender ao pedido de mais enfermeiros-auxiliares
                                throw new ArithmeticException("O número de auxiliares pedido pelo médico é maior do que o número de auxiliares disponíveis na ListaPessoas.");
                            }
                            else{
                                for(Map.Entry<String,Pessoa> auxiliarnalista : hospital.getListaPessoas().entrySet()){
                                    if(auxiliarnalista.getValue().getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
                                        if(((EnfermeiroAuxiliar)auxiliarnalista).getMedicoAcompanhado()==null){
                                            ((EnfermeiroAuxiliar)auxiliarnalista).setMedicoAcompanhado((Medico)mediconalista);
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
    }
    
    public void diagnosticoPaciente(Hospital hospital, Medico medico, Paciente paciente){
        for(Map.Entry<String,Pessoa> enfermeironalista : hospital.getListaPessoas().entrySet()){
            switch(enfermeironalista.getValue().getClass().getSimpleName()){
                case "EnfermeiroAuxiliar":
                    EnfermeiroAuxiliar ea = (EnfermeiroAuxiliar) enfermeironalista.getValue();
                    if(ea.getMedicoAcompanhado().equals(medico) && ea.isFullPacienteAgenda()){
                        throw new ArrayIndexOutOfBoundsException("O(s) enfermeiro(s) que acompanha(m) o médico têm a agenda cheia.");
                    }
                    else if(ea.getMedicoAcompanhado().equals(medico) && !ea.isFullPacienteAgenda()){
                        if(paciente.getDoenca().getCovid() || paciente.getDoenca().getEbola() || paciente.getDoenca().getHiv()){
                            if(hospital.getListaPacientes().containsValue(paciente)){
                                ea.addPacienteAgenda(hospital, paciente);
                                hospital.removerPaciente(paciente);
                            }
                            else{
                                ea.addPacienteAgenda(hospital, paciente);
                                medico.removePacienteAlta(paciente);
                            }
                        }
                        else if(!(paciente.getDoenca().getCovid() || paciente.getDoenca().getEbola() || paciente.getDoenca().getHiv())){
                            medico.removePacienteAlta(paciente);
                            ea.removePacienteAgenda(paciente);
                            //adicionar dados do paciente que teve alta no relatorio hospitalar
                        }
                    }
                    break;
                case "EnfermeiroEspecialista":
                    EnfermeiroEspecialista ee = (EnfermeiroEspecialista) enfermeironalista.getValue();
                    if(ee.getMedicoAcompanhado().equals(medico) && ee.isFullPacienteAgenda()){
                        throw new ArrayIndexOutOfBoundsException("O(s) enfermeiro(s) que acompanha(m) o médico têm a agenda cheia.");
                    }
                    else if(ee.getMedicoAcompanhado().equals(medico) && !ee.isFullPacienteAgenda()){
                        if(paciente.getDoenca().getCovid() || paciente.getDoenca().getEbola() || paciente.getDoenca().getHiv()){
                            if(hospital.getListaPacientes().containsValue(paciente)){
                                ee.addPacienteAgenda(hospital, paciente);
                                hospital.removerPaciente(paciente);
                            }
                            else{
                                ee.addPacienteAgenda(hospital, paciente);
                                medico.removePacienteAlta(paciente);
                            }
                        }
                        else if(!(paciente.getDoenca().getCovid() || paciente.getDoenca().getEbola() || paciente.getDoenca().getHiv())){
                            medico.removePacienteAlta(paciente);
                            ee.removePacienteAgenda(paciente);
                            //adicionar dados do paciente que teve alta no relatorio hospitalar
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
    public int contadorAuxiliaresDisponiveis(Hospital hospital){
        int conta = 0;
        for(Map.Entry<String,Pessoa> auxiliarnalista : hospital.getListaPessoas().entrySet()){
            if(auxiliarnalista.getValue().getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
                if(((EnfermeiroAuxiliar)auxiliarnalista).getMedicoAcompanhado()==null){
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

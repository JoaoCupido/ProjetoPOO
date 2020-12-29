/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Utilizador
 */
public class MenuAdministrador {
    //variaveis de instancia
    private boolean sair = false;
    //construtor
    //metodos
    
    public void menuOpcoesAdministrador(Hospital hospital){
        int opcao;
        System.out.println("***SubMenu Administrador***");
        System.out.println("1) Criar Médico");
        System.out.println("2) Criar Enfermeiro-Especialista");
        System.out.println("3) Criar Enfermeiro-Auxiliar");
        System.out.println("4) Criar Novo Paciente");
        System.out.println("5) Promover Enfermeiro a Chefe");
        System.out.println("6) Aumentar Anos de Carreria");
        System.out.println("7) Listar Enfermeiros");
        System.out.println("8) Listar Médicos");
        System.out.println("9) Listar Pedidos para Enfermeiros-Auxiliares");
        System.out.println("10) Listar Pacientes em espera no Hospital");
        System.out.println("11) Atirar Pedidos para Enfermeiros-Auxiliares para a Trituradora");
        System.out.println("12) Virus Outbreak");
        System.out.println("13) N-ésimo Relatório Hospitalar");
        System.out.println("14) Sair da Aplicação\n");
        Scanner escolha = new Scanner(System.in);
        System.out.println("Digite uma opção. Digite nenhuma das opções apresentadas para sair do SubMenu Administrador: ");
        opcao = escolha.nextInt();

        switch(opcao)
            {
                case 1:
                    System.out.println("\nEscolhido a opção Criar Médico...\n");
                    criarMedico(hospital);
                    break;
                case 2:
                    System.out.println("\nEscolhido a opção Criar Enfermeiro-Especialista...\n");
                    criarEnfermeiroEspecialista(hospital);
                    break;
                case 3:
                    System.out.println("\nEscolhido a opção Criar Enfermeiro-Auxiliar...\n");
                    criarEnfermeiroAuxiliar(hospital);
                    break;
                case 4:
                    System.out.println("\nEscolhido a opção Criar Novo Paciente...\n");
                    criarNovoPaciente(hospital);
                    break;
                case 5:
                    System.out.println("\nEscolhido a opção Promover Enfermeiro a Chefe...\n");
                    promoverEnfermeiroChefe(hospital);
                    break;
                case 6:
                    System.out.println("\nEscolhido a opção Aumentar Anos de Carreria...\n");
                    aumentarAnosCarreira(hospital);
                    break;
                case 7:
                    System.out.println("\nEscolhido a opção Listar Enfermeiros...\n");
                    listarEnfermeiros(hospital);
                    break;
                case 8:
                    System.out.println("\nEscolhido a opção Listar Médicos...\n");
                    listarMedicos(hospital);
                    break;
                case 9:
                    System.out.println("\nEscolhido a opção Listar Pedidos para Enfermeiros-Auxiliares...\n");
                    pedidosEnfermeirosAuxiliares();
                    break;
                case 10:
                    System.out.println("\nEscolhido a opção Listar Pacientes em espera no Hospital...\n");
                    pacientesEsperanoHospital(hospital);
                    break;
                case 11:
                    System.out.println("\nEscolhido a opção Atirar Pedidos para Enfermeiros-Auxiliares para a Trituradora...\n");
                    atribuirPedidosEnfAuxTrituradora();
                    break;
                case 12:
                    System.out.println("\nEscolhido a opção Virus Outbreak...\n");
                    outBreak(hospital);
                    break;
                case 13:
                    System.out.println("\nEscolhido a opção N-ésimo Relatório Hospitalar...\n");
                    relatorioHospitalar();
                    break;
                case 14:
                    System.out.println("\nEscolhido a opção Sair da Aplicação...\n");
                    sairAplicacao();
                    break;
                default:
                    System.out.println("\nNão foi escolhido nenhuma das opções que foram apresentadas! Voltando para Menu...\n");
                    break;
            }
    }
    
    public void criarMedico(Hospital hospital)
    {
        Pessoa medico = new Medico();
        hospital.getListaPessoas().add(medico); //adicionar medico à lista de pessoas no hospital
    }
    
    public void criarEnfermeiroEspecialista(Hospital hospital)
    {
        String nome;
        Scanner inserirnome = new Scanner(System.in);
        System.out.println("Insere o nome: ");
        nome = inserirnome.next();
        Pessoa enfermeiroespecialista = new EnfermeiroEspecialista(nome, 0);
        hospital.addPessoa(enfermeiroespecialista); //adicionar enfermeiroespecialista à lista de pessoas no hospital 
    }
    
    public void criarEnfermeiroAuxiliar(Hospital hospital)
    {
        String nome;
        Scanner inserirnome = new Scanner(System.in);
        System.out.println("Insere o nome: ");
        nome = inserirnome.next();
        Pessoa enfermeiroauxiliar = new EnfermeiroAuxiliar(nome, 0);
        hospital.addPessoa(enfermeiroauxiliar); //adicionar enfermeiroauxiliar à lista de pessoas no hospital 
    }
    
    public void criarNovoPaciente(Hospital hospital)
    {
        int anonascimento;
        Scanner inserirano = new Scanner(System.in);
        System.out.println("Insere o ano de nascimento: ");
        anonascimento = inserirano.nextInt();
        Pessoa paciente = new Paciente(anonascimento);
        hospital.addPessoa(paciente); //adicionar paciente à lista de pessoas no hospital
        hospital.addPaciente((Paciente) paciente); //adicionar paciente à lista de pacientes em espera no hospital
    }
    
    public void promoverEnfermeiroChefe(Hospital hospital)
    {
        if(hospital.getListaPessoas().isEmpty()){
            throw new ArrayIndexOutOfBoundsException("ListaPessoas está vazio.");
        }
        else{
            for(int i = 0; i < hospital.getListaPessoas().size(); i++) {
                if((hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroEspecialista")){
                    EnfermeiroEspecialista enfermeiroespecialista = (EnfermeiroEspecialista) hospital.getListaPessoas().get(i);
                    if(enfermeiroespecialista.getAnosCarreira() >= hospital.getAnosCarreiraMinimo()){
                        Pessoa enfermeirochefe = new EnfermeiroChefe(enfermeiroespecialista.getNome(), enfermeiroespecialista.getAnosCarreira());
                        enfermeirochefe.setId(enfermeiroespecialista.getId());
                        enfermeirochefe.setContarPessoas(enfermeirochefe.getContarPessoas()-1);
                        //EnfermeiroChefe enfermeirochefe = (EnfermeiroChefe) enfermeiroespecialista; //ERRO AQUI!
                        //ERRO: class BaseDeDadosHospitalarDeDoencasInfectocontagiosas.EnfermeiroEspecialista cannot be cast to class BaseDeDadosHospitalarDeDoencasInfectocontagiosas.EnfermeiroChefe
                        hospital.getListaPessoas().set(i, enfermeirochefe);
                    }
                    else{
                        System.out.println("O enfermeiro especialista " + enfermeiroespecialista.getId() + " de nome " + enfermeiroespecialista.getNome() + " não tem o requerimento minimo de anos de carreira para ser promovido a enfermeiro chefe.");
                    }
                }
            }
        }
    }
    
    public void aumentarAnosCarreira(Hospital hospital)
    {
        if(hospital.getListaPessoas().isEmpty()){
            throw new ArrayIndexOutOfBoundsException("ListaPessoas está vazio.");
        }
        else{
            for(int i = 0; i < hospital.getListaPessoas().size(); i++) {
                if((hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroEspecialista") || (hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroAuxiliar") || (hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroChefe")){
                    Enfermeiro enfermeiro = (Enfermeiro) hospital.getListaPessoas().get(i);
                    int novoanocarreira = enfermeiro.getAnosCarreira() + 1;
                    enfermeiro.setAnosCarreira(novoanocarreira);
                    hospital.getListaPessoas().set(i, enfermeiro);
                }
            }
        }
    }
    
    public void listarEnfermeiros(Hospital hospital)
    {
        if(hospital.getListaPessoas().isEmpty()){
            throw new ArrayIndexOutOfBoundsException("ListaPessoas está vazio.");
        }
        else{
            for(int i = 0; i < hospital.getListaPessoas().size(); i++) {
                switch (hospital.getListaPessoas().get(i).getClass().getSimpleName()) {
                    case "EnfermeiroEspecialista":
                        EnfermeiroEspecialista enfermeiroespecialista = (EnfermeiroEspecialista) hospital.getListaPessoas().get(i);
                        System.out.println(enfermeiroespecialista);
                        break;
                    case "EnfermeiroAuxiliar":
                        EnfermeiroAuxiliar enfermeiroauxiliar = (EnfermeiroAuxiliar) hospital.getListaPessoas().get(i);
                        System.out.println(enfermeiroauxiliar);
                        break;
                    case "EnfermeiroChefe":
                        EnfermeiroChefe enfermeirochefe = (EnfermeiroChefe) hospital.getListaPessoas().get(i);
                        System.out.println(enfermeirochefe);
                        break;
                    default:
                        break;
                }
            }
        }
    }
    
    public void listarMedicos(Hospital hospital)
    {
        if(hospital.getListaPessoas().isEmpty()){
            throw new ArrayIndexOutOfBoundsException("ListaPessoas está vazio.");
        }
        else{
            for(int i = 0; i < hospital.getListaPessoas().size(); i++) {
                if((hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("Medico")){
                    Medico medico = (Medico) hospital.getListaPessoas().get(i);
                    System.out.println(medico);
                }
            }
        }
    }
    
    public void pedidosEnfermeirosAuxiliares()
    {
        
    }
    
    public void pacientesEsperanoHospital(Hospital hospital)
    {
        if(hospital.getListaPacientes().isEmpty()){
            throw new ArrayIndexOutOfBoundsException("ListaPacientes está vazio.");
        }
        else{
            for(int i = 0; i < hospital.getListaPacientes().size(); i++){
                System.out.println(hospital.getListaPacientes().get(i));
            }
        }
    }
    
    public void atribuirPedidosEnfAuxTrituradora()
    {
        
    }
    
    public void outBreak(Hospital hospital)
    {
        Random gerador = new Random();
        if(hospital.getListaPessoas().isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Não é possivel haver Virus Outbreak, porque ListaPessoas está vazio.");
        }
        else{
            for(int i = 0; i < hospital.getListaPessoas().size(); i++){
                switch(hospital.getListaPessoas().get(i).getClass().getSimpleName()) {
                    case "Medico":
                        Medico medicoencontrado = (Medico) hospital.getListaPessoas().get(i);
                        if(medicoencontrado.vazioPacienteAlta()){
                            if(!isEnfermeiroWithMedico(hospital, medicoencontrado)){
                                if(gerador.nextBoolean()){
                                    Scanner anonascimento = new Scanner(System.in);
                                    System.out.println("Insere o ano de nascimento de um infetado: ");
                                    Pessoa paciente = new Paciente(anonascimento.nextInt());
                                    paciente.setId(hospital.getListaPessoas().get(i).getId());
                                    paciente.setContarPessoas(paciente.getContarPessoas()-1);
                                    hospital.getListaPessoas().set(i, paciente);
                                    hospital.addPaciente((Paciente) paciente);
                                }
                            }
                        }
                        break;
                    case "Paciente":
                        boolean pacientepossivelinfetar = true;
                        if(!isPacienteOnListaEspera(hospital, (Paciente) hospital.getListaPessoas().get(i))){
                            for(int j = 0; j < hospital.getListaPessoas().size(); j++){
                                switch(hospital.getListaPessoas().get(j).getClass().getSimpleName()) {
                                    case "Medico":
                                        for(int k = 0; k < ((Medico)hospital.getListaPessoas().get(j)).getlistaPacientesAlta().length; k++){
                                            if(((Medico)hospital.getListaPessoas().get(j)).getlistaPacientesAlta()[k].equals(hospital.getListaPessoas().get(i))){
                                                pacientepossivelinfetar = false;
                                                break;
                                            }
                                        }
                                        break;
                                    case "EnfermeiroEspecialista":
                                        for(int k = 0; k < ((EnfermeiroEspecialista)hospital.getListaPessoas().get(j)).getAgenda().length; k++){
                                            if(((EnfermeiroEspecialista)hospital.getListaPessoas().get(j)).getAgenda()[k].equals(hospital.getListaPessoas().get(i))){
                                                pacientepossivelinfetar = false;
                                                break;
                                            }
                                        }
                                        break;
                                    case "EnfermeiroAuxiliar":
                                        for(int k = 0; k < ((EnfermeiroAuxiliar)hospital.getListaPessoas().get(j)).getAgenda().length; k++){
                                            if(((EnfermeiroAuxiliar)hospital.getListaPessoas().get(j)).getAgenda()[k].equals(hospital.getListaPessoas().get(i))){
                                                pacientepossivelinfetar = false;
                                                break;
                                            }
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                            if(pacientepossivelinfetar){
                                if(gerador.nextBoolean()){
                                    Scanner anonascimento = new Scanner(System.in);
                                    System.out.println("Insere o ano de nascimento de um infetado: ");
                                    Pessoa paciente = new Paciente(anonascimento.nextInt());
                                    paciente.setId(hospital.getListaPessoas().get(i).getId());
                                    paciente.setContarPessoas(paciente.getContarPessoas()-1);
                                    hospital.getListaPessoas().set(i, paciente);
                                    hospital.addPaciente((Paciente) paciente);
                                }
                            }
                        }
                        break;
                    case "EnfermeiroEspecialista":
                        if(((EnfermeiroEspecialista)hospital.getListaPessoas().get(i)).vazioPacienteAgenda() && ((EnfermeiroEspecialista)hospital.getListaPessoas().get(i)).getMedicoAcompanhado()==null){
                            if(gerador.nextBoolean()){
                                Scanner anonascimento = new Scanner(System.in);
                                System.out.println("Insere o ano de nascimento de um infetado: ");
                                Pessoa paciente = new Paciente(anonascimento.nextInt());
                                paciente.setId(hospital.getListaPessoas().get(i).getId());
                                paciente.setContarPessoas(paciente.getContarPessoas()-1);
                                hospital.getListaPessoas().set(i, paciente);
                                hospital.addPaciente((Paciente) paciente);
                            }
                        }
                        break;
                    case "EnfermeiroAuxiliar":
                        if(((EnfermeiroAuxiliar)hospital.getListaPessoas().get(i)).vazioPacienteAgenda() && ((EnfermeiroAuxiliar)hospital.getListaPessoas().get(i)).getMedicoAcompanhado()==null){
                            if(gerador.nextBoolean()){
                                Scanner anonascimento = new Scanner(System.in);
                                System.out.println("Insere o ano de nascimento de um infetado: ");
                                Pessoa paciente = new Paciente(anonascimento.nextInt());
                                paciente.setId(hospital.getListaPessoas().get(i).getId());
                                paciente.setContarPessoas(paciente.getContarPessoas()-1);
                                hospital.getListaPessoas().set(i, paciente);
                                hospital.addPaciente((Paciente) paciente);
                            }
                        }
                        break;
                    case "EnfermeiroChefe":
                        if(gerador.nextBoolean()){
                            Scanner anonascimento = new Scanner(System.in);
                            System.out.println("Insere o ano de nascimento de um infetado: ");
                            Pessoa paciente = new Paciente(anonascimento.nextInt());
                            paciente.setId(hospital.getListaPessoas().get(i).getId());
                            paciente.setContarPessoas(paciente.getContarPessoas()-1);
                            hospital.getListaPessoas().set(i, paciente);
                            hospital.addPaciente((Paciente) paciente);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
    
    public void relatorioHospitalar()
    {
        
    }
    
    public void sairAplicacao(){
        setSair(true);
    }
    
    public boolean isEnfermeiroWithMedico(Hospital hospital, Medico medico){
        boolean foundmedico = false;
        for(int i = 0; i < hospital.getListaPessoas().size(); i++){
            if(hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
                if(((EnfermeiroAuxiliar)hospital.getListaPessoas().get(i)).getMedicoAcompanhado().equals(medico)){
                    foundmedico = true;
                }
            }
            else if(hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("EnfermeiroEspecialista")){
                if(((EnfermeiroEspecialista)hospital.getListaPessoas().get(i)).getMedicoAcompanhado().equals(medico)){
                    foundmedico = true;
                }
            }
        }
        return foundmedico;
    }
    
    public boolean isPacienteOnListaEspera(Hospital hospital, Paciente paciente){
        boolean ispacientelistaespera = false;
        for(int i = 0; i < hospital.getListaPacientes().size(); i++){
            if(hospital.getListaPacientes().get(i).equals(paciente) && hospital.getListaPacientes().get(i).getClass().getSimpleName().equals("Paciente")){
                ispacientelistaespera = true;
                break;
            }
        }
        return ispacientelistaespera;
    }
    //getters e setters
    public boolean getSair(){
        return sair;
    }
    public void setSair(boolean sair){
        this.sair = sair;
    }
    //toString
    //equals
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;
import PrincipaisClasses.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Utilizador
 */
public class MenuAdministrador {
    //variaveis de instancia
    private boolean sair;
    //construtor
    /**
     * Construtor da classe MenuAdministrador em que sair=false;
     */
    public MenuAdministrador(){
        sair = false;
    }
    //metodos
    /**
     * Método em que contêm várias opções de administrador
     * @param hospital 
     */
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
        System.out.println("12) Atender ao Pedido para Enfermeiros-Auxiliares");
        System.out.println("13) Virus Outbreak");
        System.out.println("14) N-ésimo Relatório Hospitalar");
        System.out.println("15) Sair da Aplicação\n");
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
                    pedidosEnfermeirosAuxiliares(hospital);
                    break;
                case 10:
                    System.out.println("\nEscolhido a opção Listar Pacientes em espera no Hospital...\n");
                    pacientesEsperanoHospital(hospital);
                    break;
                case 11:
                    System.out.println("\nEscolhido a opção Atirar Pedidos para Enfermeiros-Auxiliares para a Trituradora...\n");
                    atribuirPedidosEnfAuxTrituradora(hospital);
                    break;
                case 12:
                    System.out.println("\nEscolhido a opção Atender ao Pedido para Enfermeiros-Auxiliares...\n");
                    atenderPedidoEnfAuxiliares(hospital);
                    break;
                case 13:
                    System.out.println("\nEscolhido a opção Virus Outbreak...\n");
                    outBreak(hospital);
                    break;
                case 14:
                    System.out.println("\nEscolhido a opção N-ésimo Relatório Hospitalar...\n");
                    relatorioHospitalar(hospital);
                    break;
                case 15:
                    System.out.println("\nEscolhido a opção Sair da Aplicação...\n");
                    sairAplicacao();
                    break;
                default:
                    System.out.println("\nNão foi escolhido nenhuma das opções que foram apresentadas! Voltando para Menu...\n");
                    break;
            }
    }
    /**
     * criarMedico: criar um novo médico na lista de pessoas do hospital
     * @param hospital 
     */
    public void criarMedico(Hospital hospital)
    {
        Pessoa medico = new Medico();
        hospital.addPessoa(medico); //adicionar medico à lista de pessoas no hospital
    }
    /**
     * criarEnfermeiroEspecialista: criar um novo enfermeiro-especialista na lista de pessoas do hospital
     * @param hospital 
     */
    public void criarEnfermeiroEspecialista(Hospital hospital)
    {
        String nome;
        Scanner inserirnome = new Scanner(System.in);
        System.out.println("Insere o nome: ");
        nome = inserirnome.nextLine();
        Pessoa enfermeiroespecialista = new EnfermeiroEspecialista(nome, 0);
        hospital.addPessoa(enfermeiroespecialista); //adicionar enfermeiroespecialista à lista de pessoas no hospital 
    }
    /**
     * criarEnfermeiroAuxiliar: criar um novo enfermeiro-auxiliar na lista de pessoas do hospital
     * @param hospital 
     */
    public void criarEnfermeiroAuxiliar(Hospital hospital)
    {
        String nome;
        Scanner inserirnome = new Scanner(System.in);
        System.out.println("Insere o nome: ");
        nome = inserirnome.nextLine();
        Pessoa enfermeiroauxiliar = new EnfermeiroAuxiliar(nome, 0);
        hospital.addPessoa(enfermeiroauxiliar); //adicionar enfermeiroauxiliar à lista de pessoas no hospital 
    }
    /**
     * criarNovoPaciente: criar um novo paciente na lista de pessoas do hospital e na lista de pacientes em espera do hospital
     * @param hospital 
     */
    public void criarNovoPaciente(Hospital hospital)
    {
        int anonascimento;
        Scanner inserirano = new Scanner(System.in);
        System.out.println("Insere o ano de nascimento: ");
        try{
            anonascimento = inserirano.nextInt();
            Pessoa paciente = new Paciente(anonascimento);
            hospital.addPessoa(paciente); //adicionar paciente à lista de pessoas no hospital
            hospital.addPaciente((Paciente) paciente); //adicionar paciente à lista de pacientes em espera no hospital
        }
        catch(InputMismatchException e){
            System.out.println("Input inválido!");
            inserirano.nextLine();
        }
    }
    /**
     * promoverEnfermeiroChefe: transformar todas as pessoas que são enfermeiros-especialistas e cumprem os requisitos mínimos
     * para enfermeiros-chefes
     * @param hospital 
     */
    public void promoverEnfermeiroChefe(Hospital hospital)
    {
        if(hospital.getListaPessoas().isEmpty()){
            System.out.println("ListaPessoas está vazio.");
        }
        else{
            for(Pessoa pessoaencontrar : hospital.getListaPessoas().values()) {
                if((pessoaencontrar.getClass().getSimpleName()).equals("EnfermeiroEspecialista")){
                    EnfermeiroEspecialista enfermeiroespecialista = (EnfermeiroEspecialista) pessoaencontrar;
                    if(enfermeiroespecialista.getAnosCarreira() >= hospital.getAnosCarreiraMinimo() && enfermeiroespecialista.getMedicoAcompanhado()==null){
                        Pessoa enfermeirochefe = new EnfermeiroChefe(enfermeiroespecialista.getNome(), enfermeiroespecialista.getAnosCarreira());
                        enfermeirochefe.setId(enfermeiroespecialista.getId());
                        enfermeirochefe.setContarPessoas(enfermeirochefe.getContarPessoas()-1);
                        //EnfermeiroChefe enfermeirochefe = (EnfermeiroChefe) enfermeiroespecialista; //ERRO AQUI!
                        //ERRO: class BaseDeDadosHospitalarDeDoencasInfectocontagiosas.EnfermeiroEspecialista cannot be cast to class BaseDeDadosHospitalarDeDoencasInfectocontagiosas.EnfermeiroChefe
                        hospital.getListaPessoas().replace(enfermeirochefe.getId(), enfermeirochefe);
                    }
                    else if(enfermeiroespecialista.getAnosCarreira() < hospital.getAnosCarreiraMinimo() && enfermeiroespecialista.getMedicoAcompanhado()!=null){
                        System.out.println("O enfermeiro especialista " + enfermeiroespecialista.getId() + " de nome " + enfermeiroespecialista.getNome() + " não tem o requerimento minimo de anos de carreira ( " + enfermeiroespecialista.getAnosCarreira() + " < " + hospital.getAnosCarreiraMinimo() + " ) para ser promovido a enfermeiro chefe.");
                        System.out.println("O enfermeiro especialista " + enfermeiroespecialista.getId() + " de nome " + enfermeiroespecialista.getNome() + " acompanha o médico " + enfermeiroespecialista.getMedicoAcompanhado().getId() + ".");
                    }
                    else if(enfermeiroespecialista.getAnosCarreira() < hospital.getAnosCarreiraMinimo() && enfermeiroespecialista.getMedicoAcompanhado()==null){
                        System.out.println("O enfermeiro especialista " + enfermeiroespecialista.getId() + " de nome " + enfermeiroespecialista.getNome() + " não tem o requerimento minimo de anos de carreira ( " + enfermeiroespecialista.getAnosCarreira() + " < " + hospital.getAnosCarreiraMinimo() + " ) para ser promovido a enfermeiro chefe.");
                    }
                    else if(enfermeiroespecialista.getAnosCarreira() >= hospital.getAnosCarreiraMinimo() && enfermeiroespecialista.getMedicoAcompanhado()!=null){
                        System.out.println("O enfermeiro especialista " + enfermeiroespecialista.getId() + " de nome " + enfermeiroespecialista.getNome() + " acompanha o médico " + enfermeiroespecialista.getMedicoAcompanhado().getId() + ".");
                    }
                }
            }
        }
    }
    /**
     * aumentarAnosCarreira: aumentar anos de carreira de todos os enfermeiros
     * @param hospital 
     */
    public void aumentarAnosCarreira(Hospital hospital)
    {
        if(hospital.getListaPessoas().isEmpty()){
            System.out.println("ListaPessoas está vazio.");
        }
        else{
            for(Pessoa pessoaencontrar : hospital.getListaPessoas().values()) {
                if(pessoaencontrar instanceof Enfermeiro){
                    Enfermeiro enfermeiro = (Enfermeiro) pessoaencontrar;
                    int novoanocarreira = enfermeiro.getAnosCarreira() + 1;
                    enfermeiro.setAnosCarreira(novoanocarreira);
                    //hospital.getListaPessoas().replace(enfermeiro.getId(), enfermeiro);
                }
            }
        }
    }
    /**
     * listarEnfermeiros: imprimir todos os enfermeiros na consola
     * @param hospital 
     */
    public void listarEnfermeiros(Hospital hospital)
    {
        if(hospital.getListaPessoas().isEmpty()){
            System.out.println("ListaPessoas está vazio.");
        }
        else{
            for(Pessoa pessoaencontrar : hospital.getListaPessoas().values()) {
                switch (pessoaencontrar.getClass().getSimpleName()) {
                    case "EnfermeiroEspecialista":
                        EnfermeiroEspecialista enfermeiroespecialista = (EnfermeiroEspecialista) pessoaencontrar;
                        System.out.println(enfermeiroespecialista);
                        break;
                    case "EnfermeiroAuxiliar":
                        EnfermeiroAuxiliar enfermeiroauxiliar = (EnfermeiroAuxiliar) pessoaencontrar;
                        System.out.println(enfermeiroauxiliar);
                        break;
                    case "EnfermeiroChefe":
                        EnfermeiroChefe enfermeirochefe = (EnfermeiroChefe) pessoaencontrar;
                        System.out.println(enfermeirochefe);
                        break;
                    default:
                        break;
                }
            }
        }
    }
    /**
     * listarMedicos: listar todos os médicos do hospital na consola
     * @param hospital 
     */
    public void listarMedicos(Hospital hospital)
    {
        if(hospital.getListaPessoas().isEmpty()){
            System.out.println("ListaPessoas está vazio.");
        }
        else{
            for(Pessoa pessoaencontrar : hospital.getListaPessoas().values()) {
                if((pessoaencontrar.getClass().getSimpleName()).equals("Medico")){
                    Medico medico = (Medico) pessoaencontrar;
                    System.out.println(medico);
                }
            }
        }
    }
    /**
     * pedidosEnfermeirosAuxiliares: listar todos os pedidos de auxiliares do hospital na consola
     * @param hospital 
     */
    public void pedidosEnfermeirosAuxiliares(Hospital hospital)
    {
        if(hospital.getPedidos().isEmpty()){
            System.out.println("PedidosAuxiliares está vazio.");
        }
        else{
            for(Pessoa auxiliar : hospital.getPedidos()){
                System.out.println(auxiliar);
            }
        }
    }
    /**
     * pacientesEsperanoHospital: listar todos os pacientes em espera do hospital na consola
     * @param hospital 
     */
    public void pacientesEsperanoHospital(Hospital hospital)
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
    /**
     * atribuirPedidosEnfAuxTrituradora: de pedido a pedido, é removido 50% das hipóteses
     * @param hospital 
     */
    public void atribuirPedidosEnfAuxTrituradora(Hospital hospital)
    {
        if(hospital.getPedidos().isEmpty()){
            System.out.println("PedidosAuxiliares está vazio.");
        }
        else{
            Random generator = new Random();
            for(Pessoa auxiliar : hospital.getPedidos()){
                if(generator.nextBoolean()){
                    hospital.removerPedido(auxiliar);
                }
            }
        }
    }
    /**
     * atenderPedidoEnfAuxiliares: adicionar 2 enfermeiros-auxiliares na lista de pessoas do hospital
     * de acordo com os últimos 2 pedidos de enfermeiros-auxiliares
     * @param hospital 
     */
    public void atenderPedidoEnfAuxiliares(Hospital hospital){
        if(hospital.getPedidos().isEmpty()){
            System.out.println("PedidosAuxiliares está vazio.");
        }
        else{
            int tamanho = hospital.getPedidos().size();
            int n = 2;
            while(n>0){
                hospital.addPessoa(hospital.getPedidos().get(tamanho-1));
                hospital.removerPedido(hospital.getPedidos().get(tamanho-1));
            }
        }
    }
    /**
     * outBreak: ocorre um surto no hospital; vai percorrer na lista de pessoas e ocorre certas condições para
     * cada caso (se cumpre as condições, a pessoa tem 50% de probabilidade de ficar infetado - se for infetado, é alterado o tipo de pessoa
     * para paciente na lista de pessoas e entra na lista de pacientes em espera no hospital):
     *  > Medico: se este não tem enfermeiros acompanhados (auxiliares ou especialistas) e se não tem pacientes à espera da alta;
     *  > Paciente: se este já está em alta ou está em lista de espera do hospital;
     *  > Especialista: se este tem a agenda vazia (ou seja, se não tem pacientes à espera do curativo), e não é acompanhado por um médico;
     *  > Auxiliar: se este tem a agenda vazia (ou seja, se não tem pacientes à espera do curativo), e não é acompanhado por um médico;
     *  > Chefe: este não tem condições; é logo feito a probabilidade de ser infetado
     *
     * @param hospital 
     */
    public void outBreak(Hospital hospital)
    {
        Random gerador = new Random();
        if(hospital.getListaPessoas().isEmpty()){
            System.out.println("Não é possivel haver Virus Outbreak, porque ListaPessoas está vazio.");
        }
        else{
            for(Pessoa pessoaencontrar : hospital.getListaPessoas().values()){
                switch(pessoaencontrar.getClass().getSimpleName()) {
                    case "Medico":
                        Medico medicoencontrado = (Medico) pessoaencontrar;
                        if(medicoencontrado.isEmptyPacienteAlta()){
                            if(medicoencontrado.getAuxiliaresAcompanhados().isEmpty() && medicoencontrado.getEspecialistasAcompanhados().isEmpty()){
                                if(gerador.nextBoolean()){
                                    Scanner anonascimento = new Scanner(System.in);
                                    System.out.println("Insere o ano de nascimento de um infetado: ");
                                    Pessoa paciente = new Paciente(anonascimento.nextInt());
                                    paciente.setId(pessoaencontrar.getId());
                                    paciente.setContarPessoas(paciente.getContarPessoas()-1);
                                    hospital.getListaPessoas().replace(paciente.getId(), paciente);
                                    hospital.addPaciente((Paciente) paciente);
                                }
                            }
                        }
                        break;
                    case "Paciente":
                        boolean pacientepossivelinfetar = true;
                        if(!hospital.getListaPacientes().containsValue((Paciente)pessoaencontrar)){
                            for(Pessoa pessoarelacaopacienteencontrar : hospital.getListaPessoas().values()){
                                switch(pessoarelacaopacienteencontrar.getClass().getSimpleName()) {
                                    case "Medico":
                                        for(int k = 0; k < ((Medico)pessoarelacaopacienteencontrar).getlistaPacientesAlta().length; k++){
                                            if(((Medico)pessoarelacaopacienteencontrar).getlistaPacientesAlta()[k].equals(pessoaencontrar)){
                                                pacientepossivelinfetar = false;
                                                break;
                                            }
                                        }
                                        break;
                                    case "EnfermeiroEspecialista":
                                        for(int k = 0; k < ((EnfermeiroEspecialista)pessoarelacaopacienteencontrar).getAgenda().length; k++){
                                            if(((EnfermeiroEspecialista)pessoarelacaopacienteencontrar).getAgenda()[k].equals(pessoaencontrar)){
                                                pacientepossivelinfetar = false;
                                                break;
                                            }
                                        }
                                        break;
                                    case "EnfermeiroAuxiliar":
                                        for(int k = 0; k < ((EnfermeiroAuxiliar)pessoarelacaopacienteencontrar).getAgenda().length; k++){
                                            if(((EnfermeiroAuxiliar)pessoarelacaopacienteencontrar).getAgenda()[k].equals(pessoaencontrar)){
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
                                    paciente.setId(pessoaencontrar.getId());
                                    paciente.setContarPessoas(paciente.getContarPessoas() - 1);
                                    hospital.getListaPessoas().replace(paciente.getId(), paciente);
                                    hospital.addPaciente((Paciente) paciente);
                                }
                            }
                        }
                        else{
                            if(gerador.nextBoolean()){
                                Scanner anonascimento = new Scanner(System.in);
                                System.out.println("Insere o ano de nascimento de um infetado: ");
                                Pessoa paciente = new Paciente(anonascimento.nextInt());
                                paciente.setId(pessoaencontrar.getId());
                                paciente.setContarPessoas(paciente.getContarPessoas() - 1);
                                hospital.getListaPessoas().replace(paciente.getId(), paciente);
                                hospital.addPaciente((Paciente) paciente);
                            }
                        }
                        break;
                    case "EnfermeiroEspecialista":
                        if(((EnfermeiroEspecialista)pessoaencontrar).isEmptyPacienteAgenda() && ((EnfermeiroEspecialista)pessoaencontrar).getMedicoAcompanhado()==null){
                            if(gerador.nextBoolean()){
                                Scanner anonascimento = new Scanner(System.in);
                                System.out.println("Insere o ano de nascimento de um infetado: ");
                                Pessoa paciente = new Paciente(anonascimento.nextInt());
                                paciente.setId(pessoaencontrar.getId());
                                paciente.setContarPessoas(paciente.getContarPessoas() - 1);
                                hospital.getListaPessoas().replace(paciente.getId(), paciente);
                                hospital.addPaciente((Paciente) paciente);
                            }
                        }
                        break;
                    case "EnfermeiroAuxiliar":
                        if(((EnfermeiroAuxiliar)pessoaencontrar).isEmptyPacienteAgenda() && ((EnfermeiroAuxiliar)pessoaencontrar).getMedicoAcompanhado()==null){
                            if(gerador.nextBoolean()){
                                Scanner anonascimento = new Scanner(System.in);
                                System.out.println("Insere o ano de nascimento de um infetado: ");
                                Pessoa paciente = new Paciente(anonascimento.nextInt());
                                paciente.setId(pessoaencontrar.getId());
                                paciente.setContarPessoas(paciente.getContarPessoas() - 1);
                                hospital.getListaPessoas().replace(paciente.getId(), paciente);
                                hospital.addPaciente((Paciente) paciente);
                            }
                        }
                        break;
                    case "EnfermeiroChefe":
                        if(gerador.nextBoolean()){
                            Scanner anonascimento = new Scanner(System.in);
                            System.out.println("Insere o ano de nascimento de um infetado: ");
                            Pessoa paciente = new Paciente(anonascimento.nextInt());
                            paciente.setId(pessoaencontrar.getId());
                            paciente.setContarPessoas(paciente.getContarPessoas() - 1);
                            hospital.getListaPessoas().replace(paciente.getId(), paciente);
                            hospital.addPaciente((Paciente) paciente);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
    /**
     * relatorioHospitalar: imprime o relatorio hospitalar na consola
     * @param hospital 
     */
    public void relatorioHospitalar(Hospital hospital)
    {
        System.out.println(hospital.getRelatorio());
    }
    /**
     * sairAplicacao: passar a variavel de instancia sair=false para sair=true;
     */
    public void sairAplicacao(){
        setSair(true);
    }
    //getters e setters
    /**
     * Getter da variável de instância sair
     * @return 
     */
    public boolean getSair(){
        return sair;
    }
    /**
     * Setter da variável de instância sair
     * @param sair 
     */
    public void setSair(boolean sair){
        this.sair = sair;
    }
    //toString
    //equals
}

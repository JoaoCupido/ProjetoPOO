/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
import java.util.Scanner;
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
                    pacientesEsperanoHospital();
                    break;
                case 11:
                    System.out.println("\nEscolhido a opção Atirar Pedidos para Enfermeiros-Auxiliares para a Trituradora...\n");
                    atribuirPedidosEnfAuxTrituradora();
                    break;
                case 12:
                    System.out.println("\nEscolhido a opção Virus Outbreak...\n");
                    outBreak();
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
        hospital.getListaPessoas().add(enfermeiroespecialista); //adicionar enfermeiroespecialista à lista de pessoas no hospital 
    }
    
    public void criarEnfermeiroAuxiliar(Hospital hospital)
    {
        String nome;
        Scanner inserirnome = new Scanner(System.in);
        System.out.println("Insere o nome: ");
        nome = inserirnome.next();
        Pessoa enfermeiroauxiliar = new EnfermeiroAuxiliar(nome, 0);
        hospital.getListaPessoas().add(enfermeiroauxiliar); //adicionar enfermeiroauxiliar à lista de pessoas no hospital 
    }
    
    public void criarNovoPaciente(Hospital hospital)
    {
        int anonascimento;
        Scanner inserirano = new Scanner(System.in);
        System.out.println("Insere o ano de nascimento: ");
        anonascimento = inserirano.nextInt();
        Pessoa paciente = new Paciente(anonascimento);
        hospital.getListaPessoas().add(paciente); //adicionar paciente à lista de pessoas no hospital
    }
    
    public void promoverEnfermeiroChefe(Hospital hospital)
    {
        for(int i = 0; i < hospital.getListaPessoas().size(); i++) {
            if((hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroEspecialista")){
                EnfermeiroEspecialista enfermeiroespecialista = (EnfermeiroEspecialista) hospital.getListaPessoas().get(i);
                if(enfermeiroespecialista.getAnosCarreira() >= hospital.getAnosCarreiraMinimo()){
                    EnfermeiroChefe enfermeirochefe = (EnfermeiroChefe) enfermeiroespecialista; //ERRO AQUI!
                    //ERRO: class BaseDeDadosHospitalarDeDoencasInfectocontagiosas.EnfermeiroEspecialista cannot be cast to class BaseDeDadosHospitalarDeDoencasInfectocontagiosas.EnfermeiroChefe
                    hospital.getListaPessoas().set(i, enfermeirochefe);
                }
            }
        }
    }
    
    public void aumentarAnosCarreira(Hospital hospital)
    {
        for(int i = 0; i < hospital.getListaPessoas().size(); i++) {
            if((hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroEspecialista") || (hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroAuxiliar") || (hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroChefe")){
                Enfermeiro enfermeiro = (Enfermeiro) hospital.getListaPessoas().get(i);
                int novoanocarreira = enfermeiro.getAnosCarreira() + 1;
                enfermeiro.setAnosCarreira(novoanocarreira);
                hospital.getListaPessoas().set(i, enfermeiro);
            }
        }
    }
    
    public void listarEnfermeiros(Hospital hospital)
    {
        for(int i = 0; i < hospital.getListaPessoas().size(); i++) {
            if((hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroEspecialista")){
                EnfermeiroEspecialista enfermeiroespecialista = (EnfermeiroEspecialista) hospital.getListaPessoas().get(i);
                System.out.println(enfermeiroespecialista);
            }
            else if((hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroAuxiliar")){
                EnfermeiroAuxiliar enfermeiroauxiliar = (EnfermeiroAuxiliar) hospital.getListaPessoas().get(i);
                System.out.println(enfermeiroauxiliar);
            }
            else if((hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("EnfermeiroChefe")){
                EnfermeiroChefe enfermeirochefe = (EnfermeiroChefe) hospital.getListaPessoas().get(i);
                System.out.println(enfermeirochefe);
            }
        }
    }
    
    public void listarMedicos(Hospital hospital)
    {
        for(int i = 0; i < hospital.getListaPessoas().size(); i++) {
            if((hospital.getListaPessoas().get(i).getClass().getSimpleName()).equals("Medico")){
                Medico medico = (Medico) hospital.getListaPessoas().get(i);
                System.out.println(medico);
            }
        }
    }
    
    public void pedidosEnfermeirosAuxiliares()
    {
        
    }
    
    public void pacientesEsperanoHospital()
    {
        
    }
    
    public void atribuirPedidosEnfAuxTrituradora()
    {
        
    }
    
    public void outBreak()
    {
       
    }
    
    public void relatorioHospitalar()
    {
        
    }
    
    public void sairAplicacao(){
        setSair(true);
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

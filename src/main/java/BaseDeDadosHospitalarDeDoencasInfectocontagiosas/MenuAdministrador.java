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
    //construtor
    public MenuAdministrador(){
        
    }
    //metodos
    
    public void menuOpcoes(Hospital hospital){
        int opcao;
        System.out.println("***SubMenu Medico***");
        System.out.println("1) Criar Medico");
        System.out.println("2) Criar Enfermeiro-Especialista");
        System.out.println("3) Criar Enfermeiro-Auxiliar");
        System.out.println("4) Criar Novo Paciente");
        System.out.println("5) Criar Enfermeiro-Auxiliar"+"\n");
        System.out.println("6) Aumentar anos de carreria"+"\n");
        System.out.println("7) Listar Enfermeiros"+"\n");
        System.out.println("8) Listar Médicos"+"\n");
        System.out.println("9) Listar Pedidos para Enfermeiros Auxiliares"+"\n");
        System.out.println("10) Listar Pacientes em espera no Hospital"+"\n");
        System.out.println("11) Atirara Pedidos para Enfermeiros Auxiliares para a Trituradora"+"\n");
        System.out.println("12) Virus Outbreak"+"\n");
        System.out.println("13) Relatorio Hospitalar"+"\n");
        System.out.println("14) Sair"+"\n");
        Scanner escolha = new Scanner(System.in);
        System.out.println("Digite uma opcao. Digite nenhuma das opcoes apresentadas para sair do programa: ");
        opcao = escolha.nextInt();

        switch(opcao)
            {
                case 1:
                    criarMedico((Hospital) hospital);
                    break;
                case 2:
                    criarEnfermeiroEspecialista((Hospital) hospital);
                    break;
                case 3:
                    criarEnfermeiroAuxiliar((Hospital) hospital);
                    break;
                case 4:
                    criarNovoPaciente((Hospital) hospital);
                    break;
                case 5:
                    promoverEnfermeiroChefe((Hospital) hospital);
                    break;
                case 6:
                    aumentarAnosCarreira((Hospital) hospital);
                    break;
                case 7:
                    listarEnfermeiros((Hospital) hospital);
                    break;
                case 8:
                    listarMedicos((Hospital) hospital);
                    break;
                case 9:
                    pedidosEnfermeirosAuxiliares();
                    break;
                case 10:
                    pacientesEsperanoHospital();
                    break;
                case 11:
                    atribuirPedidosEnfAuxTrituradora();
                    break;
                case 12:
                    outBreak();
                    break;
                case 13: 
                    relatorioHospitalar();
                    break;
                case 14: 
                    sairAplicacao();
                    break;
 
                default:
                    
                    break;
            }
    }
    
    public void criarMedico(Hospital hospital)
    {
        Pessoa medico = new Medico();
        hospital.listaPessoas.add(medico); //adicionar medico à lista de pessoas no hospital
        
    }
    
    public void criarEnfermeiroEspecialista(Hospital hospital)
    {
        String nome;
        Scanner inserirnome = new Scanner(System.in);
        System.out.println("Insere o nome: " + "\n");
        nome = inserirnome.next();
        Pessoa enfermeiroespecialista = new EnfermeiroEspecialista(nome, 0);
        hospital.listaPessoas.add(enfermeiroespecialista); //adicionar enfermeiroespecialista à lista de pessoas no hospital 
        
}
    
    public void criarEnfermeiroAuxiliar(Hospital hospital)
    {
        String nome;
        Scanner inserirnome = new Scanner(System.in);
        System.out.println("Insere o nome: " + "\n");
        nome = inserirnome.next();
        Pessoa enfermeiroauxiliar = new EnfermeiroAuxiliar(nome, 0);
        hospital.listaPessoas.add(enfermeiroauxiliar); //adicionar enfermeiroauxiliar à lista de pessoas no hospital 
        
    }
    
    public void criarNovoPaciente(Hospital hospital)
    {
        int anonascimento;
        Scanner inserirano = new Scanner(System.in);
        System.out.println("Insere o ano de nascimento: " + "\n");
        anonascimento = inserirano.nextInt();
        Pessoa paciente = new Paciente(anonascimento);
        hospital.listaPessoas.add(paciente); //adicionar paciente à lista de pessoas no hospital
    }
    
    public void promoverEnfermeiroChefe(Hospital hospital)
    {
        for(int i = 0; i < hospital.listaPessoas.size(); i++) {
            if((hospital.listaPessoas.get(i).getClass().getName()).equals("EnfermeiroEspecialista")){
                EnfermeiroEspecialista enfermeiroespecialista = (EnfermeiroEspecialista) hospital.listaPessoas.get(i);
                if(enfermeiroespecialista.getAnosCarreira() >= hospital.getAnosCarreiraMinimo()){
                    EnfermeiroChefe enfermeirochefe = (EnfermeiroChefe) enfermeiroespecialista;
                    hospital.listaPessoas.set(i, enfermeirochefe);
                }
            }
        }
    }
    
    public void aumentarAnosCarreira(Hospital hospital)
    {
        for(int i = 0; i < hospital.listaPessoas.size(); i++) {
            if((hospital.listaPessoas.get(i).getClass().getName()).equals("EnfermeiroEspecialista") || (hospital.listaPessoas.get(i).getClass().getName()).equals("EnfermeiroAuxiliar") || (hospital.listaPessoas.get(i).getClass().getName()).equals("EnfermeiroChefe")){
                Enfermeiro enfermeiro = (Enfermeiro) hospital.listaPessoas.get(i);
                int novoanocarreira = enfermeiro.getAnosCarreira() + 1;
                enfermeiro.setAnosCarreira(novoanocarreira);
                hospital.listaPessoas.set(i, enfermeiro);
            }
        }
    }
    
    public void listarEnfermeiros(Hospital hospital)
    {
        for(int i = 0; i < hospital.listaPessoas.size(); i++) {
            if((hospital.listaPessoas.get(i).getClass().getName()).equals("EnfermeiroEspecialista")){
                EnfermeiroEspecialista enfermeiroespecialista = (EnfermeiroEspecialista) hospital.listaPessoas.get(i);
                System.out.println(enfermeiroespecialista);
            }
            else if((hospital.listaPessoas.get(i).getClass().getName()).equals("EnfermeiroAuxiliar")){
                EnfermeiroAuxiliar enfermeiroauxiliar = (EnfermeiroAuxiliar) hospital.listaPessoas.get(i);
                System.out.println(enfermeiroauxiliar);
            }
            else if((hospital.listaPessoas.get(i).getClass().getName()).equals("EnfermeiroChefe")){
                EnfermeiroChefe enfermeirochefe = (EnfermeiroChefe) hospital.listaPessoas.get(i);
                System.out.println(enfermeirochefe);
            }
        }
    }
    
    public void listarMedicos(Hospital hospital)
    {
        for(int i = 0; i < hospital.listaPessoas.size(); i++) {
            if((hospital.listaPessoas.get(i).getClass().getName()).equals("Medico")){
                Medico medico = (Medico) hospital.listaPessoas.get(i);
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
        
    }
    //getters e setters
    //toString
    //equals
}

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
    //metodos
    
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
    
    public void aumentarAnosCarreira()
    {
        
    }
    
    public void listarEnfermeiros()
    {
        
    }
    
    public void listarMedicos()
    {
        
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

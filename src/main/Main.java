package main;

import java.util.ArrayList;
import java.util.Scanner;
import models.Pessoa;
import models.Telefone;

public class Main{

    static Scanner sc = new Scanner(System.in);

	/**
     *  Base de dados dos objetos de {@link Pessoa}.
     */
	static ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
    
    /**
     * QuestÃ£o: Fazer um CRUD de Contatos, utilizando as classes {@link Pessoa} e 
     * {@link Endereco} criadas no pacote 'models'. VocÃª deve fazer os ajustes necessÃ¡rios 
     * par isso. Tente nÃ£o copiar o exemplo da sala de aula. Mas pode sim usÃ¡-lo como referÃªncia. 
     */
    public static void main(String[] args) {
    	boolean quiserContinuar = true;
		while (quiserContinuar) {
			imprimirMenu();
			int opcao = coletarOpcao();
			switch (opcao) {
			case 0:
				quiserContinuar =querExecutar();
				break;
			case 1: // adicionar pessoa
				System.out.println("adicionando pessoa!!!");
				pessoa.add(criarPessoa());
				
				break;
			case 2: // remover pessoa
				ImprimirLista();
				int rm = opcaoRemover();
				pessoa.remove(rm);
				System.out.println("Usuario removido com sucesso");
				
				
				break;
			case 3: // alterar pessoa
				ImprimirLista();
				int posicao = coletarOpcao();
				 alterarPessoa(posicao);
				
				break;
			case 4: // recuperar pessoa
				ImprimirLista();
				int busc = opcaoBuscar();
				buscarPessoa(busc);
				break;
			case 5: // imprimir lista
				 ImprimirLista();
				 quiserContinuar =querExecutar();
				break;
			default:
				System.out.println("Escolha outra opção!");
				break;
			}
		}
		System.out.println("Obrigado por usar!");
		sc.close();
    }
    public static void imprimirMenu(){
    	StringBuilder st = new StringBuilder();
    	st.append("\nMenu do programa!!!!\n");
    	st.append("1 - Adiciona pessoa\n");
    	st.append("2 - Remover pessoa\n");
    	st.append("3 - Alterar  pessoa\n");
    	st.append("4 - Buscar pessoa\n");
    	st.append("5 - Imprimir lista de pessoas\n");
    	st.append("0 - Sair\n");
    	System.out.println(st.toString());
    	
    }
 
     
     public static Pessoa criarPessoa() {
    	 String pessoa = coletarPessoa();
    	 double CPF = coletarCPF();
    	  byte DDD = coletarDDD();
    	 int  numero = coletarTelefone();
    	 return new Pessoa(pessoa,CPF,DDD,numero);
     }
    		
     private static String coletarPessoa() { 

    	 System.out.println("Informe  o nome da pessoa: ");
    	 String nome =sc.nextLine();
    	 
    	  return nome;
    	}
     private static double coletarCPF() {
    	 System.out.println("Informe o CPF da pessoa: ");
 		double CPF = Double.parseDouble(sc.nextLine());
 		return CPF;
     }
    public static byte coletarDDD() {
    	
    	 System.out.println("Informe o DDD da pessoa: ");
  		byte DDD = Byte.parseByte(sc.nextLine());
  		return DDD;
     }
     public static int coletarTelefone() {
    	 System.out.println("Informe o Numero para contato da pessoa: ");
  		int telefone =  Integer.parseInt(sc.nextLine());
  	
  		return telefone;
     
     }	
   
     /**
      * Metodo para Imprimir uma lista de pessoas cadastrada .
      */
     public static void ImprimirLista() {
			if(pessoa.isEmpty()) {
				System.out.println("LIsta vazia");
			}else {
			System.out.println("-----Lista de Pessoas-----");
			int i = 0;
			for(Pessoa tmp: pessoa ) {
				System.out.println("----------------------");
				System.out.println("Nome "+i+": " +tmp.getNome()+ "\nCPF: "+tmp.getCPF()+"\nTelefone:("+tmp.getDDD()+")"+tmp.getNumero());
				System.out.println(" ");
				i++;
			 }
			}
		}
    
     public static int  coletarOpcao(){ //Coleta opção para entra no laço.
       	 
       	 System.out.println("informe um numero:");
       	 int opcao = Integer.parseInt(sc.nextLine());
       	 return opcao;    	
       }
     /**
		 * Metodo para buscar um usuario cadastrado
		 * @param opcao
		 */
		public static void buscarPessoa(int opcao) {
	      
			System.out.println("\n");
			Pessoa posicao = pessoa.get(opcao);
			System.out.println("Aluno selecinado:\n Nome: "+ posicao.getNome()+" CPF "+  posicao.getCPF()+"Telefone: ("+posicao.getDDD()+")"+posicao.getNumero());
		}
		public static int opcaoRemover() { // coleta opção para remover um usuario.
			int opcao;
			System.out.print("Informe o numero da pessoa que deseja remover: ");
	    	 opcao = Integer.parseInt(sc.nextLine());
	    	 return opcao;
		}
        public static int opcaoBuscar() {  // coleta opção para buscar um usuario.
         int opcao;
         System.out.print("Informe o numero da pessoa que deseja Buscar: ");
	    	 opcao = Integer.parseInt(sc.nextLine());
	    	 return opcao;
        }
        /**
         * Metodo para alterar Qualquer valor adicionado na lista.
         * @param posicao
         */
        public static void alterarPessoa(int posicao) {
    		System.out.print("oque deseja alterar? 1) Nome 2)CPF 3) DDD 4)Numero 5)Todos");
    		int opcao = coletarOpcao();
    		String novoNome;
    		Pessoa alterado = pessoa.get(posicao);
    		double novoCPF;
    		byte novoDDD;
    		int novoNumero;
    		switch(opcao) {
    		case 1:
    			novoNome = coletarPessoa();
    			alterado.setNome(novoNome); 
    			break;
    		case 2:
    			novoCPF = coletarCPF();
    			alterado.setCPF(novoCPF); 
    			break;
    		case 3:
    			novoDDD = coletarDDD();
    			alterado.setDDD(novoDDD);
    			break;
    		case 4:
    			novoNumero = coletarTelefone();
    			alterado.setNumero(novoNumero);
    			break;
    		case 5:
    			novoNome = coletarPessoa();
    			novoCPF = coletarCPF();
    			novoDDD = coletarDDD();
    			novoNumero = coletarTelefone();
    			alterado.setNome(novoNome);
    			alterado.setCPF(novoCPF); 
    			alterado.setDDD(novoDDD);
    			alterado.setNumero(novoNumero);
    			break;
    			default: 
    				System.out.println("Valor Invalido");
    		}	
    	}
       
        
        public static boolean querExecutar(){
			System.out.println("Deseja Continuar(sim/nao) ?");
			String resposta = sc.nextLine();
			return resposta.toLowerCase().equals("sim") ? true :false;
		}
		
              
}
package application;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import models.Funcionario;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale localeBR = new Locale("pt","BR");
		List<Funcionario> listaFuncionarios = new ArrayList<>();
		
//		DataNascimentos
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
			NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
			
//		3.1 Inserindo dados dos funcionarios
			listaFuncionarios.add(new Funcionario("Maria",LocalDate.of(2000, 10, 18),2009.44,"Operador"));
			listaFuncionarios.add(new Funcionario("João",LocalDate.of(1990, 5, 12),2284.38,"Operador"));
			listaFuncionarios.add(new Funcionario("Caio",LocalDate.of(1961, 5, 2),9836.14,"Coordenador"));
			listaFuncionarios.add(new Funcionario("Miguel",LocalDate.of(1988, 10, 14),19119.88,"Diretor"));
			listaFuncionarios.add(new Funcionario("Alice",LocalDate.of(1995, 1, 5),2234.68,"Recepcionista"));
			listaFuncionarios.add(new Funcionario("Heitor",LocalDate.of(1999, 11, 19),1582.72,"Operador"));
			listaFuncionarios.add(new Funcionario("Arthur",LocalDate.of(1993, 3, 31),4071.84,"Contador"));
			listaFuncionarios.add(new Funcionario("Laura",LocalDate.of(1994, 7, 8),3017.45,"Gerente"));
			listaFuncionarios.add(new Funcionario("Heloísa",LocalDate.of(2003, 5, 24),1606.85,"Eletricista"));
			listaFuncionarios.add(new Funcionario("Helena",LocalDate.of(1996, 9, 2),2799.93,"Gerente"));
		
//		3.2 remover joao
		for (Funcionario funcionario: listaFuncionarios) {

		       if (funcionario.nome.equals("João")) {
		    	   listaFuncionarios.remove(funcionario);
		    	   break;
		       }
		 }
		
//		3.3 print com dinheiro e dataNascimento formatadas
		System.out.println();

		System.out.println("-------------------------------------------------------------------");
		System.out.println("|                       Print  funcionarios                       |");
		System.out.println("-------------------------------------------------------------------");

		for(int i =0;listaFuncionarios.size() > i; i++) {
			imprimirDados(listaFuncionarios.get(i).nome,listaFuncionarios.get(i).dataNascimento,listaFuncionarios.get(i).salario,listaFuncionarios.get(i).funcao);

		}
		System.out.println();

		System.out.println("-------------------------------------------------------------------");
		System.out.println("|                        Aumento de 10%                           |");
		System.out.println("-------------------------------------------------------------------");

//		3.4 Aumento de 10%
		for(int i =0;listaFuncionarios.size() > i; i++) {
			listaFuncionarios.get(i).salario =  (listaFuncionarios.get(i).salario * 110) / 100  ;

			imprimirDados(listaFuncionarios.get(i).nome,listaFuncionarios.get(i).dataNascimento,listaFuncionarios.get(i).salario,listaFuncionarios.get(i).funcao);

		}
		
//		 3.5 e 3.6 Não soube fazer
		
		System.out.println();

		System.out.println("-------------------------------------------------------------------");
		System.out.println("|                    aniversario dia 10 e 12                      |");
		System.out.println("-------------------------------------------------------------------");

//		3.8 Imprimir quem faz aniversario dia 10 e 12
		for(int i =0;listaFuncionarios.size() > i; i++) {
			if(listaFuncionarios.get(i).dataNascimento.getMonthValue() == 10 || listaFuncionarios.get(i).dataNascimento.getMonthValue() == 11) {
				
			imprimirDados(listaFuncionarios.get(i).nome,listaFuncionarios.get(i).dataNascimento,listaFuncionarios.get(i).salario,listaFuncionarios.get(i).funcao);
			
			}
		}
		System.out.println();

		System.out.println("-------------------------------------------------------------------");
		System.out.println("|                           MAIOR IDADE                           |");
		System.out.println("-------------------------------------------------------------------");

//		3.9 Imprimir funcionario com maior idade
		int maiorIdade = 9999;
		
//		Descobrir o ano
		for(int i =0;listaFuncionarios.size() > i; i++) {
			if(listaFuncionarios.get(i).dataNascimento.getYear() < maiorIdade) {
				maiorIdade = listaFuncionarios.get(i).dataNascimento.getYear();
			}
		}
		for(int i =0;listaFuncionarios.size() > i; i++) {
			if(listaFuncionarios.get(i).dataNascimento.getYear() == maiorIdade) {				
				System.out.printf(
						"%s %s",
						listaFuncionarios.get(i).nome,
						listaFuncionarios.get(i).dataNascimento.format(formatter));
				
				System.out.println();
			}
		}
		System.out.println();

		System.out.println("-------------------------------------------------------------------");
		System.out.println("|                         Ordem alfabetica                        |");
		System.out.println("-------------------------------------------------------------------");

		
//		3.10 Por ordem alfabetica
        Collections.sort(listaFuncionarios, Comparator.comparing(Funcionario::getNome));
        for(int i =0;listaFuncionarios.size() > i; i++) {

			imprimirDados(listaFuncionarios.get(i).nome,listaFuncionarios.get(i).dataNascimento,listaFuncionarios.get(i).salario,listaFuncionarios.get(i).funcao);


		}
		System.out.println();

        System.out.println("-------------------------------------------------------------------");
		System.out.println("|                         Total de salarios                       |");
		System.out.println("-------------------------------------------------------------------");

//		3.11 Total dos salarios
		double total = 0;
		  for(int i =0;listaFuncionarios.size() > i; i++) {
				total += listaFuncionarios.get(i).salario;
		}
		String formattedTotal = dinheiro.format(total);

		  System.out.println(formattedTotal);
		  
		  
			System.out.println();
		    System.out.println("-------------------------------------------------------------------");
			System.out.println("|               Quantos salarios minimos ganha cada               |");
			System.out.println("-------------------------------------------------------------------");

			
			
//			3.12 quantos salarios minimos ganha cada funcionario
			double salarioMinimo = 1212.00;
			double result = 0;
		      for(int i =0;listaFuncionarios.size() > i; i++) {
		    	   result = listaFuncionarios.get(i).salario / salarioMinimo;
					BigDecimal valorFormatado = new BigDecimal(result).setScale(1, RoundingMode.HALF_UP);

					System.out.printf(
							"%s %s",
							listaFuncionarios.get(i).nome,
							valorFormatado);
					
					System.out.println();

				}


	}
	public static void imprimirDados(String nome,LocalDate dataNascimento, double salario, String funcao) {
		Locale localeBR = new Locale("pt","BR");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 

		NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

		String formattedNumber = dinheiro.format(salario);

		System.out.printf(
				"%s %s %s %s",
				nome,
				dataNascimento.format(formatter),
				formattedNumber,
				funcao);
		
		System.out.println();
	}

}

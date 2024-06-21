package models;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends pessoa {
	public String funcao;
	public double salario;

	BigDecimal valorFormatado = new BigDecimal(salario).setScale(2, RoundingMode.HALF_UP);
	
	public Funcionario(String nome,LocalDate dataNascimento, double salario,String funcao) {
		super(nome,dataNascimento);
		this.funcao = funcao;
		this.salario = salario;
	}
	
	

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
	
}

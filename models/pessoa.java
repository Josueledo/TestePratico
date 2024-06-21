package models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class pessoa {

	
	public String nome;
	public LocalDate dataNascimento;
	
	public pessoa(String nome, LocalDate dataNascimento) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = formatter.format(dataNascimento);

		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}

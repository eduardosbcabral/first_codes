package model;

public class Disciplina {
	
	private int id_disciplina;
	private int id_professor;
	private String nome;
	private String curso;
	private String carga_horaria;
	
	public Disciplina (int id_disciplina, String nome, String curso, String carga_horaria){
		this.id_disciplina = id_disciplina;
		this.nome = nome;
		this.curso = curso;
		this.carga_horaria = carga_horaria;
	}

	public int getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	
	
}

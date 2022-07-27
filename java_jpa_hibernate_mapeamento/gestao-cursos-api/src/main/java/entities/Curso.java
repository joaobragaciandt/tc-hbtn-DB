package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String sigla;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="materialcurso_id")
    private MaterialCurso materialCurso;

    @OneToMany(mappedBy = "curso")
    private List<Professor> listaProfessores;

    @ManyToMany(mappedBy = "cursos",cascade = CascadeType.ALL)
    List<Aluno> alunos;


    public Curso() {
    }

    public Curso(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        this.alunos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(List<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public MaterialCurso getMaterialCurso() {
        return materialCurso;
    }

    public void setMaterialCurso(MaterialCurso materialCurso) {
        this.materialCurso = materialCurso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}

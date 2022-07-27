package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue
    private Long id;
    private String nomeCompleto;
    private String matricula;
    private LocalDate nascimento;
    private String email;

    @OneToMany(mappedBy = "aluno")
    List<Telefone> listaTelefones;

    @OneToMany(mappedBy = "aluno")
    List<Endereco> listaEnderecos;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "aluno_curso",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    List<Curso> cursos;


    public Aluno() {
    }

    public Aluno(String nomeCompleto, String matricula, LocalDate nascimento, String email) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.nascimento = nascimento;
        this.email = email;
        this.listaTelefones = new ArrayList<>();
        this.listaEnderecos = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public List<Telefone> getListaTelefones() {
        return listaTelefones;
    }

    public void setListaTelefones(List<Telefone> listaTelefones) {
        this.listaTelefones = listaTelefones;
    }

    public List<Endereco> getListaEnderecos() {
        return listaEnderecos;
    }

    public void setListaEnderecos(List<Endereco> listaEnderecos) {
        this.listaEnderecos = listaEnderecos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getListatelefones() {
        return listaTelefones;
    }

    public void setListatelefones(List<Telefone> listatelefones) {
        this.listaTelefones = listatelefones;
    }
}

package entities;

import javax.persistence.*;

@Entity
public class Professor {

    @Id
    @GeneratedValue
    public Long id;

    private String nomeCompleto;
    private String matricula;
    private String email;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Professor() {
    }

    public Professor(String nomeCompleto, String matricula, String email, Curso curso) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.email = email;
        this.curso = curso;
    }

}

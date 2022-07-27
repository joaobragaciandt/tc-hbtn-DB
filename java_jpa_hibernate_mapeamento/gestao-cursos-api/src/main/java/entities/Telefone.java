package entities;

import javax.persistence.*;

@Entity
public class Telefone {
    @Id
    @GeneratedValue
    private Long id;
    private String DDD;
    private String numero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="aluno_id",nullable = false)
    private Aluno aluno;

    public Telefone() {
    }

    public Telefone(String DDD, String numero, Aluno aluno) {
        this.DDD = DDD;
        this.numero = numero;
        this.aluno = aluno;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

}

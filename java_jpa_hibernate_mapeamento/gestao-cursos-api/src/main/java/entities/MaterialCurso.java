package entities;

import javax.persistence.*;

@Entity
public class MaterialCurso {

    @Id
    @GeneratedValue
    private Long id;

    private String url;

    @OneToOne(mappedBy = "materialCurso",cascade = CascadeType.ALL)
    private Curso curso;


    public MaterialCurso() {
    }

    public MaterialCurso(String url, Curso curso) {
        this.url = url;
        this.curso = curso;
    }
}

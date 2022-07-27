package demo;


import entities.*;
import models.AlunoModel;
import models.CursoModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(1997,02,17);
        Aluno aluno = new Aluno("nometeste","matteste",localDate,"teste@gmail.com");
        Curso curso = new Curso("nomeCurso","siglaCurso");
        Endereco endereco = new Endereco("logradouro1","endereco1","numero1","bairro1","cidade1"
                ,"cidade1",48503023,aluno);
        MaterialCurso materialCurso = new MaterialCurso("curso.com",curso);
        Professor professor = new Professor("professor1","312412312","prof@gmail.com",curso);
        Telefone telefone = new Telefone("87","123123",aluno);

        List<Endereco> listaEnderecos = List.of(endereco);
        List<Professor> listaProfessor = List.of(professor);
        List<Telefone> listaTelefone = List.of(telefone);

        aluno.setListaEnderecos(listaEnderecos);
        aluno.setListatelefones(listaTelefone);

        curso.setMaterialCurso(materialCurso);
        curso.setListaProfessores(listaProfessor);
        curso.setMaterialCurso(materialCurso);

        List<Curso> listaCursos = List.of(curso);
        List<Aluno> listaAlunos = List.of(aluno);

        aluno.setCursos(listaCursos);
        curso.setAlunos(listaAlunos);

        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        alunoModel.create(aluno);

        List<Aluno> listaAlunos1 = alunoModel.findAll();
        System.out.println("Qtde de alunos encontrados: " + listaAlunos1.size());

        Aluno aluno1 = alunoModel.findById(aluno.getId());
        System.out.println("Aluno eh: " + aluno1.getEmail());

        aluno.setEmail("mudouemail@hotmail.com");
        aluno.setMatricula("00000001");

        alunoModel.update(aluno);
        System.out.println("Aluno novo eh: " + aluno.getEmail());

        //alunoModel.delete(aluno);

        Curso curso2 = new Curso("nomeCurso2","siglaCurso2");

        cursoModel.create(curso2);

        List<Curso> listaCurso1= cursoModel.findAll();
        System.out.println("Qtde de alunos encontrados: " + listaCurso1.size());
        Curso curso1 = cursoModel.findById(curso2.getId());
        System.out.println("Aluno eh: " + curso1.getSigla());

        curso.setNome("cursoMudouNome");
        curso.setSigla("CMN");

        cursoModel.update(curso2);
        System.out.println("Aluno novo eh: " + curso.getSigla());

        //cursoModel.delete(curso2);

    }
}

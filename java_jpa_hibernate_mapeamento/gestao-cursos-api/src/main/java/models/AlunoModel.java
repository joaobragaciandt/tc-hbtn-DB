package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class AlunoModel {

    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
           /* em.persist(aluno.getListaTelefones());
            em.persist(aluno.getListaEnderecos());*/
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno buscaAluno = null;
        try {
            System.out.println("Iniciando a transação");
            buscaAluno =  em.find(Aluno.class,id);
            System.out.println("Aluno encontrado com sucesso !!!");
            
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar o Aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return buscaAluno;
    }

    public List<Aluno> findAll() {
        List<Aluno> alunos = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            TypedQuery<Aluno> consulta = em.createQuery("SELECT a FROM Aluno a",Aluno.class);
            alunos.addAll(consulta.getResultList());
            System.out.println("Alunos encontrados com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar o Aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return alunos;
    }

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Aluno buscaAluno =  em.find(Aluno.class,aluno.getId());
            buscaAluno.setNomeCompleto(aluno.getNomeCompleto());
            buscaAluno.setMatricula(aluno.getMatricula());
            buscaAluno.setNascimento(aluno.getNascimento());
            buscaAluno.setEmail(aluno.getEmail());
            /*buscaAluno.setListatelefones(aluno.getListatelefones());
            buscaAluno.setListaEnderecos(aluno.getListaEnderecos());
            buscaAluno.setCursos(aluno.getCursos());*/

            em.getTransaction().commit();
            System.out.println("Aluno modificado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao modificar o Curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Aluno buscaAluno =  em.find(Aluno.class,aluno.getId());
            em.remove(buscaAluno);
            em.getTransaction().commit();
            System.out.println("Aluno deletado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar o Aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }
}
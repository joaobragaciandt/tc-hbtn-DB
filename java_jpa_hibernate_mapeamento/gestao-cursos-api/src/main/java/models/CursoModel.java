package models;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CursoModel {

    public void create(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();

            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("curso criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            Curso buscaCurso =  em.find(Curso.class,id);
            System.out.println("Curso encontrado com sucesso !!!");
            if(buscaCurso != null) {
                return buscaCurso;
            }
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar o Curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return null;
    }

    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            TypedQuery<Curso> consulta = em.createQuery("SELECT c FROM Curso c",Curso.class);
            cursos.addAll(consulta.getResultList());
            System.out.println("cursos encontrados com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return cursos;
    }

    public void update(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Curso buscaCurso=  em.find(Curso.class,curso.getId());
            buscaCurso.setNome(curso.getNome());
            buscaCurso.setSigla(curso.getSigla());
            //buscaCurso.setMaterialCurso(curso.getMaterialCurso());
            /*buscaCurso.setAlunos(curso.getAlunos());
            buscaCurso.setListaProfessores(buscaCurso.getListaProfessores());*/

            em.getTransaction().commit();
            System.out.println("curso modificado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao modificar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Curso buscaCurso =  em.find(Curso.class,curso.getId());
            em.remove(buscaCurso);
            em.getTransaction().commit();
            System.out.println("curso deletado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }
}

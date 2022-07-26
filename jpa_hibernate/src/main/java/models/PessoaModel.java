package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    public void create(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Pessoa buscaP =  em.find(Pessoa.class,p.getId());
            buscaP.setNome(p.getNome());
            buscaP.setCpf(p.getCpf());
            buscaP.setDataNascimento(p.getDataNascimento());
            buscaP.setEmail(p.getEmail());
            buscaP.setIdade(p.getIdade());

            em.getTransaction().commit();
            System.out.println("Pessoa modificado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao modificar o Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Pessoa buscaP =  em.find(Pessoa.class,p.getId());
            em.remove(buscaP);
            em.getTransaction().commit();
            System.out.println("Pessoa deletado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar o Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Pessoa findById(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            Pessoa buscaP =  em.find(Pessoa.class,p.getId());
            System.out.println("Pessoa encontrado com sucesso !!!");
            if(buscaP != null) {
                return buscaP;
            }
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar o Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return null;
    }

    public List<Pessoa> findAll() {

        List<Pessoa> pessoas = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            TypedQuery<Pessoa> consulta = em.createQuery("SELECT p FROM Pessoa p",Pessoa.class);
            pessoas.addAll(consulta.getResultList());
            System.out.println("Pessoas encontrados com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar a Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return pessoas;
    }

}

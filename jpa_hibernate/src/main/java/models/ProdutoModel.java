package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    public void create(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Produto buscaP =  em.find(Produto.class,p.getId());
            buscaP.setNome(p.getNome());
            buscaP.setPreco(p.getPreco());
            buscaP.setQuantidade(p.getQuantidade());
            buscaP.setStatus(p.getStatus());
            em.getTransaction().commit();
            System.out.println("Produto modificado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao modificar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Produto buscaP =  em.find(Produto.class,p.getId());
            em.remove(buscaP);
            em.getTransaction().commit();
            System.out.println("Produto deletado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Produto findById(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            Produto buscaP =  em.find(Produto.class,p.getId());
            System.out.println("Produto encontrado com sucesso !!!");
            if(buscaP != null) {
                return buscaP;
            }
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return null;
    }

    public List<Produto> findAll() {

        List<Produto> produtos = new ArrayList<Produto>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            TypedQuery<Produto> consulta = em.createQuery("SELECT p FROM Produto p",Produto.class);
            produtos.addAll(consulta.getResultList());
            System.out.println("Produtos encontrados com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return produtos;
    }
}

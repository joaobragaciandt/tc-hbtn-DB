package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        Produto p2 = produtoModel.findById(p1);
        System.out.println("Produto é: " + p2.getNome());

        p1.setNome("Smart TV");
        p1.setPreco(400.0);
        produtoModel.update(p1);

        produtoModel.delete(p1);
        //------------------------------------------------
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Joao");
        pessoa1.setIdade(25);
        pessoa1.setDataNascimento(150297);
        pessoa1.setCpf("00000000");

        pessoaModel.create(pessoa1);

        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + pessoas.size());

        Pessoa pessoa2 = pessoaModel.findById(pessoa1);
        System.out.println("Pessoa é: " + pessoa2.getNome());

        pessoa1.setNome("Mariana");
        pessoa1.setCpf("02406123122");
        pessoaModel.update(pessoa1);

        pessoaModel.delete(pessoa1);


    }
}

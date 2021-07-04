package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		
		Produto celular = new Produto();
		celular.setNome("Iphone 12");
		celular.setDescricao("Um celular incrivel");
		celular.setPreco(new BigDecimal ("5999"));
		
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("loja");
		
		//criando um objeto do tipo entity manager;
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin(); //em pega e inicia transação depois dispara o insert no banco;
		em.persist(celular);  //inserir meu objeto celular como registro no banco de dado;
		em.getTransaction().commit(); //comita a transação;
		em.close();// fecha a transação;
		
		
	}

}

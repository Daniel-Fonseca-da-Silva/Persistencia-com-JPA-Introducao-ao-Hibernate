package testes;

import modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProdutos {

    public static void main(String[] args) {
        Produto computador = new Produto();
        computador.setNome("Notebook Debian");
        computador.setDescricao("Computador moderno com sistema operacional debian");
        computador.setPreco(new BigDecimal("1500.99"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(computador);
        em.getTransaction().commit();
        em.close();

    }

}

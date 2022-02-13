package testes;

import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Pagamento;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProdutos {

    public static void main(String[] args) {
        Categoria computadores = new Categoria("Computador");
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(computadores);
        computadores.setNome("computador1");

        em.flush();
        em.clear();

        computadores = em.merge(computadores);
        computadores.setNome("computador2");
        em.flush();
        em.clear();
        em.remove(computadores);
        em.flush();

    }

}

package testes;

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
        Produto computador = new Produto("Notebook Debian", "Notebbok Debian", new BigDecimal("1500.99"), Categoria.INFORMATICA, Pagamento.PIX);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.cadastrar(computador);
        em.getTransaction().commit();
        em.close();

    }

}

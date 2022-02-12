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
        Produto computador = new Produto("Notebook Debian", "Notebbok Debian", new BigDecimal("1500.99"), computadores, Pagamento.PIX);
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(computadores);
        produtoDao.cadastrar(computador);
        em.getTransaction().commit();
        em.close();

    }

}

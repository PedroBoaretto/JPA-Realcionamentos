package com.example.ac1.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.ac1.models.Produto;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto inserir(Produto produto){
        entityManager.merge(produto);
        return produto;
    }

    public List<Produto> obterTodos(){
        return entityManager.createQuery("from Produto", Produto.class).getResultList();
    }
    
    @Transactional
public void excluir(long id) {
    Produto produto = entityManager.find(Produto.class, id);
    if (produto != null) {
        entityManager.remove(produto);
    }
}

    public Produto obterPorId (long id){
        return entityManager.find(Produto.class, id);
    }


}

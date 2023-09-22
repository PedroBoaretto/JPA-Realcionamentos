package com.example.ac1.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.ac1.models.CategoriaProduto;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaProduto inserir(CategoriaProduto categoriaProduto){
        entityManager.merge(categoriaProduto);
        return categoriaProduto;
    }

    public List<CategoriaProduto> obterTodos(){
        return entityManager.createQuery("from CategoriaProduto", CategoriaProduto.class).getResultList();
    }

    @Transactional
    public void excluir(CategoriaProduto categoriaProduto){
        if (!entityManager.contains(categoriaProduto)) {
            categoriaProduto = entityManager.merge(categoriaProduto);
        }
        entityManager.remove(categoriaProduto);
    }

    public CategoriaProduto obterPorId (long id){
        return entityManager.find(CategoriaProduto.class, id);
    }

    
}

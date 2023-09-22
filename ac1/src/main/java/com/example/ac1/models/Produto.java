package com.example.ac1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    
    @Column(length = 200, nullable = false)
    private String nome;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "categoriaProduto_id")
    private CategoriaProduto categoriaProduto;

    public Produto() {
    }

    public Produto(Long idProduto, String nome, int quantidade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Proutos [idProduto=" + idProduto + ", nome=" + nome + ", quantidade=" + quantidade + "]";
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }
    
    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

}

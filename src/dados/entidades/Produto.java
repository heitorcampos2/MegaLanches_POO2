/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.entidades;

/**
 *
 * @author david
 */
public class Produto {
    private Integer id_produto;
    private String nome_p;
    private Double preco_un;
    private String ingredientes;

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome_p;
    }

    public void setNome(String nome_p) {
        this.nome_p = nome_p;
    }

    public Double getPreco_un() {
        return preco_un;
    }

    public void setPreco_un(Double preco_un) {
        this.preco_un = preco_un;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    
}

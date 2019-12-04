package dados.entidades;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PedidoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedidoProduto;

    @ManyToOne(optional = false)
    private Produto produto;
    private BigDecimal preco;

    @ManyToOne(optional = false)
    private Pedido pedido;

    private Integer qtd;

    public PedidoProduto() {
    }
    
    public BigDecimal getPrecoMultiplicado(){
        return preco.multiply(new BigDecimal(qtd));
    }

    public PedidoProduto(Produto produto, BigDecimal preco, Pedido pedido, Integer qtd) {
        this.setProduto(produto);
        this.setPreco(preco);
        this.setPedido(pedido);
        this.setQtd(qtd);
    }

    public Integer getIdPedidoProduto() {
        return idPedidoProduto;
    }

    public void setIdPedidoProduto(Integer idPedidoProduto) {
        this.idPedidoProduto = idPedidoProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idPedidoProduto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidoProduto other = (PedidoProduto) obj;
        if (!Objects.equals(this.idPedidoProduto, other.idPedidoProduto)) {
            return false;
        }
        return true;
    }

}

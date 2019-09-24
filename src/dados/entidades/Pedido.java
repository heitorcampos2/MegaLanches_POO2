/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.entidades;

//import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author david
 */
public class Pedido {
    private Integer id_pedido;
    private LocalDateTime data_pedido;
    private Cliente cliente;

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public LocalDateTime getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDateTime data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
     
}

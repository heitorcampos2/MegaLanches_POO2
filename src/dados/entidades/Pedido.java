/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.entidades;

//import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class Pedido {
    private Integer id_pedido;
    private LocalDateTime data_pedido;
    private Cliente cliente;
    private List<Produto> produtos;

    
}

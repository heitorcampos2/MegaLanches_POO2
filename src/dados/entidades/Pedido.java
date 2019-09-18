/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.entidades;

//import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Pedido {
    private Integer id_pedido;
    private LocalDate data_pedido;
    private Cliente cliente;
    private ArrayList<Produto> produtos;

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceListaPedidos;

import exceptions.ListaCheiaException;
import exceptions.PedidoDuplicadoException;
import exceptions.PedidoNaoExisteException;
import listapedidos.Pedido;

/**
 *
 * @author bruna
 */
public interface InterfaceListaPedidos {
    
    public Pedido buscarPedido(int numPed);


    public void cadastrarPedido(Pedido p) throws PedidoDuplicadoException, ListaCheiaException;

    public void atenderPedido(int numPed) throws PedidoNaoExisteException; 


    public void relatorioCliente(int codCli, boolean todos, boolean atendidos);
  

    public void pagarVendedor(int codVend, double porcent);
    
}

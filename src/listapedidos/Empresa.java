/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listapedidos;

import exceptions.ListaCheiaException;
import exceptions.PedidoDuplicadoException;
import exceptions.PedidoNaoExisteException;

/**
 *
 * @author bruna
 */
public class Empresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pedido pedido01 = new Pedido(1, 1, 10, 100, false, false);
        Pedido pedido02 = new Pedido(2, 1, 10, 200, true, false);
        Pedido pedido03 = new Pedido(3, 1, 10, 3000, false, true);
        Pedido pedido04 = new Pedido(4, 2, 30, 3000, true, true);
        

        Pedido errIDrep = new Pedido(1, 2, 30, 3000, true, true); // repeti o id do pedido01
        Pedido errMax = new Pedido(4, 2, 30, 3000, true, true); // repeti o id do pedido01

        ListaPedidos listaPedidos = new ListaPedidos(3);

        try {
            listaPedidos.cadastrarPedido(pedido01);
            listaPedidos.cadastrarPedido(pedido02);
            listaPedidos.cadastrarPedido(pedido03);
            listaPedidos.cadastrarPedido(pedido04);
            
        } catch (PedidoDuplicadoException e1 ) {
            System.out.println("Exception: "+e1.getMessage());
        } catch(ListaCheiaException e2){
            System.out.println("Exception: "+e2.getMessage());
        };
        
        System.out.println("--- Buscar Pedido ---");
        Pedido aux = listaPedidos.buscarPedido(4);
        if(aux != null)
            System.out.println("Pedido "+aux.getNuameroPedido()+" encontrado");
        else
            System.out.println("Não encontrado");
        
        System.out.println("--- Buscar Pedido ---");
        aux = listaPedidos.buscarPedido(2);
        if(aux != null)
            System.out.println("Pedido "+aux.getNuameroPedido()+" encontrado");
        else
            System.out.println("Não encontrado");

        
        System.out.println("--- Atender Pedido ---");
        try{
            aux = listaPedidos.buscarPedido(1);
            System.out.println("pedido atendido-> "+ aux.isAtendido());
            listaPedidos.atenderPedido(1);
            System.out.println("pedido atendido-> "+ aux.isAtendido());
        }catch(PedidoNaoExisteException e){
            System.out.println("Exception: "+e.getMessage());
        };
        
        System.out.println("--- Relatorio Cliente ---"); 
        listaPedidos.relatorioCliente(1, false, false);
        
        
        System.out.println("--- Pagar Comissão ---");
        listaPedidos.pagarVendedor(10, 0.5);
    }
}

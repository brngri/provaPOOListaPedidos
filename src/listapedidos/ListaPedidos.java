/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listapedidos;

import exceptions.ListaCheiaException;
import exceptions.PedidoDuplicadoException;
import exceptions.PedidoNaoExisteException;
import interfaceListaPedidos.InterfaceListaPedidos;

/**
 *
 * @author bruna
 */
public class ListaPedidos implements InterfaceListaPedidos {

    private Pedido[] pedido;
    private int indiceAtual;

    public ListaPedidos(int max) {
        this.pedido = new Pedido[max];
        this.indiceAtual = 0;
    }

    @Override
    public Pedido buscarPedido(int numPed) {
        for (int i = 0; i < pedido.length; i++) {
            if (pedido[i].getNuameroPedido() == numPed && pedido[i] != null) {
                return pedido[i];
            }
        }
        return null;
    }

    @Override
    public void cadastrarPedido(Pedido p) throws PedidoDuplicadoException, ListaCheiaException {
        if (indiceAtual == pedido.length) {
            throw new ListaCheiaException("Lista Cheia, pedido não cadastrado");
        }

        for (int i = 0; i < pedido.length; i++) {
            if (pedido[i] != null && pedido[i].getNuameroPedido() == p.getNuameroPedido()) {
                throw new PedidoDuplicadoException("O pedido -> " + p.getNuameroPedido() + " já existe, , pedido não                            cadastradof");
            }
        }

        pedido[indiceAtual] = p;
        System.out.println("Pedido: " + pedido[indiceAtual].getNuameroPedido() + " cadastrado");
        indiceAtual++;
    }

    @Override
    public void atenderPedido(int numPed) throws PedidoNaoExisteException {
        Pedido pedido = buscarPedido(numPed);
        if (pedido != null) {
            pedido.setAtendido(true);
        } else {
            throw new PedidoNaoExisteException("Pedido não existe");
        }
    }

    @Override
    public void relatorioCliente(int codCli, boolean todos, boolean atendidos) {
        double total = 0;
        for (int i = 0; i < pedido.length; i++) {
            if (pedido[i].getCodCiente() == codCli) {

                if (todos == true) {

                    System.out.println("--- TODOS ---");
                    System.out.println("Pedido:" + pedido[i].getNuameroPedido() + ", valor: " + pedido[i].getValorPedido());
                    total += pedido[i].getValorPedido();

                } else {
                    if (atendidos == true) {
                        System.out.println("--- Atendidos ---");
                        if (pedido[i].isAtendido() == true) {
                            System.out.println("Pedido:" + pedido[i].getNuameroPedido() + ", valor: " + pedido[i].getValorPedido());
                            total += pedido[i].getValorPedido();
                        }
                    } else {
                        System.out.println("--- Não Atendidos ---");
                        if (pedido[i].isAtendido() == false) {
                            System.out.println("Pedido:" + pedido[i].getNuameroPedido() + ", valor: " + pedido[i].getValorPedido());
                            total += pedido[i].getValorPedido();
                        }
                    }
                }

            }
        }
        System.out.println("Valor total ->>> " + total);
    }

    @Override
    public void pagarVendedor(int codVend, double porcent) {
        double total = 0;
        for (int i = 0; i < pedido.length; i++) {
            if (pedido[i].getCodVendedor() == codVend && pedido[i].isAtendido() == true && pedido[i].isComissãoPaga() == false) {
                System.out.println("Pedido realizado -> " + pedido[i].getNuameroPedido());
                total += pedido[i].getValorPedido();
                pedido[i].setComissãoPaga(true);
            }
        }
        double comissao = total * porcent;
        System.out.println("Valor total: " + total);
        System.out.println("Valor comissão: " + comissao);

    }
}

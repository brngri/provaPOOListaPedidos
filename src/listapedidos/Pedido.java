/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listapedidos;

/**
 *
 * @author bruna
 */
public class Pedido {

    //alt + insert
    // alt + shift + f
    public Pedido(){}

    public Pedido(int nuameroPedido, int codCiente, int codVendedor, double valorPedido, boolean atendido, boolean                comissãoPaga) {
        this.nuameroPedido = nuameroPedido;
        this.codCiente = codCiente;
        this.codVendedor = codVendedor;
        this.valorPedido = valorPedido;
        this.atendido = atendido;
        this.comissãoPaga = comissãoPaga;
    }

    private int nuameroPedido;
    private int codCiente;
    private int codVendedor;
    private double valorPedido;
    private boolean atendido;
    private boolean comissãoPaga;

    /**
     * @return the nuameroPedido
     */
    public int getNuameroPedido() {
        return nuameroPedido;
    }

    /**
     * @param nuameroPedido the nuameroPedido to set
     */
    public void setNuameroPedido(int nuameroPedido) {
        this.nuameroPedido = nuameroPedido;
    }

    /**
     * @return the codCiente
     */
    public int getCodCiente() {
        return codCiente;
    }

    /**
     * @param codCiente the codCiente to set
     */
    public void setCodCiente(int codCiente) {
        this.codCiente = codCiente;
    }

    /**
     * @return the codVendedor
     */
    public int getCodVendedor() {
        return codVendedor;
    }

    /**
     * @param codVendedor the codVendedor to set
     */
    public void setCodVendedor(int codVendedor) {
        this.codVendedor = codVendedor;
    }

    /**
     * @return the valorPedido
     */
    public double getValorPedido() {
        return valorPedido;
    }

    /**
     * @param valorPedido the valorPedido to set
     */
    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    /**
     * @return the atendido
     */
    public boolean isAtendido() {
        return atendido;
    }

    /**
     * @param atendido the atendido to set
     */
    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    /**
     * @return the comissãoPaga
     */
    public boolean isComissãoPaga() {
        return comissãoPaga;
    }

    /**
     * @param comissãoPaga the comissãoPaga to set
     */
    public void setComissãoPaga(boolean comissãoPaga) {
        this.comissãoPaga = comissãoPaga;
    }

}

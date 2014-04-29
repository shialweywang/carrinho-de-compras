/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex01;
import br.calebe.exemplos.ex02.controller.PedidoController;

/**
 *
 * @author desktop02
 */
public class Pedido {
    
    private PedidoController controller;
    private EnumStatusPedido answer;
    
    public Pedido() throws Exception{
        this.controller = new PedidoController();
        
    }

    public void run(Carrinho c) {
        answer = controller.ChecarStatusPedido(c);
    }

    public EnumStatusPedido getAnswer() {
        return answer;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex01;

import br.calebe.exemplos.ex02.controller.EstoqueController;
import br.calebe.exemplos.ex02.controller.PedidoController;

/**
 *
 * @author desktop02
 */
public class Pedido {
    
    private EnumStatusPedido status;
    private Carrinho carrinho;
    private PedidoController controller;
    private String answer;
    
    public Pedido() throws Exception{
        this.controller = new PedidoController();
        this.status = EnumStatusPedido.aguardando;
        this.carrinho = new Carrinho();
        
    }

    public void run(Pedido p) {
        answer = controller.ChecarStatusPedido(p);
    }

    public String getAnswer() {
        return answer;
    }
    
}

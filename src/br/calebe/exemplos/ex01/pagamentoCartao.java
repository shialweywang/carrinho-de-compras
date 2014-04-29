/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex01;

import br.calebe.exemplos.ex01.Carrinho;
import br.calebe.exemplos.ex02.controller.*;

/**
 *
 * @author desktop02
 */
public class pagamentoCartao {
    private final pagamentoCartaoController controller;
    private boolean answer;

    public pagamentoCartao() throws Exception {
        controller = new pagamentoCartaoController();
    }

    public void run(Carrinho car) {
        answer = controller.Pagar(car.valorTotal());
    }
    
    public boolean getAnswer() {
        return answer;
    }
}

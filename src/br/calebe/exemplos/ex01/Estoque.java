/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex01;

import br.calebe.exemplos.ex02.*;
import br.calebe.exemplos.ex02.controller.*;

/**
 *
 * @author desktop02
 */
public class Estoque {

    private EstoqueController controller;
    private int answer;
    
    public Estoque() throws Exception {
        controller = new EstoqueController();
    }
    
    public void run(Produto p) {
        answer = controller.ChecarEstoque(p);
    }

    public int getAnswer() {
        return answer;
    }
    
}

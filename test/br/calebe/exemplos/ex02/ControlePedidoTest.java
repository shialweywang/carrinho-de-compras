/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.Pedido;
import br.calebe.exemplos.ex02.controller.PedidoController;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author desktop02
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Pedido.class})
public class ControlePedidoTest {
    @Test
    public void VerificarStatusPedido() throws Exception {
        Pedido p = new Pedido();
        // Cria o objeto Mock da classe ClasseExemploController
        PedidoController controllerMock = PowerMock.createMock(PedidoController.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(PedidoController.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        EasyMock.expect(controllerMock.ChecarStatusPedido(p)).andReturn("Aguardando");
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, PedidoController.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        Pedido tested = new Pedido();
        tested.run(p);
        
        // Faz a verificaçao agendada
        Assert.assertEquals("Aguardando", tested.getAnswer());
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
}

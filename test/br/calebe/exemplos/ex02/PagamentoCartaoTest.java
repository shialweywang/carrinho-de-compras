/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex02.controller.*;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import br.calebe.exemplos.ex01.*;
/**
 *
 * @author Calebe de Paula Bianchini
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({pagamentoCartao.class})
public class PagamentoCartaoTest {
    
    @Test
    public void pagamentoCartao() throws Exception {
        Carrinho car = new Carrinho();
        Computador comp = new Computador(10.00);
        car.add(comp);
        Doll doll = new Doll(5.00);
        car.add(doll);
        
        // Cria o objeto Mock da classe ClasseExemploController
        pagamentoCartaoController controllerMock = PowerMock.createMock(pagamentoCartaoController.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(pagamentoCartaoController.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        EasyMock.expect(controllerMock.Pagar(car.valorTotal())).andReturn(true);
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, pagamentoCartaoController.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        pagamentoCartao tested = new pagamentoCartao();
        tested.run(car);
        
        // Faz a verificaçao agendada
        Assert.assertEquals(true, tested.getAnswer());
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex02.controller.*;
import br.calebe.exemplos.ex01.*;
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
@PrepareForTest({Estoque.class})
public class ControleEstoqueTest {
    @Test
    public void VerificarEstoqueProdutoDisponível() throws Exception {
        // Cria o objeto Mock da classe ClasseExemploController
        EstoqueController controllerMock = PowerMock.createMock(EstoqueController.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(EstoqueController.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        EasyMock.expect(controllerMock.ChecarEstoque(new Computador(10.0))).andReturn(10);
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, EstoqueController.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        Estoque tested = new Estoque();
        tested.run(new Computador(10.00));
        
        // Faz a verificaçao agendada
        Assert.assertEquals(10, tested.getAnswer());
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
    
    @Test
    public void VerificarEstoqueProdutoVazio() throws Exception {
        // Cria o objeto Mock da classe ClasseExemploController
        EstoqueController controllerMock = PowerMock.createMock(EstoqueController.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(EstoqueController.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        EasyMock.expect(controllerMock.ChecarEstoque(new Produto())).andReturn(0);
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, EstoqueController.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        Estoque tested = new Estoque();
        tested.run(new Produto());
        
        // Faz a verificaçao agendada
        Assert.assertEquals(0, tested.getAnswer());
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
}

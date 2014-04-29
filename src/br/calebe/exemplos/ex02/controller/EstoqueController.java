/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex02.controller;

import br.calebe.exemplos.ex01.*;
import br.calebe.exemplos.ex02.*;
import java.io.FileInputStream;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author desktop02
 */
public class EstoqueController implements EstoqueInterface{
    private EstoqueInterface ejb;

    public EstoqueController() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        ejb = (EstoqueInterface) ctx.lookup("ejb/EstoqueInterface");
    }
    
    @Override
    public int ChecarEstoque(Produto p) {
        //Implementação do código de checagem de estoque
        return 0;
    }
}

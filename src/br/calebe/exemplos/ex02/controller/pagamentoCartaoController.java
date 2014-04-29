/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex02.controller;

import br.calebe.exemplos.ex02.CartaoInterface;
import br.calebe.exemplos.ex02.EJBStatelessExemploInterface;
import java.io.FileInputStream;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author desktop02
 */
public class pagamentoCartaoController  implements CartaoInterface{
    private CartaoInterface ejb;

    public pagamentoCartaoController() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        ejb = (CartaoInterface) ctx.lookup("ejb/CartaoInterface");
    }

    @Override
    public boolean Pagar(double i) {
        //Implementação do código de comunicação com a operadora de cartão.
        return true;
    }
}

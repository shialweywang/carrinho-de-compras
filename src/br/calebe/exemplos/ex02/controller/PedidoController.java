/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex02.controller;

import br.calebe.exemplos.ex02.PedidoInterface;
import br.calebe.exemplos.ex01.*;
import java.io.FileInputStream;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author desktop02
 */
public class PedidoController implements PedidoInterface{

    private PedidoInterface ejb;

    public PedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        ejb = (PedidoInterface) ctx.lookup("ejb/PedidoController");
    }
    
    @Override    
    public String ChecarStatusPedido(Pedido pedido) {
        return "";
    }
    
}

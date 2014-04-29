/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.*;
import javax.ejb.Remote;

/**
 *
 * @author desktop02
 */
@Remote
public interface EstoqueInterface {

    int ChecarEstoque(Produto p);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex02;

import javax.ejb.Remote;

/**
 *
 * @author desktop02
 */
@Remote
public interface CartaoInterface {

    boolean Pagar(double i);
}

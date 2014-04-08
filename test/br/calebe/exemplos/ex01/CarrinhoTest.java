package br.calebe.exemplos.ex01;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    @Test(expected = CarrinhoVazioExpected.class)
    public void colocandoZeroProduto() throws CarrinhoVazioExpected {
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{null}, new Object[]{menor});
    }

    @Test
    public void colocandoUmProduto() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void identidadeDeProdutos() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        original = carrinho.menorProduto();
        assertArrayEquals(new Object[]{original}, new Object[]{copia});
    }
  
    @Test
    public void numeroProdutos() {
        Produto prod1 = new Produto("Produto 1",2.00);
        Produto prod2 = new Produto("Produto 2",4.00);
        Produto prod3 = new Produto("Produto 3",6.00);
       
        carrinho.add(prod1);
        carrinho.add(prod2);
        carrinho.add(prod3);
      
        int quantidade = carrinho.Count();
        assertTrue(quantidade == 3);
    }
 
    @Test
    public void removerProduto() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java for Things", 2.00);
        carrinho.add(original);
        Produto clone = new Produto("mine", 2.00);
        carrinho.add(clone);
        carrinho.remove(original);
        original = carrinho.menorProduto();
        assertArrayEquals(new Object[]{original}, new Object[]{clone});
    }
    
    @Test
    public void valorTotalCarrinho(){
        Produto produto1 = new Produto("Java for Things", 2.00);
        carrinho.add(produto1);
        Produto produto2 = new Produto("mine", 2.00);
        carrinho.add(produto2);
        double valor = carrinho.valorTotal();
        assertTrue(valor == 4);
    }
    
    @Test
    public void herancaProduto() throws CarrinhoVazioExpected {
        Computador pc = new Computador(2000.00);
        Doll doll = new Doll(150.00);
        carrinho.add(pc);
        carrinho.add(doll);
        Produto original = carrinho.menorProduto();
        assertArrayEquals(new Object[]{original}, new Object[]{doll});
    }
}
package br.calebe.exemplos.ex01;

import br.calebe.exemplos.ex02.*;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos;
    private EnumStatusPedido Status;
    
    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public Produto menorProduto() throws CarrinhoVazioExpected {
        if (produtos.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        Produto menor = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getPreco() < menor.getPreco()) {
                menor = produto;
            }
        }
        return menor;
    }

    public int Count() {
        return produtos.size();
    }

    public void remove(Produto original) {
        produtos.remove(original);
    }

    public double valorTotal() {
        double sum = 0;
        for(Produto array : produtos){
            sum += array.getPreco();
        }
        return sum;
    }

    public String listarProdutos() {
        String text = "";
        for(Produto array : produtos){
            text += array.getNome() + ";";
        }
        return text;
    }

    public boolean isVazio() {
        return produtos.isEmpty();
    }

    public boolean find(Produto prod) {
        if(produtos.contains(prod))
            return true;
        return false;
    }
    
    public void PagarCartao() throws Exception
    {
        pagamentoCartao card = new pagamentoCartao();
        card.run(this);
    }
    
    
}

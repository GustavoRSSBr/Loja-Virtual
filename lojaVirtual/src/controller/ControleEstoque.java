package controller;

import model.Produto;

import java.util.ArrayList;

public class ControleEstoque {

    ArrayList<Produto> produtos = new ArrayList<>();

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Produto buscarProduto(String idProcurado) {
        Produto produtoEncontrado = produtos.stream()
                .filter(p -> p.getId().equals(idProcurado))
                .findFirst()
                .orElse(null);

        if (produtoEncontrado != null) {
            return produtoEncontrado;
        }

        System.out.println("Produto não encontrado");
        return null;
    }

    public void removerProduto(String id) {
        Produto produtoRemovido = buscarProduto(id);

        if (produtoRemovido != null) {
            produtos.remove(produtoRemovido);
            System.out.println("Produto removido com sucesso");
        }
    }

    public void atualizarProduto(Produto produtoAntigo, Produto produtoAtualizado) {
        int indice = produtos.indexOf(produtoAntigo);
        if (indice != -1) {
            produtos.set(indice, produtoAtualizado);
        } else {
            System.out.println("Produto não encontrado. Não foi possível atualizar o produto.");
        }
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void listar(){
        for(Produto p : produtos){
            System.out.println(p);
        }
    }


}

package controller;

import model.Item;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

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

    public void listar() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public boolean removerQuantidadeDoProdutoDoEstoque(Produto produto, int quantidade) {
        for (Produto p : produtos) {
            if (p.equals(produto)) {
                if (p.getQuantidadeEmEstoque() >= quantidade) {
                    p.setQuantidadeEmEstoque(p.getQuantidadeEmEstoque() - quantidade);
                    return true;
                } else {
                    System.out.println("Produto não disponível em quantidade suficiente");
                }
            }
        }
        return false;
    }


    public boolean verificarQuantidadeNoEstoque(Produto produtoDoEstoque, int quantidade) {
        for (Produto p : produtos) {
            if (p.equals(produtoDoEstoque)) {
                if (p.getQuantidadeEmEstoque() >= quantidade) {
                    return true;
                } else {
                    System.out.println("Produto não disponível em quantidade suficiente");
                }
            }
        }
        return false;
    }

    public boolean removerQuantidadeDoEstoque(List<Item> listaDeItens) {

        for(Item item : listaDeItens){

            Produto produtoDoEstoque = item.getProduto();
            int quantidade = item.getQuantidade();

            boolean remocaoBemSucedida = removerQuantidadeDoProdutoDoEstoque(produtoDoEstoque, quantidade);

            if(!remocaoBemSucedida){
                return false;
            }
        }

        return true;
    }
}

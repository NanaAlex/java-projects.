package org.example;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo +
                "| Nome: " + nome +
                "| Preço: " + String.format("%.2f", preco);
    }
}

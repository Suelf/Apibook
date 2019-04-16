package com.example.demo;

public class Livro {

        public String nome;
        public String autor;
        public int edicao;

        public String getNome() { return nome; }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getAutor() {
                return autor;
        }

        public void setAutor(String autor) {
                this.autor = autor;
        }

        public int getEdicao() { return edicao; }

        public void setEdicao(int edicao) {
                this.edicao = edicao;
        }

}
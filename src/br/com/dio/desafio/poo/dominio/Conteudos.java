package br.com.dio.desafio.poo.dominio;

public sealed abstract class Conteudos permits Cursos, Mentorias {
    private static final double xP = 100;
    private String titulo;
    private String descricao;
    private String tipoConteudo;

    Conteudos(String titulo, String descricao, String tipoConteudo){
        this.titulo=titulo;
        this.descricao=descricao;
        this.tipoConteudo=tipoConteudo;
    }

    public abstract double calculaXp();

    public static double getXp() {
        return xP;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String retornaConteudo(){
        return String.format("\nTipo de Conteúdo: %s \nTítulo: %s \nDescrição: %s", 
        tipoConteudo,titulo,descricao);
    }

}

package br.com.dio.desafio.poo.dominio;

import java.util.LinkedHashSet;
import java.util.Set;

public class Developers {
    private String nome;
    private Set<Conteudos> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudos> conteudosFinalizados = new LinkedHashSet<>();

    public Developers (String nome){
        this.nome=nome;
    }

    public void seIncreverBootcamp(Bootcamp bootcamp){
        conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevelopers().add(this);
    }

    public void progredirBootcamp(){
        conteudosInscritos.stream().findFirst().
        ifPresentOrElse(conteudo -> {
            conteudosInscritos.remove(conteudo);
            conteudosFinalizados.add(conteudo);}, 
            () ->System.err.println("Você finalizou todos os cursos!"));
    }

    public double calcularXpAcumulada(){
        return conteudosFinalizados.stream()
        .mapToDouble(conteudo -> conteudo.calculaXp()).sum();
    }

    public void desistirBootcamp(Bootcamp bootcamp){
        conteudosInscritos.clear();
        bootcamp.getDevelopers().clear();
    }

    public String getNome() {
        return nome;
    }

    public Set<Conteudos> getConteudosIncritos() {
        return conteudosInscritos;
    }

    public Set<Conteudos> getConteudosFinalizados() {
        return conteudosFinalizados;
    }
}

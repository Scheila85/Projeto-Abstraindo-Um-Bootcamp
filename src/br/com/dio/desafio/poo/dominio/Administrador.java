package br.com.dio.desafio.poo.dominio;

import java.time.LocalTime;

public class Administrador {
    private String nome;

    public Administrador(String nome){
        this.nome=nome;
    }

    public Bootcamp criarBootcamp(String name, String descricao){
        Bootcamp bootcamp = new Bootcamp(name, descricao);
        return bootcamp;
    }

    public Conteudo adicionarCurso(String titulo, String descricao, int cargaHoraria, Bootcamp bootcamp){
        Conteudo curso = new Curso(titulo, descricao, "Cursos",cargaHoraria);
        bootcamp.getConteudos().add(curso);
        return curso;
    }

    public Conteudo adicionarMentorias(String titulo, String descricao,
                                       String dataOcorrencia, LocalTime horaAcontecimento, Bootcamp bootcamp){
        Conteudo mentoria = new Mentoria(titulo, descricao, "Mentorias", dataOcorrencia,
        horaAcontecimento);
        bootcamp.getConteudos().add(mentoria);
        return mentoria;
    }

    public String getNome() {
        return nome;
    }
}

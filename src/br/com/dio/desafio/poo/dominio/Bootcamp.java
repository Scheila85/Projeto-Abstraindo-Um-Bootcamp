package br.com.dio.desafio.poo.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

    public class Bootcamp {
        private String name;
        private String descricao;
        private final LocalDate dataInicio = LocalDate.now();
        private final LocalDate dataTermino = dataInicio.plusDays(90);
        private Set<Conteudos> conteudos = new LinkedHashSet<>();
        private Set<Developers> developers = new HashSet<>();

        public Bootcamp(String name, String descricao){
            this.name=name;
            this.descricao=descricao;
        }

        public String getName() {
            return name;
        }

        public String getDescricao() {
            return descricao;
        }

        public LocalDate getDataInicio() {
            return dataInicio;
        }

        public LocalDate getDataTermino() {
            return dataTermino;
        }

        public Set<Conteudos> getConteudos() {
            return conteudos;
        }

        public Set<Developers> getDevelopers() {
            return developers;
        }

        @Override
        public String toString() {
            return String.format("nome=%s, descricao=%s, dataInicio=%s, dataTermino=%s, conteudos=%s, developers=%s",
            name, descricao, dataInicio, dataTermino, conteudos, developers);
        }

    }

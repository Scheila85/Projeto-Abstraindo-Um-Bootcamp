package br.com.dio.desafio.poo.dominio;

import java.time.LocalTime;

public non-sealed class Mentorias extends Conteudos {
    
    private String dataOcorrencia;
    private LocalTime horaAcontecimento;
    
    public Mentorias(String titulo, String descricao, String tipoConteudo, String dataOcorrencia,
        LocalTime horaAcontecimento){
            super(titulo, descricao, "Mentoria");
            this.dataOcorrencia=dataOcorrencia;
            this.horaAcontecimento=horaAcontecimento;
    }

    @Override
    public double calculaXp() {
        return Conteudos.getXp() + 40;
    }

    @Override
    public String toString() {
        return String.format("Mentorias{titulo=%s; descrição=%s; dataOcorrencia=%s, horaAcontecimento=%s", 
        getTitulo(), getDescricao(), dataOcorrencia, horaAcontecimento);
    }

    @Override
    public String retornaConteudo() {
        return super.retornaConteudo() + "\nData Ocorrência: "+dataOcorrencia+"\nHorário: "+horaAcontecimento;
    } 
}

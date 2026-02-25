package br.com.dio.desafio.poo.dominio;

public non-sealed class Cursos extends Conteudos {
    
    private int cargaHoraria;

    public Cursos(String titulo, String descricao, String tipoConteudo, int cargaHoraria){
        super(titulo, descricao, "Curso");
        this.cargaHoraria=cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calculaXp() {
        return Conteudos.getXp() * cargaHoraria;
    }

    @Override
    public String toString() {
        return String.format("Cursos{titulo=%s; descricao=%s; cargaHoraria=%s}",
            getTitulo(), getDescricao(), cargaHoraria);
    }

    @Override
    public String retornaConteudo() {
        return super.retornaConteudo() + "\nCarga Horária: "+cargaHoraria;
    }
}

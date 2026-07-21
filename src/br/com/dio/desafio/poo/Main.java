package br.com.dio.desafio.poo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.dio.desafio.poo.dominio.Administrador;
import br.com.dio.desafio.poo.dominio.Bootcamp;
import br.com.dio.desafio.poo.dominio.Conteudos;
import br.com.dio.desafio.poo.dominio.Developer;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static Administrador administrador;
    private static Developer developer;
    private static Bootcamp bootcamp;

    public static void main(String[] args) {

        int opcaoUsuario;

        while(true){
            System.out.println("\nEscolha o usuário:");
            System.out.println("1 - Administrador");
            System.out.println("2 - Developer");
            System.out.println("0 - Encerrar sistema");
            System.out.print("Opção: ");
            
            opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoUsuario) {
                case 1:
                    cadastrarAdministrador();
                    int opcaoMenuAdm = -2;

                    while (opcaoMenuAdm != 0) {
                        System.out.print("\n--Menu Administrator--\n");
                        System.out.print("1 - Criar Bootcamp\n");
                        System.out.print("2 - Adicionar cursos ao Bootcamp\n");
                        System.out.print("3 - Adicionar Mentorias ao Bootcamp\n");
                        System.out.print("4 - Visualizar Bootcamp\n");
                        System.out.print("0 - Voltar ao Menu Inicial\n");
                        System.out.print("Opção: ");

                        opcaoMenuAdm = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoMenuAdm) {
                            case 1 -> criarBootcamp();
                            case 2 -> adicionarCursos();
                            case 3 -> adicionarMentorias();
                            case 4 -> visualizarBootcamp();
                            case 0 -> System.out.println("\nVoltando ao menu inicial...");
                            default -> System.out.println("\nOpção inválida, tente uma opção válida.\n");
                        }
                    }
                break;

                case 2:
                    System.out.println("\nSeja bem-vindo Dev!");
                    cadastrarDeveloper();
                    if (bootcampNaoInicializado()) break;
                    int opcaoMenuDev;

                    do{
                        System.out.println("\n --Menu Developer--");
                        System.out.print("1 - Se inscrever no bootcamp\n");
                        System.out.print("2 - Progredir no bootcamp\n");
                        System.out.print("3 - Calcular xP acumulada\n");
                        System.out.print("4 - Desistir do bootcamp\n");
                        System.out.print("0 - Voltar ao menu inicial\n");
                        System.out.print("Opção: ");

                        opcaoMenuDev = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoMenuDev) {
                            case 1 -> {
                                inscreverBootcamp();
                                exibirInformacoesBootcamp();
                            }
                            case 2 -> progredirBootcamp();
                            case 3 -> calcularXp();
                            case 4 -> desistirBootcamp();
                            case 0 -> System.out.println("\nVoltando ao menu inicial...");
                            default -> System.out.println("\nOpção inválida, tente uma opção válida.");
                        } 
                    } while (opcaoMenuDev != 0);
                break;

                case 0:
                    scanner.close();
                    System.out.println("\nSistema encerrado.\n");
                    System.exit(0);
                default: 
                    System.out.println("\nOpção inválida, tente uma opção válida.");
            }
        }
    }

    private static void cadastrarAdministrador() {
        System.out.println("\nCadastro de usuário");
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine().trim();
        administrador = new Administrador(nome);
        System.out.println("\nUsuário criado com sucesso!");
    }

    private static void criarBootcamp() {
        if (administrador == null) {
            System.out.println("É necessário cadastrar um usuário, para criar bootcamps.");
            return;
        }
        System.out.print("\nTítulo do Bootcamp: ");
        String tituloBootcamp = scanner.nextLine().trim();
        System.out.print("Descrição do Bootcamp: ");
        String descricaoBootcamp = scanner.nextLine().trim();

        bootcamp = administrador.criarBootcamp(tituloBootcamp,descricaoBootcamp);
        System.out.println("\nBootcamp, "+ tituloBootcamp + ", criado com sucesso!");
    }

    private static void adicionarCursos() {
        if (bootcampNaoInicializado()){
            System.out.println("\nCrie um bootcamp para poder adicionar um curso.");
            return;
        }
        System.out.print("\nTítulo do Curso: ");
        String tituloCurso = scanner.nextLine().trim();
        System.out.print("Descrição Curso: ");
        String descricaoCurso = scanner.nextLine().trim();
        System.out.print("Carga horária (digite apenas números): ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();

        Conteudos curso = administrador.adicionarCurso(tituloCurso, descricaoCurso, cargaHoraria, bootcamp);
        System.out.println("Curso adicionado ao bootcamp, "+ bootcamp.getName() + ", com sucesso!");
    }

    private static void adicionarMentorias() {
        if (bootcampNaoInicializado()) {
            System.out.println("\nCrie um bootcamp para poder adicionar uma mentoria.");
            return;
        }
        System.out.print("\nTítulo da Mentoria: ");
        String tituloMentoria= scanner.nextLine().trim();
        System.out.print("Descrição da Mentoria: ");
        String descricaoMentoria = scanner.nextLine().trim();
        System.out.print("Data ocorrência (ex 22/02/2026): ");
        String dataOcorrencia = scanner.nextLine();
        System.out.print("Hora acontecimento (ex 14:13): ");
        String horaAcontecimento = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaAcontecimentoFormatted = LocalTime.parse(horaAcontecimento, formatter);

        Conteudos mentoria =  administrador.adicionarMentorias(tituloMentoria, descricaoMentoria,
                dataOcorrencia, horaAcontecimentoFormatted, bootcamp);
        System.out.println("Mentoria adicionada ao bootcamp, "+ bootcamp.getName() + ", com sucesso!");
    }

    private static void visualizarBootcamp() {
        if (bootcampNaoInicializado()){
            System.out.println("\nCrie um bootcamp para poder exibi-lo!");
            return;
        }
        exibirInformacoesBootcamp();
    }

    private static void cadastrarDeveloper() {
        if (bootcampNaoInicializado()) {
            System.out.println("\nNenhum bootcamp disponível no momento.");
            return;
        }
        System.out.println("\nCadastro de usuário");
        System.out.println("Digite seu nome: ");
        String nomeDev = scanner.nextLine();

        developer = new Developer(nomeDev);
        System.out.println("\nUsuário criado com sucesso!");
    }

    private static void inscreverBootcamp() {
        developer.seInscreverBootcamp(bootcamp);
        System.out.println("\nInscrição realizada com sucesso!");
    }

    private static void progredirBootcamp() {
        if (naoInscritoEmConteudos()){
            System.out.println("\nVocê não está inscrito em nenhum conteúdo.");
        }
        developer.progredirBootcamp();
        System.out.println("\nParabéns, você finalizou mais um conteúdo!");
    }

    private static void calcularXp() {
        System.out.printf("\nTotal xP: %s\n",developer.calcularXpAcumulada());
    }

    private static void desistirBootcamp() {
        if (naoInscritoEmConteudos()){
            System.out.println("\nVocê não está inscrito em nenhum conteúdo.");
        }
        developer.desistirBootcamp(bootcamp);
        System.out.println("\nVocê não está mais inscrito no Bootcamp!");
    }

    private static Boolean bootcampNaoInicializado(){
        return bootcamp == null;
    }

    private static boolean naoInscritoEmConteudos(){
        return developer.getConteudosInscritos() == null;
    }

    private static void exibirInformacoesBootcamp(){
        System.out.println("------------------------");
        System.out.println("Bootcamp: " + bootcamp.getName());
        System.out.println("Descrição: " + bootcamp.getDescricao());
        System.out.println("Data Início: " + bootcamp.getDataInicio());
        System.out.println("Data Término: " + bootcamp.getDataTermino());
        System.out.println("---------------------");
        System.out.println("Conteúdos");
        bootcamp.getConteudos().forEach(conteudo -> System.out.println
                (conteudo.retornaConteudo()));
        System.out.println("---------------------");
    }
}


package br.com.dio.desafio.poo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.dio.desafio.poo.dominio.Administrador;
import br.com.dio.desafio.poo.dominio.Bootcamp;
import br.com.dio.desafio.poo.dominio.Conteudos;
import br.com.dio.desafio.poo.dominio.Developers;

public class Main {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        Bootcamp bootcamp = null;
        int opcaoUsuario;

        do{
            System.out.println("\nEscolha o usuário:");
            System.out.println("1 - Administrador");
            System.out.println("2 - Developer");
            System.out.println("0 - Encerrar sistema");
            System.out.print("Opção: ");
            
            opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoUsuario) {
                case 1: 

                    Administrador administrador = null;
                    int opcaoMenuAdm;

                    System.out.println("\nCadastro de usuário");
                    System.out.println("Digite seu nome: ");
                    String nome = scanner.nextLine().trim();
                    administrador = new Administrador(nome);
                    System.out.println("Usuário criado com sucesso!");

                    do {
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
                            case 1 -> {
                                if (administrador == null) {
                                    System.out.println("É necessário cadastrar um usuário, para criar bootcamps.");
                                    break;
                                }
                                System.out.print("\nTítulo do Bootcamp: ");
                                String tituloBootcamp = scanner.nextLine().trim();
                                System.out.print("Descrição do Bootcamp: ");
                                String descricaoBootcamp = scanner.nextLine().trim();
                                bootcamp = administrador.criarBootcamp(tituloBootcamp,descricaoBootcamp);
                                System.out.println("\nBootcamp, "+ tituloBootcamp + ", criado com sucesso!\n");
                                }
                            case 2 -> {
                                if (bootcamp == null){
                                    System.out.println("Crie um bootcamp para poder adicionar um curso.");
                                    break;
                                }
                                System.out.print("\nTítulo do Curso: ");
                                String tituloCurso = scanner.nextLine().trim();
                                System.out.print("Descrição Curso: ");
                                String descricaoCurso = scanner.nextLine().trim();
                                System.out.print("Carga horária (digite apenas números): ");
                                int cargaHoraria = scanner.nextInt();
                                scanner.nextLine();
                                Conteudos curso = administrador.adicionarCurso(tituloCurso, descricaoCurso, cargaHoraria, bootcamp);
                                System.out.println("\nCurso "+ curso.getTitulo() + " criado com sucesso!");
                                System.out.println("Curso adicionado ao bootcamp, "+ bootcamp.getName() + ", com sucesso!");
                            }
                            case 3 -> {
                                if (bootcamp == null){
                                    System.out.println("Crie um bootcamp para poder adicionar uma mentoria.");
                                    break;
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
                                Conteudos mentoria =  administrador.adicionarMentorias(tituloMentoria, descricaoMentoria, dataOcorrencia, horaAcontecimentoFormatted, bootcamp);
                                System.out.println("\nMentoria "+ mentoria.getTitulo() + " criada com sucesso!");
                                System.out.println("Mentoria adicionada ao bootcamp, "+ bootcamp.getName() + ", com sucesso!");
                            }
                            case 4 -> {
                                if (bootcamp == null){
                                    System.out.println("\nCrie um bootcamp para poder exibi-lo!");
                                }else{
                                    System.out.println("-------------------------");
                                    System.out.println("Bootcamp: " + bootcamp.getName());
                                    System.out.println("Descrição: " + bootcamp.getDescricao());
                                    System.out.println("Data Início: " + bootcamp.getDataInicio());
                                    System.out.println("Data Término: " + bootcamp.getDataTermino());
                                    System.out.println("-------------------------");

                                    System.out.println("Conteudos");
                                    for (Conteudos conteudo : bootcamp.getConteudos()){
                                        System.out.println(conteudo.retornaConteudo());
                                    }
                                    System.out.println("-------------------------");
                                }
                            }
                            case 0 -> {
                                System.out.println("\nVoltando ao menu inicial...");
                            }
                            default -> {
                                System.out.println("\nOpção inválida, tente uma opção válida.\n");
                            }
                        }   
                    } while (opcaoMenuAdm != 0);
                    break;

                case 2:
                    if (bootcamp == null) {
                        System.out.println("\nNenhum bootcamp disponível no momento.");
                        break;
                    }
                    Developers developer = null;
                    int opcaoMenuDev;

                    System.out.println("\nSeja bem-vindo Dev!");

                    System.out.println("\nCadastro de usuário");
                    System.out.println("Digite seu nome: ");
                    String nomeDev = scanner.nextLine();

                    developer = new Developers(nomeDev);
                    System.out.println("\nUsuário criado com sucesso!");

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
                                developer.seIncreverBootcamp(bootcamp);
                                System.out.println("\nInscrição realizada com sucesso!");
                                System.out.println("------------------------");
                                    System.out.println("Bootcamp: " + bootcamp.getName());
                                    System.out.println("Descrição: " + bootcamp.getDescricao());
                                    System.out.println("Data Início: " + bootcamp.getDataInicio());
                                    System.out.println("Data Término: " + bootcamp.getDataTermino());
                                    System.out.println("---------------------");
                                    System.out.println("Conteudos");
                                    bootcamp.getConteudos().forEach(conteudo -> System.out.println(conteudo.retornaConteudo()));
                                    System.out.println("---------------------");
                            }
                            case 2 -> {
                                developer.progredirBootcamp();
                                System.out.println("\nParabéns, você finalizou mais um conteúdo!");
                            }
                            case 3 -> {
                                System.out.printf("\nTotal xP: %s\n",developer.calcularXpAcumulada());
                            }
                            case 4 -> {
                                developer.desistirBootcamp(bootcamp);
                                System.out.println("\nVocê não está mais incrito no Bootcamp!");
                            }
                            case 0 -> {
                                System.out.println("\nVoltando ao menu inicial...");
                            }
                            default -> {
                                System.out.println("\nOpção inválida, tente uma opção válida.");
                            }
                        } 
                    } while (opcaoMenuDev != 0);
                break;

                case 0: 
                    System.out.println("\nSistema encerrado.\n");
                    break;
                default: 
                    System.out.println("\nOpção inválida, tente uma opção válida.");
            }
        } while (opcaoUsuario != 0);
    scanner.close();
    }
}


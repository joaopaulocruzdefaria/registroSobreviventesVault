import java.util.Scanner;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Vault vault = new Vault();
        int option;
        // Scanner scanner1 = new Scanner(System.in);
        do {
            System.out.println("1 - Cadastrar Sobrevivente");
            System.out.println("2 - Adicionar habilidade a um sobrevivente");
            System.out.println("3 - Remover habilidade de um sobrevivente");
            System.out.println("4 - Adicionar Recurso");
            System.out.println("5 - Consumir Recurso");
            System.out.println("6 - Registrar missão");
            System.out.println("7 - Adicionar sobrevivente a missão");
            System.out.println("8 - Exibir Sobreviventes do Vault");
            System.out.println("9 - Exibir Recursos do Vault");
            System.out.println("10 - Exibir Missões do Vault");
            System.out.println("11 - Exibir Sobreviventes de uma Missão");
            System.out.println("12 - Sair");
            System.out.print("Digite a opção desejada: ");
            option = scanner1.nextInt();
            scanner1.nextLine(); // Consume newline

            switch (option) {
                case 1: // Cadastrar Sobrevivente
                    System.out.println("Digite o nome do sobrevivente: ");
                    String nome = scanner1.nextLine();
                    System.out.println("Digite a idade do sobrevivente: ");
                    int idade = scanner1.nextInt();
                    scanner1.nextLine(); // Consume newline
                    System.out.println("Digite o identificador do sobrevivente: ");
                    String identificador = scanner1.nextLine();
                    System.out.println("Digite o status do sobrevivente (Ativo, Doente, Ferido, Morto): ");
                    String status = "";
                    String aux = scanner1.nextLine();

                    while (!status.equals(aux)) {
                        if (aux.equals("Ativo") || aux.equals("Doente") || aux.equals("Ferido")
                                || aux.equals("Morto")) {
                            status = aux;
                        } else {
                            System.out.println("Status inválido. Digite novamente: ");
                            aux = scanner1.nextLine();
                        }

                    }

                    String[] habilidades = new String[3];

                    for (int i = 0; i < habilidades.length; i++) {
                        System.out.println("Digite a habilidade " + (i + 1)
                                + " ou pressione Enter para pular (Engenharia , Medicina, Combate, Exploracao, Culinaria, Diplomacia, Hacking, Furtividade):");
                        String habilidade = scanner1.nextLine();
                        if (habilidade.isEmpty()) {
                            break;
                        }
                        if (habilidade.equals("Engenharia") || habilidade.equals("Medicina")
                                || habilidade.equals("Combate") ||
                                habilidade.equals("Exploracao") || habilidade.equals("Culinaria")
                                || habilidade.equals("Diplomacia") ||
                                habilidade.equals("Hacking") || habilidade.equals("Furtividade")) {
                            habilidades[i] = habilidade;
                        } else {
                            System.out.println("Habilidade inválida. Digite novamente.");
                            i--;
                        }
                    }
                    Sobrevivente sobrevivente = new Sobrevivente(nome, idade, identificador, status, habilidades);
                    vault.adicionarSobrevivente(sobrevivente);
                    break;

                case 2: // Adicionar habilidade a um sobrevivente
                    System.out.println("Digite o identificador do sobrevivente: ");
                    String id = scanner1.nextLine();
                    Sobrevivente sobreviventeEncontrado = null;
                    for (Sobrevivente s : vault.getSobreviventes()) {
                        if (s.getIdentificador().equals(id)) {
                            sobreviventeEncontrado = s;
                            break;
                        }
                    }
                    if (sobreviventeEncontrado != null) {
                        System.out.println(
                                "Digite a habilidade a ser adicionada (Engenharia, Medicina, Combate, Exploracao, Culinaria, Diplomacia, Hacking, Furtividade): ");
                        String novaHabilidade = scanner1.nextLine();
                        if (novaHabilidade.equals("Engenharia") || novaHabilidade.equals("Medicina")
                                || novaHabilidade.equals("Combate") || novaHabilidade.equals("Exploracao")
                                || novaHabilidade.equals("Culinaria") || novaHabilidade.equals("Diplomacia")
                                || novaHabilidade.equals("Hacking") || novaHabilidade.equals("Furtividade")) {
                            if (sobreviventeEncontrado.adicionarHabilidade(novaHabilidade)) {
                                System.out.println("Habilidade adicionada com sucesso.");
                            } else {
                                System.out.println(
                                        "Não foi possível adicionar a habilidade. O sobrevivente já possui 3 habilidades.");
                            }
                        } else {
                            System.out.println("Habilidade inválida. Verifique se a habilidade é válida.");
                        }
                    } else {
                        System.out.println("Sobrevivente não encontrado.");
                    }
                    break;

                case 3: // Remover habilidade de um sobrevivente
                    System.out.println("Digite o identificador do sobrevivente: ");
                    String idRemover = scanner1.nextLine();
                    Sobrevivente sobreviventeParaRemover = null;
                    for (Sobrevivente s : vault.getSobreviventes()) {
                        if (s.getIdentificador().equals(idRemover)) {
                            sobreviventeParaRemover = s;
                            break;
                        }
                    }
                    if (sobreviventeParaRemover != null) {
                        System.out.println(
                                "Digite a habilidade a ser removida (Engenharia, Medicina, Combate, Exploração, Culinária, Diplomacia, Hacking, Furtividade): ");
                        String habilidadeRemover = scanner1.nextLine();
                        if (sobreviventeParaRemover.removerHabilidade(habilidadeRemover)) {
                            System.out.println("Habilidade removida com sucesso.");
                        } else {
                            System.out.println(
                                    "Não foi possível remover a habilidade. Verifique se a habilidade é válida e se o sobrevivente possui essa habilidade.");
                        }
                    } else {
                        System.out.println("Sobrevivente não encontrado.");
                    }
                    break;

                case 4: // Adicionar Recurso
                    String nomeRecurso;
                    do {
                        System.out.println(
                                "Digite o nome do recurso (Agua, Comida, Municao, Remedios, Partes Mecanicas): ");
                        nomeRecurso = scanner1.nextLine();
                        if (!(nomeRecurso.equals("Agua") || nomeRecurso.equals("Comida")
                                || nomeRecurso.equals("Municao") || nomeRecurso.equals("Remedios")
                                || nomeRecurso.equals("Partes Mecanicas"))) {
                            System.out.println("Recurso inválido. Digite novamente.");
                        }
                    } while (!(nomeRecurso.equals("Agua") || nomeRecurso.equals("Comida")
                            || nomeRecurso.equals("Municao") ||
                            nomeRecurso.equals("Remedios") || nomeRecurso.equals("Partes Mecanicas")));

                    System.out.println("Digite a quantidade do recurso: ");
                    int quantidadeRecurso = scanner1.nextInt();
                    Recurso recurso = new Recurso(quantidadeRecurso, nomeRecurso);
                    vault.adicionarRecurso(recurso);
                    System.out.println("Recurso adicionado com sucesso.");
                    break;

                case 5: // Consumir Recurso
                    String nomeRecursoConsumir;
                    do {
                        System.out.println(
                                "Digite o nome do recurso a ser consumido (Agua, Comida, Municao, Remedios, Partes Mecanicas): ");
                        nomeRecursoConsumir = scanner1.nextLine();
                        if (!(nomeRecursoConsumir.equals("Agua") || nomeRecursoConsumir.equals("Comida")
                                || nomeRecursoConsumir.equals("Municao") ||
                                nomeRecursoConsumir.equals("Remedios")
                                || nomeRecursoConsumir.equals("Partes Mecanicas"))) {
                            System.out.println("Recurso inválido. Digite novamente.");
                        }
                    } while (!(nomeRecursoConsumir.equals("Agua") || nomeRecursoConsumir.equals("Comida")
                            || nomeRecursoConsumir.equals("Munição") ||
                            nomeRecursoConsumir.equals("Remédios") || nomeRecursoConsumir.equals("Partes Mecânicas")));

                    System.out.println("Digite a quantidade a ser consumida: ");
                    int quantidadeConsumir = scanner1.nextInt();
                    boolean recursoConsumido = vault.consumirRecurso(nomeRecursoConsumir, quantidadeConsumir);
                    if (recursoConsumido) {
                        System.out.println("Recurso consumido com sucesso.");
                    } else {
                        System.out.println(
                                "Não foi possível consumir o recurso. Verifique se o recurso existe e se a quantidade é suficiente.");
                    }
                    break;

                case 6: // Registrar missão
                    System.out.println("Digite o nome da missão: ");
                    String nomeMissao = scanner1.nextLine();
                    System.out.println("Digite o Objetivo da missão: ");
                    String objetivoMissao = scanner1.nextLine();
                    System.out.println("Digite o local da missão: ");
                    String localMissao = scanner1.nextLine();
                    System.out.println("Digite o status da missão (Em andamento, Concluída, Fracassada): ");
                    String statusMissao = "";
                    String auxStatus = scanner1.nextLine();
                    while (!statusMissao.equals(auxStatus)) {
                        if (auxStatus.equals("Em andamento") || auxStatus.equals("Concluída")
                                || auxStatus.equals("Fracassada")) {
                            statusMissao = auxStatus;
                        } else {
                            System.out.println("Status inválido. Digite novamente: ");
                            auxStatus = scanner1.nextLine();
                        }
                    }
                    Missao missao = new Missao(nomeMissao, objetivoMissao, localMissao, statusMissao);
                    vault.adicionarMissao(missao);
                    System.out.println("Missão registrada com sucesso.");
                    break;

                case 7: // Adicionar sobrevivente a missão
                    System.out.println("Digite o nome da missão: ");
                    String nomeMissaoParaAdicionar = scanner1.nextLine();
                    Missao missaoParaAdicionar = null;
                    for (Missao m : vault.getMissoes()) {
                        if (m.getNome().equals(nomeMissaoParaAdicionar)) {
                            missaoParaAdicionar = m;
                            break;
                        }
                    }
                    if (missaoParaAdicionar != null) {
                        System.out.println("Digite o identificador do sobrevivente: ");
                        String idSobreviventeParaAdicionar = scanner1.nextLine();
                        Sobrevivente sobreviventeParaAdicionar = null;
                        for (Sobrevivente s : vault.getSobreviventes()) {
                            if (s.getIdentificador().equals(idSobreviventeParaAdicionar)) {
                                sobreviventeParaAdicionar = s;
                                break;
                            }
                        }
                        if (sobreviventeParaAdicionar != null) {
                            missaoParaAdicionar.adicionarSobrevivente(sobreviventeParaAdicionar);
                            System.out.println("Sobrevivente adicionado à missão com sucesso.");
                        } else {
                            System.out.println("Sobrevivente não encontrado.");
                        }
                    } else {
                        System.out.println("Missão não encontrada.");
                    }
                    break;

                case 8: // Exibir Sobreviventes do Vault
                    System.out.println("Sobreviventes do Vault:");
                    for (Sobrevivente s : vault.getSobreviventes()) {
                        System.out.println("Nome: " + s.getNome() + ", Idade: " + s.getIdade() + ", Identificador: "
                                + s.getIdentificador() + ", Status: " + s.getStatus());
                        String[] habilidadesObtidas = s.getHabilidades();
                        System.out.println("Habilidades: " + Arrays.toString(habilidadesObtidas));
                        System.out.println();
                    }
                    break;

                case 9: // Exibir Recursos do Vault
                    System.out.println("Recursos do Vault:");
                    for (Recurso r : vault.getRecursos()) {
                        System.out.println("Nome: " + r.getNome() + ", Quantidade: " + r.getQuantidade());
                    }
                    break;

                case 10: // Exibir Missões do Vault
                    System.out.println("Missões do Vault:");
                    for (Missao m : vault.getMissoes()) {
                        System.out.println("Nome: " + m.getNome() + ", Descrição: " + m.getObjetivo() + ", Local: "
                                + m.getLocal() + ", Status: " + m.getStatus());
                    }
                    break;

                case 11: // Exibir Sobreviventes de uma Missão
                    System.out.println("Digite o nome da missão: ");
                    String nomeMissaoParaExibir = scanner1.nextLine();
                    Missao missaoParaExibir = null;
                    for (Missao m : vault.getMissoes()) {
                        if (m.getNome().equals(nomeMissaoParaExibir)) {
                            missaoParaExibir = m;
                            break;
                        }
                    }
                    if (missaoParaExibir != null) {
                        System.out.println("Sobreviventes da missão " + missaoParaExibir.getNome() + ":");
                        for (Sobrevivente s : missaoParaExibir.getListaDeSobreviventes()) {
                            System.out.println("Nome: " + s.getNome() + ", Idade: " + s.getIdade() + ", Identificador: "
                                    + s.getIdentificador() + ", Status: " + s.getStatus());
                        }
                    } else {
                        System.out.println("Missão não encontrada.");
                    }
                    break;

                case 12: // Sair
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;

                default:
                    break;
            }
        } while (option != 12);

        scanner1.close();
    }
}
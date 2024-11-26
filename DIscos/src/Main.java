import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n--- Catálago de discos da loja Music 2000---");
            System.out.println("1. Cadastro de discos!");
            System.out.println("2. Cadastro de artistas!");
            System.out.println("3. listar os discos!");
            System.out.println("4. Editar discos ja adicionados!");
            System.out.println("5. Remover discos!");
            System.out.println("6. Remover Artista!");
            System.out.println("7. Editar generos musicais!");
            System.out.println("8. Remover gêneros musicais!");
            System.out.println("9. Sair de nosso sistema!");
            System.out.println("Esolha uma das opções para seguir adiante!");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1 :
                    System.out.println("Titulo do disco: ");
                    String titulo = sc.nextLine();
                    System.out.println("Ano de lançamento: ");
                    int anoLancamento = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Número de faixas do disco: ");
                    int numFaixas = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite os nome das faixas: ");
                    List<String> faixas = new ArrayList<>();
                    for ( int i = 0; i < numFaixas; i++){
                        System.out.println("Faixa "+(i +1)+ ": ");
                        faixas.add(sc.nextLine());
                    }
                    cadastro.adicionarDisco(new Discos(titulo, anoLancamento, faixas));
                    break;

                case 2:
                    System.out.print("Nome do Artista: ");
                    String nomeArtista = sc.nextLine();
                    System.out.println("Genêro Musical: ");
                    String generoMusical = sc.nextLine();
                    System.out.println("Associe o artista ao nome de um Disco: ");
                    String DiscoTtulo = sc.nextLine();
                    cadastro.adicionarArtista(new Artista(nomeArtista, generoMusical), DiscoTtulo);
                    break;

                case 3:
                    System.out.print("----Lista de discos: -------");
                    for (Discos discos : cadastro.listarDiscos()){
                        System.out.print(discos);
                    }
                    break;

                case 4:
                    System.out.print("Título do Disco a editar: ");
                    String discoEditar = sc.nextLine();

                    Discos discoEncontrado = null;
                    for (Discos disco : cadastro.listarDiscos()) {
                        if (disco.getTitulo().equalsIgnoreCase(discoEditar)) {
                            discoEncontrado = disco;
                            break;
                        }
                    }

                    if (discoEncontrado == null) {
                        System.out.println("Disco não encontrado no catálogo!");
                        break;
                    }

                    System.out.println("Informações atuais do disco:");
                    System.out.println(discoEncontrado);

                    System.out.print("Novo título (pressione Enter para manter o atual): ");
                    String novoTitulo = sc.nextLine();
                    if (!novoTitulo.isEmpty()) {
                        discoEncontrado.setTitulo(novoTitulo);
                    }

                    System.out.print("Novo ano de lançamento (pressione Enter para manter o atual): ");
                    String novoAnoStr = sc.nextLine();
                    if (!novoAnoStr.isEmpty()) {
                        try {
                            int novoAno = Integer.parseInt(novoAnoStr);
                            discoEncontrado.setAnoLancamento(novoAno);
                        } catch (NumberFormatException e) {
                            System.out.println("Ano inválido! Mantendo o ano atual.");
                        }
                    }

                    System.out.println("Deseja editar a lista de faixas? (S/N)");
                    String editarFaixas = sc.nextLine();
                    if (editarFaixas.equalsIgnoreCase("S")) {
                        List<String> novasFaixas = new ArrayList<>();
                        System.out.println("Digite as faixas do disco (digite 'fim' para encerrar):");
                        while (true) {
                            String faixa = sc.nextLine();
                            if (faixa.equalsIgnoreCase("fim")) {
                                break;
                            }
                            novasFaixas.add(faixa);
                        }
                        discoEncontrado.setFaixas(novasFaixas);
                    }

                    System.out.println("Disco editado com sucesso!");
                    break;

                case 5:
                    System.out.println("Titulo do Disco que quer remover");
                    String RemoverDisco = sc.nextLine();
                    cadastro.removerDiscos(RemoverDisco);
                    break;

                case 6:
                    System.out.println("Nome do artista a remover: ");
                    String RemoverArtista = sc.nextLine();
                    cadastro.removerArtista(RemoverArtista);
                    break;

                case 7:
                    System.out.println("Digite o nome do artista cujo genero musical queres editar: ");
                    String NomeArtista = sc.nextLine();
                    System.out.println("Digite o nome do genero musical");
                    String NomeGenero = sc.nextLine();
                    cadastro.editarGenero(NomeGenero, NomeArtista);
                    break;

                case 8:
                    System.out.println("Digite o nome do Genero Musical que desejas excluir: ");
                    String RemoverGenero = sc.nextLine();
                    cadastro.removerGenero(RemoverGenero);
                    break;

                case 9:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida!!!");
            }
        }
    }
}

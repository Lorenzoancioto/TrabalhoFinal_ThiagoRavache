import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private List<Discos> discos;
    private List<Artista> artistas;

    public Cadastro(){
        discos = new ArrayList<>();
        artistas = new ArrayList<>();
        this.artistas = new ArrayList<>(artistas);
        this.discos = new ArrayList<>(discos);
    }


    public void adicionarDisco(Discos disco) {
        discos.add(disco);
    }

    public void adicionarArtista(Artista artista, String tituloDisco) {
        for (Discos disco : discos) {
            if (disco.getTitulo().equalsIgnoreCase(tituloDisco)) {
                disco.setArtista(artista);
                artistas.add(artista);
                break;
            }
        }
    }

    public List<Discos> listarDiscos(){
        return discos;
    }

    public void editarDisco(String titulo, Discos novoDisco){
        for(int i = 0; i< discos.size(); i++ ){
            if(discos.get(i).getTitulo().equalsIgnoreCase(titulo)){
                discos.set(i, novoDisco);
                break;
            }
        }
    }

    public void removerDiscos(String titulo){
        discos.removeIf(discos -> discos.getTitulo().equalsIgnoreCase(titulo));
    }

    public void removerArtista(String nome){
        artistas.removeIf(artista -> artista.getNome().equalsIgnoreCase(nome));
        discos.forEach(disco ->{
            if(disco.getArtista() !=null && disco.getArtista().getNome().equalsIgnoreCase(nome)){
                disco.setArtista(null);
            }
        } );
    }
    public void editarGenero(String artistaNome, String novoGenero){
        for(Artista artista : artistas){
            if (artista.getNome().equalsIgnoreCase(artistaNome)){
                artista.setGeneroMusical(novoGenero);
                System.out.printf("Gênero musical do artista " + artistaNome + " atualizado para: "+ novoGenero);
                return;
            }
        }
        System.out.println("Artista não encontrado!");
    }

    public void removerGenero(String genero){
        for (Artista artista: artistas){
            if (artista.getGeneroMusical().equalsIgnoreCase(genero)){
                artista.setGeneroMusical(null);
            }
        }
        System.out.println("Todos os artista que tinham seu gênero musical como: " + genero +" foram removidos");
    }
}

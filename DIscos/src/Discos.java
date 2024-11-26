import java.util.ArrayList;
import java.util.List;

public class Discos {

    private String titulo;
    private int anoLancamento;
    private List<String> faixas;
    private Artista artista;

    public Discos(String titulo, int anoLancamento, List<String> faixas){
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.faixas = new ArrayList<>(faixas);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public List<String> getFaixas() {
        return faixas;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setFaixas(List<String> faixas) {
        this.faixas = faixas;
    }

    @Override
    public String toString(){
        return "Disco: " + titulo + " (" + anoLancamento + ")"
                +", Artista: " + (artista !=null ? artista.getNome(): "Desconhecido");
    }

}

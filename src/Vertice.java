
import java.util.HashSet;
import java.util.Set;

public class Vertice {
    

    private Tabuleiro tabuleiroEstado;

    private Set<Vertice> verticesAdjascentes = new HashSet<Vertice>();
    
    private Vertice verticePai;
    
    private String jogadaText; //saber a jogada é x ou o
    
    public String getJogadaText(){
        return jogadaText;
    }
    public void setJogadaText(String jogadaText) {
        this.jogadaText = jogadaText;
    }
    
    public Vertice getVerticePai() {
        return verticePai;
    }
    public void setVerticePai (Vertice verticePai) {
        this.verticePai = verticePai;
    }
    
    public Tabuleiro getTabuleiroEstado() {
        return tabuleiroEstado;
        
    }
    public void setTabuleiroEstado(Tabuleiro tabuleiroEstado){
        this.tabuleiroEstado = tabuleiroEstado;
    }
//add vertices filhos a vertice atual
    public void adicionarVertice(Vertice vertice) {
        verticesAdjascentes.add(vertice);
    }
}

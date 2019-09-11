import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Tela extends JFrame implements ActionListener{
    
    JButton[][] botoes = new JButton[3][3];
    int jogador = 1;
    Tabuleiro tabuleiro = new Tabuleiro();
    
    int cordenadaYProximaJogadaIA;
    int cordenadaXProximaJogadaIA;
    
    

    public Tela() {
        super("Jogo da Velha - Tec. Desenv. de jogos digitais");
        this.setSize(800,800);
        this.setVisible(true);
        this.setLayout(new GridLayout(3,3));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        tabuleiro.limparTabuleiro();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j] = new JButton();
                botoes[i][j].addActionListener(this);
                this.add(botoes [i][j]);
            }
        }
    }
   
    @Override
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == botoes [i][j]) {
                    jogar(i,j,jogador);
                    
                }
                
            }
            
        }
    }
    public void jogar(int x, int y, int jogador) {
        String text = "O";
        
        
      tabuleiro.adicionarJogada(x, y, text);
        botoes[x][y].setText(text);
        botoes[x][y].setFont(new Font ("Dialog",0, 75));
        botoes[x][y].setEnabled(false);
        tabuleiro.adicionarJogada(x, y, text);
        if(tabuleiro.verificarVencedor(text)){
            JOptionPane.showMessageDialog(null,"Venceu o Jogador:" + text);
            dispose();
        }
        jogarIA(text);
    }
    
     public Vertice selecionarProximaJogadaAPatirDoVerticeObjetivo(Vertice verticeObjetivo ){
            Vertice verticeAux = verticeObjetivo;
            Vertice verticeAnterior = null;
            while(verticeAux.getVerticePai() != null){
                verticeAnterior = verticeAux;
                verticeAux = verticeAux.getVerticePai();
            }
            return verticeAnterior;
        }
        public void jogarIA(String jogadaHumana){
            String text = "X";

            if (tabuleiro.verificarVencedor(text)) {
                JOptionPane.showConfirmDialog(null,"Vencedor é o Jogador :" + text);
                dispose();
            }
            Vertice verticeEstadoAtual = new Vertice();
             verticeEstadoAtual.setJogadaText(jogadaHumana);
             verticeEstadoAtual.setTabuleiroEstado(this.tabuleiro);
             BuscaEmProfundidade buscaEmProfundidade = new BuscaEmProfundidade();
             try{


                 Vertice verticeObjeto = buscaEmProfundidade.encontrarVerticeSolucao(verticeEstadoAtual);
                 Vertice proximajogadaVertice = selecionarProximaJogadaAPatirDoVerticeObjetivo(verticeObjeto);
                 setXYIA(proximajogadaVertice.getTabuleiroEstado(), verticeEstadoAtual.getTabuleiroEstado());
                 
                 tabuleiro.adicionarJogada(this.cordenadaXProximaJogadaIA, this.cordenadaYProximaJogadaIA, text);
                 botoes[cordenadaXProximaJogadaIA][cordenadaYProximaJogadaIA].setText(text);
                 botoes[cordenadaXProximaJogadaIA][cordenadaYProximaJogadaIA].setFont(new Font("Dialog",0,60));
                 botoes[cordenadaXProximaJogadaIA][cordenadaYProximaJogadaIA].setEnabled(false);
                 if(tabuleiro.verificarVencedor(text)){
                     JOptionPane.showMessageDialog(null,"Vencedor é o Jogador : "+ text);
                     dispose();
                 }
             }catch ( CloneNotSupportedException e){
                 e.printStackTrace();
             }
     }
        public void setXYIA(Tabuleiro proximoEstado, Tabuleiro estadoAtual){
            String[][] tabuleiroProximoEstado = proximoEstado.getTabuleiro();
            String[][] tabuleiroEstadoAtual = estadoAtual.getTabuleiro();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!tabuleiroEstadoAtual[i][j].equals(tabuleiroProximoEstado[i][j])) {
                        this.cordenadaXProximaJogadaIA = i;
                        this.cordenadaYProximaJogadaIA = j;
                    }
                    
                }
                
            }
        }
     
}


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
    

    public Tela() {
        super("Jogo da Velha - Tec. Desenv. de jogos digitais");
        this.setVisible(true);
        this.setLayout(new GridLayout(3,3));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        
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
        String texto;
        
        if( jogador == 1 ){
            texto = "X";
            this.jogador = 2;
            
        } else{
            texto = "O";
            this.jogador =1;
        } 
        botoes[x][y].setText(texto);
        botoes[x][y].setFont(new Font ("Dialog",0, 75));
        tabuleiro.adicionarJogada(x, y, texto);
        if(tabuleiro.verificarVencedor(texto)){
            JOptionPane.showMessageDialog(null,"Venceu o Jogador:" + texto);
        }
    }
    
    
    
}

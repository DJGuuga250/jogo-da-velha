


public class Tabuleiro {
    private String tabuleiro[][] = new String[3][3];
    int j;
    int i;
    
    public void adicionarJogada(int x, int y, String valor) {
        this.tabuleiro[x][y] = valor;
    }
    public void limparTabuleiro() {
        for (int i=0; i < 3; i++ ){
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = " ";
                
            }
        }
    }
    private boolean validarHorizontal(String valor){
        for(int i = 0; i < 3; i++){
            if (valor.equals(tabuleiro[i][0]) && valor.equals(tabuleiro[i][1])
                    && valor.equals(tabuleiro[i][2])) {
                return true; 
                
            }
        }
        return false;
    }
    private boolean validarVertical(String valor){
        for(int i = 0; i < 3; i++){
            if (valor.equals(tabuleiro[i][0]) && valor.equals(tabuleiro[1][i])
                    && valor.equals(tabuleiro[2][i])) {
                return true; 
                
            }
        }
        return false;
    }
    private boolean validarDiagonal (String valor){
        if(valor.equals(tabuleiro [0][0]) && valor.equals(tabuleiro[1][1])
            && valor.equals(tabuleiro[2][2])){
            return true;
        }
       if(valor.equals(tabuleiro [0][2]) && valor.equals(tabuleiro[1][1])
            && valor.equals(tabuleiro[0][0])){
            return true;
    }
       return false;
    }
    
            
   public boolean verificarVencedor(String valor){
        return validarHorizontal(valor) || validarVertical(valor) || validarDiagonal(valor);
    }
   @Override
  protected Object clone( ) throws CloneNotSupportedException{
      Tabuleiro tabuleiro = new Tabuleiro();
      String [][] tabuleiroString = new String[3][3];
      for (int i = 0; i < this.tabuleiro.length; i++){
          
      for (int j = 0; j < this.tabuleiro.length; j++){
          tabuleiroString[i][j] = this.tabuleiro[i][j];
      }
      }
      tabuleiro.setTabuleiro(tabuleiroString);
        return tabuleiro;
  }
    public void setTabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
        
    }
    public boolean isVazio(int x, int y){
        return this.tabuleiro[x][y].equals(" ");
        
    }
    public boolean isFimDeJogo(){
        if (verificarVencedor("X") || verificarVencedor("O")){
        return true;
        
    }else{
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro.length; j++) {
                    if (isVazio(i,j))
                        return false;
                }
                
            }
            return true;
        }
    }
   
    
}

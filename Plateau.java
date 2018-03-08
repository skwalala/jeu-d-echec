import java.util.*;

class Plateau{
  private Piece plateau[][];

  public Plateau(){
    this.plateau = new Piece[8][8];
    for (int i = 0 ; i < 8 ; i++ ) {
      if (i == 1 ) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[i][j] = new Piece(i,j,"noir","P");
        }
      }
      if (i == 6 ) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[i][j] = new Piece(i,j,"noir","P");
        }
      }
      if (i != 1 && i != 6) {
        this.plateau[0][0] = new Piece(0,0,"noir","T");
        this.plateau[0][1] = new Piece(0,1,"noir","C");
        this.plateau[0][2] = new Piece(0,2,"noir","F");
        this.plateau[0][3] = new Piece(0,3,"noir","D");
        this.plateau[0][4] = new Piece(0,4,"noir","R");
        this.plateau[0][5] = new Piece(0,5,"noir","F");
        this.plateau[0][6] = new Piece(0,6,"noir","C");
        this.plateau[0][7] = new Piece(0,7,"noir","T");
        this.plateau[7][0] = new Piece(0,0,"blanc","T");
        this.plateau[7][1] = new Piece(0,1,"blanc","C");
        this.plateau[7][2] = new Piece(0,2,"blanc","F");
        this.plateau[7][3] = new Piece(0,3,"blanc","D");
        this.plateau[7][4] = new Piece(0,4,"blanc","R");
        this.plateau[7][5] = new Piece(0,5,"blanc","F");
        this.plateau[7][6] = new Piece(0,6,"blanc","C");
        this.plateau[7][7] = new Piece(0,7,"blanc","T");
      }
      if (i > 2 && i < 6) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[i][j] = null;
        }
      }
    }
  }

  public void affichePlateau(){
          System.out.println("+---+---+---+---+---+---+---+---+");
    for (int i = 0 ; i < 8 ; i++ ) {

      System.out.print("| ");
      for (int j = 0 ; j < 8 ; j++ ) {
        if ((this.plateau[i][j]) instanceof Piece) {
          System.out.print((this.plateau[i][j]).getNom() + " | ");
        }else {
          System.out.print("- | ");
        }

      }
      System.out.println();
      System.out.println("+---+---+---+---+---+---+---+---+");
    }
  }

  public static void main(String[] args) {
    Plateau p = new Plateau();

    p.affichePlateau();
  }
}

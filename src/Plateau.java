import java.util.*;

class Plateau{
  private Piece plateau[][];

  public Plateau(){
    this.plateau = new Piece[8][8];
    for (int i = 0 ; i < 8 ; i++ ) {
      if (i == 1 ) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[j][i] = new Piece(j,i,"noir","P");
        }
      }
      if (i == 6 ) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[j][i] = new Piece(j,i,"noir","P");
        }
      }
      if (i != 1 && i != 6) {
        this.plateau[0][0] = new Piece(0,0,"blanc","T");
        this.plateau[1][0] = new Piece(1,0,"blanc","C");
        this.plateau[2][0] = new Piece(2,0,"blanc","F");
        this.plateau[3][0] = new Piece(3,0,"blanc","D");
        this.plateau[4][0] = new Piece(4,0,"blanc","R");
        this.plateau[5][0] = new Piece(5,0,"blanc","F");
        this.plateau[6][0] = new Piece(6,0,"blanc","C");
        this.plateau[7][0] = new Piece(7,0,"blanc","T");
        this.plateau[0][7] = new Piece(0,7,"noir","T");
        this.plateau[1][7] = new Piece(1,7,"noir","C");
        this.plateau[2][7] = new Piece(2,7,"noir","F");
        this.plateau[3][7] = new Piece(3,7,"noir","D");
        this.plateau[4][7] = new Piece(4,7,"noir","R");
        this.plateau[5][7] = new Piece(5,7,"noir","F");
        this.plateau[6][7] = new Piece(6,7,"noir","C");
        this.plateau[7][7] = new Piece(7,7,"noir","T");
      }
      if (i > 2 && i < 6) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[j][i] = null;
        }
      }
    }
  }

  public void affichePlateau(){
          System.out.println("+---+---+---+---+---+---+---+---+");
    for (int i = 0 ; i < 8 ; i++ ) {

      System.out.print("| ");
      for (int j = 0 ; j < 8 ; j++ ) {
        if ((this.plateau[j][i]) instanceof Piece) {
          System.out.print((this.plateau[j][i]).getNom() + " | ");
        }else {
          System.out.print("- | ");
        }

      }
      System.out.println();
      System.out.println("+---+---+---+---+---+---+---+---+");
    }
  }

  /**
  * Renvoie true si il y à une pièce de la couleur "couleur" aux coordonées x,y
  * @param x coordonée en x (int)
  * @param y coordonée en y (int)
  * @param couleur couleur à vérifier (string) (mettre this.couleur lors de l'appel de la fonction depuis une classe pièce)
  * @return true si pièce de la même couleur à l'emplacement. sinon return false
  */
  
  public boolean estOcuppeParPieceEquipe(int x, int y, String couleur){
	if (this.plateau[x][y]!=null){
		if (this.plateau[x][y].getCouleur().equals(couleur)){
			return true;
		}
		return false;
	}
	return false;
  }

  public Piece[][] getPlateau(){
	return this.plateau;
  }
}

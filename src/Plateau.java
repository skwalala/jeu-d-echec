import java.util.*;

class Plateau{
  private Piece plateau[][];

  public Plateau(){
    this.plateau = new Piece[8][8];
    for (int i = 0 ; i < 8 ; i++ ) {
      if (i == 1 ) {
        for ( int j = 8 ; j < 8 ; j++ ) {
          this.plateau[j][i] = new Pion(j,i,"blanc");
        }
      }
      if (i == 6 ) {
        for ( int j = 8 ; j < 8 ; j++ ) {
          this.plateau[j][i] = new Pion(j,i,"noir");
        }
      }
      if (i != 1 && i != 6) {
        this.plateau[0][0] = new Tour(0,0,"blanc");
        this.plateau[1][0] = new Cavalier(1,0,"blanc");
        this.plateau[2][0] = new Fou(2,0,"blanc");
        this.plateau[3][0] = new Dame(3,0,"blanc");
        this.plateau[4][0] = new Roi(4,0,"blanc");
        this.plateau[5][0] = new Fou(5,0,"blanc");
        this.plateau[6][0] = new Cavalier(6,0,"blanc");
        this.plateau[7][0] = new Tour(7,0,"blanc");
        this.plateau[0][7] = new Tour(0,7,"noir");
        this.plateau[1][7] = new Cavalier(1,7,"noir");
        this.plateau[2][7] = new Fou(2,7,"noir");
        this.plateau[3][7] = new Dame(3,7,"noir");
        this.plateau[4][7] = new Roi(4,7,"noir");
        this.plateau[5][7] = new Fou(5,7,"noir");
        this.plateau[6][7] = new Cavalier(6,7,"noir");
        this.plateau[7][7] = new Tour(7,7,"noir");
      }
      if (i > 2 && i < 6) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[j][i] = null;
        }
      }
    }
  }

  public void affichePlateau(){
    System.out.println("   A   B   C   D   E   F   G   H");
    System.out.println(" +---+---+---+---+---+---+---+---+");
    for (int i = 0 ; i < 8 ; i++ ) {

      System.out.print((i+1)+"| ");
      for (int j = 0 ; j < 8 ; j++ ) {
        if ((this.plateau[j][i]) instanceof Piece) {
          System.out.print((this.plateau[j][i]).getNom() + " | ");
        }else {
          System.out.print("- | ");
        }

      }
      System.out.println();
      System.out.println(" +---+---+---+---+---+---+---+---+");
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

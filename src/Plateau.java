import java.util.*;
import java.awt.*;
import javax.swing.*;

class Plateau extends JFrame{
  private Piece plateau[][];
  public ControlButton controlButton;

  public Plateau(){
    initPLateau();
    this.setSize(1000,1000);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void initPLateau(){
    JPanel pGrille = new JPanel(new GridLayout(8,8));
    JButton but;

    this.plateau = new Piece[8][8];
    this.plateau[0][0] = new Tour(0,0,"blanc");
    this.plateau[0][1] = new Cavalier(0,1,"blanc");
    this.plateau[0][2] = new Fou(0,2,"blanc");
    this.plateau[0][3] = new Dame(0,3,"blanc");
    this.plateau[0][4] = new Roi(0,4,"blanc");
    this.plateau[0][5] = new Fou(0,5,"blanc");
    this.plateau[0][6] = new Cavalier(0,6,"blanc");
    this.plateau[0][7] = new Tour(0,7,"blanc");
    this.plateau[7][0] = new Tour(7,0,"noir");
    this.plateau[7][1] = new Cavalier(7,1,"noir");
    this.plateau[7][2] = new Fou(7,2,"noir");
    this.plateau[7][3] = new Dame(7,3,"noir");
    this.plateau[7][4] = new Roi(7,4,"noir");
    this.plateau[7][5] = new Fou(7,5,"noir");
    this.plateau[7][6] = new Cavalier(7,6,"noir");
    this.plateau[7][7] = new Tour(7,7,"noir");
    for (int i = 0 ; i < 8 ; i++ ) {
      if (i == 1 ) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[i][j] = new Pion(i,j,"blanc");
        }
      }
      if (i == 6 ) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[i][j] = new Pion(i,j,"noir");
        }
      }
      if (i > 1 && i < 6) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[i][j] = null;
        }
      }
    }
    for (int i = 0 ; i < 8 ; i++) {
      for (int j = 0 ; j < 8 ; j++) {
        if (i > 1 && i < 6) {
          JPanel pBut = new JPanel();
          but = new JButton("-");
          controlButton = new ControlButton(this, i,j);
          (but).addActionListener(controlButton);
          pBut.add(but);
          pGrille.add(pBut);
        }else {
          JPanel pBut = new JPanel();
          but = new JButton((plateau[i][j]).getNom());
          controlButton = new ControlButton(this, i,j);
          (but).addActionListener(controlButton);
          pBut.add(but);
          pGrille.add(pBut);
        }
      }
    }
    JPanel pAffiche = new JPanel();
    pAffiche.setLayout(new BoxLayout(pAffiche, BoxLayout.X_AXIS));
    pAffiche.add(pGrille);
    pAffiche.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
    setContentPane(pAffiche);


  }

  public void affichePlateau(){
    System.out.println("    A   B   C   D   E   F   G   H");
    System.out.println("  +---+---+---+---+---+---+---+---+");
    for (int i = 0 ; i < 8 ; i++ ) {
      System.out.print((i+1) + " | ");
      for (int j = 0 ; j < 8 ; j++ ) {
        if ((this.plateau[i][j]) instanceof Piece) {
          System.out.print((this.plateau[i][j]).getNom() + " | ");
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

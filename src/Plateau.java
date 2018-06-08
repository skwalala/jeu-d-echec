import java.util.*;
import java.awt.*;
import javax.swing.*;

class Plateau extends JFrame{
  private Piece plateau[][];
  public ControlButton controlButton;
  private JPanel pGrille;
  private JPanel pAffiche;

  public Plateau(){
    initPLateau();
    this.setSize(1000,1000);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void initPLateau(){

    pGrille = new JPanel(new GridLayout(8,8));
    controlButton = new ControlButton(this);
    pAffiche = new JPanel();

    this.plateau = new Piece[8][8];
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
    for (int i = 0 ; i < 8 ; i++ ) {
      if (i == 1 ) {
        for ( int j = 0 ; j < 8 ; j++ ) {
         this.plateau[j][i] = new Pion(j,i,"blanc");
        }
      }
      if (i == 6 ) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[j][i] = new Pion(j,i,"noir");
        }
      }
      if (i > 1 && i < 6) {
        for ( int j = 0 ; j < 8 ; j++ ) {
          this.plateau[j][i] = null;
        }
      }
    }
    display();
  }



  public void affichePlateau(){
    System.out.println("    A   B   C   D   E   F   G   H");
    System.out.println("  +---+---+---+---+---+---+---+---+");
    for (int i = 0 ; i < 8 ; i++ ) {
      System.out.print((i+1) + " | ");
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

  public void roque(Piece roi, int x, int y){
    if (this.plateau[x][y]instanceof Tour) {
      this.remove(roi);
      this.remove(this.plateau[x][y]);
      if (y == 0 && x == 0) {
        this.plateau[2][0] = new Roi(2, 0, "blanc");
        this.plateau[3][0] = new Tout(3, 0, "blanc");
      }
      if (y == 7 && x == 0) {
        this.plateau[6][0] = new Roi(6, 0, "blanc");
        this.plateau[5][0] = new Tout(5, 0, "blanc");
      }
      if (y == 0 && x == 7) {
        this.plateau[2][7] = new Roi(2, 7, "noir");
        this.plateau[3][7] = new Tout(3, 7, "noir");
      }
      if (y == 7 && x == 7) {
        this.plateau[6][7] = new Roi(6, 7, "noir");
        this.plateau[5][7] = new Tout(5, 7, "noir");
      }
    }
  }

  public Piece[][] getPlateau(){
	return this.plateau;
  }
  
  public void display(){
    pAffiche.removeAll();
    pGrille.removeAll();
    Bouton but;
    for (int i = 0 ; i < 8 ; i++) {
      for (int j = 0 ; j < 8 ; j++) {
        JPanel pBut = new JPanel();
	  if (plateau[j][i]!=null) {
          but = new Bouton((plateau[j][i]).getNom(),i,j);
	}else{
          but = new Bouton("-",i,j);
	}
        but.setPreferredSize(new Dimension(100,100));
        but.addActionListener(controlButton);
        pBut.add(but);
        pGrille.add(pBut);
      }
    }
    this.pAffiche.setLayout(new BoxLayout(this.pAffiche, BoxLayout.X_AXIS));
    this.pAffiche.add(pGrille);
    this.pAffiche.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
    setContentPane(this.pAffiche);
  }
}

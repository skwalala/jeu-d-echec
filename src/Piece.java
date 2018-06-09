import java.util.*;

abstract class Piece{
  private int x;
  private int y;
  private String couleur;
  private String nom;

  public Piece(int x, int y, String couleur, String nom){
    this.x = x;
    this.y = y;
    this.couleur = couleur;
    this.nom = nom;
  }

  public Piece(){
  }

  public int getPosX(){
    return this.x;
  }

  public int getPosY(){
    return this.y;
  }

  public String getCouleur(){
    return this.couleur;
  }

  public String getNom(){
    return this.nom;
  }
  public int setPosX(int x){
    return this.x = x;
  }

  public int setPosY(int y){
    return this.y = y;
  }

  public String setCouleur(String couleur){
    return this.couleur = couleur;
  }

  public String setNom(String nom){
    return this.nom = nom;
  }

  public abstract boolean seDeplace(Piece[][] p, int x, int y);

  public int[][] getAllDeplacement(Piece[][] p){
	int grille[][] =new int[8][8];
	for(int i=0; i<8; i++){
		for (int j=0; j<8; j++){
			if (seDeplace(p,i,j))
				grille[i][j]=1;
			else
				grille[i][j]=0;
		}
	}
	return grille;
  }

  public boolean estOcuppeParPieceEquipe(int x, int y, String couleur, Piece[][] plateau){
	if (plateau[x][y]!=null){
		if (plateau[x][y].getCouleur().equals(couleur)){
			return true;
		}
		return false;
	}
	return false;
  }


  /*public boolean checkDevant(Piece plateau[][], int deplacementX, int deplacementY){
    if (this.getPosX() != 1 && this.getPosX() !=8 && this.getPosY() != 1 && this.getPosY() !=8 ) {
      if (plateau[deplacementX][deplacementY] == null) {
        return true;
      }
      if (plateau[deplacementX][deplacementY] != null) {
        return false;
      }

    }
  }*/
}

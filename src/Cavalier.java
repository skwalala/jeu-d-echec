import java.util.*;

public class Cavalier extends Piece{
	public Cavalier(int x, int y, String couleur){
		super(x,y,"C",couleur);
	}

	public boolean seDeplace(Piece[][] p, int dx, int dy){
		if (((super.getPosX()+2==dx)&&(super.getPosY()+1==dy))||
			((super.getPosX()+2==dx)&&(super.getPosY()-1==dy))||
			((super.getPosX()+1==dx)&&(super.getPosY()+2==dy))||
			((super.getPosX()+1==dx)&&(super.getPosY()-2==dy))||
			((super.getPosX()-1==dx)&&(super.getPosY()+2==dy))||
			((super.getPosX()-1==dx)&&(super.getPosY()-2==dy))||
			((super.getPosX()-2==dx)&&(super.getPosY()+1==dy))||
			((super.getPosX()-2==dx)&&(super.getPosY()-1==dy))){
			if (super.estOcuppeParPieceEquipe(dx,dy,super.getCouleur(),p)==false){
				return true;
			}
			
		}
		return false;
	}

	public int[][] getAllDeplacement(Piece[][] p){
		int grille[][] =new int[8][8];
		for(int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				if (((super.getPosX()+2==i)&&(super.getPosY()+1==j))||
					((super.getPosX()+2==i)&&(super.getPosY()-1==j))||
					((super.getPosX()+1==i)&&(super.getPosY()+2==j))||
					((super.getPosX()+1==i)&&(super.getPosY()-2==j))||
					((super.getPosX()-1==i)&&(super.getPosY()+2==j))||
					((super.getPosX()-1==i)&&(super.getPosY()-2==j))||
					((super.getPosX()-2==i)&&(super.getPosY()+1==j))||
					((super.getPosX()-2==i)&&(super.getPosY()-1==j))){
					if (super.estOcuppeParPieceEquipe(i,j,super.getCouleur(),p)==false){
						grille[i][j]=1;
					}
				}else{
					grille[i][j]=0;
				}
			}
		}
		grille[super.getPosX()][super.getPosY()]=1;
		return grille;
	}
}
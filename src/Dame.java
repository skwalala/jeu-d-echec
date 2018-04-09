import java.util.*;

public class Dame extends Piece{
	public Dame(int x, int y, String couleur){
		super(x,y,"D",couleur);
	}

	public boolean seDeplace(Piece[][] p, int dx, int dy){
		if ((super.getPosX()==dx || super.getPosY()==dy) && checkDeplace(p,dx,dy)) //déplacement comme tour
			return true;
		else{
			int i;
			for (i=0; i>=super.getPosX()-dx; i--){} //place i en tant que différence entre la position initiale et la position demandée
			for (i=i; i<super.getPosX()-dx; i++){} //pareil mais dans l'autre sens
			if (super.getPosY()-dy==i && checkDeplace(p,dx,dy)) //vérifie si la différence est la même sur l'axe Y
				return true;
		}
		return false;
	}

	public boolean checkDeplace(Piece[][] p, int dx, int dy){
		int initX=super.getPosX();
		int initY=super.getPosY();

		int i=initX;
		int j=initY;
		while(i!=dx && j!=dy){
			if (p[i][j]!=null){
			 return false;
			}
			if (i<dx){
				i++;
			}
			if (i>dx){
				i--;
			}
			if (j<dy){
				j++;
			}
			if (j>dy){
				j--;
			}
		}
		return !super.estOcuppeParPieceEquipe(dx,dy,super.getCouleur(),p);
	}

	public int[][] getAllDeplacement(Piece[][] p){
		int grille[][] =new int[8][8];
		for(int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				if (i!=super.getPosX() && j!=super.getPosY())
					grille[i][j]=0;
				else
					grille[i][j]=1;
			}
		}
		return grille;
	}
}
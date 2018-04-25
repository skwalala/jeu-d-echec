import java.util.*;
import java.lang.Math;

public class Dame extends Piece{
	public Dame(int x, int y, String couleur){
		super(x,y,couleur,"D");
	}

	public boolean seDeplace(Piece[][] p, int dx, int dy){
		if ((super.getPosX()==dx || super.getPosY()==dy) && checkDeplace(p,dx,dy)){ //déplacement comme tour
			if (super.getPosX()==dx){
				System.out.println("deplacement haut-bas");
			}
			if (super.getPosY()==dy){
				System.out.println("deplacement gauche-droite");
			}
			return true;
		}else{
			int diffX=Math.abs(dx-super.getPosX());
			int diffY=Math.abs(dy-super.getPosY());
			System.out.println(diffX);
			System.out.println(diffY);
			if(diffX==diffY && checkDeplace(p,dx,dy)){
				return true;
			}
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
				System.out.println(i);
			}
			if (i>dx){
				i--;
				System.out.println(i);
			}
			if (j<dy){
				j++;
				System.out.println(j);
			}
			if (j>dy){
				j--;
				System.out.println(j);
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
		for (int x=1; x<8; x++){
      		if(super.getPosX()+x < 8 && super.getPosY()+x <8){
 				grille[super.getPosX()+x][super.getPosY()+x]=1;
 			}
 			if(super.getPosX()+x < 8 && super.getPosY()-x >=0){
 				grille[super.getPosX()+x][super.getPosY()-x]=1;
 			}
 			if(super.getPosX()-x >=0 && super.getPosY()+x <8){
 				grille[super.getPosX()-x][super.getPosY()+x]=1;
 			}
 			if(super.getPosX()-x >=0 && super.getPosY()-x >=0){
 				grille[super.getPosX()-x][super.getPosY()-x]=1;
 			}
 		}
		return grille;
	}
}

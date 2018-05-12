import java.util.*;
import java.lang.Math;

public class Dame extends Piece{
	public Dame(int x, int y, String couleur){
		super(x,y,couleur,"D");
	}

	public boolean seDeplace(Piece[][] p, int dx, int dy){
		if (super.getPosX()==dx || super.getPosY()==dy){
			System.out.println("tour like");
			return checkDeplace(p, dx, dy);
		}else if(Math.abs(dx-super.getPosX())==Math.abs(dy-super.getPosY())){
			System.out.println("fou like");
			return checkDeplace(p, dx, dy);

		}
		return false;
	}

	public boolean checkDeplace(Piece[][] p, int dx, int dy){
		int initX=super.getPosX();
		int initY=super.getPosY();

		int i=initX;
		int j=initY;
		while(i!=dx && j!=dy){
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
			System.out.println(i);
			System.out.println(j);
			if(i!=dx || j!=dy){
				if (p[i][j]!=null){
					return false;
				}
			}
		}
		return !super.estOcuppeParPieceEquipe(dx,dy,super.getCouleur(),p);
	}

	public int[][] getAllDeplacement(Piece[][] p){
		int grille[][] =new int[8][8];
		for(int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				if (seDeplace(p,i,j))
					grille[i][j]=0;
				else
					grille[i][j]=1;
			}
		}

		/* quesaca ?
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
		*/
	}
}

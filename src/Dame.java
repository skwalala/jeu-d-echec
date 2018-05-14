import java.util.*;
import java.lang.Math;

public class Dame extends Piece{
	public Dame(int x, int y, String couleur){
		super(x,y,couleur,"D");
	}

	public boolean seDeplace(Piece[][] p, int dx, int dy){
		if (super.getPosX()==dx || super.getPosY()==dy){
			return checkDeplace(p, dx, dy);
		}else if(Math.abs(dx-super.getPosX())==Math.abs(dy-super.getPosY())){
			return checkDeplace(p, dx, dy);

		}
		return false;
	}

	public boolean checkDeplace(Piece[][] p, int dx, int dy){
		int initX=super.getPosX();
		int initY=super.getPosY();

		int i=initX;
		int j=initY;

		while(i!=dx || j!=dy){
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
			if(i!=dx || j!=dy){
				if (p[i][j]!=null){
					return false;
				}
			}
		}
		return !super.estOcuppeParPieceEquipe(dx,dy,super.getCouleur(),p);
	}
}

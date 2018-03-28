import java.util.*;

public class Cavalier extends Piece{
	public Cavalier(int x, int y, String couleur){
		super(x,y,"C",couleur);
	}

	public boolean seDeplace(Plateau p, int dx, int dy){
		if (((super.getPosX()+2==dx)&&(super.getPosY()+1==dy))||
			((super.getPosX()+2==dx)&&(super.getPosY()-1==dy))||
			((super.getPosX()+1==dx)&&(super.getPosY()+2==dy))||
			((super.getPosX()+1==dx)&&(super.getPosY()-2==dy))||
			((super.getPosX()-1==dx)&&(super.getPosY()+2==dy))||
			((super.getPosX()-1==dx)&&(super.getPosY()-2==dy))||
			((super.getPosX()-2==dx)&&(super.getPosY()+1==dy))||
			((super.getPosX()-2==dx)&&(super.getPosY()-1==dy))){
			if (estOccuppeParPieceEquipe(dx,dy,super.getCouleur())==false){
				mange(p[dx][dy]);
				return true;
			}
			
		}
		return false;
	}
}
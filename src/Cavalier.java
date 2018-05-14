import java.util.*;

public class Cavalier extends Piece{
	public Cavalier(int x, int y, String couleur){
		super(x,y,couleur,"C");
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
}

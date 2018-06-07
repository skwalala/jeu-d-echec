import java.util.*;
import java.lang.*;

public class Roi extends Piece
{


        // Constructeur tour

        public Roi()
        {

        }

        public Roi(int x, int y, String Couleur)
        {
          super(x, y, Couleur,"R");
        }



        // methode validiter du mouvement

        public boolean estValide(int deplacementX, int deplacementY, Piece[][] p) {

            int x = super.getPosX();
            int y = super.getPosY();
            int a = x;
            int b = y;
            int diffX = deplacementX - x;
            int diffY = deplacementY - y;
            diffX = Math.abs(diffX);
            diffY = Math.abs(diffY);

	    if (Math.abs(diffX)<=1 && Math.abs(diffY)<=1){
	    	return true;
		}
		else{
		return false;
		}

/*            if (x == deplacementX - 1 && y == deplacementY) {

                if (p[a + 1][b] == null) {
                    return true;
                } else {
                    return false;
                }
            }

            if (x == deplacementX + 1 && y == deplacementY) {

                if (p[a - 1][b] == null) {
                    return true;
                } else {
                    return false;
                }
            }

            if (y == deplacementY + 1 && x == deplacementX) {

                if (p[a][b - 1] == null) {

                    return true;
                } else {
                    return false;
                }
            }

            if (y == deplacementY - 1 && x == deplacementX) {


                if (p[a][b + 1] == null) {
                    return true;
                } else {
                    return false;
                }
            }

            if (y == deplacementY - 1 && x == deplacementX - 1) {

                if (p[a + 1][b + 1] == null) {
                    return true;
                } else {
                    return false;
                }
            }

            if (y == deplacementY + 1 && x == deplacementX + 1) {

                if (p[a - 1][b - 1] == null) {
                    return true;
                } else {
                    return false;
                }
            }

            if (y == deplacementY + 1 && x == deplacementX - 1) {

                if (p[a + 1][b - 1] == null) {
                    return true;
                } else {
                    return false;
                }
            }

            if (y == deplacementY - 1 && x == deplacementX + 1) {

                if (p[a - 1][b + 1] == null) {
                    return true;
                } else {
                    return false;
                }
            }

            return false;*/

        }

        public String getNom()
        {
            return super.getNom();
        }

        public int getPosX()
        {
            return super.getPosX();
        }


        public int getPosY()
        {
            return super.getPosY();
        }

        public boolean seDeplace(Piece[][] p, int x, int y) {
       		if (estValide(x,y,p)){
       			if (!(p[x][y]==null)) {
       				if (!(p[x][y].getCouleur().equals(super.getCouleur()))) {
       					return true;
       				} else return false;
       			} else {
       				return true;
       			}
       		} else if (estValide(x,y,p)==false){
       		}
       		return false;
       	}
}

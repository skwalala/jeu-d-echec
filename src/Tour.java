import java.util.*;

public class Tour extends Piece
{


        // Constructeur tour

        public Tour()
        {

        }

        public Tour(int x, int y, String Couleur)
        {
          super(x, y, Couleur,"T");
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

            if ((y * deplacementY == 0) && (x < deplacementX)) {
                for (int i = 0; i < diffX; i++) {
                    if (p[a - 1][0] == null) {
                        a--;
                    } else {
                        return false;
                    }
                }

            }

            if ((y * deplacementY == 0) && (x > deplacementX)) {
                for (int i = 0; i < diffX; i++) {
                    if (p[a + 1][0] == null) {
                        a++;
                    } else {
                        return false;
                    }
                }

            }


            if ((x * deplacementX == 0) && (y < deplacementY)) {
                for (int i = 0; i < diffY; i++) {
                    if (p[0][b - 1] == null) {
                        b--;
                    } else {
                        return false;
                    }
                }
            }

            if ((x * deplacementX == 0) && (y > deplacementY)) {
                for (int i = 0; i < diffY; i++) {
                    if (p[0][b + 1] == null) {
                        b++;
                    } else {
                        return false;
                    }
                }
            }

             return false;
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

         public boolean seDeplace(int x, int y, Piece[][] p) {
       		if (estValide(x,y,p)){
       			if (!(p[x][y]==null)) {
       				if (!(p[x][y].getCouleur()==super.getCouleur())) {
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

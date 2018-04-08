import java.util.*;

public class Roi extends Piece
{


        // Constructeur tour

        public Roi()
        {

        }

        public Roi(int x, int y, String Couleur)
        {
          super(x, y, Couleur,"return ");
        }



        // methode validiter du mouvement

        public boolean estValide(int deplacementX, int deplacementY, Piece[][] p)
        {

          int x =super.getPosX();
      		int y =super.getPosY();
          int a = x;
          int b = y;
      		int diffX = deplacementX - x;
      		int diffY = deplacementY - y;
      		int b=initY;
      		diffX=Math.abs(diffX);
      		diffY=Math.abs(diffY);

          




        }

        @Override
            public String getNom()
        {
            return super.getNom();
        }

         @Override
            public int getPosX()
         {
            return super.getPosX();
         }

         @Override
            public int getPosY()
         {
            return super.getPosY();
         }

         public boolean seDeplace(int x, int y, Piece[][] p) {
       		if (checkDeplace(x,y,p)){
       			if (!(p[x][y]==null)) {
       				if (!(p[x][y].getCouleur()==super.getCouleur())) {
       					return true;
       				} else return false;
       			} else {
       				return true;
       			}
       		} else if (checkDeplace(x,y,p)==false){
       		}
       		return false;
       	}



}

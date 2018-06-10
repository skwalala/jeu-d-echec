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

	    if (diffX!=0 && diffY!=0){
	    	return false;
	    }

	    if (diffX>0 && diffY==0){
	    	for (int i=x+1; i<deplacementX; i++){
			if (p[i][y]!=null){
				return false;
			}
		}
	    	return true;
	    }

	    if (diffX<0 && diffY==0){
	    	for (int i=x-1; i>deplacementX; i--){
			if (p[i][y]!=null){
				return false;
			}
		}
	    	return true;
	    }

	    if (diffY>0 && diffX==0){
	    	for (int i=y+1; i<deplacementY; i++){
			if (p[x][i]!=null){
				return false;
			}
		}
	    	return true;
	    }

	
	    if (diffY<0 && diffX==0){
	    	for (int i=y-1; i>deplacementY; i--){
			if (p[x][i]!=null){
				return false;
			}
		}
	    	return true;
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
	
         public boolean seDeplace(Piece[][] p, int x, int y) {
       		if (estValide(x,y,p)){
       			if (!(p[x][y]==null)) {
       				if (!(p[x][y].getCouleur()==super.getCouleur())) {
       					return true;
       				} else return false;
       			} else {
       				return true;
       			}
       		}
       		return false;
       	}
}

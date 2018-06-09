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

	    if (diffX<0 || diffY==0){
	    	for (int i=x-1; i>deplacementX; i--){
			if (p[y][i]!=null){
				return false;
			}
		}
	    	return true;
	    }

	    if (diffX>0 || diffY==0){
	    	for (int i=x-1; i<deplacementX; i++){
			if (p[y][i]!=null){
				return false;
			}
		}
	    	return true;
	    }

	
	    if (diffY<0 || diffX==0){
	    	for (int i=y-1; i>deplacementY; i--){
			if (p[i][x]!=null){
				return false;
			}
		}
	    	return true;
	    }

	
	    if (diffY>0 || diffX==0){
	    	for (int i=y; i<deplacementY; i++){
			if (p[i][x]!=null){
				return false;
			}
		}
	    	return true;
	    }

	
	    return false;
/*
            if (((y == deplacementY) && (x < deplacementX))) {
                for (int i = 0; i < diffX; i++) {
                    if (p[a + 1][b] == null) {
                        a++;
                        if(a == deplacementX){
                          return true;
                        }
                    } else {
                        return false;
                    }
                }

            }

            if (((y == deplacementY) && (x > deplacementX))) {
                for (int i = 0; i < diffX; i++) {
                    if (p[a - 1][b] == null) {
                        a--;
                        if(a == deplacementX){
                          return true;
                        }
                    } else {
                        return false;
                    }
                }

            }


            if (((x == deplacementX) && (y < deplacementY))) {
                for (int i = 0; i < diffY; i++) {
                    if (p[a][b + 1] == null) {
                        b++;
                        if(b == deplacementY){
                          return true;
                        }
                    } else {
                        return false;
                    }
                }
            }

            if (((x == deplacementX) && (y > deplacementY))) {
                for (int i = 0; i < diffY; i++) {
                    if (p[a][b - 1] == null) {
                        b--;
                        if(b == deplacementY){
                          return true;
                        }
                    } else {
                        return false;
                    }
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

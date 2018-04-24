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
                    if (p[a + 1][0] == null) {
                        a++;
                    } else {
                        return false;
                    }
                }

            }

            if ((y * deplacementY == 0) && (x > deplacementX)) {
                for (int i = 0; i < diffX; i++) {
                    if (p[a - 1][0] == null) {
                        a--;
                    } else {
                        return false;
                    }
                }

            }


            if ((x * deplacementX == 0) && (y < deplacementY)) {
                for (int i = 0; i < diffY; i++) {
                    if (p[0][b + 1] == null) {
                        b++;
                    } else {
                        return false;
                    }
                }
            }

            if ((x * deplacementX == 0) && (y > deplacementY)) {
                for (int i = 0; i < diffY; i++) {
                    if (p[0][b - 1] == null) {
                        b--;
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

         public boolean seDeplace(Piece[][] p,int x, int y) {
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

       	public int[][] getAllDeplacements(Piece[][] p) {
           int tabDeplacements[][] = new int[8][8];

            int initX = super.getPosX();
            int initY = super.getPosY();

            for (int i =0; i<8; i++){
                for (int j =0; j<8; j++){
                    tabDeplacements[i][j]=0;
                }
            }

            int x = initX;
            int y = initY;

            while (x<8) {
                if (p[x][y]==null){
                    tabDeplacements[x][y] = 1;
                    x++;
                } else {
                    if (!(p[x][y].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x][y] = 1;
                    }
                    break;
                }
            }

            while (x>=0) {
                if (p[x][y]==null){
                    tabDeplacements[x][y] = 1;
                    x--;
                } else {
                    if (!(p[x][y].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x][y] = 1;
                    }
                    break;
                }
            }

            while (y<8) {
                if (p[x][y]==null){
                    tabDeplacements[x][y] = 1;
                    y++;
                } else {
                    if (!(p[x][y].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x][y] = 1;
                    }
                    break;
                }
            }

            while (y>=0) {
                if (p[x][y]==null){
                    tabDeplacements[x][y] = 1;
                    y--;
                } else {
                    if (!(p[x][y].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x][y] = 1;
                    }
                    break;
                }
            }



            return tabDeplacements;
        }



}

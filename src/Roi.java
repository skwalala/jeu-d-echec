import java.util.*;

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

            if (x == deplacementX - 1 && y == deplacementY) {

                if (p[a + 1][0] == null) {
                    return true;
                } else {
                    return false;
                }
            }

            if (x == deplacementX + 1 && y == deplacementY) {

                if (p[a - 1][0] == null) {
                    return true;
                } else {
                    return false;
                }
            }

            if (y == deplacementY + 1 && x == deplacementX) {

                if (p[0][b - 1] == null) {

                    return true;
                } else {
                    return false;
                }
            }

            if (y == deplacementY - 1 && x == deplacementX) {


                if (p[0][b + 1] == null) {
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

            if(x+1<8){
                if (p[x+1][y]==null){
                    tabDeplacements[x+1][y] = 1;
                } else {
                    if (!(p[x+1][y].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x+1][y] = 1;
                    }
                }
            }

            if(x-1>=0){
                if (p[x-1][y]==null){
                    tabDeplacements[x-1][y] = 1;
                } else {
                    if (!(p[x-1][y].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x-1][y] = 1;
                    }
                }
            }

            if(y-1>=0){
                if (p[x][y-1]==null){
                    tabDeplacements[x][y-1] = 1;
                } else {
                    if (!(p[x][y-1].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x][y-1] = 1;
                    }
                }
            }

            if(y+1<8){
                if (p[x][y+1]==null){
                    tabDeplacements[x][y+1] = 1;
                } else {
                    if (!(p[x][y+1].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x][y+1] = 1;
                    }
                }
            }

            if(y-1>=0 && x-1>=0){
                if (p[x-1][y-1]==null){
                    tabDeplacements[x-1][y-1] = 1;
                } else {
                    if (!(p[x-1][y-1].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x-1][y-1] = 1;
                    }
                }
            }

            if(y+1<8 && x-1>=0){
                if (p[x-1][y+1]==null){
                    tabDeplacements[x-1][y+1] = 1;
                } else {
                    if (!(p[x-1][y+1].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x-1][y+1] = 1;
                    }
                }
            }

            if(y-1>=0 && x+1<8){
                if (p[x+1][y-1]==null){
                    tabDeplacements[x+1][y-1] = 1;
                } else {
                    if (!(p[x+1][y-1].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x+1][y-1] = 1;
                    }
                }
            }

            if(y+1<8 && x+1<8){
                if (p[x+1][y+1]==null){
                    tabDeplacements[x+1][y+1] = 1;
                } else {
                    if (!(p[x+1][y+1].getCouleur()==super.getCouleur())) {
                        tabDeplacements[x+1][y+1] = 1;
                    }
                }
            }

            return tabDeplacements;


        }

}

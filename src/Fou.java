import java.lang.Math;
class Fou extends Piece{

	/*
	 * constructeur vide
	 */
	public Fou(){}

	/*
	 * constructeur avec les positions en x, y et la couleur
	 */
	public Fou(int x, int y, String couleur){
		super(x,y,couleur,"F");
	}

	/*
	 * reçoit une demande de déplacement et l'éxecute si celle-ci est possible
	 */
	public boolean seDeplace(int x, int y, Piece[][] p) {
		if (checkDeplace(x,y,p)){
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

	/*
	 * vérifie si le déplacement est possible
	 */
	public boolean checkDeplace(int newX, int newY, Piece[][] p){
		int initX=super.getPosX();
		int initY=super.getPosY();
		int diffX=newX-initX;
		int diffY=newY-initY;
		int b=initY;
		diffX=Math.abs(diffX);
		diffY=Math.abs(diffY);

		if (diffX==diffY) {
			if( newX<initX && newY<initY ) {
				for (int a=initX-1 ; a>newX-1 ; a--){
					b--;
					if (!(p[a][b]==null)){
						return false;
					}
				}
			} else if ( newX>initX && newY<initY ) {
				for (int a=initX+1 ; a<newX-1 ; a++){
					b--;
					if (!(p[a][b]==null)){
						return false;
					}
				}
			} else if ( newX<initX && newY>initY ) {
				for (int a=initX-1 ; a>newX-1 ; a--){
					b++;
					if (!(p[a][b]==null)){
						return false;
					}
				}
			} else if ( newX>initX && newY>initY ) {
				for (int a=initX+1 ; a<newX-1 ; a++){
					b++;
					if (!(p[a][b]==null)){
						return false;
					}
				}
			}
		}
		return true;
	}

	public int[][] getAllDeplacements(Piece[][] p){
		int tabDeplacements[][] = new int[8][8];

		int initX = super.getPosX();
		int initY = super.getPosY();

		boolean finDeDiagonale = false;

		for (int i = 0 ; i < 8 ; i++ ) {
			for (int j = 0 ; j < 8 ; j++ ) {
				tabDeplacements[i][j]=0;
			}
		}

		tabDeplacements[initX][initY] = 1;

		int x=initX+1;
		int y=initY+1;


		while (x<8 && y<8 && finDeDiagonale==false) {
			if (p[x][y]==null){
				tabDeplacements[x][y] = 1;
				x++;
				y++;
			} else {
				if (!(p[x][y].getCouleur()==super.getCouleur())) {
					tabDeplacements[x][y] = 1;
				}
				finDeDiagonale=true;
			}	
		}

		finDeDiagonale=false;
		x=initX+1;
		y=initY-1;
		while (x<8 && y>=0 && finDeDiagonale==false) {
			if (p[x][y]==null){
				tabDeplacements[x][y] = 1;
				x++;
				y--;
			} else {
				if (!(p[x][y].getCouleur()==super.getCouleur())) {
					tabDeplacements[x][y] = 1;
				}
				finDeDiagonale=true;
			}	
		}

		finDeDiagonale=false;
		x=initX-1;
		y=initY+1;
		while (x>=0 && y<8 && finDeDiagonale==false) {
			if (p[x][y]==null){
				tabDeplacements[x][y] = 1;
				x--;
				y++;
			} else {
				if (!(p[x][y].getCouleur()==super.getCouleur())) {
					tabDeplacements[x][y] = 1;
				}
				finDeDiagonale=true;
			}	
		}

		finDeDiagonale=false;
		x=initX-1;
		y=initY-1;
		while (x<8 && y<8 && finDeDiagonale==false) {
			if (p[x][y]==null){
				tabDeplacements[x][y] = 1;
				x--;
				y--;
			} else {
				if (!(p[x][y].getCouleur()==super.getCouleur())) {
					tabDeplacements[x][y] = 1;
				}
				finDeDiagonale=true;
			}	
		}
		return tabDeplacements;
	}
}

class Pion extends Piece{

	/*
	 * constructeur vide
	 */
	public Pion(){}

	/*
	 * constructeur avec les positions en x, y et la couleur
	 */
	public Pion(int x, int y, String couleur){ 
		super(x,y,couleur,"P");
	}

	/*
	 * reçoit une demande de déplacement et l'éxecute si celle-ci est possible
	 */
	public boolean seDeplace(Piece[][] p, int x, int y){
		return checkDeplace(x,y,p);
	}

	/*
	 * vérifie si le déplacement est possible
	 */
	public boolean checkDeplace(int newX, int newY, Piece[][] p){
		int initX=super.getPosX();
		int initY=super.getPosY();

		if (super.getCouleur()=="blanc"){
			if (newX==initX){ // déplacement vertical
				if (initY==1){ // si la pièce est à sa position initiale (au début de partie)
					if (newY==2){ // déplacement de une case
						if (p[newX][newY]==null){
							return true;
						} else return false;
					}
					if (newY==3){ // déplacement de deux case
						if (p[newX][newY]==null && p[newX][2]==null){
							return true;
						}
					} else return false;
				} else {
					if (newY==initY+1) { // déplacement de une case
						if (p[newX][newY]==null) {
							return true;
						}
					} else return false;
				}
			} else if (newX==initX-1 || newX==initX+1){ // déplacement diagonale
				if (newY==initY+1){ // déplacement de une case
					if (!(p[newX][newY]==null)){
						if (p[newX][newY].getCouleur().equals("noir")){
							return true;
						} else return false;
					} else return false;
				} else return false;
			} else return false;
		

		} else { //pièce de couleur blanche
			if (newX==initX){ // déplacement vertical
				if (initY==6){ // si la pièce est à sa position initiale (au début de partie)
					if (newY==5){ // déplacement de une case
						if (p[newX][newY]==null){
							return true;
						} else return false;
					}
					if (newY==4){ // déplacement de deux case
						if (p[newX][newY]==null && p[newX][5]==null){
							return true;
						}
					} else return false;
				} else {
					if (newY==initY-1) { // déplacement de une case
						if (p[newX][newY]==null) {
							return true;
						}
					} else return false;
				}
			} else if (newX==initX-1 || newX==initX+1){ // déplacement diagonale
				if (newY==initY-1){ // déplacement de une case
					if (!(p[newX][newY]==null)){
						if (p[newX][newY].getCouleur().equals("blanc")){
							return true;
						} else return false;
					} else return false;
				} else return false;
			} else return false;
		}
	return false;
	}



	public int[][] getAllDeplacement(Piece[][] p){
		int tabDeplacements[][] = new int[8][8];

		int initX = super.getPosX();
		int initY = super.getPosY();

		for (int i = 0 ; i < 8 ; i++ ) {
			for (int j = 0 ; j < 8 ; j++ ) {
				tabDeplacements[i][j]=0;
			}
		}

		tabDeplacements[initX][initY] = 1;

		if (super.getCouleur()=="blanc"){
			if (initY==1){ // si la pièce est à sa position initiale (au début de partie)
				if (p[initX][initY+1]==null){
					tabDeplacements[initX][initY+1]=1;
				}
				if (p[initX][initY+2]==null){
					tabDeplacements[initX][initY+2]=1;
				}
				if (initX+1 < 8){
					if (!(p[initX+1][initY+1]==null)) {
						if (p[initX+1][initY+1].getCouleur()=="noir") {
							tabDeplacements[initX+1][initY+1]=1;
						}
					}
				}
				if (initX-1 >= 0){
					if (p[initX-1][initY+1]==null) {
						if (p[initX-1][initY+1].getCouleur()=="noir") {
							tabDeplacements[initX+1][initY+1]=1;
						}
					}
				}
			} else {
				if (p[initX][initY+1]==null){
					tabDeplacements[initX][initY+1]=1;
				}
				if (!(p[initX+1][initY+1]==null)) {
					if (p[initX+1][initY+1].getCouleur()=="noir") {
						tabDeplacements[initX+1][initY+1]=1;
					}
				}
				if (p[initX-1][initY+1]==null) {
					if (p[initX-1][initY+1].getCouleur()=="noir") {
						tabDeplacements[initX+1][initY+1]=1;
					}
				}
			}
		} else { // pièce de couleur noir
			if (initY==6){ // si la pièce est à sa position initiale (au début de partie)
				if (p[initX][initY-1]==null){
					tabDeplacements[initX][initY-1]=1;
				}
				if (p[initX][initY-2]==null){
					tabDeplacements[initX][initY-2]=1;
				}
				if (initX+1 < 8){
					if (!(p[initX+1][initY-1]==null)) {
						if (p[initX+1][initY-1].getCouleur()=="blanc") {
							tabDeplacements[initX+1][initY-1]=1;
						}
					}
				}
				if (initX-1 >= 0){
					if (p[initX-1][initY-1]==null) {
						if (p[initX-1][initY-1].getCouleur()=="blanc") {
							tabDeplacements[initX+1][initY-1]=1;
						}
					}
				}
			} else {
				if (p[initX][initY-1]==null){
					tabDeplacements[initX][initY-1]=1;
				}
				if (!(p[initX+1][initY-1]==null)) {
					if (p[initX+1][initY-1].getCouleur()=="blanc") {
						tabDeplacements[initX+1][initY-1]=1;
					}
				}
				if (p[initX-1][initY-1]==null) {
					if (p[initX-1][initY-1].getCouleur()=="blanc") {
						tabDeplacements[initX+1][initY-1]=1;
					}
				}
			}
		}

		return tabDeplacements;

	}

}


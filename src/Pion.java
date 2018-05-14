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
}

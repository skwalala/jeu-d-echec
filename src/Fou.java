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
	public void seDeplace(int x, int y, Piece[][] p) {
		if (checkDeplace(x,y,p)){
			if (!(p[x][y]==null)) {
				if (!(p[x][y].getCouleur()==super.getCouleur())) {
					mange(x,y,p);
				}
			} else {
				Piece temp;
				temp=p[super.getPosX()][super.getPosY()];
				p[super.getPosX()][super.getPosY()]=null;
				super.setPosX(x);
				super.setPosY(y);
				p[x][y]=temp;
			}
		} else if (checkDeplace(x,y,p)==false){
			
		}
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

	public void mange(int x, int y, Piece[][] p){
		Piece temp;
		temp=p[super.getPosX()][super.getPosY()];
		p[super.getPosX()][super.getPosY()]=null;
		super.setPosX(x);
		super.setPosY(y);
		p[x][y]=temp;
	}
}


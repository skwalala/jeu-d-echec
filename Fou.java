class Fou extends Piece{
	
	public Fou(){}

	public Fou(int x, int y, String couleur){
		super(x,y,'F',couleur);
	}

	public boolean seDeplace(int x, int y) {
		if (x==this.x-1 && y==this.y-1) {

		}
	}

	public boolean mange(int x, int y){
		if (seDeplace(x,y)) {
			return true;
		}
		return false;
	}
}



/*   -x / x / -y / y
*       
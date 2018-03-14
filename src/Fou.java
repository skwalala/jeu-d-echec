import java.lang.Math;
class Fou extends Piece{
	
	public Fou(){}

	public Fou(int x, int y, String couleur){
		super(x,y,couleur,"F");
	}

	public void seDeplace(int x, int y, Piece[][] p) {
		if (checkDeplace(x,y,p)=="true"){
			Piece temp;
			temp=p[super.getPosX()][super.getPosY()];
			p[super.getPosX()][super.getPosY()]=null;
			this.x=x;
			this.y=y;
			p[x][y]=temp;
		} else if (checkDeplace(x,y,p)=="mange"){
			this.mange(x,y,p);
		}
	}

	public String checkDeplace(int newX, int newY, Piece[][] p){
		int initX=super.getPosX();
		int initY=super.getPosY();
		int diffX=newX-initX;
		int diffY=newY-initY;
		int b=initY;
		diffX=Math.abs(diffX);
		diffY=Math.abs(diffY);

		if (diffX==diffY) {
			if( newX<initX && newY<initY ) {
				for (int a=initX-1 ; a>newX ; a--){
					b--;
					if (!(p[a][b]==null)){
						if(a==newX && b == newY){
							return "mange";
						} else return "false";
					}
				}
			} else if ( newX>initX && newY<initY ) {
				for (int a=initX+1 ; a<newX ; a++){
					b--;
					if (!(p[a][b]==null)){
						if(a==newX && b == newY){
							return "mange";
						} else return "false";
					}
				}
			} else if ( newX<initX && newY>initY ) {
				for (int a=initX-1 ; a>newX ; a--){
					b++;
					if (!(p[a][b]==null)){
						if(a==newX && b == newY){
							return "mange";
						} else return "false";
					}
				}
			} else if ( newX>initX && newY>initY ) {
				for (int a=initX+1 ; a<newX ; a++){
					b++;
					if (!(p[a][b]==null)){
						if(a==newX && b == newY){
							return "mange";
						} else return "false";
					}
				}
			}
		}
	}

	public boolean mange(int x, int y, Piece[][] p){
		Piece temp;
		temp=p[super.getPosX()][super.getPosY()];
		p[super.getPosX()][super.getPosY()]=null;
		this.x=x;
		this.y=y;
		p[x][y]=temp;
	}
}


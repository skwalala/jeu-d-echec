import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.WindowEvent;

public class Jeu extends Component {
    static final Scanner input = new Scanner(System.in);
    public static int[] coordonnees;
    public static String camp = "";
    public static Plateau p;
    private static int xPiece;
    private static int yPiece;
    private static int newXPiece;
    private static int newYPiece;

    public static int[] getCoordonnéePiece() {
        int[] coordonneesPiece = new int[2];
        coordonneesPiece[0] = coordonnees[0];
        coordonneesPiece[1] = coordonnees[1];
        return coordonneesPiece;
    }

    public static int[] getCoordonnéeDeplacement() {
        int[] coordonneesDeplacement = new int[2];
        coordonneesDeplacement[0] = coordonnees[2];
        coordonneesDeplacement[1] = coordonnees[3];
        return coordonneesDeplacement;
    }

    public static void verif(int i, int j, JButton but) {
        Piece[][] pieces = p.getPlateau();
    	if(Jeu.coordonnees[0] == 9 && Jeu.coordonnees[1] == 9){
        	if (pieces[j][i] != null) {
	            if (pieces[j][i].getCouleur().equals(camp)) {
				Jeu.coordonnees[0] = i;
	        		Jeu.coordonnees[1] = j;
				but.setBorder(BorderFactory.createLineBorder(Color.red, 5));
        	      		printAllDeplacement(pieces, j, i);
			}else{
				dispErrorSelection();
			}
		}else{
			dispErrorSelection();
		}
	
	}else if(coordonnees[0]==i && coordonnees[1]==j){
		for(int k = 0; k < 4; k++){
                	Jeu.coordonnees[k] = 9;
		}
        	p.affichePlateau();
	        p.display();
	}else{
		Jeu.coordonnees[2] = i;
	        Jeu.coordonnees[3] = j;
	        int[] pieceJoue = getCoordonnéePiece();
        	      xPiece = pieceJoue[1];
	              yPiece = pieceJoue[0];

	              int[] deplacementJoue = getCoordonnéeDeplacement();
                      newXPiece = deplacementJoue[1];
        	      newYPiece = deplacementJoue[0];

		      //check roque
		      if (pieces[xPiece][yPiece]!=null && pieces[newXPiece][newYPiece]!=null
			&& ((pieces[xPiece][yPiece].getNom().equals("R") && pieces[newXPiece][newYPiece].getNom().equals("T"))
			|| ("T".equals(pieces[xPiece][yPiece].getNom()) && "R".equals(pieces[newXPiece][newYPiece].getNom())))){
		      			System.out.println("roque select detected");
					System.out.println("check piece");
					if (roque(pieces, xPiece, yPiece, newXPiece, newYPiece)){
						System.out.println("check roque");
						Piece tempPiece = pieces[newXPiece][newYPiece];
						pieces[newXPiece][newYPiece] = pieces[xPiece][yPiece];
			                        pieces[xPiece][yPiece] = tempPiece;


						if ((isEchec(pieces, camp))){
			                                System.out.println("Roi est en echec, veuillez deplacer le roi.");
							tempPiece = pieces[newXPiece][newYPiece];
							pieces[newXPiece][newYPiece] = pieces[xPiece][yPiece];
			                        	pieces[xPiece][yPiece] = tempPiece;
			                                dispErrorEchec();
			                        }else{
			                        	pieces[newXPiece][newYPiece].setPosX(newXPiece);
				                        pieces[newXPiece][newYPiece].setPosY(newYPiece);
				                        pieces[xPiece][yPiece].setPosX(xPiece);
				                        pieces[xPiece][yPiece].setPosY(xPiece);
                        			        changePion(pieces);
			                                if (camp.equals("noir")) {
                        			            camp = "blanc";
			                                } else {
                    				            camp = "noir";
                                			}
							pieces[newXPiece][newYPiece].setMoved();
							pieces[xPiece][yPiece].setMoved();
                        			}			
			                        for(int k = 0; k < 4; k++){
                        			    Jeu.coordonnees[k] = 9;
			                        }
        					p.affichePlateau();
					        p.display();
					}
		      }else if (!pieces[xPiece][yPiece].seDeplace(pieces, newXPiece, newYPiece)) {
                       	System.out.println("Erreur : veuillez choisir un autre emplacement.");
                        deplacementJoue = null;
			dispErrorPosition();
        	      } else {
	                pieces[newXPiece][newYPiece] = pieces[xPiece][yPiece];
                      	pieces[xPiece][yPiece] = null;
        	        if ((isEchec(pieces, camp))){
	             		System.out.println("Roi est en echec, veuillez deplacer le roi.");
	                      	pieces[xPiece][yPiece] = pieces[newXPiece][newYPiece];
	                	pieces[newXPiece][newYPiece] = null;
				dispErrorEchec();
			}else{
                        	pieces[newXPiece][newYPiece].setPosX(newXPiece);
	        	        pieces[newXPiece][newYPiece].setPosY(newYPiece);
		                changePion(pieces);
                      		if (camp.equals("noir")) {
                	            camp = "blanc";
        		        } else {
		                    camp = "noir";
                      		}
				pieces[newXPiece][newYPiece].setMoved();
			}
			for(int k = 0; k < 4; k++){
	        	    Jeu.coordonnees[k] = 9;
	        	}
        		p.affichePlateau();
		        p.display();
		      }
    		if (isEchecEtMat(pieces,camp)){
			dispEchecEtMat();
		}
	}
    }

    public static void changePion(Piece[][] pieces) {
        if (pieces[newXPiece][newYPiece].getNom().equals("P")){
            if (camp.equals("blanc")){
                if (newYPiece == 7){
                    switch (showChange()){
                        case 0:
                            pieces[newXPiece][newYPiece] = new Dame(newXPiece, newYPiece, "blanc");
                            break;
                        case 1:
                            pieces[newXPiece][newYPiece] = new Fou(newXPiece, newYPiece, "blanc");
                            break;
                        case 2:
                            pieces[newXPiece][newYPiece] = new Cavalier(newXPiece, newYPiece, "blanc");
                            break;
                        case 3:
                            pieces[newXPiece][newYPiece] = new Tour(newXPiece, newYPiece, "blanc");
                            break;
                    }
                }
            }else{
                if (newYPiece == 0){
                    switch (showChange()){
                        case 0:
                            pieces[newXPiece][newYPiece] = new Dame(newXPiece, newYPiece, "noir");
                            break;
                        case 1:
                            pieces[newXPiece][newYPiece] = new Fou(newXPiece, newYPiece, "noir");
                            break;
                        case 2:
                            pieces[newXPiece][newYPiece] = new Cavalier(newXPiece, newYPiece, "noir");
                            break;
                        case 3:
                            pieces[newXPiece][newYPiece] = new Tour(newXPiece, newYPiece, "noir");
                            break;
                    }                }
            }
        }
    }


    public static boolean isEchec(Piece[][] p, String camp) {
        int[] posRoi = getPosRoi(p, camp);
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (p[i][j] != null) {
                    int[][] deplacements = p[i][j].getAllDeplacement(p);
                    if (deplacements[posRoi[0]][posRoi[1]] == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isEchecEtMat(Piece[][] p, String camp){
        int[] posRoi = getPosRoi(p, camp);
	int[][] dep;
	
	Piece[][] tempPlateau = new Piece[8][];
	Piece tempPiece;

	for (int i=0; i<p.length; i++){
		for (int j=0; j<p[i].length;j++){
			if (p[i][j]!=null && p[i][j].getCouleur().equals(camp)){
				dep = p[i][j].getAllDeplacement(p);
        	      		printAllDeplacement(p, i, j);
				for (int x=0; x<dep.length; x++){
					for (int y=0; y<dep[x].length;y++){
						if (dep[x][y]==1){
							for (int z=0; z<8; z++){
								tempPlateau[z] = Arrays.copyOf(p[z],p[z].length);
							}
							tempPiece = tempPlateau[i][j];
                                                	tempPlateau[i][j] = tempPlateau[x][y];
                                                	tempPlateau[x][y] = tempPiece;
							if (!isEchec(tempPlateau, camp)){
								return false;
							}
						}
					}
				}
			}
		}
	}
        return true;
    }

    private static boolean roque(Piece[][] p, int x, int y, int nx, int ny){
    	if (p[x][y].moved()==true || p[nx][ny].moved()==true){
		System.out.println("already moved");
		return false;
	}
	if (x<nx){
		for (int i=x+1;i<x;i++){
			if (p[i][y]!=null){
				System.out.println("piece detected at : "+i); 
				return false;
			}
		}
		return true;
	}else{
		for (int i=nx+1;i<nx;i++){
			if (p[i][y]!=null){
				System.out.println("piece detected at : "+i); 
				return false;
			}
		}
		return true;
	}
    }

    public static int[] getPosRoi(Piece[][] p, String camp) {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (p[i][j] != null && p[i][j].getNom().equals("R") && p[i][j].getCouleur().equals(camp)) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void printAllDeplacement(Piece[][] piece, int x, int y) {
	System.out.println(""+x+"+"+y);
        if (piece[x][y] != null) {
            int[][] deplacement = piece[x][y].getAllDeplacement(piece);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(deplacement[j][i]);
                    System.out.print(" ");
                }
                System.out.println("");
            }
        }

    }

    public static int getxPiece() {
        return xPiece;
    }

    public static int getyPiece() {
        return yPiece;
    }

    public static int getNewXPiece() {
        return newXPiece;
    }

    public static int getNewYPiece() {
        return newYPiece;
    }

    public static int showChange(){
        Object[] options = {"Dame",
                "Fou",
                "Cavalier",
                "Tour"};

        int n = JOptionPane.showOptionDialog(p,
                "Que voulez vous faire ?",
                "Je veux qu'il devienne : ",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[3]);

        return n;
    }

    private static void dispEchecEtMat(){
	JOptionPane.showMessageDialog(p, "echec et mat. "+camp+" a perdu");
	p.dispatchEvent(new WindowEvent(p, WindowEvent.WINDOW_CLOSING));
    }

    private static void dispErrorSelection(){
	JOptionPane.showMessageDialog(p, "erreur veuillez choisir une piece de votre couleur");
    }

    private static void dispErrorPosition(){
	JOptionPane.showMessageDialog(p, "veuillez choisir un emplacement correct");
    }

    private static void dispErrorEchec(){
	JOptionPane.showMessageDialog(p, "attention le roi est en echec");
    }

    public static void main(String[] args) {
        p = new Plateau();
        camp = "blanc";
        coordonnees = new int[4];
        for(int i = 0; i < 4; i++){
            coordonnees[i] = 9;
        }
        p.affichePlateau();
    }
}


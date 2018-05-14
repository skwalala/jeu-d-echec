import java.util.*;
public class Jeu {
    static final Scanner input = new Scanner(System.in);

    public static String getCoordonnéePiece(String camp) {
        System.out.println(camp.concat(" c'est à vous, qu'elle pièce vous voulez déplacer ? "));
        return input.nextLine();
    }

    public static String getCoordonnéeDeplacement() {
        System.out.println("Où voulez vous déplacer votre pièce ?");
        return input.nextLine();
    }

    public static void verif(char[] possA, char[] possB, String camp, Piece[][] p) {
        boolean pieceCorrect = false;
        boolean deplacementCorrect = false;
        int verification = 0;
        char caractXPiece;
        char caractYPiece;
        int xPiece = 0;
        int yPiece = 0;
        while (!pieceCorrect) {
            String pieceJoue = getCoordonnéePiece(camp);
            if ((!pieceJoue.equals("")) && (!pieceJoue.equals(" "))){
                caractXPiece = pieceJoue.charAt(0);
                caractYPiece = pieceJoue.charAt(1);
                for (int i = 0; i < possA.length; i++) {
                    for (int j = 0; j < possB.length; j++) {
                        if (((pieceJoue.length() == 2)) && (caractXPiece == possA[i]) && (caractYPiece == possB[j])){
                            xPiece = i;
                            yPiece = j;
                            //System.out.println("xPiece = "+xPiece+" yPiece = "+yPiece);
                            if (p[xPiece][yPiece] != null) {
                                if (p[xPiece][yPiece].getCouleur().equals(camp)) {
                                    System.out.println(p[xPiece][yPiece].getNom());
				    printAllDeplacement(p,xPiece,yPiece);
                                    verification = 1;
                                }
                            }
                        }
                    }
                }
            }
            if (verification == 1) {
                pieceCorrect = true;
            } else {
                System.out.println("Erreur : veuillez entrer une pièce se situant entre A1 et H8 et de votre camp.");
            }
        }
        while (!deplacementCorrect) {
            String deplacementJoue = getCoordonnéeDeplacement();
            char caractNewXPiece = deplacementJoue.charAt(0);
            char caractNewYPiece = deplacementJoue.charAt(1);
            int newXPiece = 0;
            int newYPiece = 0;
            //System.out.println(xPiece + " " + yPiece);
            for (int i = 0; i < possA.length; i++) {
                if (possA[i] == caractNewXPiece) {
                    newXPiece = i;
                    newYPiece = Character.getNumericValue(caractNewYPiece)-1;
                }
            }
            //System.out.println(newXPiece + " " + newYPiece);
            if (!p[xPiece][yPiece].seDeplace(p, newXPiece, newYPiece)) {
                System.out.println("Erreur : veuillez choisir un autre emplacement.");
            } else {
                p[newXPiece][newYPiece] = p[xPiece][yPiece];
                p[xPiece][yPiece] = null;
                deplacementCorrect = true;
		p[newXPiece][newYPiece].setPosX(newXPiece);
		p[newXPiece][newYPiece].setPosY(newYPiece);
            }
        }
    }


    public static void checkEchec(){
	    
    }


    public static void main(String[] args) {
    	Plateau p = new Plateau();
    	String camp = "";
    	boolean partieFinie = false;
    	char[] possA = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    	char[] possB = {'1', '2', '3', '4', '5', '6', '7','8'};
    	while (!partieFinie) {
    	    p.affichePlateau();
	    camp = "blanc";
	    verif(possA, possB, camp,p.getPlateau());
	    //System.out.print("\033\143");
	    p.affichePlateau();
	    camp = "noir";
	    verif(possA, possB, camp,p.getPlateau());
	    //System.out.print("\033\143");


    	}
    }
    public static void printAllDeplacement(Piece[][] piece, int x, int y){
	    if(piece[x][y]!=null){
	    int[][] deplacement = piece[x][y].getAllDeplacement(piece);
	    for (int i=0; i<8; i++){
	    	for (int j=0;j<8; j++){
			System.out.print(deplacement[j][i]);
			System.out.print(" ");
		}
		System.out.println("");
	    }
	    System.out.println(piece[x][y].getNom());
	    }
	
    }
}

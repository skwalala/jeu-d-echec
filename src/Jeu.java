import java.util.*;
public class Jeu{
	static final Scanner input = new Scanner(System.in);

	public static String getCoordonnéePiece(String camp){
		System.out.println(camp.concat(" c'est à vous, qu'elle pièce vous voulez déplacé ? "));
		return input.nextLine();
	}

	public static String getCoordonnéeDeplacement(){
	    System.out.println("Où voulez vous déplacer votre pièce ?");
	    return input.nextLine();
    }

	public static void verif(char[] possA, char[] possB, String camp, Piece[][] p){
        boolean pieceCorrect = false;
        boolean deplacementCorrect = false;
        int verification = 0;
        char caractXPiece;
        char caractYPiece;
        int xPiece = 0;
        int yPiece = 0;
        while(!pieceCorrect){
            String pieceJoue = getCoordonnéePiece(camp);
            caractXPiece = pieceJoue.charAt(0);
            caractYPiece = pieceJoue.charAt(1);
            for (int i = 0; i<possA.length; i++) {
                for (int j = 0; j < possB.length; j++) {
                    if ((pieceJoue.length() == 2) && (caractXPiece == possA[i]) && (caractYPiece == possB[j])) {
                        if (possA[i] == caractXPiece){
                            xPiece = i;
                            yPiece = Character.getNumericValue(caractYPiece);
                            verification = 1;
                        }
                    }
                }
            }
            if (verification == 1){
                pieceCorrect = true;
            } else {
                System.out.println("Erreur : veuillez entrer une pièce se situant entre A1 et H8.");
            }
        }
        while(!deplacementCorrect){
         String deplacementJoue = getCoordonnéeDeplacement();
         char caractNewXPiece = deplacementJoue.charAt(0);
         char caractNewYPiece = deplacementJoue.charAt(1);
         int newXPiece = 0;
         int newYPiece = 0;
         System.out.println(xPiece+" "+yPiece);
	     System.out.println(caractNewXPiece+" "+caractNewYPiece);
	     for (int i = 0; i<possA.length; i++) {
             if (possA[i] == caractNewXPiece){
                 newXPiece = i;
                 newYPiece = Character.getNumericValue(caractNewYPiece);
             }
         }
         if(!p[xPiece][yPiece].seDeplace(p, newXPiece, newYPiece)){
             System.out.println("Erreur : veuillez choisir un autre emplacement.");
         } else {
             p[xPiece][yPiece].seDeplace(p, newXPiece, newYPiece);
             deplacementCorrect = true;
         }
        }
    }

    public void checkEchec(){
	    
    }

    public static void main(String[] args) {
    	Plateau p = new Plateau();
    	String camp = "";
    	boolean partieFinie = false;
    	char[] possA = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    	char[] possB = {'1', '2', '3', '4', '5', '6', '7', '8'};
    	while (!partieFinie) {
    		p.affichePlateau();
			camp = "Blanc";
    		verif(possA, possB, camp,p.getPlateau());
			camp = "Noir";
		verif(possA, possB, camp,p.getPlateau());
    	}
    }
}

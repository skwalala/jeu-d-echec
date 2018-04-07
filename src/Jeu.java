import java.util.*;
public class Jeu{
	static final Scanner input = new Scanner(System.in);

	public static String getCoordonnée(String pieceJoue, String camp){
		System.out.println(camp.concat(" c'est à vous, qu'elle pièce vous voulez déplacé ? "));
		pieceJoue = input.nextLine();
		return pieceJoue;
	}

	public static int[] verif(char[] possA, char[] possB, String pieceJoue, String camp){
	    int[] pieceConvertis = {};
        boolean pieceCorrect = false;
        int verification = 0;
        while(!pieceCorrect){
            getCoordonnée(pieceJoue, camp);
            char premierCaract = pieceJoue.charAt(0);
            char secondCaract = pieceJoue.charAt(1);
            for (int i = 0; i<possA.length; i++) {
                for (int j = 0; j < possB.length; j++) {
                    if ((pieceJoue.length() == 2) && (premierCaract == possA[i]) && (secondCaract == possB[j])) {
                        verification = 1;
                        int k = pieceConvertis.length;
                        int convertisseur = Integer.parseInt(pieceJoue.substring(0,1));
                        pieceConvertis[k+1] = convertisseur;
                        convertisseur = Integer.parseInt(pieceJoue.substring(1,2));
                        pieceConvertis[k+2] = convertisseur;
                    }
                }
            }
            if (verification == 1){
                pieceCorrect = true;
            } else {
                System.out.println("Erreur : veuillez entrer une pièce se situant entre A1 et H8.");
            }
        }
        return pieceConvertis;
    }

    public void checkEchec(){
	    
    }

    public static void main(String[] args) {
    	//Plateau p = new Plateau();
    	String pieceJoue = "";
    	String camp = "";
    	boolean partieFinie = false;
    	char[] possA = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    	char[] possB = {'1', '2', '3', '4', '5', '6', '7', '8'};
    	while (!partieFinie) {
    		//p.affichePlateau();
			camp = "Blanc";
    		verif(possA, possB, pieceJoue, camp);
			camp = "Noir";
			verif(possA, possB, pieceJoue, camp);
    	}
    }

	/**
	 *
	 *  check echec => verifier si une des pièces addverses peut manger le roi
	 *
	 */
}
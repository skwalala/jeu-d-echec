import java.util.*;
public class Jeu {
    static final Scanner input = new Scanner(System.in);
    public static int[] coordonnees;
    public static String camp = "";
    public static Plateau p;

    public static int[] getCoordonnéePiece(String camp) {
        System.out.println(camp.concat(" c'est à vous, qu'elle pièce vous voulez déplacer ? "));
        int[] coordonneesPiece = new int[2];
        coordonneesPiece[0] = coordonnees[0];
        coordonneesPiece[1] = coordonnees[1];
        return coordonneesPiece;
    }

    public static int[] getCoordonnéeDeplacement() {
        System.out.println("Où voulez vous déplacer votre pièce ?");
        int[] coordonneesDeplacement = new int[2];
        coordonneesDeplacement[0] = coordonnees[2];
        coordonneesDeplacement[1] = coordonnees[3];
        return coordonneesDeplacement;
    }

    public static void verif() {
        Piece[][] pieces = p.getPlateau();
        boolean deplacementCorrect = false;
        int xPiece = 0;
        int yPiece = 0;
        int[] pieceJoue = getCoordonnéePiece(Jeu.camp);
        xPiece = pieceJoue[0];
        yPiece = pieceJoue[1];
        if (pieces[xPiece][yPiece] != null) {
            if (pieces[xPiece][yPiece].getCouleur().equals(Jeu.camp)) {
                System.out.println(pieces[xPiece][yPiece].getNom());
                printAllDeplacement(pieces, xPiece, yPiece);
            }
        }
        while (!deplacementCorrect) {
            int[] deplacementJoue = getCoordonnéeDeplacement();
            int newXPiece = deplacementJoue[0];
            int newYPiece = deplacementJoue[1] - 1;
            if (!pieces[xPiece][yPiece].seDeplace(pieces, newXPiece, newYPiece)) {
                System.out.println("Erreur : veuillez choisir un autre emplacement.");
            } else {
                pieces[newXPiece][newYPiece] = pieces[xPiece][yPiece];
                pieces[xPiece][yPiece] = null;
                deplacementCorrect = true;
                pieces[newXPiece][newYPiece].setPosX(newXPiece);
                pieces[newXPiece][newYPiece].setPosY(newYPiece);
            }
        }
    }


    public boolean isEchec(Piece[][] p, String camp) {
        int[] posRoi = getPosRoi(p, camp);
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                int[][] deplacements = p[i][j].getAllDeplacement(p);
                if (deplacements[posRoi[0]][posRoi[1]] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCheckMat(Piece[][] p, String camp){
        int[] posRoi = getPosRoi(p, camp);
        if (isEchec(p, camp)){
           int[][] getAllDeplacementCouleur = new int[8][8]; // new int[8][8] remplacé par getAllDeplacementCouleur
            for (int i=posRoi[0]-1; i<posRoi[0]+1; i++){
                for (int j=posRoi[1]-1; j<posRoi[1]+1;){
                    if (getAllDeplacementCouleur[i][j] == 0){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public int[] getPosRoi(Piece[][] p, String camp) {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (p[i][j].getNom().equals("R") && p[i][j].getCouleur().equals(camp)) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void printAllDeplacement(Piece[][] piece, int x, int y) {
        if (piece[x][y] != null) {
            int[][] deplacement = piece[x][y].getAllDeplacement(piece);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(deplacement[j][i]);
                    System.out.print(" ");
                }
                System.out.println("");
            }
            System.out.println(piece[x][y].getNom());
        }

    }

    public static void main(String[] args) {
        p = new Plateau();
        coordonnees = new int[4];
        for(int i = 0; i < 4; i++){
            coordonnees[i] = 9;
        }
        p.affichePlateau();
        boolean partieFinie = false;
        /*while (!partieFinie) {
            p.affichePlateau();
            camp = "blanc";
            verif(camp, p.getPlateau());
            //System.out.print("\033\143");
            p.affichePlateau();
            camp = "noir";
            verif(camp, p.getPlateau());
            //System.out.print("\033\143");


        }*/
    }
}


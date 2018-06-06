import java.util.*;
public class Jeu {
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

    public static void verif() {
        Piece[][] pieces = p.getPlateau();
        int[] pieceJoue = getCoordonnéePiece();
        if (pieces[pieceJoue[1]][pieceJoue[0]] != null) {
            if (pieces[pieceJoue[1]][pieceJoue[0]].getCouleur().equals(camp)) {
                if ((isEchec(pieces, camp)) && (!pieces[pieceJoue[1]][pieceJoue[0]].getNom().equals("R"))){
                    System.out.println("Roi est en echec, veuillez deplacer le roi.");
                }else{
                    xPiece = pieceJoue[1];
                    yPiece = pieceJoue[0];
                    System.out.println(pieces[xPiece][yPiece].getNom());
                    printAllDeplacement(pieces, xPiece, yPiece);

                    int[] deplacementJoue = getCoordonnéeDeplacement();
                    newXPiece = deplacementJoue[1];
                    newYPiece = deplacementJoue[0];
                    if (!pieces[xPiece][yPiece].seDeplace(pieces, newXPiece, newYPiece)) {
                        System.out.println("Erreur : veuillez choisir un autre emplacement.");
                        deplacementJoue = null;
                    } else {
                        pieces[newXPiece][newYPiece] = pieces[xPiece][yPiece];
                        pieces[xPiece][yPiece] = null;
                        pieces[newXPiece][newYPiece].setPosX(newXPiece);
                        pieces[newXPiece][newYPiece].setPosY(newYPiece);
                        changePion(pieces);
                        if (camp.equals("noir")) {
                            camp = "blanc";
                        } else {
                            camp = "noir";
                        }
                    }
                }
            }else{
                System.out.println("Erreur : veulliez choisir une autre piece.");
            }
        }
        p.affichePlateau();
    }

    public static void changePion(Piece[][] pieces) {
        if (pieces[newXPiece][newYPiece].getNom().equals("P")){
            if (camp.equals("blanc")){
                if (newYPiece == 7){
                    pieces[newXPiece][newYPiece] = new Dame(newXPiece, newYPiece, "blanc");
                }
            }else{
                if (newYPiece == 0){
                    pieces[newXPiece][newYPiece] = new Dame(newXPiece, newYPiece, "noir");
                }
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


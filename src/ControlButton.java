import java.awt.*;
import java.awt.event.*;
class ControlButton implements ActionListener{

    public Plateau p;

    public ControlButton(Plateau p){
        this.p = p;

    }

    public void actionPerformed (ActionEvent e) {
      Bouton but = (Bouton)e.getSource();
      int i = but.getX();
      int j = but.getY();
      String nom = but.getNom();

      System.out.println("i = " + i + " j = " + j + " nom = " +nom);


      if(Jeu.coordonnees[0] == 9 && Jeu.coordonnees[1] == 9){
          Jeu.coordonnees[0] = i;
          Jeu.coordonnees[1] = j;
      }else if(Jeu.coordonnees[2] == 9 && Jeu.coordonnees[3] == 9){
          Jeu.coordonnees[2] = i;
          Jeu.coordonnees[3] = j;
      }

      for(int l = 0; l < 4; l++ ){
          System.out.println(Jeu.coordonnees[l]);
      }

    }


}

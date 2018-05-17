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
    }


}

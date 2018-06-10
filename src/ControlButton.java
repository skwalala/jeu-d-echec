import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

      Jeu.verif(i,j);
    }


}

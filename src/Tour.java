import java.util.*;

public class Tour extends Piece
{


        // Constructeur tour

        public Tour()
        {

        }

        public Tour(int x, int y, String Couleur)
        {
          super(x, y, Couleur,"T");
        }



        // methode validiter du mouvement

        public boolean estValide(int DeplacementX, int DeplacementY, Piece[][] p)
        {

          int x =super.getPosX();
      		int y =super.getPosY();
      		int diffX = DeplacementX - x;
      		int diffY = DeplacementY - y;
      		int b=initY;
      		diffX=Math.abs(diffX);
      		diffY=Math.abs(diffY);

          if((y * DeplacementY == 0) && (x != DeplacementX))
          {
              //if(checkDevant()== true)
              //{
                  return true;
              //}

          }

          if((x * DeplacementX == 0) && (y != DeplacementY))
          {
              //if (checkDevant() == true)
              //{
                  return true;
              //}
          }
          else
          {
            return false;
          }

        }

        @Override
            public String getNom()
        {
            return super.getNom();
        }

         @Override
            public int getPosX()
         {
            return super.getPosX();
         }

         @Override
            public int getPosY()
         {
            return super.getPosY();
         }

         public void seDeplace(int x, int y, Piece[] p)
         {


             if(estValide(x,y,p)=="true"){
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



}

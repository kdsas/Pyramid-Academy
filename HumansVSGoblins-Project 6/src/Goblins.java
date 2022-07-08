import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Goblins extends Character{

    boolean moveRight;
    boolean moveLeft;

    boolean isVisible;
    boolean isVis;

    public Goblins()
    {
        super();
    }

    public Goblins(int x, int y, int s) {
        super(x, y, s);

        moveLeft=false;
        moveRight=true;
        isVisible=true;
    }



    @Override
    public String toString(){
        return "Goblin";
    }


    public Goblins(int x, int y, int w, int h, int s, String u)
    {
        super(x, y, w, h, s, u);
        isVis=true;
        moveRight=true;
    }

    public void mover(){

    }
    public  void move(int direction){
        if(moveLeft==true)
            setX(getX()-getSpeed());

        if(moveRight==true)
            setX(getX()+getSpeed());

    }
    public void draw(Graphics window){
        window.drawImage(getImage(),getX(),getY(),getWidth(),getHeight(),null);
    }

}

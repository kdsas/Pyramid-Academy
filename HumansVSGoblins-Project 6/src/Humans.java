
import java.awt.Graphics;


public class Humans extends Character{

    boolean moveRight;
    boolean moveLeft;

    public Humans()
    {
        super();
    }

    public Humans(int x, int y, int w, int h, int s, String u)
    {
        super(x, y, w, h, s, "res/human.png");
    }

    public void draw(Graphics window){
        window.drawImage(getImage(),getX(),getY(),getWidth(),getHeight(),null);
    }

    public  void move(int d){
        if(moveLeft)
            setX(getX()-getSpeed());

        if(moveRight){
            setX(getX()+getSpeed());
        }

    }

    public void setLeftRight(int d){
        if(d==37){
            moveLeft = true;
        }

        if(d==39){
            moveRight = true;
        }

    }

    public void stop(){
        moveLeft=false;
        moveRight=false;

    }



    @Override
    public String toString(){
        return "Human";}

}

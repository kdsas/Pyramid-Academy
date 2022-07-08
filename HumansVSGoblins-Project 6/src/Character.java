import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
public abstract class Character {


    int x;
    int y;
    int speed;
    int w;
    int h;
    private Image image;

    public Character(int x,int y, int speed){

        this.x=x;
        this.y=y;
        this.speed=speed;
    }

    public Character()
    {
        // initialise instance variables
        x = 0;
        y = 0;
    }

    public Character(int x, int y, int w, int h, int s, String u)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        speed=s;
        try
        {
            URL url = getClass().getResource(u);
            image = ImageIO.read(url);
        }
        catch(Exception e)
        {
            //feel free to do something here, this is mainly useful if you aren't getting your ship to show up
        }
    }

    public abstract void move(int direction);

    public abstract void draw(Graphics window);

    public String toString()
    {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
    }

    public void setPos( int x, int y)
    {
        //add code here
        x = getX();
        y = getY();
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setWidth(int w)
    {
        this.w = w;
    }

    public void setHeight(int h)
    {
        this.h = h;
    }

    public int getWidth()
    {
        return w;  //finish this method
    }

    public int getHeight()
    {
        return h;  //finish this method
    }

    public int getSpeed(){
        return speed;
    }

    public Image getImage(){
        return image;
    }


}

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.event.*;


public class Land {

    private JFrame frame;
    int fW = 600;
    int fH = 600;
    JPanel healthBarPanel,optionsPanel;

    static JPanel goblinPanel;
    static JProgressBar healthBar;
    public static int playerHP,goblinHP;
    static JButton b, b1,b2,b3;
    static JLabel lab1,lab2,lab3, lab4, lab5;
    private static String inv[] = {"","","","",""};
    // The method to set up
    public Land() {

        frame = new JFrame("Humans vs Goblins");
        frame.setSize(fW, fH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // the event that triggers the end of the program
        frame.setPreferredSize(frame.getSize());
        frame.add(new showGraphics(frame.getSize())); // Setting up the DrawBars public class function (getting bars and
        // putting it in this frame

        healthBarPanel = new JPanel();
        healthBarPanel.setPreferredSize(new Dimension(10, 20));
        healthBarPanel.setBackground(Color.green);
        frame.add(healthBarPanel, BorderLayout.NORTH);


        optionsPanel = new JPanel();
        optionsPanel.setPreferredSize(new Dimension(100, 30));
        optionsPanel.setBackground(Color.blue);
        frame.add(optionsPanel, BorderLayout.EAST);

        goblinPanel = new JPanel();
        goblinPanel.setPreferredSize(new Dimension(100, 30));
        goblinPanel.setBackground(Color.red);
        frame.add(goblinPanel, BorderLayout.WEST);


        healthBar = new JProgressBar(0, 100);
        healthBar.setPreferredSize(new Dimension(600, 10));
        healthBar.setBackground(Color.red);
        healthBar.setForeground(Color.darkGray);
        healthBarPanel.add(healthBar);



        frame.pack();
        frame.setVisible(true);

        fightGoblins();
        heal();
        addInv();

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                randomGoblinAttack();
            }
        });
        timer.setRepeats(true);
        timer.start(); // Go go go!

    }

    public void randomGoblinAttack(){
        stealInv();
        int goblinDamage=0;
        goblinDamage=new java.util.Random().nextInt(3);
        playerHP=playerHP-goblinDamage;
        healthBar.setValue(playerHP);
        lab1 = new JLabel("Goblin Hit: "+goblinDamage, JLabel.LEFT);
        lab1.setForeground(Color.RED);
        optionsPanel.add(lab1);
        if(playerHP<=0) {
            playerHP = 0;
            lab3.setText("Player HP: " + playerHP);


        }
        if(goblinHP<=0){
            goblinHP=0;
            lab2.setText("Goblin HP: "+goblinHP);

        }

    }

    public void removeItemFromInv(String name){
        for(int i = 0; i < inv.length; i++){
            if(inv[i].equals(name)){
                inv[i] = "";
            }
        }
        lab5 = new JLabel("Goblin took: " + name + ".", JLabel.LEFT);
        lab5.setForeground(Color.BLACK);
        goblinPanel.add(lab5);
        //System.out.println("That item is not in your inventory.");
    }

    public void combat(){

        String[] arr={"Punch", "Kick", "Shoot", "Stab"};
        Random r=new Random();
        int randomWord=r.nextInt(arr.length);
        b.setText(arr[randomWord]);
        if(arr[randomWord]=="Shoot"){
            playerHP=playerHP-30;
            healthBar.setValue(playerHP);
            goblinHP=goblinHP-20;
            lab2.setText("Goblin HP: "+goblinHP);
            lab3.setText("Player HP: "+playerHP);
        }

        if(arr[randomWord]=="Stab"){
            playerHP=playerHP-20;
            healthBar.setValue(playerHP);
            goblinHP=goblinHP-10;
            lab2.setText("Goblin HP: "+goblinHP);
            lab3.setText("Player HP: "+playerHP);
        }
    }

    public void addItemToInv(String name){

        for(int i = 0; i < inv.length; i++){
            if(inv[i] == ""){
                inv[i] = name;
                lab4 = new JLabel("Added: " + name + ".", JLabel.LEFT);
                lab4.setForeground(Color.BLACK);
                goblinPanel.add(lab4);
                return;
            }
        }
        lab4 = new JLabel("No room in inv.", JLabel.LEFT);
    }
    private void fightGoblins(){

        b = new JButton("Fight");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerHP=playerHP-10;
                goblinHP=goblinHP-5;
                lab2.setText("Goblin HP: "+goblinHP);
                healthBar.setValue(playerHP);
                lab3.setText("Player HP: "+playerHP);
                combat();
                if(playerHP<=0) {
                    playerHP = 0;
                    b1.hide();
                    b.hide();
                    b3.hide();
                    lab3.setText("Player HP: " + playerHP);
                    if(playerHP>goblinHP){
                    lab1 = new JLabel("Player Wins ", JLabel.LEFT);
                    }else{

                        lab1 = new JLabel("Goblin Wins ", JLabel.LEFT);
                    }
                    lab1.setForeground(Color.RED);
                    optionsPanel.add(lab1);

                }
                if(goblinHP<=0){
                    goblinHP=0;
                    lab2.setText("Goblin HP: "+goblinHP);
                    b1.hide();
                    b.hide();
                    b3.hide();
                    if(goblinHP>playerHP){
                        lab1 = new JLabel("Goblin Wins ", JLabel.LEFT);
                    }else{

                        lab1 = new JLabel("Player Wins ", JLabel.LEFT);
                    }
                    lab1.setForeground(Color.RED);
                    optionsPanel.add(lab1);
                }
            }
        });
        optionsPanel.add(b);
        frame.setVisible(true);
    }

    private void stealInv(){

        String[] arr={"Knife", "Loot", "Gun", "Gems", "Shoes"};
        Random r=new Random();
        int randomWord=r.nextInt(arr.length);
        removeItemFromInv(arr[randomWord]);


    }
    private void addInv(){

        b3 = new JButton("Add Inv");
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] arr={"Knife", "Loot", "Gun", "Gems", "Shoes"};
                Random r=new Random();
                int randomWord=r.nextInt(arr.length);
                addItemToInv(arr[randomWord]);


            }
        });

        optionsPanel.add(b3);
        frame.setVisible(true);
    }
    private void heal(){

        b1 = new JButton("Heal");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerHP=playerHP+10;
                healthBar.setValue(playerHP);
                lab3.setText("Player HP: "+playerHP);
            }
        });
        optionsPanel.add(b1);
        frame.setVisible(true);
    }

    public static void playerSetup(){
     playerHP=100;
     goblinHP=100;
    healthBar.setValue(playerHP);
    lab2 = new JLabel("Goblin HP: "+goblinHP, JLabel.LEFT);
    lab3=new JLabel("Player HP: "+playerHP, JLabel.LEFT);
    goblinPanel.add(lab2);
    goblinPanel.add(lab3);
}
    // The main method
    public static void main(String... argv) {
        new Land();
        playerSetup();
        JFrame frame = new JFrame("Instructions");
        JPanel panel = new JPanel();
        JLabel jlabel = new JLabel("Either press the buttons to the right to fight the Goblins or press your spacebar to shoot the Goblins. You cannot do both at once! If shooting the Goblins with your spacebar, press the 'S' key to restart the game once the Goblins reach the ground.");
        jlabel.setFont(new Font("Verdana",1,10));
        panel.add(jlabel);
        panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
        frame.add(panel, BorderLayout.CENTER);
        JPanel buttonsPanel;

        buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(100, 30));
        buttonsPanel.setBackground(Color.black);
        frame.add(buttonsPanel, BorderLayout.SOUTH);;
        b2 = new JButton("Shoot Goblins with Spacebar");
        buttonsPanel.add(b2);
        chooseShoot();
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    private static void chooseShoot(){


        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b.hide();
                b1.hide();
                b3.hide();
                lab1.hide();
                lab2.hide();
                lab3.hide();
                healthBar.hide();

            }
        });


    }
    public static class showGraphics extends JPanel implements Runnable, MouseListener, KeyListener {

        private Thread animator;

        int xAxis = 30;
        int yAxis = 30;
        Humans s;
        Goblins[][] a = new Goblins[3][10];
        Shot sh;
        boolean gameOn=false;

        public void Reset(){
           xAxis=30;
           yAxis=30;

           a=new Goblins[3][10];
           gameOn=false;
           s=new Humans(200,500,57,35,5,"res/human.png");
           sh = new Shot(200,500,5,20,15,"res/shot.png");
           int x=10;
           int y=10;

           for(int r=0; r<a.length; r++){

               for(int c =0;c<a[0].length; c++){

                   a[r][c]=new Goblins(x,y,30,20,5,"res/goblin.png");
                   x+=35;

               }
               x=10;
               y+=25;

           }


        }

        public showGraphics(Dimension dimension) {
            s = new Humans (200,500,57,35,5,"res/human.png");
            sh = new Shot(200,500,5,20,15,"res/shot.png");
            int x = 10;
            int y = 10;
            for(int r = 0; r<a.length; r++){
                for (int c = 0; c<a[0].length; c++){
                    a[r][c] = new Goblins(x,y,30,20,5,"res/goblin.png");
                    x += 35;
                }
                x=10;
                y += 25;
            }

            setSize(dimension);
            setPreferredSize(dimension);
            addMouseListener(this);
            addKeyListener ( this ) ;
            //addActionListener(this);
            setFocusable(true);
            if (animator == null) {
                animator = new Thread(this);
                animator.start();
            }

            setDoubleBuffered(true);

        }

        @Override

        public void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;// g2 is the graphics object that we need to use

            // to draw things to the screen
            Dimension d = getSize();

            // create a background
            g2.setColor(Color.white);
            g2.fillRect(0, 0, d.width, d.height);

            moveGoblin();
            s.move(0);
            sh.move(0);

            sh.draw(g2);
            s.draw(g2);
            hitDetect();
            if(gameOn==true){


                moveGoblin();
                s.move(0);
                sh.move(0);
            }else{

                g2.setColor(Color.BLACK);

            }
            sh.draw(g2);
            s.draw(g2);
            hitDetect();
            for(int r = 0; r<a.length; r++){
                for (int c = 0; c<a[0].length; c++){
                    if(a[r][c].isVis)
                        a[r][c].draw(g2);
                }
            }

        } // end of paintcomponent

        public void hitDetect(){

            for(int r = 0; r<a.length; r++){
                for (int c = 0; c<a[0].length; c++){

                    // if ( a[r][c].isVisible() ) {//&& shot.isVisible()
                    if (a[r][c].isVis == true && sh.getX() + sh.getWidth() >= a[r][c].getX() &&
                            sh.getX() <= a[r][c].getX() + a[r][c].getWidth() &&
                            sh.getY() + sh.getHeight() >= (a[r][c].getY()) &&
                            sh.getY() <= a[r][c].getY() + a[r][c].getHeight()) {

                        a[r][c].isVis=false;
                        sh.x = -30;
                    }
                    //}

                }}

        }

        public void moveGoblin(){
            for(int r = 0; r<a.length; r++){
                for (int c = 0; c<a[0].length; c++){
                    if(a[r][c].moveLeft)
                        a[r][c].setX(a[r][c].getX()-a[r][c].getSpeed());

                    if(a[r][c].moveRight){
                        a[r][c].setX(a[r][c].getX()+a[r][c].getSpeed());
                    }
                }}
            //check if we need to switch directions
            for(int r = 0; r<a.length; r++){
                for (int c = 0; c<a[0].length; c++){

                    if(a[r][c].getX()>600){
                        moveLeftRight(1);
                        break;
                    }

                    if(a[r][c].getX()<0){
                        moveLeftRight(2);
                        break;
                    }
                }}

        }

        public void moveLeftRight(int d){
            for(int r = 0; r<a.length; r++){
                for (int c = 0; c<a[0].length; c++){
                    if(d==1){
                        a[r][c].moveLeft=true;
                        a[r][c].moveRight=false;
                    }else{
                        a[r][c].moveLeft=false;
                        a[r][c].moveRight=true;
                    }

                    a[r][c].setY(a[r][c].getY()+10);
                    if(a[r][c].getY()>500){

                        gameOn=false;
                    }

                }}
        }

        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void keyTyped ( KeyEvent e ){

        }

        public void keyPressed ( KeyEvent e){
            // System.out.println("Key: " + e.getKeyCode());
            int k = e.getKeyCode();
            s.setLeftRight(k);
            if(k==32)  {
                sh.goUp=true;
                sh.setX(s.getX() + (s.getWidth()/2));
                sh.setY(s.getY() );
                //Press Spacebar
            }

            if(k==83){
            //Press 'S' key
                Reset();
                gameOn=true;

            }
            s.setLeftRight(k);
        }

        public void keyReleased ( KeyEvent e ){
            int k = e.getKeyCode();
            s.stop();

        }
        public void run() {
            long beforeTime, timeDiff, sleep;
            beforeTime = System.currentTimeMillis();
            int animationDelay = 37;
            long time = System.currentTimeMillis();
            while (true) {// infinite loop
                // spriteManager.update();
                repaint();
                try {
                    time += animationDelay;
                    Thread.sleep(Math.max(0, time - System.currentTimeMillis()));
                } catch (InterruptedException e) {
                    System.out.println(e);
                } // end catch
            } // end while loop
        }// end of run

    }






    @Override
    public String toString(){
        return "Land";
    }

}

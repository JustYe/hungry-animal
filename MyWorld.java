import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world the elephant lives in.
 * 
 * @author (Justin) 
 * @version (Nov 21 2023)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1,false);
        
        Mario john = new Mario();
        addObject(john, 300, 350);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        
        createCupcake();
    }
    
    /**
     * End the game
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over",100);
        addObject(gameOverLabel,300,200);
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 2 == 0)
        {
            level += 1;
        }
    }
    
    public void createCupcake()
    {
        Cupcake a = new Cupcake();
        a.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(a,x,y);
    }
}

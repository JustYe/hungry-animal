import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class titleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class titleScreen extends World
{
    Label titleLabel = new Label("Mario's Cardio Workout",50);
    
    
    /**
     * Constructor for objects of class titleScreen.
     * 
     */
    public titleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(titleLabel, getWidth()/2, getHeight()/2);
    }
    
    /**
     * the main world loop.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("s"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
}

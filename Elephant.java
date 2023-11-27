import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author (Justin Ye) 
 * @version (Nov 21,2023)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantCoin = new GreenfootSound("coin.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    
    /**
     * Constructor - the code that gets run one time when an object is created.
     */
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(50,50);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
           idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
           idleLeft[i].mirrorHorizontally();
           idleLeft[i].scale(50,50); 
        }
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing = "right";
        }
        eat();
        animateElephant();
    }
    
    /**
     * Eat the apple and spawn new apple if an apple is eaten
     */
    public void eat()
    {
        if(isTouching(Cupcake.class))
        {
            removeTouching(Cupcake.class);
            MyWorld world = (MyWorld) getWorld();
            world.createCupcake();
            world.increaseScore();
            elephantCoin.play();
        }
    }
}

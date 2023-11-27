import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author (Justin Ye) 
 * @version (Nov 21,2023)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantLazer = new GreenfootSound("blaster.mp3");
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        eat();
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
            elephantLazer.play();
        }
    }
}

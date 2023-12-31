import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The Ambulance subclass
 */
public class Ambulance extends Vehicle
{
    public static final int HEAL_IMAGE_DURATION = 200;
    SimpleTimer timer = new SimpleTimer();
    HealEffect healEffect;
    public Ambulance(VehicleSpawner origin){
        super (origin); // call the superclass' constructor first
        
        maxSpeed = 2.5;
        speed = maxSpeed;
        /*
         * Check image height and width
         */
        //System.out.println("Width: "+getImage().getWidth()+"\nHeight: "+getImage().getHeight());
        GreenfootImage ambulance = getImage();
        ambulance.scale(100,50);
        
        healEffect = new HealEffect();
    }

    /**
     * Act - do whatever the Ambulance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(timer.millisElapsed() >= HEAL_IMAGE_DURATION){
            getWorld().removeObject(healEffect);    
            //getWorld().removeObjects(getWorld().getObjects(HealEffect.class));
        }
        super.act();
    }

    public boolean checkHitPedestrian () {
        /*
        Pedestrian p = (Pedestrian)getOneObjectAtOffset((int)speed + getImage().getWidth()/2, 0, Pedestrian.class);
        if(p != null && !p.isAwake()){
            p.healMe();
            return true;
        }
        */
        
        ArrayList<Pedestrian> peds = (ArrayList<Pedestrian>)getObjectsInRange(100,Pedestrian.class);
        for(Pedestrian pe : peds){
            if(pe != null && !pe.isAwake()){
                pe.healMe();
                getWorld().addObject(healEffect,getX(),getY());
                timer.mark();
            }
        }
        return false;
    }
}

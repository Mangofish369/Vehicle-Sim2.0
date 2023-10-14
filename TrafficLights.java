import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class TrafficLights extends Actor
{
    private GreenfootImage red = new GreenfootImage("redLight.png");
    private GreenfootImage yellow = new GreenfootImage("yellowLight.png");
    private GreenfootImage green = new GreenfootImage("greenLight.png");
    private GreenfootImage traffic; 
    private boolean crossing;
    public TrafficLights (){
        crossing = false;
        traffic = green;
        traffic.scale(50,100);
        setRotation(-90);
        setImage(traffic);
    }
    public void act(){
        if(!crossing && Greenfoot.isKeyDown("m")){
            changeLight(red);
        }
    }
    public void changeLight(GreenfootImage colour){
        if(colour.equals("red") || colour.equals("yellow") || colour.equals("green")){
            traffic = red;
            traffic.scale(50,100);
            setRotation(-90);
            setImage(traffic);
        }    
    }
}
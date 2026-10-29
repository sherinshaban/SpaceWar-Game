import greenfoot.*;  

public class Enemy extends Actor
{
    private int vx = 0;
    private boolean toRemove = false;
    
public Enemy()
{
    
}
public boolean sudahHancur()
{
    return toRemove;
}

public Enemy(int v){
    vx = v;
}
public void addedToWorld(World Latar){
    setRotation(180);
}
public void move(){
    setLocation(getX()+vx , getY());
    Actor actor = getOneIntersectingObject(Rocket.class);
    if(actor != null){
        ((Rocket)actor).HanCur();
        HanCur();
    }
    if(getX()<-200){
        toRemove = true;
    }
}
public void HanCur(){
    if(toRemove) return;
    for(int i=0;i<10;i++){
        int px = -20+Greenfoot.getRandomNumber(40);
        int py = -20+Greenfoot.getRandomNumber(40);
        getWorld().addObject(new Pecahan(getImage()),getX() + px,getY()+py);
    }
    getWorld().addObject(new Bundaran(),getX(),getY());
    toRemove = true;
}

    public void act()
    {
        if(!toRemove){
           move(); 
        }
        else{
            getWorld().removeObject(this);
        }
    }
}

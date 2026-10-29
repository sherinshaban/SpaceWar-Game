import greenfoot.*;


public class Laser extends Actor
{
    private boolean toRemove = false;
    private int vx =3;
    public void addedToWorld(World Latar){
    GreenfootImage image = new GreenfootImage(50,10);
    image.setColor(new Color(255,255,0));
    image.drawLine(0,5,image.getWidth()-1,5);
    setImage(image);
    
    }
    
    public void act()
    {
        if(!toRemove){
            setLocation(getX()+vx,getY());
            
            Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
            if(e != null && !e.sudahHancur()){
                e.HanCur();
                ((Latar) getWorld()).tambahSkor();
                toRemove = true;
            }
            if(getX() > getWorld().getWidth()+200) {
            toRemove = true;
            }
        }
        else{
            getWorld().removeObject(this);
        }
    }
}

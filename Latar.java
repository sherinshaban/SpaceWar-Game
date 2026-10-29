import greenfoot.*;  

public class Latar extends World
{
    private int jeda =0;
    private int score =0;
    private int level;
    private int target =50;
    private boolean selesai;
    private int timerNext = 0;

    public Latar(){
        this(1);
    }

    public Latar(int level)
    {    
        super(600, 400, 1,false); 
        this.level = level;
        addObject(new Rocket(),100,200);
        tampilkanSkor();
    }

    private void tampilkanSkor(){
        showText("Level: "+level+" Score: "+score+"/"+target,100,20);
    }

    public void tambahSkor()
    {
        if (selesai) return;
        score++;
        tampilkanSkor();
        if (score >= target) {
            selesai = true;
            showText("WIN!", getWidth() / 2, getHeight() / 2);
            timerNext = 120;           
        }
    }

    public void gameOver()
    {
        if (selesai) return;
        selesai = true;
        showText("GAME OVER", getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();              
    }

    public void act(){
        if(selesai){
            if(timerNext > 0){
                timerNext -- ;

                if(timerNext == 0){
                    Greenfoot.setWorld(new Latar(level+1));
                }
            }
            return ;
        }
        int interval = Math.max(5,20-((level-1)*4));
        
        if (jeda > 0){
            jeda--;
        }
        else{
            jeda = interval;
        }
        if(jeda == 1){
            int py= Greenfoot.getRandomNumber(getHeight());
            int speed = 2+ Greenfoot.getRandomNumber(3) + (level -1);
            addObject(new Enemy(-speed),getWidth()+200,py);
        }
    }
}

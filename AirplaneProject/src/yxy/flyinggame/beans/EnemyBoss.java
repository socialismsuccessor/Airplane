package yxy.flyinggame.beans;

import java.util.Random;

import yxy.flyinggame.ui.GameFrame;
import yxy.flyinggame.ui.GamePanel;
import yxy.flyinggame.ui.PlayingPanel;

public class EnemyBoss extends FlyingObjectAbstract implements EnemyInterface {
    private int step = 2;//y轴移动方向
    
    //初始化
    public EnemyBoss() {
    	Image = GamePanel.enemybBossImg;
    	Height = Image.getHeight();
    	Width = Image.getWidth();
    	
    	Random rand = new Random();
    	x = rand.nextInt(GameFrame.WIDTH-this.Width);//产生X的坐标
    	y = -Height;
    	life = 30;
    	
    }
    //击败得分90
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 90;
	}
    //boss机走位
	@Override
	public void move() {
		// TODO Auto-generated method stub
		y+=step;
	}
    //超出边界判断
	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return this.y > GameFrame.HEIGHT;
	}
    //发射子弹
	public EnemyBullet shoot() {
		EnemyBullet bullet = new EnemyBullet(this.x + this.Width,this.y + this.Height);
		return bullet;
		
	}
}

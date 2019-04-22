package yxy.flyinggame.beans;

import yxy.flyinggame.ui.GameFrame;
import yxy.flyinggame.ui.GamePanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class EnemyBoss extends FlyingObjectAbstract implements EnemyInterface {
	private int xStep = 1; // x坐标走步步数
	private double yStep = 0.0001; // y坐标走步步数

	//private int step = 2;//y轴移动方向
    private static yxy.flyinggame.beans.EnemyBoss EnemyBoss;
    private static  int i = 0;
    //初始化
    public EnemyBoss() {
    	Image = GamePanel.enemybBossImg;
    	Height = Image.getHeight();
    	Width = Image.getWidth();
 //   	x = 160;
    	Random rand = new Random();
    	x = rand.nextInt(GameFrame.WIDTH-this.Width);//产生X的坐标
    	y = -Height;
    	life = 30;

    }
    public static synchronized yxy.flyinggame.beans.EnemyBoss getInstance() {
    	
    	if(null == EnemyBoss) {
    		EnemyBoss = new EnemyBoss();
    		
    	}
    	return EnemyBoss;
    }
    public  void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//画外圈
		Rectangle2D r2 = new Rectangle2D.Double(x, y-10,40 ,10 );
		g2.setColor(Color.WHITE);
		g2.draw(r2);
		//根据血量比例画血条
		Rectangle2D r = new Rectangle2D.Double(x+1, y-10, 40*((double)life/25)-1, 10);
		g2.setColor(Color.RED);
		g2.fill(r);
	}
   
    public boolean isbLive() {
		// TODO Auto-generated method stub
		return true;
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
		if (x >= GameFrame.WIDTH - this.Width) {
			xStep = -1;
		}
		if (x <= 0) {
			xStep = 1;
		}
		if(y >= GameFrame.HEIGHT-this.Height-200) {
			yStep = -1;
		}
		if(y <= 0) {
			yStep = 1;
		}
		x += xStep;
		y += yStep;
	}

    //超出边界判断
	@Override
	public boolean outOfBounds() {
//		 TODO Auto-generated method stub
		//return this.y > GameFrame.HEIGHT;
		return false;
	}
    //发射子弹
	public EnemyBullet shoot() {
		EnemyBullet bullet = new EnemyBullet(this.x + this.Width/2,this.y + this.Height);
		return bullet;
		
	}
}

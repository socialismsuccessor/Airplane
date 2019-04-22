package yxy.flyinggame.beans;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BossMove extends Frame  implements Runnable{
	public EnemyBoss Enemyboss;
	
	public BossMove() {
		super();
		setUndecorated(true);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			stop();
			rePaint();
		}
		
	}

	private void rePaint() {
		// TODO Auto-generated method stub
		
	}

	private void stop() {
		// TODO Auto-generated method stub
		
	}

}

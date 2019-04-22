package yxy.flyinggame.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PausePanel extends JPanel {

    // 暂停界面
    public JLabel PauseBg = new JLabel(); // 暂停界面背景
    public static JPanel PauseJp = new JPanel();
    public JLabel InfoScore = new JLabel(); // 提示信息框
    public JButton PauseGoOn = new JButton("继续游戏");
    public JButton EndPlay1 = new JButton("结束游戏");
    public JButton ExitPlay1 = new JButton("退出游戏");
    public JLayeredPane PauseJlp = new JLayeredPane(); // 难度选择
    // 暂停页面面板
    public void initPauseUI() {
        //暂停界面背景
        PauseBg = new JLabel(new ImageIcon(GamePanel.background1Img));
        PauseBg.setBounds(0, 0, GameFrame.WIDTH, GameFrame.HEIGHT);
        //暂停界面控件
        PauseJp.setBounds(0, 0, GameFrame.WIDTH, GameFrame.HEIGHT);
        PauseJp.setLayout(null);
        PauseJp.setOpaque(false);
        PauseJp.add(InfoScore);
        PauseJp.add(PauseGoOn);
        PauseJp.add(EndPlay1);
        PauseJp.add(ExitPlay1);
        InfoScore.setBounds(90, 150, 140, 30);
        PauseGoOn.setBounds(100, 210, 100, 30);
        EndPlay1.setBounds(100, 260, 100, 30);
        ExitPlay1.setBounds(100, 310, 100, 30);
        InfoScore.setText("当前分数为："+ PlayingPanel.score);
        //分层面板
        PauseJlp.setBounds(0, 0, GameFrame.WIDTH, GameFrame.HEIGHT);
        PauseJlp.add(PauseBg, JLayeredPane.DEFAULT_LAYER);
        PauseJlp.add(PauseJp, JLayeredPane.MODAL_LAYER);
        PauseGoOn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //继续游戏的方法
                PlayingPanel.zp.setVisible(false); //隐藏暂停页面
                GamePanel.pp.setVisible(true); //显示游戏页面
            }

        });
        //退出按钮
        ExitPlay1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
        //结束按钮
        EndPlay1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //PauseJlp.setVisible(false); //隐藏暂停界面
                //GamePanel.StartJlp.setVisible(true);
                GamePanel.state = GamePanel.GAME_OVER;
                GamePanel.pp.setVisible(true); //显示游戏页面
            }

        });
    }
    //开始
    public void start() {
        initPauseUI();
    }
}

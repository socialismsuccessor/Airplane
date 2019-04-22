package yxy.flyinggame.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel {

    // 游戏结束界面
    public JLabel GameOverBg = new JLabel(); // 游戏结束界面背景
    public static JPanel GameoverJp = new JPanel();
    public JLabel InfoScore = new JLabel(); // 提示信息框
    public JButton BeginNowGame = new JButton("开始新游戏");
    public JButton ExitPlay1 = new JButton("退出游戏");
    public JLayeredPane GameOverJlp = new JLayeredPane(); // 难度选择

    // 暂停页面面板
    public void initPauseUI() {
        //游戏结束界面
        GameOverBg = new JLabel(new ImageIcon(GamePanel.background2Img));
        GameOverBg.setBounds(0, 0, GameFrame.WIDTH, GameFrame.HEIGHT);
        //游戏结束界面控件
        GameoverJp.setBounds(0, 0, GameFrame.WIDTH, GameFrame.HEIGHT);
        GameoverJp.setLayout(null);
        GameoverJp.setOpaque(false);
        GameoverJp.add(InfoScore);
        GameoverJp.add(BeginNowGame);
        GameoverJp.add(ExitPlay1);
        InfoScore.setBounds(90, 150, 140, 30);
        BeginNowGame.setBounds(100, 210, 100, 30);
        ExitPlay1.setBounds(100, 260, 100, 30);
        InfoScore.setText("您的分数为："+ PlayingPanel.score);
        //分层面板
        GameOverJlp.setBounds(0, 0, GameFrame.WIDTH, GameFrame.HEIGHT);
        GameOverJlp.add(GameOverBg, JLayeredPane.DEFAULT_LAYER);
        GameOverJlp.add(GameoverJp, JLayeredPane.MODAL_LAYER);
        //重新开始游戏按钮
        BeginNowGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                GamePanel.pp.removeNull();
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
    }
    //开始
    public void start() {
        initPauseUI();
    }
}

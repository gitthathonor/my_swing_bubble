package bubble.test.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true);
	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);
		
		player = new Player();
		add(player);
//		backgroundMap.setSize(1000,600);
//		backgroundMap.setSize(100,100);
//		backgroundMap.setLocation(300,300);
//		add(backgroundMap); //JFrame에 JLabel이 그려진다.
	}

	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // absolute 레이아웃 (자유롭게 그릴 수 있다)
		setLocationRelativeTo(null); // JFrame 화면 가운데 끄게 하기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼으로 창을 끌 때 JVM 같이 종료하기
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
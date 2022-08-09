package bubble.test.ex01;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

// 1. 윈도우 창이 되었음
// 2. 윈도우 창은 내부에 패널을 하나 가지고 있다
public class BubbleFrame extends JFrame{
	private JTextField textField;
	
	public BubbleFrame() {
		setSize(1000, 640);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(76, 232, 91, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(29, 339, 96, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		setVisible(true); // 그림을 그려라
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}

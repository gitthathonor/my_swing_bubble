package bubble.game.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import bubble.game.component.Enemy;

// 메인스레드 바쁨 - 키보드 이벤트를 처리하기 바쁨.
// 백그라운드에서 계속 관찰
public class BackgroundEnemyService implements Runnable {
	
	private BufferedImage image;
	private Enemy enemy;
	

	// 플레이어, 버블
	public BackgroundEnemyService(Enemy enemy) {
		this.enemy = enemy;
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		while(enemy.getState() == 0) {
			
			// 색상 확인
			Color leftColor = new Color(image.getRGB(enemy.getX() - 10, enemy.getY()+ 25));
			Color rightColor = new Color(image.getRGB(enemy.getX() + 50 + 15, enemy.getY() + 25));
			// 양쪽 하단부가 한쪽이라도 색상을 걸치고 있으면 착지가 되게하고 둘 다 흰색이면 착지 없이 떨어진다.
			int bottomColor =image.getRGB(enemy.getX() + 10, enemy.getY() + 50 + 5) 
					+ image.getRGB(enemy.getX() + 50 - 10, enemy.getY() + 50 + 5); // -2가 될 때 떨어진다. 
			
			// 바닥 충돌 확인
			if(bottomColor != -2) {
//				System.out.println("바텀 컬러 : " + bottomColor);
//				System.out.println("바닥에 충돌함");
				enemy.setDown(false);
			} else { // -2일 때 실행됨 => 캐릭터의 바닥 밑이 하얀색이라는 것
				if(!enemy.isUp() && !enemy.isDown()) {
					// System.out.println("다운 실행됨");
					enemy.down();
				}
			}
			
			// 외벽 충돌 확인
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				enemy.setLeft(false);
				if(!enemy.isRight()) {
					enemy.right();
				}
			} else if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				enemy.setRight(false);
				if(!enemy.isLeft()) {
					enemy.left();
				}
			} 
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

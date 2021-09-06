package animated.nothreads;

import static animated.nothreads.Constants.*;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimatedBalls {

	public static void main(String[] args) {

		// Her oppretter vi et ball-objekt med gitt farge og starthastighet
		Ball roedBall = new Ball(Color.RED, randomVxVy(), randomVxVy());
		Ball blaaBall = new Ball(Color.BLUE, randomVxVy(), randomVxVy());
		Ball gronBall = new Ball(Color.GREEN, randomVxVy(), randomVxVy());

		// Her oppretter vi en tegneflate og legger til ballobjektet
		JPanel tegneflate = new JPanel();
		tegneflate.setLayout(null);
		tegneflate.add(roedBall);
		tegneflate.add(blaaBall);
		tegneflate.add(gronBall);

		// Her oppretter vi selve 2D-grafikk-vinduet legger til tegneflaten
		JFrame grafikkvinduet = new JFrame();
		grafikkvinduet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grafikkvinduet.setLayout(new BorderLayout());
		grafikkvinduet.setSize(PANE_SIZE, PANE_SIZE);
		grafikkvinduet.add(tegneflate);

		// Her starter vi applikasjonen ved å gjøre grafikkvinduet synlig
		// og be ballen om å gjøre animasjonen, dvs. bevege og tegne seg
		// på nytt i evig løkke.
		grafikkvinduet.setVisible(true);

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				roedBall.animate();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				blaaBall.animate();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				gronBall.animate();
			}
		});

		t1.start();
		t2.start();
		t3.start();

	}

	private static int randomVxVy() {
		return (int) Math.round((Math.random() * MAX_VX_VY));
	}

}
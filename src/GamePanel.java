import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel 
	 implements ActionListener, KeyListener{  
Timer frameDraw;
Timer alienSpawn;
Rocketship rocketship = new Rocketship (250,700,50,50);
ObjectManager objectmanager = new ObjectManager(rocketship);
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont = new Font ("Arial", Font.PLAIN, 48);
    Font smallTitleFont = new Font ("Arial", Font.PLAIN, 20);
    Font middleTitleFont = new Font ("Arial", Font.PLAIN, 30);
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	 void updateMenuState() {  
	 }
	 void updateGameState() {  
		objectmanager.update();
		if (rocketship.isActive==true) { 
		}
		else {
			currentState = END;
		}
	 }
	 void updateEndState()  {  
		 
	 }
	 void drawMenuState(Graphics g) {  
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("LEAGUE INVADERS", 22, 100);
		 g.setFont(smallTitleFont);
		 g.drawString("Press ENTER to start", 150, 400);
		 g.setFont(middleTitleFont);
		 g.drawString("Press SPACE for instructions", 50, 600);
	 }
	 void drawGameState(Graphics g) {  
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 objectmanager.draw(g);
	 }
	 void drawEndState(Graphics g)  {  
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Game Over", 151, 100);
		 g.setFont(smallTitleFont);
		 g.drawString("You killed"+objectmanager.getScore()+" enemies", 150, 400);
		 g.setFont(middleTitleFont);
		 g.drawString("Press ENTER to start", 100, 600);
		 
	 }
	 GamePanel(){
		 Timer frameDraw = new Timer (1000/60, this);
		 frameDraw.start();
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		        rocketship=new Rocketship(250,700,50,50);
		        objectmanager = new ObjectManager(rocketship);
		    }
		    else {
		        currentState++;
		        if (currentState==GAME) {
		        	startGame();
		        }
		        if (GAME==END) {
		        	alienSpawn.stop();
		        }
		    }
		    
		}   
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		 rocketship.up();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    rocketship.down();
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    rocketship.right();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    rocketship.left();
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			objectmanager.addProjectile(rocketship.getProjectile());
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		void startGame() {
			alienSpawn = new Timer(1000 , objectmanager);
		    alienSpawn.start();
		}
	}



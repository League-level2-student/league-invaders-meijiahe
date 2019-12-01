import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class ObjectManager implements ActionListener{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Rocketship rocket;
  ObjectManager (Rocketship rocket){
	  this.rocket=rocket;
	  if (needImage) {
		    loadImage ("space.png");
		}
}
  ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
  void addProjectile(Projectile projectile){
	  projectiles.add(projectile);
  }
  ArrayList<Alien> aliens = new ArrayList<Alien>();
  Random random = new Random();
  void addAlien() {
	  aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
  }
  void update(){
	 for (int i=0;i<aliens.size();i++) {
		aliens.get(i).update(); 
	 }
		 for (int i=0;i<projectiles.size();i++) {
			projectiles.get(i).update(); 
		 }
		 checkCollision();
		 purgeObjects();
		 rocket.update();
  }
  void draw(Graphics g) {
	  if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
	  for (int i=0;i<aliens.size();i++) {
		  aliens.get(i).draw(g);
	  }
	  rocket.draw(g);
		  for (int i=0;i<projectiles.size();i++) {
			  projectiles.get(i).draw(g);
		  }
  }
  void purgeObjects() {
	  for (int i=aliens.size()-1;i>=0;i--) {
		  if (aliens.get(i).isActive==false) {
			  aliens.remove(i);
		  }
	  }
	  for (int i=projectiles.size()-1;i>=0;i--) {
		  if (projectiles.get(i).isActive==false) {
			  projectiles.remove(i);
  }
	  }
  }
  void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addAlien();
}
void checkCollision () {
	for (int i=0;i<aliens.size();i++) {
		if (rocket.collisionBox.intersects(aliens.get(i).collisionBox)) {
			rocket.isActive=false;
			aliens.get(i).isActive=false;
		}
	}
}
}

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
  ObjectManager (Rocketship rocket){
	  this.rocket=rocket;
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
  }
  void draw(Graphics g) {
	  for (int i=0;i<aliens.size();i++) {
		  aliens.get(i).draw(g);
	  }
	  
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
}

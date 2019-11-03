import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
Rocketship (int x,int y,int width,int height){
	super(x,y,width,height);
	speed=10;
}
void draw (Graphics g) {
	 g.setColor(Color.BLUE);
     g.fillRect(x, y, width, height);
}
public void right() {
	if (x<LeagueInvaders.WIDTH) {
		x+=speed;
	}
}
public void left () {
	if (x>0)
	x-=speed;
}
public void up () {
	if (y<LeagueInvaders.HEIGHT) {
	y-=speed;
}
}
public void down () {
	if (y>0) {
		y+=speed;
	}
}
}

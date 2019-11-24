import java.awt.Rectangle;

public class GameObject {
	int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0; 
	 boolean isActive = true;
	 Rectangle collisionBox;
	 GameObject(int x,int y,int width,int height) {
		 this.x=x;
		 this.y=y;
		 this.width=width;
		 this.height=height;
		 this.speed=0;
		 this.isActive=true;
	 }
	 void update () {
		 collisionBox.setBounds(x, y, width, height);
	 }
	 }

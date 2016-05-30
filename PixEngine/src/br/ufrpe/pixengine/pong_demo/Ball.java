package br.ufrpe.pixengine.pong_demo;

import br.ufrpe.pixengine.components.Collider;
import br.ufrpe.pixengine.components.GameObject;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import br.ufrpe.pixengine.core.fx.AnimatedImage;
import javafx.geometry.Rectangle2D;

public class Ball extends GameObject {
    private AnimatedImage ballAnimatedImg;
	boolean left = true;
	boolean playColisionSound = false;
	float speedY = 0;

	public Ball(int x, int y) {
		setTag("ball");
		this.x = x;
		this.y = y;
		w = 45;
		h = 45;
		this.ballAnimatedImg = new AnimatedImage("ball_animation.png", 
		        1200, 8, 8, 0, 0, (int) w, (int) h);
		addComponent(new Collider());
	}

	@Override
	public void update(GameContainer gc, float dt) {
	    if (playColisionSound) {
	        gc.getSoundManager().playSound("shot");
	        playColisionSound = false;
        }
		if (left) {
			x -= dt * 50;
		} else {
			x += dt * 50;
		}

		y += speedY;

		if (y < 0) {
			y = 0;
			speedY *= -1;
		}

		if (y + h > gc.getHeight()) {
			y = gc.getHeight() - h;
			speedY *= -1;
		}

		this.ballAnimatedImg.nextFrame(dt);
		updateComponents(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
	    Rectangle2D pos = this.ballAnimatedImg.getCurrentFramePosition();
	    r.drawImage(this.ballAnimatedImg.getImage(), 
	            pos.getMinX(), pos.getMinY(), pos.getWidth(), pos.getHeight(),
	            x, y, pos.getWidth(), pos.getHeight());
	}

	@Override
	public void dispose() {

	}

	@Override
	public void componentEvent(String name, GameObject object) {
		if (name.equalsIgnoreCase("collider")) {
			if (object.getX() < x) {
				left = false;
			} else {
				left = true;
			}
			playColisionSound = true;
			speedY = -((object.getY() + (object.getH() / 2)) - (y + (h / 2))) / (object.getH() / 2);
		}
	}

}

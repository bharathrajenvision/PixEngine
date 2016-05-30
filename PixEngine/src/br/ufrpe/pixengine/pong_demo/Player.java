package br.ufrpe.pixengine.pong_demo;

import br.ufrpe.pixengine.components.Collider;
import br.ufrpe.pixengine.components.GameObject;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Player extends GameObject {
	public Player(int x, int y) {
		setTag("player");
		this.x = x;
		this.y = y;
		w = 16;
		h = 64;
		addComponent(new Collider());
	}

	@Override
	public void update(GameContainer gc, float dt) {
		if (gc.getInput().isKey(KeyCode.W.ordinal())) {
			y -= 100 * dt;

			if (y < 0) {
				y = 0;
			}
		}

		if (gc.getInput().isKey(KeyCode.S.ordinal())) {
			y += 100 * dt;

			if (y + h > gc.getHeight()) {
				y = gc.getHeight() - h;
			}
		}

		updateComponents(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawRect((int) x, (int) y, (int) w, (int) h, Color.AQUA, 2.0);
	}

	@Override
	public void dispose() {

	}

	@Override
	public void componentEvent(String name, GameObject object) {

	}

}

package br.ufrpe.pixengine.pong_demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import br.ufrpe.pixengine.core.AbstractGame;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;

public class GameManager extends AbstractGame {
    
	public GameManager() {
		push(new PlayState());
	}
	
	@Override
	public void update(GameContainer gc, float dt) {
		peek().update(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		peek().render(gc, r);
	}

	@Override
	public void init(GameContainer gc) {
        try {
            gc.getSoundManager().loadSoundEffects("shot", Paths.get("res/shot.wav").toUri().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//		peek().getManager()
	}

}

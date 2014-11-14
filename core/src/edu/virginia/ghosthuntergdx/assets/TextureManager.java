package edu.virginia.ghosthuntergdx.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.TextureAtlasLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import edu.virginia.ghosthuntergdx.entities.Player;

public class TextureManager {

	public static TextureAtlas player;
	public static Texture mKnob;
	public static Texture mBack;
	public static Texture aKnob;
	public static Texture aBack;
	public static TextureAtlas items;
//	public static Texture vampire;
//	public static Texture warewolf;
//	public static Texture ghost;
//	
	public static final int playerIdleFrame = 2;
	
	public static void LoadTextures()
	{
		player = new TextureAtlas(Gdx.files.internal("data/playerAtlas.pack"));
		items = new TextureAtlas(Gdx.files.internal("data/itemAtlas.pack"));
		Array<AtlasRegion> regions = player.getRegions();
		Player.idleFists = (TextureRegion)regions.get(playerIdleFrame);
		mKnob = new Texture(Gdx.files.internal("data/mKnob.png"));
		mBack = new Texture(Gdx.files.internal("data/mBack.png"));
		aKnob = new Texture(Gdx.files.internal("data/aKnob.png"));
		aBack = new Texture(Gdx.files.internal("data/aBack.png"));
		
//		vampire = new Texture(Gdx.files.internal("data/vampire1.png"));
//		warewolf = new Texture(Gdx.files.internal("data/warewolf.png"));
//		ghost = new Texture(Gdx.files.internal("data/ghost.png"));

				
	}
	
	public static void DisposeTextures()
	{
		player.dispose();
		items.dispose();
		mKnob.dispose();
		mBack.dispose();
		aKnob.dispose();
		aBack.dispose();
//		vampire.dispose();
//		ghost.dispose();
//		warewolf.dispose();
	}
}

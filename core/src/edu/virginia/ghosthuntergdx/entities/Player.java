package edu.virginia.ghosthuntergdx.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.*;

import edu.virginia.ghosthuntergdx.Consts;
import edu.virginia.ghosthuntergdx.TextureManager;

public class Player extends PhysicsActor{

	Vector2 moveDir = new Vector2(0,0);
	Vector2 attackDir = new Vector2(0,0);
	
	public final float baseMoveSpeed = 3f;
	public float moveSpeed = baseMoveSpeed;
	public float rotSpeed = 900f;
	
	public Player(Vector2 position) {
		super(position, TextureManager.player);
		maxVelocity = new Vector2(5,5);
	}
	public Player(Vector2 position,Texture t) {
		super(position, t);
	}
	
	@Override
	public void act(float delta)
	{
		super.act(delta);

		//If player is attacking, slow his movement speed
		if(!attackDir.equals(Vector2.Zero))
		{
			moveSpeed = baseMoveSpeed/1.5f;
		}else{
			moveSpeed = baseMoveSpeed;
		}
		
		if(mBody.getLinearVelocity().len() < maxVelocity.len() )
		{
			mBody.setLinearVelocity(moveDir.x*moveSpeed,moveDir.y*moveSpeed);
		}
		
		float targetRot = getSprite().getRotation();
		if(moveDir.len() > 0 && attackDir.equals(Vector2.Zero))
		{
			targetRot = (float) Math.atan2(moveDir.y,moveDir.x)*MathUtils.radiansToDegrees;

		}else if(!attackDir.equals(Vector2.Zero)){
			targetRot = (float) Math.atan2(attackDir.y,attackDir.x)*MathUtils.radiansToDegrees;
		}
		
		
		if(Math.abs(targetRot - rot) > 180)
		{
			if(rot < targetRot)
				rot+=360;
			else
				targetRot+=360;
		}
		
		if(Math.abs(targetRot - rot) > 0)
		{
			if(rot < targetRot)
			{
				rot+=rotSpeed*delta;
				if(rot > targetRot)
					rot = targetRot;
			}else
			{
				rot-=rotSpeed*delta;
				if(rot < targetRot)
					rot = targetRot;
			}
		}
	}
	
	
	public void setMoveDir(Vector2 target)
	{
		moveDir = target;
	}
	
	public void setAttackDir(Vector2 target)
	{
		attackDir = target;
	}

}
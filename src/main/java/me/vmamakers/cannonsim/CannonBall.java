package me.vmamakers.cannonsim;

import lombok.Getter;
import lombok.Setter;

public class CannonBall {
	
	@Getter @Setter private float m; //mass of ball
	@Getter @Setter private float r; //radius of ball; used for drag calculation
	@Getter @Setter private float cD; //spherical drag coefficient
	
}

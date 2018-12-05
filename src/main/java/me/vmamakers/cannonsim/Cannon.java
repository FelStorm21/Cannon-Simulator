package me.vmamakers.cannonsim;

import lombok.Getter;
import lombok.Setter;

public class Cannon {
	
	@Getter @Setter private float angle; //angle of elevation of cannon with respect to horizontal
	@Getter @Setter private float length; //length of cannon
	@Getter @Setter private float avgExplodingForce; //average exploding force within combustion chamber of cannon; used to find v0 using work-energy theorem
	
}

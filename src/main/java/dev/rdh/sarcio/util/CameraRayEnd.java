package dev.rdh.sarcio.util;

import net.minecraft.util.math.Vec3d;

public final class CameraRayEnd extends Vec3d {
	public CameraRayEnd(Vec3d end) {
		super(end.x, end.y, end.z);
	}
}

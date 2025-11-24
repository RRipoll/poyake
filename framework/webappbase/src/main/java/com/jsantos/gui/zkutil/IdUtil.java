package com.jsantos.gui.zkutil;

import java.util.Random;

public class IdUtil {
	public static String generateRandomId() {
		return Integer.toString(new Random().nextInt());
	}

}

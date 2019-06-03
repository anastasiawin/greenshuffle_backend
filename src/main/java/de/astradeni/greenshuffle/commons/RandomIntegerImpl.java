package de.astradeni.greenshuffle.commons;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomIntegerImpl implements IRandomInteger {
	private Random random;

	public RandomIntegerImpl() {
		// Create a Random object.
		random = new Random();
	}

	public int nextInt(int max) {
		return random.nextInt(max);
	}

}

package game.items.runes;

import game.utils.RandomNumberGenerator;

public interface RuneGenerator {
    default int generateRunes(int lowerBound, int upperBound){
        return RandomNumberGenerator.getRandomInt(lowerBound,upperBound);
    }
}

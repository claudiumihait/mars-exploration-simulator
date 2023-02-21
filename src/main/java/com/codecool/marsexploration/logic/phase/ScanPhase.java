package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.Symbol;

import java.util.Arrays;

public class ScanPhase implements Phase{

    @Override
    public void perform(Context context) {
        Rover rover = context.rover();
        int sight = context.rover().sight();
        Character[][] map = context.map();
        Coordinate roverPsn = context.rover().coordinate();
        int maxX = Math.min((roverPsn.x() + sight), map.length);
        int minX = Math.max((roverPsn.x() - sight), 0);
        int maxY = Math.min((roverPsn.y() + sight), map.length);
        int minY = Math.min((roverPsn.y() - sight), 0);
        for (int i = minX; i < maxX; i++ ){
            for (int j = minY; j < maxY; j++){
                String currentSymbol = map[i][j].toString();
                if (Arrays.stream(Symbol.values()).anyMatch(s-> s.getSymbol().equals(currentSymbol))){
                    rover.sightings().put(new Coordinate(i, j), currentSymbol);
                }
            }
        }
    }
}

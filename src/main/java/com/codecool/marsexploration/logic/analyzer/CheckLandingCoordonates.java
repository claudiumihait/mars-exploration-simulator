package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.analyzer.Analyzer;

import java.util.Optional;

public class CheckLandingCoordonates implements Analyzer {

    @Override
    public Optional<Outcome> analyze(Context context) {
        Character[][] map = context.getMap();
        int x = context.getLanding().x();
        int y = context.getLanding().y();
        Character symbolAtLandingCoordinates = map[x][y];

        if (Symbol.PIT.getSymbol().equals(symbolAtLandingCoordinates.toString())
                || Symbol.MOUNTAIN.getSymbol().equals(symbolAtLandingCoordinates.toString())) {
            return Optional.of(Outcome.WRONG_LANDING_COORDINATES);
        }

        return Optional.empty();
    }
}

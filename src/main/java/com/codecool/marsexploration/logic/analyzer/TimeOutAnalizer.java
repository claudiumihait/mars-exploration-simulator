package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class TimeOutAnalizer implements Analyzer{

    @Override
    public Optional<Outcome> analyze(Context context) {

        int currentStep = context.stepNumber();
        long timeOut = context.timeout();



        return Optional.empty();
    }
}

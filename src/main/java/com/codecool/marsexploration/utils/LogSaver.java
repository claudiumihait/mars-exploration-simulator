package com.codecool.marsexploration.utils;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.logic.routine.BuildingRoutine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogSaver {

    public void logStep(Context context){
        //STEP 6; EVENT position; UNIT rover-1; POSITION [21,22]
        String content;
        if(!(context.getRover().getState() instanceof BuildingRoutine)){
            content = "STEP-" + context.getStepNumber() + "; EVENT position; UNIT ROVER-" + context.getRover().getId() + "; POSITION [" + context.getRover().getCoordinate().x() + "," +context.getRover().getCoordinate().y() + "]";
            if (context.getOutcome().isPresent()) {
                content += "\nEVENT outcome; OUTCOME " + context.getOutcome().get().getStatusMessage();
            }
        } else {
            content = "STEP-" + context.getStepNumber() + "; BUILDING STEP - " + context.currentStepsInConstruction + "/" + context.stepsNeededForConstruction;
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(context.getLogPath(), true))){
            bw.append(content);
            bw.newLine();
        }catch(IOException e){
            System.out.println("An error occurred while trying to write the file.\n Error message: " + e.getMessage());
        }
    }
}
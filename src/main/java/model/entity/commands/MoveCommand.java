package model.entity.commands;

import model.Step;
import model.WorldContext;
import model.entity.*;

public class MoveCommand implements BaseCommand {
    @Override
    public void execute(Bacteria bacteria, int commandCode, WorldContext worldContext) {
        Step step = worldContext.generateValidStep(bacteria);
        int newX = bacteria.getCoords().x + step.getX();
        int newY = bacteria.getCoords().y + step.getY();
        int healthPoints = bacteria.getHealthPoints();
        bacteria.setHealthPoints(healthPoints - 1);
        AbstractEntity encounteredEntity = worldContext.checkCellForAnEntity(bacteria, step, Bacteria.class, Food.class, Poison.class, Wall.class);
        if (encounteredEntity == null) {
            worldContext.moveBacteria(bacteria,  newX, newY);
        } else {
            if (encounteredEntity instanceof Food food) {
                worldContext.eatFood(food);
                worldContext.moveBacteria(bacteria, newX, newY);
                bacteria.setHealthPoints(healthPoints + 10);
            } else if (encounteredEntity instanceof Poison) {
                worldContext.eatPoison(bacteria);
            }
        }
    }
}

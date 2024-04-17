package flocking;

import simstation.*;
import mvc.*;


public class FlockingFactory extends SimStationFactory {
    @Override
    public Model makeModel() {
        return new FlockingSimulation();
    }
    @Override
    public String getTitle() {
        return "Flocking Simulation";
    }


    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equals("Stats")) {
            return new FlockingStatsCommand(model);
        } else {
            return super.makeEditCommand(model, type, source);
        }
    }

    class FlockingStatsCommand extends StatsCommand {
        public FlockingStatsCommand(Model model) {
            super(model);
        }

        @Override
        protected String[] stats() {
            FlockingSimulation simulation = (FlockingSimulation) model;
            int[] speeds = new int[5];
            for (Agent agent : simulation.getAgents()) {
                Flocking bird = (Flocking) agent;
                speeds[(int) (bird.getSpeed() - 1)]++;
            }
            String[] stats = new String[5];
            for (int i = 0; i < 5; i++) {
                stats[i] = "#birds @ speed " + (i + 1) + "= " + speeds[i];
            }
            return stats;
        }
    }
}

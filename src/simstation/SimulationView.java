package simstation;

import mvc.*;

import java.awt.*;

public class SimulationView extends View {
    private Simulation simulation;
    public SimulationView(Model model) {
        super(model);
    }


    // I think this code below should go into the customizations
    /*public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation simulation = (Simulation) model;
        for (Agent agent : simulation.getAgents()) {
            gc.setColor(agent.getColor());
            gc.fillOval(agent.getXc(), agent.getYc(), 5, 5);
        }
    }*/
}

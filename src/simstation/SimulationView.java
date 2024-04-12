package simstation;

import mvc.*;

import java.awt.*;

public class SimulationView extends View {
    protected final static int AGENT_SIZE = 6;
    public SimulationView(Model model) {
        super(model);
        this.setBackground(Color.GRAY);
    }


    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation simulation = (Simulation) model;
        gc.setColor(Color.BLACK);
        gc.drawRect(0, 0, simulation.SIZE, simulation.SIZE);
        int offset = AGENT_SIZE / 2;
        for (Agent a : simulation.getAgents()) {
            gc.setColor(Color.WHITE);
            gc.fillOval(a.getXc() - offset, a.getYc() - offset, AGENT_SIZE, AGENT_SIZE);
        }
    }
}

package plague;
import simstation.*;
import mvc.*;

public class PlagueSimulation extends Simulation {
    private static int VIRULENCE = 50; // % chance of infection 50
    private static int RESISTANCE = 2; // % chance of resisting infection 2
    private static int POPULATION = 15;
    private static int INFECTED = 0;
    public static final int CHANCE = 100;
    public void populate() {
        for(int i = 0; i < POPULATION; i++)
            addAgent(new Plague());
        infectAgents(); // Infect random agents in the World
    }
    public void infectAgents() {
        for (Agent agent : getAgents()) {
            Plague a = (Plague) agent;
            if (!a.isInfected()) {
                if (isSusceptible(agent)) {
                    int infectionChance = Utilities.rng.nextInt(CHANCE);
                    if (infectionChance < VIRULENCE) {
                        a.setInfected(true);
                        INFECTED++;
                    }
                }
            }
        }
    }
    // This method tries to infect an infected Agent's neighbor.
    public void infectNeighbor(Plague agent, Plague neighbor) {
        if(agent.isInfected()) {
            if(!neighbor.isInfected()) {
                if (isSusceptible(neighbor)) {
                    int infectionChance = Utilities.rng.nextInt(CHANCE);
                    if (infectionChance < VIRULENCE) {
                        neighbor.setInfected(true);
                        INFECTED++;
                    }
                }
            }
        }
    }
    // Method to determine if an agent is susceptible to infection
    private boolean isSusceptible(Agent agent) {
        int resistanceChance = Utilities.rng.nextInt(CHANCE);
        return resistanceChance >= RESISTANCE; // If resistance chance is greater than or equal to resistance factor, agent is susceptible
    }
    public synchronized String stats() {
        double percentInf = Math.ceil(((double) INFECTED / POPULATION) * 100.0);
        return "% infected: " + percentInf;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}

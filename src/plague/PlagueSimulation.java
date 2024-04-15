package plague;
import simstation.*;
import mvc.*;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
//    public void populate() {
//        for(int i = 0; i < 15; i++)
//            //addAgent(new Drunk());
//    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}

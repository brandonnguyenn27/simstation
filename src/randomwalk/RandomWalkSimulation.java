package randomwalk;

//<<<<<<< HEAD
//import mvc.*;
//import simstation.*;
//import java.awt.*;
//import java.util.Iterator;
//
//public class RandomWalkSimulation extends Simulation{
//    @Override
//=======
import simstation.Simulation;
import mvc.*;
import simstation.SimulationPanel;

public class RandomWalkSimulation extends Simulation {
    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }
}

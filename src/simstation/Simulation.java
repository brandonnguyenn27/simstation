package simstation;

import mvc.Model;
import java.util.*;
public class Simulation extends Model {
    transient private Timer timer;
    private int clock;
    private List<Agent> agents;
    public void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }
    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }


    private void getNeighbor(Agent a, double radius) {


    }

    private void populate() {

    }

    private class ClockUpdater extends TimerTask {
        @Override
        public void run() {
            clock++;
            //changed();
        }
    }

}

package simstation;

import mvc.Model;
import mvc.Utilities;

import java.util.*;
public class Simulation extends Model {
    transient private Timer timer;
    private int clock = 0;
    private List<Agent> agents;
    public void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }
    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public void start() {
        populate();
        startTimer();
        for (Agent a : agents) {
            a.start();
        }
        changed();
    }

    public void suspend() {
        stopTimer();
        for (Agent a : agents) {
            a.suspend();
        }
        changed();
    }

    public void resume() {
        startTimer();
        for (Agent a : agents) {
            a.resume();
        }
        changed();
    }

    public void stop() {
        stopTimer();
        for (Agent a : agents) {
            a.stop();
        }
        changed();
    }

    private Agent getNeighbor(Agent a, double radius) {
        if (agents.size() == 0) {
            return null;
        }
        int startIdx = Utilities.rng.nextInt(agents.size());
        int index = startIdx;
        do {
            Agent neighbor = agents.get(index);
            if (!neighbor.equals(a) && a.distance(neighbor) < radius) { // is the radius inclusive?
                return neighbor;
            }
            index = (index + 1) % agents.size(); // wrap around
        } while (startIdx != index);
        return null;
    }

    private void populate() {
        // empty method that will be specified in subclasses
    }

    public Agent[] getAgents() {
        return agents.toArray(new Agent[0]);
    }

    private class ClockUpdater extends TimerTask {
        @Override
        public void run() {
            clock++;
            //changed();
        }
    }

}

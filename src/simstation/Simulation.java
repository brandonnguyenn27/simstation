package simstation;

import mvc.Model;
import mvc.Utilities;

import java.util.*;
public class Simulation extends Model {

    protected static int SIZE = 250;
    transient private Timer timer;
    private int clock;
    private List<Agent> agents;

    public Simulation() {
        super();
        agents = new LinkedList<Agent>();
        clock = 0;

    }

    public void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }
    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public void start() {
        this.clock = 0;
        populate();
        startTimer();
        agents.clear();
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

    public void addAgent(Agent ag) {
        ag.xc = Utilities.rng.nextInt(SIZE);
        ag.yc = Utilities.rng.nextInt(SIZE);
        agents.add(ag);
        ag.setSimulation(this);
    }

    public synchronized Agent getNeighbor(Agent a, double radius) {
        for (Agent other : agents) {
            if (other != a && a.distance(other) < radius) {
                return other;
            }
        }
        return null;
    }

    private void populate() {
        // empty method that will be specified in subclasses
    }

    public Agent[] getAgents() {
        return agents.toArray(new Agent[0]);
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getClock() {
        return clock;
    }

    public void setClock(int clock) {
        this.clock = clock;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    private class ClockUpdater extends TimerTask {
        @Override
        public void run() {
            clock++;
        }
    }

}

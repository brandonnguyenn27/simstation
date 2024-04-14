package prisoner;

import simstation.*;
import mvc.*;
public class PrisonerSim extends Simulation {
    private static final int PRISONERS_PER_STRAT = 10;
    public void populate() {
        for (int i = 0; i < PRISONERS_PER_STRAT; i++) {
            for (int j = 0; j < Strategy.COUNT; j++) {
                addAgent(createPrisoner(j));
            }
        }
    }

    public Prisoner createPrisoner(int strat) {
        Prisoner p = new Prisoner();
        switch (strat) {
            case 0:
                p.setStrategy(new Strategy.Cooperate(p));
                break;
            case 1:
                p.setStrategy(new Strategy.RandomlyCooperate(p));
                break;
            case 2:
                p.setStrategy(new Strategy.Cheat(p));
                break;
            case 3:
                p.setStrategy(new Strategy.Tit4Tat(p));
                break;
        }
        return p;
    }

    public synchronized String[] stats() {
        String[] msg = new String[Strategy.COUNT];
        double cooperate = 0;
        double randomlyCooperate = 0;
        double cheat = 0;
        double tit4tat = 0;
        for (Agent a : this.getAgents()) {
            Prisoner p = (Prisoner) a;
            switch (p.getStrategy().getType()) {
                case COOPERATE:
                    cooperate++;
                    break;
                case RANDOMLY_COOPERATE:
                    randomlyCooperate++;
                    break;
                case CHEAT:
                    cheat++;
                    break;
                case TIT4TAT:
                    tit4tat++;
                    break;
            }
        }
        msg[0] = "Cooperate average fitness = " + cooperate;
        msg[1] = "Randomly-Cooperate average fitness = " + randomlyCooperate;
        msg[2] = "Cheat average fitness = " + cheat;
        msg[3] = "Tit4Tat average fitness = " + tit4tat;

        return msg;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.display();
    }

}
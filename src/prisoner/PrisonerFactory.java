package prisoner;

import simstation.SimStationFactory;
import mvc.*;
import simstation.StatsCommand;

public class PrisonerFactory extends SimStationFactory {
    public PrisonerFactory() {
        super();
    }

    @Override
    public String getTitle() {
        return "Prisoner's Dilemma";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Cooperate or Defect"};
    }

    @Override
    public PrisonerView makeView(Model m) {
        return new PrisonerView(m);
    }

    @Override
    public PrisonerSim makeModel() {
        return new PrisonerSim();
    }

    class PrisonerStatsCommand extends StatsCommand {
        public PrisonerStatsCommand(Model model) {
            super(model);
        }

        @Override
        protected String[] stats() {
            String[] defaultStats = super.stats();
            PrisonerSim simulation = (PrisonerSim)model;
            String[] newStats = simulation.stats();
            return new String[]{defaultStats[0], defaultStats[1], newStats[0], newStats[1], newStats[2], newStats[3]};
        }
    }
}
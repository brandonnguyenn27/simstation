package plague;
import mvc.AppFactory;
import simstation.*;
import mvc.*;
public class PlagueFactory extends SimStationFactory {
    @Override
    public Simulation makeModel() {
        return new PlagueSimulation();
    }
    @Override
    public PlagueView makeView(Model m) {
        return new PlagueView(m);
    }
    public String getTitle() { return "Plague";}
    class PlagueStatsCommand extends StatsCommand {

        public PlagueStatsCommand(Model model) {
            super(model);
        }
        protected String[] stats() {
            PlagueSimulation simulation = (PlagueSimulation) model;
            return new String[]{"agents = " + simulation.getAgentsSize(), "clock = " + simulation.getClock()};
        }
    }

}

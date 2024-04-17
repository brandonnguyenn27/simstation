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
    @Override
    public String about() {
        return "Simstation: Plague \nBrandon Nguyen, Charles Manaois, Hruday Prathipati\n 2024";
    }
    @Override
    public String[] getHelp() {
        return new String[] {"Plague Simulation:", "Press Start to start the simulation.",
                "Press Suspend to pause the simulation while it is running.",
                "Press Resume to resume the simulation after it has been suspended.",
                "Press Stop to stop the simulation.",
                "Press Stats to view the statistics of the simulation. Returns Percent Infected."};
    }
    public String getTitle() { return "Plague";}
    class PlagueStatsCommand extends StatsCommand {

        public PlagueStatsCommand(Model model) {
            super(model);
        }
        @Override
        protected String[] stats() {
            //String[] defaultStats = super.stats();
            PlagueSimulation simulation = (PlagueSimulation) model;
            String infectPop = simulation.stats();
            return new String[]{"agents = " + simulation.getAgentsSize(), "clock = " + simulation.getClock(), infectPop};
        }
    }
    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "Stats":
                return new PlagueStatsCommand(model);
            default:
                return super.makeEditCommand(model, type, source);
        }
    }
}

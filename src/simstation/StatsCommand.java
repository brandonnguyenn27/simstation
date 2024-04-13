package simstation;
import mvc.*;
public class StatsCommand extends Command{
    public StatsCommand(Model model) {
        super(model);
    }

    protected String[] stats() {
        Simulation simulation = (Simulation)model;
        return new String[]{"agents = " + simulation.getAgentsSize(), "clock = " + simulation.getClock()};
    }

    public void execute() {
        Utilities.inform(stats());
    }
}

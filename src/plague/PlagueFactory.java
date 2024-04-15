package plague;
import mvc.AppFactory;
import simstation.*;

public class PlagueFactory extends SimStationFactory {
    @Override
    public Simulation makeModel() {
        return new PlagueSimulation();
    }
//    @Override
//    public Model makeModel() {
//        return new PlagueSimulation();
//    }
    public String getTitle() { return "Plague";}
}

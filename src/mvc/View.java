package mvc;

import javax.swing.*;

public class View extends JPanel implements Subscriber {
    protected Model model;
    /*
    Constructor for the View class
    @param model the model to be used
     */
    public View(Model model) {
        this.model = model;
        this.model.subscribe( this);
    }
    @Override
    public void update() {
        this.repaint();
    }

   public void setModel(Model newModel) {
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);

   }

}

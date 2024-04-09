package mvc;

import java.awt.*;
import java.io.Serializable;


public class Model extends Publisher implements Serializable {
    private String fName;
    private boolean unsavedChanges;
    public Model() {
        fName = null;
        unsavedChanges = false;

    }
    public String getFileName() {
        return this.fName;
        
    }

    public void setFileName(String fName) {
        this.fName = fName;
    }

    public void changed() {
        unsavedChanges = true;
        notifySubscribers();
    }


    public void setUnsavedChanges(boolean b) {
        unsavedChanges = b;
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;

    }


}

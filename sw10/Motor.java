import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Motor implements Switchable{
    private MotorState state;
    private final List<PropertyChangeListener> changeListeners = new ArrayList<PropertyChangeListener>();
    /**
     Default Konstruktor
     */
    public Motor() {
        this.state = MotorState.OFF;
    }
    /**
     Overloaded Konstrucktor
     @param:MotorState
      * */
    public Motor(MotorState pState) {
        this.state = pState;
    }

    public MotorState getState() {
        return this.state;
    }

    public void setState(MotorState value) {
        this.state = value;
    }

    public void addChangeListener(final PropertyChangeListener pcListener) {
        this.changeListeners.add(pcListener);
    }

    public void removeChangeListener(final PropertyChangeListener pcListener) {
        this.changeListeners.remove(pcListener);
    }

    @Override
    public void switchOn() {
        if (isSwitchedOff()) {
            this.state = MotorState.ON;
            final PropertyChangeEvent pcEvent = new
                    PropertyChangeEvent(this, "state", MotorState.OFF, MotorState.ON);
            firePropertyChangeEvent(pcEvent);
        }
    }

    @Override
    public void switchOff() {
        if (isSwitchedOn()) {
            this.state = MotorState.OFF;
            final PropertyChangeEvent pcEvent = new
                    PropertyChangeEvent(this, "state", MotorState.ON, MotorState.OFF);
            firePropertyChangeEvent(pcEvent);
        }
    }

    @Override
    public boolean isSwitchedOn() {
        if (this.state == MotorState.OFF)
            return false;
        return true;
    }

    @Override
    public boolean isSwitchedOff() {
        if (this.state == MotorState.ON)
            return false;
        return true;
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(pcEvent);
        }
        System.out.println(String.format("Property: %s, Old Value: %s, New Value: %s",
        pcEvent.getPropertyName(), pcEvent.getOldValue(), pcEvent.getNewValue()));
    }

    public static void main(String[] args) {
        Motor m = new Motor();
        m.switchOn();
        m.switchOff();
    }
}




import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class Auto implements Switchable {

    private Motor motor;
    private Licht licht;
    private boolean on;

    public Auto() {
        this.licht = new Licht();
        this.motor = new Motor();
        this.on = false;
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff())
        {
            this.licht.switchOn();
            this.motor.switchOn();
            this.on = true;
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.licht.switchOff();
            this.motor.switchOff();
            this.on = false;
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.licht.isSwitchedOn() && this.motor.isSwitchedOn() && this.on == true;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.licht.isSwitchedOff() && this.motor.isSwitchedOff() && this.on ==false;
    }

}

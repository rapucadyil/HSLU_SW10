public class Licht implements Switchable{

    private int onOff;

    public Licht() {
        this.onOff = 0;
    }

    @Override
    public void switchOn() {
        if (this.onOff == 0)
            this.onOff = 1;
    }

    @Override
    public void switchOff() {
        if (this.onOff == 1)
            this.onOff = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.onOff == 1;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.onOff == 0;
    }
}

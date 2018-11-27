import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TemperatureVerlauf {

    private ArrayList<Temperature> temperatures;
    private TemperatureEvent event;

    private final List<PropertyChangeListener> changeListeners = new ArrayList<PropertyChangeListener>();

    public TemperatureVerlauf() {
        this.temperatures = new ArrayList<Temperature>();
        this.event = TemperatureEvent.NONE;
    }

    public ArrayList<Temperature> getTemperatures() {
        return this.temperatures;
    }

    public void add(Temperature t){
        temperatures.add(t);
        if (getMaxTemperature() == t.getTemp()) {
            event = TemperatureEvent.MAX;
            final TemperatureMaxEvent tEvent = new TemperatureMaxEvent(this, TemperatureEvent.MAX);
            System.out.println(String.format("Max Event, Source: %s, Value: %s", tEvent.getSource().toString(), tEvent.getValue()));
        }else if (getMinTemperature() == t.getTemp()) {
            event = TemperatureEvent.MIN;
            final TemperatureMinEvent tEvent = new TemperatureMinEvent(this, TemperatureEvent.MIN);
            System.out.println(String.format("Min Event, Source: %s, Value: %s", tEvent.getSource(), tEvent.getValue()));
        }else{
            event = TemperatureEvent.NONE;
        }
    }

    public void clear() {
        this.temperatures.clear();
    }

    public int getCount() {
        return this.temperatures.size();
    }

    public float getMaxTemperature() {
        Temperature currentMax = this.temperatures.get(0);
        int index = 0;
        while(index < this.getCount()) {
            if (this.temperatures.get(index).getTemp() > currentMax.getTemp())
                currentMax = this.temperatures.get(index);
            index++;
        }
        return currentMax.getTemp();
    }

    public float getMinTemperature() {
        Temperature currentMin = this.temperatures.get(0);
        int i = 0;
        while(i < this.temperatures.size()) {
            if (this.temperatures.get(i).getTemp() < currentMin.getTemp())
                currentMin = this.temperatures.get(i);
            i++;
        }
        return currentMin.getTemp();
    }

    public float getAverageTemperature() {
        float maxVal = this.getMaxTemperature();
        float minVal = this.getMinTemperature();
        if (this.getCount() > 2)
            return (maxVal + minVal) / (this.getCount());

        return maxVal;
    }
    private void fireTempMaxEvent() {
        /*
        * bind to currentMax var
        * */
        System.out.println("max event!!!");
    }

    private void fireTempMinEvent() {
        System.out.println("min event!!!");
    }

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        TemperatureVerlauf tempVerlauf = new TemperatureVerlauf();
        do {
            System.out.println("Temperatur Eingeben:");
            input = scanner.next();
            try {
                float tempValue = Float.valueOf(input);
                Temperature temp = new Temperature(tempValue, "C");
                tempVerlauf.add(temp);
            }catch(Exception e){
                System.out.println("Wrong input type!");
            }
        }while(!(input.equals("exit")));
        try {
            System.out.println(String.format("Temp.Verlauf: Anzahl Temp. Punkte: %s, " +
                            "Durchschnittliche Temp: %s, Min: %s, Max: %s", tempVerlauf.getCount(), tempVerlauf.getAverageTemperature(),
                            tempVerlauf.getMinTemperature(), tempVerlauf.getMaxTemperature()));
        }catch (Exception e) {
            System.out.println("No temperatures in collections");
        }
    }

    public enum TemperatureEvent {
        MAX,
        MIN,
        NONE
    }

}

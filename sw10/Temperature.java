public final class Temperature {
    private float current;
    private String scale;

    static final float KELVIN_OFFSET = 273.15f;

    public Temperature(float c, String s) {
        try {
            if (c > -273.15)
                this.current = c;
            else if (c > 0)
                this.current = c;
        }catch (IllegalArgumentException iae) {
            System.out.println("Illegal Temperature argument");
        }
        this.scale = s;
    }

    public enum States {
        SOLID,
        LIQUID,
        GAS
    }

    public static Temperature createFromCelsiusValue(final float celsius) {
        Temperature inCelsius = null;

        inCelsius = new Temperature(celsius, "C");

        return inCelsius;
    }


    public static Temperature createFromKelvinValue(final float kelvin) {
        Temperature inKelvin = null;
        inKelvin = createFromCelsiusValue(kelvin);
        inKelvin.scale = "K";
        return inKelvin;
    }


    public Temperature() {
        this.current = 0.0f;
    }

    public float getTemp() {
        return this.current;
    }

    public String getScale() {
        return this.scale;
    }

    public void setTemp(float value) {
        if (value < -273.15){
            throw new IllegalArgumentException("Cannot have this temperature value!");
        }else{
            this.current = value;
        }
    }
    public static float convertKelvinToCelsius(float kelvin) {
        return kelvin - KELVIN_OFFSET;
    }

    public static float convertCelsiusToKelvin (float celsius) {
        return celsius + KELVIN_OFFSET;
    }
}

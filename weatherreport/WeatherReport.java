package weatherreport;

public class WeatherReport {
    public static String Report(IWeatherSensor sensor) {
        int precipitation = sensor.Precipitation();
        String report = "Sunny Day";

        if (sensor.TemperatureInC() > 25) {
            if (precipitation >= 20 && precipitation < 60)
                report = "Partly Cloudy";
            else if (sensor.WindSpeedKMPH() > 50)
                report = "Alert, Stormy with heavy rain";
        }
        return report;
    }

    public static void main(String[] args) {
        // Simulate a real sensor (could later be replaced with real implementation)
        IWeatherSensor sensor = new RealWeatherSensor();
        String report = Report(sensor);
        System.out.println("Today's Weather: " + report);
    }
}

// Interface
interface IWeatherSensor {
    double TemperatureInC();
    int Precipitation();
    int Humidity();
    int WindSpeedKMPH();
}

// Dummy real sensor for now
class RealWeatherSensor implements IWeatherSensor {
    public double TemperatureInC() { return 28; }
    public int Precipitation() { return 70; }
    public int Humidity() { return 80; }
    public int WindSpeedKMPH() { return 52; }
}

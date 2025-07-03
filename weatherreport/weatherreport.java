package weatherreport;

public class WeatherReport {
    public static String Report(IWeatherSensor sensor) {
        int precipitation = sensor.Precipitation();
        // precipitation < 20 is a sunny day
        String report = "Sunny Day";

        if (sensor.TemperatureInC() > 25) {
            if (precipitation >= 20 && precipitation < 60)
                report = "Partly Cloudy";
            else if (sensor.WindSpeedKMPH() > 50)
                report = "Alert, Stormy with heavy rain";
        }
        return report;
    }

    private static void TestRainy() {
        IWeatherSensor sensor = new SensorStub();
        String report = Report(sensor);
        System.out.println("TestRainy: " + report);
        assert(report.contains("rain")) : "Expected rain report";
    }

    private static void TestHighPrecipitation() {
        // Using the new stub that simulates high precipitation and low wind speed
        IWeatherSensor sensor = new HighPrecipLowWindStub();
        String report = Report(sensor);
        System.out.println("TestHighPrecipitation: " + report);

        // Stronger assertion to expose the bug
        assert(!report.equals("Sunny Day")) : "Bug exposed: High precipitation not detected!";
    }

    public static void main(String[] args) {
        TestRainy();
        TestHighPrecipitation();
        System.out.println("All is well (maybe!)");
    }
}

// Interface for weather sensor
interface IWeatherSensor {
    double TemperatureInC();
    int Precipitation();
    int Humidity();
    int WindSpeedKMPH();
}

// Default stub simulating stormy weather
class SensorStub implements IWeatherSensor {
    @Override
    public int Humidity() {
        return 72;
    }

    @Override
    public int Precipitation() {
        return 70; // high precipitation
    }

    @Override
    public double TemperatureInC() {
        return 26;
    }

    @Override
    public int WindSpeedKMPH() {
        return 52; // high wind speed
    }
}

// ✅ New stub to simulate high precipitation and low wind speed
class HighPrecipLowWindStub implements IWeatherSensor {
    @Override
    public int Humidity() {
        return 80;
    }

    @Override
    public int Precipitation() {
        return 70; // high precipitation
    }

    @Override
    public double TemperatureInC() {
        return 28; // warm temperature
    }

    @Override
    public int WindSpeedKMPH() {
        return 30; // low wind speed
    }
}

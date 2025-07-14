package weatherreporttest;

import weatherreport.*;

public class WeatherReportTest {
    public static void main(String[] args) {
        TestRainy();
        TestHighPrecipitation();
        System.out.println("All tests passed (probably)");
    }

    private static void TestRainy() {
        IWeatherSensor sensor = new SensorStub();
        String report = WeatherReport.Report(sensor);
        System.out.println("TestRainy: " + report);
        assert report.contains("rain") : "Expected rain report";
    }

    private static void TestHighPrecipitation() {
        IWeatherSensor sensor = new HighPrecipLowWindStub();
        String report = WeatherReport.Report(sensor);
        System.out.println("TestHighPrecipitation: " + report);
        assert !report.equals("Sunny Day") : "Bug exposed: High precipitation not detected!";
    }
}

// Stub classes for testing
class SensorStub implements IWeatherSensor {
    public double TemperatureInC() { return 26; }
    public int Precipitation() { return 70; }
    public int Humidity() { return 72; }
    public int WindSpeedKMPH() { return 52; }
}

class HighPrecipLowWindStub implements IWeatherSensor {
    public double TemperatureInC() { return 28; }
    public int Precipitation() { return 70; }
    public int Humidity() { return 80; }
    public int WindSpeedKMPH() { return 30; }
}

public class Main {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        String appName = configManager.getProperty("app.name");
        String appVersion = configManager.getProperty("app.version");
        String appMaxUsers = configManager.getProperty("app.maxUsers");

        System.out.println("Application Name: " + appName);
        System.out.println("Application Version: " + appVersion);
        System.out.println("Maximum Users: " + appMaxUsers);
    }
}

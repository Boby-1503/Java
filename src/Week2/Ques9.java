package Week2;
import java.io.FileWriter;
import java.io.IOException;

interface Logger
{
    void logInfo(String message);

    void logWarning(String message);

    void logError(String message);
}

class ConsoleLogger implements Logger
{

    @Override
    public void logInfo(String message)
    {
        System.out.println("INFO: " + message);
    }

    @Override
    public void logWarning(String message)
    {
        System.out.println("WARNING: " + message);
    }

    @Override
    public void logError(String message)
    {
        System.err.println("ERROR: " + message);
    }
}


class FileLogger implements Logger
{

    private String filePath;

    public FileLogger(String filePath)
    {
        this.filePath = filePath;
    }

    @Override
    public void logInfo(String message)
    {
        logToFile("INFO: " + message);
    }

    @Override
    public void logWarning(String message)
    {
        logToFile("WARNING: " + message);
    }

    @Override
    public void logError(String message)
    {
        logToFile("ERROR: " + message);
    }

    private void logToFile(String logMessage)
    {
        try (FileWriter fileWriter = new FileWriter(filePath, true))
        {
            fileWriter.write(logMessage + "\n");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

class DatabaseLogger implements Logger
{

    @Override
    public void logInfo(String message)
    {
        logToDatabase("INFO: " + message);
    }

    @Override
    public void logWarning(String message)
    {
        logToDatabase("WARNING: " + message);
    }

    @Override
    public void logError(String message)
    {
        logToDatabase("ERROR: " + message);
    }

    private void logToDatabase(String logMessage)
    {

        System.out.println("Logging to database: " + logMessage);
    }
}

public class Ques9
{
    public static void main(String[] args)
    {
        // Example usage
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("C:\\Users\\U6074547\\OneDrive - Clarivate Analytics\\Desktop\\log.txt");
        Logger databaseLogger = new DatabaseLogger();

        consoleLogger.logInfo("This is an informational message.");
        consoleLogger.logWarning("This is a warning message.");
        consoleLogger.logError("This is an error message.");

        fileLogger.logInfo("This is an informational message.");
        fileLogger.logWarning("This is a warning message.");
        fileLogger.logError("This is an error message.");

        databaseLogger.logInfo("This is an informational message.");
        databaseLogger.logWarning("This is a warning message.");
        databaseLogger.logError("This is an error message.");
    }
}


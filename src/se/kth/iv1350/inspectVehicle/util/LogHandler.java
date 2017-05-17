package se.kth.iv1350.inspectVehicle.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Handles the export of trhown exception to the exception_log.txt file. 
 */
public class LogHandler {
    private static final String LOG_FILE_NAME = "exception_log.txt";
    private PrintWriter logFile;
    
    public LogHandler() throws IOException {
        logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
    }
    
    /**
     * Creates an error log text file with the current time and date which is written to the project root directory.
     * @param e
     */
    public void logException(Exception e) {
        StringBuilder exceptionLog = new StringBuilder();
        exceptionLog.append(addTimeStamp());
        exceptionLog.append(" Exception thrown");       
        logFile.println(exceptionLog);
        e.printStackTrace(logFile);
        logFile.close();
    }
    
    private String addTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}

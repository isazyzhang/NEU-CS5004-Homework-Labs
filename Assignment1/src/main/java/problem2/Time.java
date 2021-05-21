package problem2;

/**
 * This class represents a Time object with details: hours, minutes, seconds.
 * @author Zu Yu Zhang
 */

public class Time {

    private int hours;
    private int minutes;
    private int seconds;
    private static final int MIN = 0;
    private static final int MAX_HOURS = 23;
    private static final int MAX_MINUTES = 59;
    private static final int MAX_SECONDS = 59;
    private static final int SECONDS_PER_HR = 3600;
    private static final int SECONDS_PER_MIN = 60;

    /**
     * Creates a new Time object with the following details: hours, minutes, and seconds
     * @param hours how many hours
     * @param minutes how many minutes
     * @param seconds how many seconds
     */
    public Time(int hours, int minutes, int seconds){
        //Check if the time is valid:
        //a valid time has: hour between 0 and 23, inclusive
        if(hours >= MIN && hours <= MAX_HOURS){
            this.hours = hours;
        }else{
            throw new IllegalArgumentException("Hours must be between 0 and 23 inclusive");
        }

        //minute between 0 and 59, inclusive
        if(minutes >= MIN && minutes <= MAX_MINUTES){
            this.minutes = minutes;
        }else{
            throw new IllegalArgumentException("Minutes must be between 0 and 59 inclusive");
        }

        //second between 0 and 59, inclusive
        if(seconds >= MIN && seconds <= MAX_SECONDS){
            this.seconds = seconds;
        }else{
            throw new IllegalArgumentException("Seconds must be between 0 and 59 inclusive");
        }
    }

    /**
     * Get the number of hours
     * @return number of hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Set the number of hours
     * @param hours new number of hours
     */
    public void setHours(int hours) {
        if(hours >= MIN && hours <= MAX_HOURS) {
            this.hours = hours;
        } else{
            throw new IllegalArgumentException("Hours must be between 0 and 23 inclusive");
        }
    }

    /**
     * Get the number of minutes
     * @return the number of minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Set the number of minutes
     * @param minutes new number of minutes
     */
    public void setMinutes(int minutes) {
        if(minutes >= MIN && minutes <= MAX_MINUTES) {
            this.minutes = minutes;
        }else{
            throw new IllegalArgumentException("Minutes must be between 0 and 59 inclusive");
        }
    }

    /**
     * Get the number of seconds
     * @return the number of seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Set the number of seconds
     * @param seconds new number of seconds
     */
    public void setSeconds(int seconds) {
        if(seconds >= MIN && seconds <= MAX_SECONDS){
            this.seconds = seconds;
        } else{
            throw new IllegalArgumentException("Seconds must be between 0 and 59 inclusive");
        }
    }

    /**
     * Represents the Time object as a number of seconds
     * @return the time as a number of seconds
     */
    public int convertToSeconds(){
        int totalSeconds = this.hours * SECONDS_PER_HR + this.minutes * SECONDS_PER_MIN + this.seconds;
        return totalSeconds;
    }

    /**
     * Represents a number of seconds as a Time object
     * @param totalSeconds the number of seconds to be converted
     * @return the Time object
     */
    public static Time convertToTime(int totalSeconds){
        int durationHours = totalSeconds / SECONDS_PER_HR;
        int durationMinutes = (totalSeconds % SECONDS_PER_HR) / SECONDS_PER_MIN;
        int durationSeconds = (totalSeconds % SECONDS_PER_HR) % SECONDS_PER_MIN;
        return new Time(durationHours, durationMinutes, durationSeconds);
    }
}

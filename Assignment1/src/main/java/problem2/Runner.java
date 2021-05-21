package problem2;

/**
 * This class represents a Runner participating in a marathon with his/her details: name, team, start and end times.
 * @author Zu Yu Zhang
 */

public class Runner {
    private String name;
    private String team;
    private Time start;
    private Time end;

    /**
     * Creates a new Runner object with the following details: name, team, start and end times.
     * @param name the Runner's name
     * @param team the Runner's team
     * @param start the Runner's start time
     * @param end the Runner's end time
     */
    public Runner(String name, String team, Time start, Time end){
        this.name = name;
        this.team = team;
        this.start = start;
        this.end = end;
    }

    /**
     * Return the total time the runner took to complete the marathon
     * @return time to complete the course
     */
    public Time getDuration(){
        int durationAsSec = this.end.convertToSeconds() - this.start.convertToSeconds();
        return Time.convertToTime(durationAsSec);
    }

    /**
     * Gets the name of the Runner.
     * @return the Runner's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the runner.
     * @param name new name of the runner
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the team name of the runner
     * @return the runner's team name
     */
    public String getTeam() {
        return team;
    }

    /**
     * Sets the team name of the runner
     * @param team new team of the runner
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * Gets the start time of the runner
     * @return the runner's start time
     */
    public Time getStart() {
        return start;
    }

    /**
     * Sets the runner's start time
     * @param start the runner's start time
     */
    public void setStart(Time start) {
        this.start = start;
    }

    /**
     * Gets the end time of the runner
     * @return the runner's end time
     */
    public Time getEnd() {
        return end;
    }

    /**
     * Sets the end time of the runner
     * @param end the runner's end time
     */
    public void setEnd(Time end) {
        this.end = end;
    }
}

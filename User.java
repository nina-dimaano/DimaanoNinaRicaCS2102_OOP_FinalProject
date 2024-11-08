public class User {
    private String userID;
    private String username;
    private String studyPreferences;
    private int studyHours;
    private int totalTasksCompleted;
    private int weeklyGoal;

    public User(String userID, String username, String studyPreferences, int weeklyGoal) {
        this.userID = userID;
        this.username = username;
        this.studyPreferences = studyPreferences;
        this.studyHours = 0;
        this.totalTasksCompleted = 0;
        if (weeklyGoal >= 0) {
            this.weeklyGoal = weeklyGoal;
        } else {
            throw new IllegalArgumentException("Weekly goal must be non-negative.");
        }
    }

    public void updatePreferences(String newPreferences) {
        if (newPreferences == null || newPreferences.isEmpty()) {
            System.out.println("Invalid preferences. Please provide a valid string.");
        } else {
            this.studyPreferences = newPreferences;
        }
    }

    public void trackProgress(int hours) {
        if (hours > 0) {
            this.studyHours += hours;
        } else {
            System.out.println("Study hours must be positive.");
        }
    }

    public String displayProfile() {
        return "User: " + username + "\nStudy Preferences: " + studyPreferences +
               "\nTotal Study Hours: " + studyHours + "\nTasks Completed: " + totalTasksCompleted +
               "\nWeekly Goal: " + weeklyGoal;
    }

    public void setWeeklyGoal(int goal) {
        if (goal >= 0) {
            this.weeklyGoal = goal;
        } else {
            System.out.println("Weekly goal must be non-negative.");
        }
    }

    public boolean checkGoalProgress() {
        return studyHours >= weeklyGoal;
    }

    public void completeTask() {
        totalTasksCompleted++;
    }

    public int getTotalTasksCompleted() {
        return totalTasksCompleted;
    }

    public int getWeeklyGoal() {
        return weeklyGoal;
    }

    public String getUsername() {
        return username;
    }
}

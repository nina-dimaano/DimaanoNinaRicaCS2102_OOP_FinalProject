public class Task {
    private String taskID;
    private String description;
    private String dueDate;
    private boolean isComplete;
    private int priorityLevel;
    private String subject;

    public Task(String taskID, String description, String dueDate, int priorityLevel, String subject) {
        if (taskID == null || taskID.isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be empty.");
        } else {
            this.taskID = taskID;
        }

        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty.");
        } else {
            this.description = description;
        }

        this.dueDate = dueDate;
        this.isComplete = false;
        
        if (priorityLevel >= 1 && priorityLevel <= 5) {
            this.priorityLevel = priorityLevel;
        } else {
            throw new IllegalArgumentException("Priority level must be between 1 and 5.");
        }

        this.subject = subject != null ? subject : "General";
    }

    public void markAsComplete() {
        if (!isComplete) {
            this.isComplete = true;
        } else {
            System.out.println("Task is already marked as complete.");
        }
    }

    public void updateDeadline(String newDueDate) {
        if (newDueDate != null && !newDueDate.isEmpty()) {
            this.dueDate = newDueDate;
        } else {
            System.out.println("Invalid due date. Please provide a valid date.");
        }
    }

    public void updateDescription(String newDescription) {
        if (newDescription != null && !newDescription.isEmpty()) {
            this.description = newDescription;
        } else {
            System.out.println("Invalid description. Please provide a valid text.");
        }
    }

    public String viewTaskDetails() {
        return "Task ID: " + taskID + "\nDescription: " + description + 
               "\nDue Date: " + dueDate + "\nCompleted: " + isComplete +
               "\nPriority Level: " + priorityLevel + "\nSubject: " + subject;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setPriorityLevel(int priorityLevel) {
        if (priorityLevel >= 1 && priorityLevel <= 5) {
            this.priorityLevel = priorityLevel;
        } else {
            System.out.println("Priority level must be between 1 and 5.");
        }
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setSubject(String subject) {
        if (subject != null && !subject.isEmpty()) {
            this.subject = subject;
        } else {
            System.out.println("Invalid subject. Please provide a valid name.");
        }
    }

    public String getSubject() {
        return subject;
    }

    public String getDueDate() {
        return dueDate;
    }
}

import java.util.HashMap;
import java.util.Map;

public abstract class User {
    private static Map<String, User> usersDatabase = new HashMap<>();
    private static int userIdCounter = 1000;

    private String firstName;
    private String middleName;
    private String surname;
    private String username;
    private String password;
    private int userId;
    private static int weeklyStudyGoal;
    private static String studyStruggleArea;
    private static String studySuggestion;

    public User(String firstName, String middleName, String surname, String username, String password) {
        if (usersDatabase.containsKey(username)) {
            this.userId = usersDatabase.get(username).getUserId();
        } else {
            this.userId = userIdCounter++;
        }
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public static void displayHeader(String title) {
        int lineWidth = 85;
        int padding = (lineWidth - title.length()) / 2;
        String paddingSpaces = " ".repeat(Math.max(0, padding));
    
        System.out.println("\033[36m");
        System.out.println("=".repeat(lineWidth));
        System.out.println(paddingSpaces + title);
        System.out.println("=".repeat(lineWidth));
        System.out.println("\033[0m");
    }

    public static boolean signUp(User user) {
        if (usersDatabase.containsKey(user.getUsername())) {
            System.out.println("\n\u001B[31mError: Username already exists.\u001B[0m");
            return false;
        }
        usersDatabase.put(user.getUsername(), user);
        System.out.println("\n\u001B[32mSign-up successful! Here's your account info:\u001B[0m");
        System.out.println("User ID: " + user.getUserId());
        return true;
    }

    public static User logIn(String username, String password) {
        User user = usersDatabase.get(username);
        if (user != null && user.password.equals(password)) {
            System.out.println("\n\u001B[32mLogin successful! Welcome, " + user.firstName + "!\u001B[0m\n");
            return user;
        }
        System.out.println("\n\u001B[31mError: Invalid username or password.\u001B[0m");
        return null;
    }

    public void setStudyGoal(int weeklyStudyGoal) {
        User.weeklyStudyGoal = weeklyStudyGoal;
        System.out.println("\n\u001B[32mWeekly study goal set to " + weeklyStudyGoal + " hours.\u001B[0m\n");
    }

    public void assessStruggle(String struggleArea) {
        studyStruggleArea = struggleArea;
        studySuggestion = generateSuggestion(struggleArea);
        System.out.println("\n\u001B[1mSuggested Study Method: \u001B[0m" + studySuggestion);
    }

    private String generateSuggestion(String struggleArea) {
        return switch (struggleArea.toLowerCase()) {
            case "focus" -> "\u001B[1m \u001B[33mScreen Time Blocking\u001B[0m" +
                            "\nIt is a great way to manage your device usage by scheduling times when certain apps or features are restricted." + 
                            "\nIt can really help you stay focused, boost productivity, and create a healthier balance between work and leisure!";
            case "comprehension" -> "\u001B[1m \u001B[33mFeynman Technique \u001B[0m" +
                                "\nIt is a learning method where you explain a concept in simple terms, like teaching it to a child. " + 
                                "\nThis helps you identify gaps in your understanding, which you can review and refine. \nBy repeating the process, you clarify and deepen your knowledge.";
            case "memorization" -> "\u001B[1m \u001B[33mThe SQ3R Method \u001B[0m" +
                                "\nIt is a study technique that helps improve comprehension and retention. \n" + 
                                "It involves surveying the material, asking questions, reading actively to find answers, reciting key points, and reviewing the material to reinforce learning. " + 
                                "\nThis approach keeps you engaged and helps you remember information better.";
            case "demotivation" -> "\u001B[1m \u001B[33mThe 3-2-1 Method \u001B[0m" +
                                "\nIt is a reflection technique where you note 3 things you've learned, 2 things that interested you, and 1 question you still have. " + 
                                "\nIt helps consolidate your understanding and encourages deeper thinking. " + 
                                "\nThis simple method is great for reinforcing what you've learned and identifying areas for further exploration.";
            case "procrastination" -> "\u001B[1m \u001B[33mThe Pomodoro Technique \u001B[0m" + 
                                "\nIt is a time management method where you work for 25 minutes, followed by a 5-minute break. " + 
                                "\nAfter completing four \"Pomodoros,\" you take a longer break, usually 15-30 minutes. " + 
                                "\nThis cycle helps maintain focus, reduce burnout, and improve productivity by balancing work and rest.";
            default -> "Identify specific areas where you need improvement.";
        };
    }

    public abstract void showAccountDetails();

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public int getWeeklyStudyGoal() {
        return weeklyStudyGoal;
    }
    
    public String getStudyStruggleArea() {
        return studyStruggleArea;
    }
    
    public String getStudySuggestion() {
        return studySuggestion;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void displayMainMenu() {
        displayHeader("MAIN MENU");
        System.out.println("1. Sign Up");
        System.out.println("2. Log In");
        System.out.println("3. Exit");
        System.out.print("\nChoose an option: ");
    }
}

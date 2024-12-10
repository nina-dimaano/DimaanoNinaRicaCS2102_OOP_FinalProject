import java.util.Scanner;

public class ConcreteUser extends User {

    public ConcreteUser(String firstName, String middleName, String surname, String username, String password) {
        super(firstName, middleName, surname, username, password);
    }

    public static void handleSignUp(Scanner scanner) {
        displayHeader("SIGN UP");

        String firstName, middleName, surname, username, password;

        while (true) {
            System.out.print("Enter your first name: ");
            firstName = scanner.nextLine().trim();
            if (firstName.isEmpty() || containsNumber(firstName)) {
                System.out.println("\n\u001B[31mInvalid first name. It cannot be blank or contain numbers. Please try again.\u001B[0m");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Enter your middle name (optional): ");
            middleName = scanner.nextLine().trim();
            if (!middleName.isEmpty() && containsNumber(middleName)) {
                System.out.println("\n\u001B[31mInvalid middle name. It cannot contain numbers. Please try again.\u001B[0m");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Enter your surname: ");
            surname = scanner.nextLine().trim();
            if (surname.isEmpty() || containsNumber(surname)) {
                System.out.println("\n\u001B[31mInvalid surname. It cannot be blank or contain numbers. Please try again.\u001B[0m");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Enter a username: ");
            username = scanner.nextLine().trim();
            
            if (username.isEmpty()) {
                System.out.println("\n\u001B[31mUsername cannot be blank. Please try again.\u001B[0m");
                continue;
            }
        
            if (username.length() < 4) {
                System.out.println("\n\u001B[31mUsername must be at least 4 characters long. Please try again.\u001B[0m");
                continue;
            }
            
            break;
        }        

        while (true) {
            System.out.print("Enter a password (at least 8 characters): ");
            password = scanner.nextLine().trim();
            if (password.isEmpty() || password.length() < 8) {
                System.out.println("\n\u001B[31mInvalid password. It must be at least 8 characters long. Please try again.\u001B[0m");
                continue;
            }
            break;
        }

        User newUser = new ConcreteUser(firstName, middleName, surname, username, password);
        boolean success = User.signUp(newUser);
        if (!success) {
            System.out.println("\n\u001B[31mUsername already exists. Please try again.\u001B[0m");
        } else {
            ((ConcreteUser) newUser).showAccountDetails();
        }
    }

    public static User handleLogIn(Scanner scanner) {
        displayHeader("LOG IN");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine().trim();

        User loggedInUser = User.logIn(username, password);
        if (loggedInUser != null) {
            while (true) {
                System.out.print("Enter your weekly study goal (hours): ");
                String weeklyGoalInput = scanner.nextLine().trim();
                try {
                    int weeklyGoal = Integer.parseInt(weeklyGoalInput);
                    if (weeklyGoal <= 0) {
                        System.out.println("\n\u001B[31mWeekly goal must be a positive number. Please try again.\u001B[0m");
                        continue;
                    }
                    loggedInUser.setStudyGoal(weeklyGoal);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\n\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                }
            }

            System.out.println("What aspect of studying do you struggle with the most?");
            System.out.println("1. Focus\n2. Comprehension\n3. Memorization\n4. Demotivation\n5. Procrastination");
            System.out.print("\nEnter your choice: ");

            String choice = scanner.nextLine().trim();
            String struggleArea = switch (choice) {
                case "1" -> "Focus";
                case "2" -> "Comprehension";
                case "3" -> "Memorization";
                case "4" -> "Demotivation";
                case "5" -> "Procrastination";
                default -> {
                    System.out.println("\n\u001B[31mInvalid choice. Defaulting to 'Unknown'.\u001B[0m");
                    yield "Unknown";
                }
            };

            loggedInUser.assessStruggle(struggleArea);
            return loggedInUser;
        } else {
            System.out.println("\n\u001B[31mInvalid username or password. Please try again.\u001B[0m");
            return null;
        }
    }

    @Override
    public void showAccountDetails() {
        System.out.println("\n\u001B[1m\u001B[34m----- Login Credentials -----\u001B[0m");
        System.out.println("Name: " + getFirstName() + " " + getMiddleName() + " " + getSurname());
        System.out.println("Username: " + getUsername());
        System.out.println("User ID: " + getUserId());
        System.out.println("\u001B[1m\u001B[34m-----------------------------\u001B[0m");
    }

    private static boolean containsNumber(String input) {
        return input.matches(".*\\d.*");
    }
}

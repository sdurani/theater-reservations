import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class TheaterReservations {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter your full name: ");
        String userFullName = read.nextLine();
        System.out.println("What date will you be coming? (MM/dd/yyyy) ");
        String userDate = read.nextLine();
        System.out.println("How many tickets would you like?");
        int userTicketAmount = read.nextInt();

        String formattedName = getFormattedName(userFullName);
        String formattedDate = getFormattedDate(userDate);
        String formattedTicketAmount = getFormattedTicketAmount(userTicketAmount);

        String confirmationMessage = getReservationConfirmation(formattedName, formattedDate, formattedTicketAmount);
        System.out.println(confirmationMessage);
    }

    public static String getFormattedDate(String userDate) {

        // Identify what format the user input is in.
        DateTimeFormatter userDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        // Convert the user's input from a String into a LocalDate data type. Default ISO format also.
        LocalDate reservationDateFormat = LocalDate.parse(userDate, userDateFormat);
        // Convert the LocalDate data type back to a String.
        String reservationDateString = reservationDateFormat.toString();

        return reservationDateString;
    }

    public static String getFormattedName(String userFullName) {

        String[] fullNameArray = userFullName.trim().split(" ");
        // fullNameArray = ["Geri", "Johnson"]
        String formattedName = fullNameArray[1] + ", " + fullNameArray[0];

        return formattedName;
    }

    public static String getFormattedTicketAmount(int userTicketAmount) {

        String formattedTicketAmount = userTicketAmount + " tickets";

        if (userTicketAmount == 1) {
            formattedTicketAmount = userTicketAmount + " ticket";
        }

        return formattedTicketAmount;
    }


    public static String getReservationConfirmation(String formattedName, String formattedDate, String formattedTicketAmount) {

        String confirmationMessage = formattedTicketAmount + " reserved for " + formattedDate + " under " + formattedName;

        return confirmationMessage;
    }
}

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ques5 {
    public static void main(String[] args) {
        String mentorCsv = "C:\\Users\\U6074547\\OneDrive - Clarivate Analytics\\Desktop\\Practice\\Mentor_Mentee.csv";

        System.out.println("Enter character to be searched: ");
        Scanner sc = new Scanner(System.in);
        String characterToSearch = sc.nextLine();

        searchMentor(characterToSearch,mentorCsv);

    }
    static void searchMentor(String characterToSearch, String mentorCsv){

        String value;

        try (BufferedReader data = new BufferedReader(new FileReader(mentorCsv))) {
            while ((value = data.readLine()) != null) {
                String[] columns = value.split(",");

                if (columns.length >= 2) {
                    String menteeName = columns[0];
                    String mentorName = columns[1];

                    if (menteeName.contains(characterToSearch)) {
                        System.out.println("\nMentee is: " +menteeName + " \nMentor is: " + mentorName);

                        if(checkValidMail(mentorName)){
                            System.out.println("Mentor Email is a valid email and of Clarivate domain!!");
                        }
                        else
                            System.out.println("\nEmail address is valid but not of clarivate domain!!");
                    }

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean checkValidMail(String mentorName){

        String emailRegex = "^[a-zA-Z0-9+-_*&]+(?:\\.[a-zA-Z0-9+-_*&]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(mentorName);

        boolean validEmail = matcher.matches();

        if(validEmail){
            return checkClarivateDomain(validEmail,mentorName);
        }
        else{
            System.out.println("\nEmail is invalid!!");
            System.exit(0);
        }
        return false;
    }

    static boolean checkClarivateDomain(boolean validEmail,String mentorName){
        boolean validDomain = false;
        if(validEmail){
            String[] emailParts = mentorName.split("@");

            if(emailParts.length==2){
                String domainName = emailParts[1].toLowerCase();

                validDomain = domainName.equals("clarivate.com");
            }
        }
        return  validDomain;
    }
}
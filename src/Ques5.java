import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//
public class Ques5
{
    public static void main(String[] args)
    {
        String mentorCsv = "C:\\Users\\U6074547\\OneDrive - Clarivate Analytics\\Desktop\\Practice\\Mentor_Mentee.csv"; //path of csv file

        System.out.println("Enter character to be searched: ");

        Scanner sc = new Scanner(System.in);

        String characterToSearch = sc.nextLine();  //Taking string input from user

        searchMentor(characterToSearch,mentorCsv);  //calling the searchMentor function

    }
    static void searchMentor(String characterToSearch, String mentorCsv)
    {

        String value;

        try (BufferedReader data = new BufferedReader(new FileReader(mentorCsv))) //reading the csv file
        {
            while ((value = data.readLine()) != null)
            {
                String[] columns = value.split(",");  //separating column with comma

                if (columns.length >= 2)
                {
                    String menteeName = columns[0];  //column with 0 index is the column of menteeName
                    String mentorName = columns[1];  //column with 1 index is the column of mentorName

                    if (menteeName.contains(characterToSearch)) //if mentee name is in the csv file it will print the mentee and mentor name
                    {
                        System.out.println("\nMentee is: " +menteeName + " \nMentor is: " + mentorName);

                        if(checkValidMail(mentorName)) //calling checkValidMail function and adding validation condition
                        {
                            System.out.println("Mentor Email is a valid email and of Clarivate domain!!");
                        }
                        else
                            System.out.println("\nEmail address is valid but not of clarivate domain!!");
                    }

                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    static boolean checkValidMail(String mentorName) //making a function to check the email is validated or not
    {

        String emailRegex = "^[a-zA-Z0-9+-_*&]+(?:\\.[a-zA-Z0-9+-_*&]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; //using regex here

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(mentorName);

        boolean validEmail = matcher.matches();

        if(validEmail)
        {
            return checkClarivateDomain(validEmail,mentorName);
        }
        else
        {
            System.out.println("\nEmail is invalid!!");
            System.exit(0);  //exit the code
        }

        return false;
    }

    static boolean checkClarivateDomain(boolean validEmail,String mentorName)
    {
        boolean validDomain = false;

        if(validEmail)
        {
            String[] emailParts = mentorName.split("@");  //split the email address into two parts __@__"

            if(emailParts.length==2)
            {
                String domainName = emailParts[1].toLowerCase();

                validDomain = domainName.equals("clarivate.com");
            }
        }

        return  validDomain;
    }
}
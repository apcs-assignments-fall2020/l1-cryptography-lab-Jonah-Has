import java.util.Scanner;

//CAPITAL LETTERS ARE FROM 65 TO 90 INCLUSIVE

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        String ret = "";
        int ncc = 0;
        for (int i = 0; i < message.length(); i++){
            
            if (message.charAt(i) <= 90 && message.charAt(i) >= 65){
                int a = key.charAt((i - ncc) % key.length()) - 65;
                int b = message.charAt(i) - 65;
                char add = (char) (((a + b) % 26) + 65);
                ret += add;
            }
            else{
                ncc++;
                ret += message.charAt(i);
            }
        }
        return ret;
    }

    public static String decryptVigenere(String message, String key) {
        String ret = "";
        int ncc = 0;
        for (int i = 0; i < message.length(); i++){
            
            if (message.charAt(i) <= 90 && message.charAt(i) >= 65){
                int a = key.charAt((i - ncc) % key.length()) - 65;
                int b = message.charAt(i) - 65;
                char add = (char) (((b - a + 26) % 26) + 65);
                ret += add;
            }
            else{
                ncc++;
                ret += message.charAt(i);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}

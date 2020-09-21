import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        String ret = "";
        for (int i = 0; i < message.length(); i++){
            char a = message.charAt(i);
            if ((a >= 65 && a <= 90)){
                char q = (char) (((a - 62) % 26 ) + 65);
                ret += q;
            }
            else if (a >= 97 && a <= 122){
                char q = (char) (((a - 94) % 26) + 97);
                ret += q;
            }
            else{
                ret += a;
            }
        }
        return ret;
    }

    public static String decryptCaesar(String message) {
        String ret = "";
        for (int i = 0; i < message.length(); i++){
            char a = message.charAt(i);
            if ((a >= 65 && a <= 90)){
                char q = (char) (((a - 16) % 26 ) + 65);
                ret += q;
            }
            else if (a >= 97 && a <= 122){
                char q = (char) (((a - 74) % 26) + 97);
                ret += q;
            }
            else{
                ret += a;
            }
        }
        return ret;
    }

    public static String encryptCaesarKey(String message, int key) {
        String ret = "";
        for (int i = 0; i < message.length(); i++){
            char a = message.charAt(i);
            if ((a >= 65 && a <= 90)){
                char q = (char) (((a + key - 13) % 26 ) + 65);
                ret += q;
            }
            else if (a >= 97 && a <= 122){
                char q = (char) (((a + key - 19) % 26) + 97);
                ret += q;
            }
            else{
                ret += a;
            }
        }
        return ret;
    }

    public static String decryptCaesarKey(String message, int key) {
        String ret = "";
        int k = key % 26;
        for (int i = 0; i < message.length(); i++){
            char a = message.charAt(i);
            if ((a >= 65 && a <= 90)){
                char q = (char) (((a - k - 13) % 26 ) + 65);
                ret += q;
            }
            else if (a >= 97 && a <= 122){
                char q = (char) (((a - k - 19) % 26) + 97);
                ret += q;
            }
            else{
                ret += a;
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
            System.out.println("What do you want your key to be?");
            int key = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("What do you want your key to be?");
            int key = scan.nextInt();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesarKey(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}

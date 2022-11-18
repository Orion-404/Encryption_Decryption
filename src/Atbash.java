import java.util.Scanner;

public class Atbash
{
    static String choice;
    
    public static void main( String[] args )
    {
        while ( true )
        {
            System.out.println( "Would you like to encrypt or decrypt a message?" );
            Scanner in = new Scanner( System.in );
            String msg = in.nextLine();
            
            if ( msg.equals( "encrypt" ) || msg.equals( "decrypt" ) )
            {
                choice = msg;
                break;
            }
            
        }
        
        if ( choice.equals( "encrypt" ) )
        {
            Encryption();
        }
        else
        {
            Decryption();
        }
    }
    
    public static void Encryption()
    {
        System.out.println( "Input a string to encrypt: " );
        Scanner toEncrypt = new Scanner( System.in );
        String encrypt = toEncrypt.nextLine().toUpperCase();
        System.out.println( Encrypt( encrypt ) );
    }
    
    public static void Decryption()
    {
        System.out.println( "Input a string to decrypt: " );
        Scanner toDecrypt = new Scanner( System.in );
        String decrypt = toDecrypt.nextLine().toUpperCase();
        System.out.println( Decrypt( decrypt ) );
    }
    
    private static StringBuilder Encrypt( String msg )
    {
        StringBuilder emsg = new StringBuilder();
        for(int i = 0; i < msg.length(); i++)
        {
            emsg.append( Dictionary( msg.charAt( i ) ) );
        }
        return emsg;
    }
    
    private static StringBuilder Decrypt( String msg )
    {
        StringBuilder dmsg = new StringBuilder();
        for(int i = 0; i < msg.length(); i++)
        {
            dmsg.append( Dictionary( msg.charAt( i ) ) );
        }
        return dmsg;
    }
    
    private static char Dictionary(char ch)
    {
        char toReturn = 0;
        switch ( ch )
        {
            case 'A' -> toReturn = 'Z';
            case 'B' -> toReturn = 'Y';
            case 'C' -> toReturn = 'X';
            case 'D' -> toReturn = 'W';
            case 'E' -> toReturn = 'V';
            case 'F' -> toReturn = 'U';
            case 'G' -> toReturn = 'T';
            case 'H' -> toReturn = 'S';
            case 'I' -> toReturn = 'R';
            case 'J' -> toReturn = 'Q';
            case 'K' -> toReturn = 'P';
            case 'L' -> toReturn = 'O';
            case 'M' -> toReturn = 'N';
            case 'N' -> toReturn = 'M';
            case 'O' -> toReturn = 'L';
            case 'P' -> toReturn = 'K';
            case 'Q' -> toReturn = 'J';
            case 'R' -> toReturn = 'I';
            case 'S' -> toReturn = 'H';
            case 'T' -> toReturn = 'G';
            case 'U' -> toReturn = 'F';
            case 'V' -> toReturn = 'E';
            case 'W' -> toReturn = 'D';
            case 'X' -> toReturn = 'C';
            case 'Y' -> toReturn = 'B';
            case 'Z' -> toReturn = 'A';
        }
        return toReturn;
    }
    
}

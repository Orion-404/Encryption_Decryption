import java.util.Scanner;

public class Affine
{
    
    static int choice;
    
    public static void main( String[] args )
    {
        while ( true )
        {
            System.out.println( "Encrypt - 0" );
            System.out.println( "Decrypt - 1" );
            Scanner in = new Scanner( System.in );
            int msg = in.nextInt();
            
            if ( msg == 0 || msg == 1 )
            {
                choice = msg;
                break;
            }
        }
        
        if ( choice == 0 )
        {
            Encryption();
        }
        else
        {
            Decryption();
        }
    }
    //howar eyou
    
    public static void Encryption()
    {
        System.out.println( "Input string: " );
        Scanner in = new Scanner( System.in );
        String msg = in.nextLine().toUpperCase();
        System.out.println( "Input shift key: " );
        Scanner k = new Scanner( System.in );
        int key = k.nextInt();
        System.out.println( Encrypt( msg, key ) );
    }
    
    private static StringBuilder Encrypt( String msg, int key )
    {
        msg = msg.replaceAll( " ", "" );
        StringBuilder emsg = new StringBuilder();
        StringBuilder outmsg = new StringBuilder();
        for ( int i = 0; i < msg.length(); i++ )
        {
            emsg.append( DDictionary( EDictionary( msg.charAt( i ), key ) ) );
        }
        for ( int i = 0; i < emsg.length(); i += 5 )
        {
            if ( ( i + 5 ) < emsg.length() )
            {
                outmsg.append( emsg.substring( i, i + 5 ) ).append( " " );
            }
            else
            {
                outmsg.append( emsg.substring( i ) );
            }
        }
        return outmsg;
    }
    
    public static void Decryption()
    {
        System.out.println( "Input string: " );
        Scanner in = new Scanner( System.in );
        String msg = in.nextLine().toUpperCase();
        System.out.println( "Input shift key: " );
        Scanner k = new Scanner( System.in );
        int key = k.nextInt();
        System.out.println( Decrypt( msg, -key ) );
    }
    
    private static StringBuilder Decrypt( String msg, int key )
    {
        msg = msg.replaceAll( " ", "" );
        StringBuilder dmsg = new StringBuilder();
        for ( int i = 0; i < msg.length(); i++ )
        {
            dmsg.append( DDictionary( EDictionary( msg.charAt( i ), key ) ) );
        }
        return dmsg;
    }
    
    private static int negNum( int num )
    {
        while ( num < 0 )
        {
            num += 26;
        }
        return num;
    }
    
    private static char DDictionary( int ch )
    {
        char toReturn = 0;
        switch ( ch )
        {
            case 25 -> toReturn = 'Z';
            case 24 -> toReturn = 'Y';
            case 23 -> toReturn = 'X';
            case 22 -> toReturn = 'W';
            case 21 -> toReturn = 'V';
            case 20 -> toReturn = 'U';
            case 19 -> toReturn = 'T';
            case 18 -> toReturn = 'S';
            case 17 -> toReturn = 'R';
            case 16 -> toReturn = 'Q';
            case 15 -> toReturn = 'P';
            case 14 -> toReturn = 'O';
            case 13 -> toReturn = 'N';
            case 12 -> toReturn = 'M';
            case 11 -> toReturn = 'L';
            case 10 -> toReturn = 'K';
            case 9 -> toReturn = 'J';
            case 8 -> toReturn = 'I';
            case 7 -> toReturn = 'H';
            case 6 -> toReturn = 'G';
            case 5 -> toReturn = 'F';
            case 4 -> toReturn = 'E';
            case 3 -> toReturn = 'D';
            case 2 -> toReturn = 'C';
            case 1 -> toReturn = 'B';
            case 0 -> toReturn = 'A';
        }
        return toReturn;
    }
    
    private static int EDictionary( char ch, int shift )
    {
        
        int toReturn = shift;
        switch ( ch )
        {
            case 'A' -> toReturn *= 0;
            case 'B' -> toReturn *= 1;
            case 'C' -> toReturn *= 2;
            case 'D' -> toReturn *= 3;
            case 'E' -> toReturn *= 4;
            case 'F' -> toReturn *= 5;
            case 'G' -> toReturn *= 6;
            case 'H' -> toReturn *= 7;
            case 'I' -> toReturn += 8;
            case 'J' -> toReturn += 9;
            case 'K' -> toReturn += 10;
            case 'L' -> toReturn += 11;
            case 'M' -> toReturn += 12;
            case 'N' -> toReturn += 13;
            case 'O' -> toReturn += 14;
            case 'P' -> toReturn += 15;
            case 'Q' -> toReturn += 16;
            case 'R' -> toReturn += 17;
            case 'S' -> toReturn += 18;
            case 'T' -> toReturn += 19;
            case 'U' -> toReturn += 20;
            case 'V' -> toReturn += 21;
            case 'W' -> toReturn += 22;
            case 'X' -> toReturn += 23;
            case 'Y' -> toReturn += 24;
            case 'Z' -> toReturn += 25;
        }
        if ( toReturn < 0 )
        {
            return negNum( toReturn );
        }
        else
        {
            return toReturn % 26;
        }
    }
}

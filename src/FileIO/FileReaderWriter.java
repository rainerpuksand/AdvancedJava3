package FileIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
    public static void main(String[] args) throws IOException {

        /*FileWriter fw;
        //fw=new FileWriter("C:/Users/Dell/Downloads/FileRW.txt",true);//write more
        fw=new FileWriter("C:\\Users\\Rainer\\Downloads\\FileRW.txt",true);//write more
        fw.write("Hey! Whats Up... This is written with FileWriter!");
        fw.close();
        System.out.println("Writing is done....");
*/

        FileReader fr = new FileReader("C:\\Users\\Rainer\\Downloads\\FileRW.txt");
        int i;
        while((i=fr.read()) != -1){
            System.out.print((char)i);//use println to see each char
            }
        fr.close();

    }
}

/*
FOR MACs... but make sure you have permission to write that file
        String separator = File.separator;
        String home = System.getProperty( "user.home" );
        String fileName ="FileRW.txt";
        FileWriter fw = new FileWriter(home + separator + fileName);
        fw.write("Hey! Whats Up... This is written with FileWriter!");

*/

/*
* WRITING
String separator = File.separator;
String home = System.getProperty( "user.home" );
String fileName ="FileRW.txt";
FileWriter fw = new FileWriter(home + separator + fileName);
fw.write("Hey! Whats Up... This is written with FileWriter!");
fw.close();
System.out.println("Writing is done....");
* */

/*
READING
String separator = File.separator;
String home = System.getProperty( "user.home" );
String fileName ="FileRW.txt";
FileReader fr = new FileReader(home + separator + fileName);
int i;
while((i=fr.read()) != -1){
    System.out.print((char)i);//use println to see each char
    }
fr.close();
*/
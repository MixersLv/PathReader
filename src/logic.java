import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class logic {

    private Scanner scan;
    private Path filepath;
    private DirectoryStream<Path> dstream;

    ArrayList<String> namelist = new ArrayList<String>();

    // RUNS THE WHOLE PROGRAM
    public void Run() throws IOException {
        ask();
        System.out.println("----------CONTENTS INSIDE PATH----------");
        read(filepath);
        sort(namelist);
    }

    // ASKS FOR A PATH INPUT
    public void ask(){

        scan = new Scanner(System.in);
        System.out.println("Enter a filepath: ");
        filepath = Path.of(scan.nextLine());

    }

    // READS THROUGH THE PATH AND ALSO ADDS THE NAMES TO A ARRAYLIST
    public void read(Path filepath) throws IOException {
        dstream = Files.newDirectoryStream(filepath);
        int filenum = 1;

        for (Path i : dstream){
            System.out.println(filenum + " | " + i.getFileName());
            filenum++;
            namelist.add(i.getFileName().toString());

            if(Files.isDirectory(i)){
                read(i);
            }
            else{
                //keep reading the files;
            }

        }

    }

    // SORTS THE LIST AND PRINTS IT OUT
    public void sort(ArrayList namelist){
        System.out.println("-------------------------\n" + "SORTED ALPHABETICALLY \n");
        Collections.sort(namelist);

        for (int i = 0; i < namelist.size(); i++){
            System.out.println(namelist.get(i));
        }
    }

}
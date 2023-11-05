import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class logic {

    private Scanner scan;
    private Path filepath;
    private DirectoryStream<Path> dstream;


    public void Run() throws IOException {
        ask();
        System.out.println("----------CONTENTS INSIDE PATH----------");
        read(filepath);
    }

    public void ask(){

        scan = new Scanner(System.in);
        System.out.println("Enter a filepath: ");
        filepath = Path.of(scan.nextLine());

    }

    public void read(Path filepath) throws IOException {
        dstream = Files.newDirectoryStream(filepath);
        int filenum = 1;

        for (Path i : dstream){
            System.out.println(filenum + " | " + i.getFileName());
            filenum++;

            if(Files.isDirectory(i)){
                read(i);
            }
            else{
                //keep reading the files;
            }
        }

    }

}

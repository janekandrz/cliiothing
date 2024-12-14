package commands;

import finance.*;
import java.io.*;

public class commandWrite {
    public void Execute(String dirPath,String command, String trans){
        String[] filename = command.split(" ");
        String path = dirPath+"/"+filename[1];

        try(FileWriter writer = new FileWriter(path,true)){
            writer.write(trans);
            System.out.println("write successful");
        } catch(IOException e){
            System.out.println("Err "+e.getMessage());
        }
    }
}

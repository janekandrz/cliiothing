package commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class commandRead {
    public void Execute(String dirPath,String command){
        String[] filename=command.split(" ");
        String pathFile=dirPath+"/"+filename[1];

        try(BufferedReader reader = new BufferedReader(new FileReader(pathFile))){
            String line;
            while((line= reader.readLine())!= null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("Err "+e.getMessage());
        }
    }
}

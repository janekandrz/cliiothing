package commands;

import java.io.File;
import java.io.IOException;

public class commandCreate {

    public void Execute(String dirPath,String command){
        String[] parts = command.split(" ");


        String[] dot = parts[1].split("\\.");
        if(!dot[1].equals("txt") && !dot[1].equals("csv")){
            System.out.println("wrong type(accepted types .txt .csv)");
        } else {
            File file= new File(dirPath, parts[1]);

            try{
                if(file.createNewFile()){
                    System.out.println("File created:  "+file.getName());
                }
            }
            catch (IOException e){
                System.out.println("Err");
                e.printStackTrace();
            }
        }
    }
}

package commands;

import java.io.File;

public class commandList {
    public void Execute(String dirPath){
        File dir = new File(dirPath);

        if(dir.exists() && dir.isDirectory()){
            File[] files = dir.listFiles();
            if(files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}

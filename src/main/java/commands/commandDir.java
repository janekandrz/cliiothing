package commands;

public class commandDir {
    private String Path;

    public void Execute(String path){
        String[] Path=path.split(" ");
        System.out.println("Current dir: "+Path[1]);
        setDirPath(Path[1]);
    }

    public void setDirPath(String path){
        this.Path = path;
    }

    public String getDirPath(){
        return this.Path;
    }
}

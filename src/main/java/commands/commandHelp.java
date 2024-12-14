package commands;

public class commandHelp {
    public void Execute(){
        System.out.println("Available Commands:");
        System.out.println("  dir <path>       Chose dir if doesnt exist it will make it");
        System.out.println("  list             List all files in current dir");
        System.out.println("  write <name>     Write a Transaction to an existing file");
        System.out.println("  create <name>    Create a new file");
        System.out.println("  read <name>      Read transactions");
        System.out.println("  exit             Exit the application");
    }
}

package CLI;

import commands.*;
import java.util.Scanner;

public class CLI {
    private static commandHelp CommandHelp = new commandHelp();
    private static commandList CommandList = new commandList();
    private static commandDir CommandDir = new commandDir();
    private static commandCreate CommandCreate = new commandCreate();
    private static commandRead CommandRead = new commandRead();
    private static commandWrite CommandWrite = new commandWrite();

    public static String dirPath;

    public static void handleInput() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to finance manager");

        while(dirPath == null){
            System.out.println("Enter dir command(`dir path/to/your/dir`): ");
            input = scanner.nextLine();
            handleDir(input);
        }

        System.out.print("Enter a command: ");

        while (true) {
            input = scanner.nextLine();
            if (input.startsWith("exit")) {
                System.out.println("Exiting the app");
                scanner.close();
                break;
            }
            handleCommand(input);
            System.out.print("Enter a command: ");
        }
    }

    public static void handleDir(String command){
        if(command.startsWith("dir")){
            CommandDir.Execute(command);
            dirPath = CommandDir.getDirPath();
        }
        else{
            System.out.println("Wrong command");
        }
    }

    public static void handleCommand(String command) {
        if (command.startsWith("help")){
            CommandHelp.Execute();
        }
        if (command.startsWith("list")) {
            CommandList.Execute(dirPath);
        }
        if (command.startsWith("create")) {
            CommandCreate.Execute(dirPath,command);
        }
        if(command.startsWith("dir")){
            CommandDir.Execute(command);
            dirPath = CommandDir.getDirPath();
        }
        if(command.startsWith("read")){
            CommandRead.Execute(dirPath,command);
        }
        if(command.startsWith("write")){
            CommandWrite.Execute(dirPath,command);
        }
        if(!command.startsWith("list") && !command.startsWith("dir") && !command.startsWith("help") && !command.startsWith("create") && !command.startsWith("read") && !command.startsWith("write")){
            System.out.println("Unknown command: " + command);
        }
    }
}

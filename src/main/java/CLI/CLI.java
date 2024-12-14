package CLI;

import commands.*;
import finance.Category;
import finance.Transaction;

import java.util.Scanner;
import java.util.Date;

public class CLI {
    private static commandHelp CommandHelp = new commandHelp();
    private static commandList CommandList = new commandList();
    private static commandDir CommandDir = new commandDir();
    private static commandCreate CommandCreate = new commandCreate();
    private static commandRead CommandRead = new commandRead();
    private static commandWrite CommandWrite = new commandWrite();
    private static checkers check = new checkers();

    public static String dirPath;

    public static String amm;
    public static String category;
    public static Date date = new Date();


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
            Scanner scanner = new Scanner(System.in);

            while(amm == null){
                System.out.println("Enter transaction amount: ");
                String tempAmm = scanner.nextLine();
                if(!check.isNumeric(tempAmm)){
                    System.out.println("Amount must be numeric!");
                }else{
                    amm=tempAmm;
                }
            }
            while(category==null){
                System.out.println("Enter transaction category(FOOD,ENTERTAINMENT,RENT): ");
                String tempCat = scanner.nextLine();
                if(!tempCat.equals("FOOD") && !tempCat.equals("ENTERTAINMENT") && !tempCat.equals("RENT")){
                    System.out.println("category must chosen from the list!");
                }else{
                    category=tempCat;
                }
            }

            double ammD = Double.parseDouble(amm);
            Category cat = Category.valueOf(category);

            Transaction tran = new Transaction(ammD,cat,date);
            System.out.println(tran.TransactionString());
            CommandWrite.Execute(dirPath,command,tran.TransactionString());
        }
        if(!command.startsWith("list") && !command.startsWith("dir") && !command.startsWith("help") && !command.startsWith("create") && !command.startsWith("read") && !command.startsWith("write")){
            System.out.println("Unknown command: " + command);
        }
    }
}

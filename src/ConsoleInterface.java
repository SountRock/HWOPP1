import java.io.IOException;
import java.util.Scanner;

public class ConsoleInterface {

    public ConsoleInterface() {}

    /**
     * Интепритуриую вводимую строку в нужный формат для чтения команды.
     */
    public String[] translateCommand(String command){
        String[] translComm = command.split(" ");
        for (int i = 0; i < translComm.length; i++) {
            translComm[i] = translComm[i].replaceAll(" ", "").toLowerCase();
        }

        return translComm;
    }

    /**
     * Метод консольного диалога, принимающий команды и выводит их результат
     */
    public void commandUp() throws IOException, InterruptedException {
        instruction();
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Слушаю вас:");
        while (!exit){
            String line = sc.nextLine();
            String[] translateLine = translateCommand(line);
            if(translateLine[0].equals("exit")){
                exit = true;
            } else if(translateLine[0].equals("clear")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //очищает консоль
            } else {
                otherCommand(translateLine);
            }
        }
    }

    /**
     * Метод обеспечивает выполнение не базовых комманд
     */
    public void otherCommand(String[] commamd){}

    /**
     * Метод выводящий инструкцию поясняющий как пользоваться коммандами
     */
    public void instruction(){}
}


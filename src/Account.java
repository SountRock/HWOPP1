/**
 * Описывает банковский счет.
 * Имеет 3 метода: пополнение(putAmount) и снятие(takeAmount) средств и отображение(getAmount) текущего баланса (геттер).
 * Первые два меняют баланс, последний просто возвращает его.
 */
public class Account extends ConsoleInterface implements Adder{
    private double money;
    private String owner;

    public String getOwner() {
        return owner;
    }

    public Account(String owner) {
        this.owner = owner;
    }

    public Account(double money, String owner) {
        this.money = money;
        this.owner = owner;
    }

    /**
     * Возвращает балланс
     */
    public double getAmount(){
        return money;
    }

    /**
     * Ложит деньги на счет
     */
    public void putAmount(double plus){
        if(plus > 0){
            money += plus;
        }
    }

    /**
     * Снимает деньги со счета, если это возможно
     */
   public boolean takeAmount(double minus){
       if(minus < 0){
           minus = minus * (-1);
       }
       double result = money - minus;
       if(result >= 0.0){
           money = result;
           return true;
       } else {
           return false;
       }
   }

    @Override
    public void otherCommand(String[] commamd){
       if(commamd.length > 1){
           switch (commamd[0]){
               case "снять":
                   boolean res = takeAmount(Double.parseDouble(commamd[1]));
                   if(res){
                       System.out.println("-" + commamd[1]);
                   } else {
                       System.out.println("ОТКЛОНЕНО!");
                   }
                   break;
               case "положить":
                   putAmount(Double.parseDouble(commamd[1]));
                   System.out.println("+" + commamd[1]);
                   break;
           }
       } else if (commamd[0].equals("баланс")){
           System.out.println("Ваш баланс: " + getAmount());
       }
    }

    @Override
    public void instruction(){
        System.out.println(
                "Пример комманды:" + '\n'
                + "-------------------------" + '\n'
                + "баланс" + '\n'
                + "Назначение: показывает ваш баланс" + '\n'
                + "-------------------------" + '\n'
                + "положить 200.50" + '\n'
                + "Назначение: кладет указанную сумму на ваш счет" + '\n'
                + "-------------------------" + '\n'
                + "снять 100" + '\n'
                + "Назначение: снимает указанную сумму со счета" + '\n'
                + "-------------------------" + '\n'
                + "clear" + '\n'
                + "Назначение: очищает терминал (работает только при вызове прогрммы через консоль!)" + '\n'
                + "-------------------------" + '\n'
                + "exit" + '\n'
                + "Назначение: выйти из диалога" + '\n'
                + "-------------------------"
        );
    }
}

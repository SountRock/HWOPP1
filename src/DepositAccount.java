import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Описывающий депозитный счет. Его особенность в том, что нельзя снимать средства в течение 1 месяца после пополнения.
 */
public class DepositAccount extends Account{
    private LocalDate lastOutDate;
    private LocalDate dateNow;

    public DepositAccount(double money, String owner) {
        super(money, owner);
        dateNow = LocalDate.now();
        lastOutDate = LocalDate.now();
    }

    @Override
    public boolean takeAmount(double minus){
        long monthBetweenTodayAndNow = ChronoUnit.MONTHS.between(lastOutDate, dateNow);
        System.out.println(monthBetweenTodayAndNow);
        if(monthBetweenTodayAndNow > 0) {
            super.takeAmount(minus);
            lastOutDate = dateNow;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void otherCommand(String[] commamd){
        super.otherCommand(commamd);
        if (commamd.length > 2 && commamd[0].equals("сдвинуть") && commamd[1].equals("дату")){
            setPrognoseDate(Integer.parseInt(commamd[2]));
        } else if (commamd.length > 1 && commamd[0].equals("сбросить") && commamd[1].equals("дату")){
            resetDate();
        }
    }

    /**
     * Сдвигает дату на указанное количесво дней
     */
    public void setPrognoseDate(int plusDays){
        dateNow = dateNow.plusDays(plusDays);
        System.out.println(dateNow);
    }

    /**
     * Сбрасыват дату
     */
    public void resetDate(){
        dateNow = LocalDate.now();
        lastOutDate = LocalDate.now();
        System.out.println(dateNow);
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
                        + "сдвинуть дату" + '\n'
                        + "Назначение: сдвигает дату на указанное количесво дней" + '\n'
                        + "-------------------------" + '\n'
                        + "сбросить дату 30" + '\n'
                        + "Сбрасыват датуй" + '\n'
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

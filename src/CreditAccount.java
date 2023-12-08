/**
 * Описывающий кредитный счет.
 * Снятие средств с этого кредитного счета облагается комиссией в размере 1% от суммы снятия.
 */

public class CreditAccount extends Account{
    private double debt;
    final private double daseSumm;

    public CreditAccount(String owner, double daseSumm) {
        super(owner);
        this.daseSumm = daseSumm;
        this.money = this.daseSumm;
    }

    @Override
    public boolean takeAmount(double minus){
        double result = money - minus - (1.0 * minus / 100.0);
        if(result >= 0.0){
            money = result;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Возвращает значение денежного долга
     */
    public double getDebt(){
        return daseSumm - money;
    }

    @Override
    public void otherCommand(String[] commamd){
        super.otherCommand(commamd);
        if (commamd[0].equals("долг")){
            System.out.println(getDebt());
        }
    }
    @Override
    public void instruction(){
        System.out.println(
                "Пример комманды:" + '\n'
                        + "-------------------------" + '\n'
                        + "доступно" + '\n'
                        + "Назначение: показывает сколько можно снять денег" + '\n'
                        + "-------------------------" + '\n'
                        + "положить 200.50" + '\n'
                        + "Назначение: кладет указанную сумму на ваш счет" + '\n'
                        + "-------------------------" + '\n'
                        + "снять 100" + '\n'
                        + "Назначение: снимает указанную сумму со счета" + '\n'
                        + "-------------------------" + '\n'
                        + "долг" + '\n'
                        + "Назначение: показывает ваш долг" + '\n'
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Payment implements PaymentCash, PaymentCashless{

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public final double discountMore3 = 0.9;
    public final double discountMore7 = 0.8;

    public boolean startPay(OrderDesk orderDesk, Order order) {
        while (true) {
            choiceTitle();
            int choicePay;
            try {
                choicePay = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (choicePay == 1) {
                return payCash(orderDesk, order);
            } else if (choicePay == 2) {
                return payCashless(orderDesk, order);
            } else {
                System.out.println("Не верный выбор способа оплаты!");
            }
        }
    }

    @Override
    public boolean payCash(OrderDesk orderDesk, Order order) {
        double totalPriceWithDiscount = calcTotalPriceWithDiscount(order);
        ReportOrderForPay.createReportForPayment(order, totalPriceWithDiscount);
        System.out.println("Оплата наличными: " + totalPriceWithDiscount + "$.");
        System.out.println("Вставьте купюры в купюроприемник...");
        System.out.println("Оплата наличными прошла успешно!");
        orderDesk.setTotalCashOrderDesk(orderDesk.getTotalCashOrderDesk() + totalPriceWithDiscount);
        return true;
    }

    @Override
    public boolean payCashless(OrderDesk orderDesk, Order order) {
        double totalPriceWithDiscount = calcTotalPriceWithDiscount(order);
        ReportOrderForPay.createReportForPayment(order, totalPriceWithDiscount);
        System.out.println("Оплата картой: " + totalPriceWithDiscount + "$.");
        System.out.println("Следуйте инструкциям на пинпаде...");
        System.out.println("Оплата картой прошла успешно!");
        orderDesk.setTotalCashOrderDesk(orderDesk.getTotalCashOrderDesk() + totalPriceWithDiscount);
        return true;
    }

    private double calcTotalPriceWithDiscount(Order order) {
        if (order.getHotDogs().size() < 3) {
            return order.getTotalPriceOrder();
        } else if (order.getHotDogs().size() >= 3 && order.getHotDogs().size() < 7)
            return order.getTotalPriceOrder() * discountMore3;
        else {
            return order.getTotalPriceOrder() * discountMore7;
        }
    }

    public void choiceTitle() {
        System.out.println("1 - Оплата наличными;\n" +
                           "2 - Оплата картой;");
        System.out.print("Выбирете способ оплаты: ");
    }
}

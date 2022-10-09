import java.io.*;

public class ReportOrderForPay {
    public static void createReportForPayment(Order order, double totalPriceOrder) {
        StringBuilder report = new StringBuilder("\nЗаказ №" + order.getIdOrder() + "\n");
        order.getHotDogs().forEach(hotDog -> {
            report.append(hotDog.toString());
        });
        report.append("\nСУММА ЗАКАЗА: ").append(order.getTotalPriceOrder()).append("$.");
        report.append("\nСкидка за кол-во: ").append(order.getTotalPriceOrder() - totalPriceOrder).append("$.");
        report.append("\nИТОГО К ОПЛАТЕ: ").append(totalPriceOrder).append("$.");
        System.out.println(report);
        writeInFile(report, order.getIdOrder());

    }

    private static void writeInFile(StringBuilder report, int idOrder) {
        String dirFile = System.getProperty("user.dir") + File.separator + "Заказ №" + idOrder + ".txt";
        File fileOrder = new File(dirFile);
        try {
            FileWriter writer = new FileWriter(fileOrder);
            if (!fileOrder.exists()) {
                fileOrder.createNewFile();
            }

            writer.write(report.toString());
            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

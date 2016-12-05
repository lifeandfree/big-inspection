package ru.urfu.inspection;

import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

import ru.urfu.inspection.xrm.reportutility.interfaces.IReportService;
import ru.urfu.inspection.xrm.reportutility.models.DataRow;
import ru.urfu.inspection.xrm.reportutility.models.Report;
import ru.urfu.inspection.xrm.reportutility.models.ReportRow;
import ru.urfu.inspection.xrm.reportutility.services.CsvReportService;
import ru.urfu.inspection.xrm.reportutility.services.TxtReportService;
import ru.urfu.inspection.xrm.reportutility.services.XlsxReportService;

/**
 * Советы, которые можно реализовать.
 * Для более оптимального постороения кода, необходимо больше абстрагироваться. Делать все от инерфейсов и абстрактных
 * классов, чтобы при расширение функцинала пришлось меньше переписывать кода
 * Для вывода отчета лучше всего реализовать в виде цепочки. Чтобы на литу собирать отчет. И будет проще манипулировать
 * с элементами
 * Для чтения файлов, чтоб постороить отчет у нас используется одинаковый принцип работы. Также мы реализуем кажое
 * чтение внутри. Думаю для этих вещей лучше испольовать Адаптер. Так как условия входа будут одни и те же.
 */

public class App {

    private static final String TAB = "\t";

    private static IReportService GetReportService(String[] args) throws Exception {
        String filename = args[0];

        // это код использует Factory Method, где TxtReportService, CsvReportService, XlsxReportService реализуют
        // фабричный метод, хотя очень можно с путать с мостом,где TxtReportService, CsvReportService, XlsxReportService
        // являются ConcreteImplementor и где ReportServiceBase есть их абстракция. IReportService интерфейс
        if (filename.endsWith(".txt")) {
            return new TxtReportService(args);
        }

        if (filename.endsWith(".csv")) {
            return new CsvReportService(args);
        }

        if (filename.endsWith(".xlsx")) {
            return new XlsxReportService(args);
        }

        throw new Exception("this extension not supported");
    }

    public static void main(String[] args) {
        // /opt/git/big-inspection/inspection/src/main/java/ru/urfu/inspection/xrm/reportutility/files/table.txt -data
        // -weightSum -costSum
        IReportService service;
        try {
            System.out.println("");
            System.out.println("Enter the data for the report.");
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            System.out.println(str);
            String[] array = str.split(" ");

            service = GetReportService(array);
            Report report = service.CreateReport();
            PrintReport(report);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void PrintReport(Report report) {
        // Убрано прямое обращение к переменным. Добавелны методы get и set. Далее по всем переменным в if
        if (report.getConfig().isWithData() && report.getData() != null && report.getData().length != 0) {
            String headerRow = "Наименование\tОбъём упаковки\tМасса упаковки\tСтоимость\tКоличество";
            // String rowTemplate = "{1,12}\t{2,14}\t{3,14}\t{4,9}\t{5,10}";

            if (report.getConfig().isWithIndex()) {
                headerRow = "№\t" + headerRow;
                // rowTemplate = "{0}\t" + rowTemplate;
            }
            if (report.getConfig().isWithTotalVolume()) {
                headerRow = headerRow + "\tСуммарный объём";
                // rowTemplate = rowTemplate + "\t{6,15}";
            }
            if (report.getConfig().isWithTotalWeight()) {
                headerRow = headerRow + "\tСуммарный вес";
                // rowTemplate = rowTemplate + "\t{7,13}";
            }

            System.out.println(headerRow);
            // Убрано прямое обращение к переменным. Добавелны методы get и set. Далее по всем переменным в for
            for (int i = 0; i < report.getData().length; i++) {
                DataRow dataRow = report.getData()[i];
                // Обрано прямое обращение к переменным. Добавелны методы get и set
                String str = (i + 1 + TAB + dataRow.getName() + ((i != 0) ? StringUtils.repeat(TAB, 2) : TAB)
                        + dataRow.getVolume() + StringUtils.repeat(TAB, 2) + dataRow.getWeight()
                        + StringUtils.repeat(TAB, 2) + dataRow.getCost() + StringUtils.repeat(TAB, 2)
                        + dataRow.getCount() + StringUtils.repeat(TAB, 2) + dataRow.getVolume() * dataRow.getCount()
                        + StringUtils.repeat(TAB, 2) + dataRow.getWeight() * dataRow.getCount());
                System.out.println(str);
            }

            System.out.println();
        }

        // Убрано прямое обращение к переменным. Добавелны методы get и set. Далее по всем переменным в if
        if (report.getRows() != null && report.getRows().size() != 0) {
            System.out.println("Итого:");
            for (ReportRow reportRow : report.getRows()) {
                System.out.println(reportRow.getName() + TAB + reportRow.getValue());
                // System.out.println(String.format(" {0,-20}\t{1}", reportRow.getName(), reportRow.getValue()));
            }
        }
    }
}

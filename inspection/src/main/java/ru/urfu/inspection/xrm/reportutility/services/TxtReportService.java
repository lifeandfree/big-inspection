package ru.urfu.inspection.xrm.reportutility.services;

import java.util.ArrayList;

import ru.urfu.inspection.xrm.reportutility.models.DataRow;

// При перепеси на Java пришлось изменить полностью чтение из txt файла. Так как читается немного не так. Писал так,
// чтобы не поменялась логика первоначальной реализации.
public class TxtReportService extends ReportServiceBase {

    public TxtReportService(String[] args) {
        super(args);
    }

    @Override
    protected DataRow[] GetDataRows(String text) {
        ArrayList<DataRow> dataRows = new ArrayList<DataRow>();
        String[] lines = text.split("\r\n");

        for (int i = 1; i < lines.length; i++) {

            String[] items = lines[i].split("\t");
            ArrayList<String> arrayList = new ArrayList<>();
            for (int j = 0; j < items.length; j++) {
                if (!items[j].isEmpty()) {
                    arrayList.add(items[j]);
                }
            }
            arrayList.toString();
            if (arrayList.size() >= 5) {
                dataRows.add(new DataRow(Double.parseDouble(arrayList.get(3)), Double.parseDouble(arrayList.get(4)),
                        arrayList.get(0), Double.parseDouble(arrayList.get(1)), Double.parseDouble(arrayList.get(2))));
            }
        }
        DataRow[] result = new DataRow[dataRows.size()];
        result = dataRows.toArray(result);
        return result;
    }
}

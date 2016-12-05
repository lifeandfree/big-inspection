package ru.urfu.inspection.xrm.reportutility.services;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import ru.urfu.inspection.xrm.reportutility.models.DataRow;

// Чтение из csv формата реализовано подругому. С помощью спец библиотеки commons-csv 1.4
public class CsvReportService extends ReportServiceBase {

    public CsvReportService(String[] args) {
        super(args);
    }

    @Override
    protected DataRow[] GetDataRows(String text) {
        ArrayList<DataRow> dataRows = new ArrayList<DataRow>();
        text = text.substring(text.indexOf("\n") + 1);
        Reader in = new StringReader(text);
        CSVParser parser;
        List<CSVRecord> list = null;
        try {
            parser = new CSVParser(in, CSVFormat.EXCEL);
            list = parser.getRecords();
        }
        catch (IOException e) {
            System.out.println(e);
        }

        for (CSVRecord csvRecord : list) {
            String[] items = csvRecord.get(0).split(";");
            dataRows.add(new DataRow(Double.parseDouble(items[3]), Double.parseDouble(items[4]), items[0],
                    Double.parseDouble(items[1]), Double.parseDouble(items[2])));
        }

        DataRow[] result = new DataRow[dataRows.size()];
        result = dataRows.toArray(result);
        return result;
    }
}

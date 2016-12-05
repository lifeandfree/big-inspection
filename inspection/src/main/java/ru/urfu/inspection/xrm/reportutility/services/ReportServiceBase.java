package ru.urfu.inspection.xrm.reportutility.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import ru.urfu.inspection.xrm.reportutility.infrastructure.DataTransformerCreator;
import ru.urfu.inspection.xrm.reportutility.interfaces.IDataTransformer;
import ru.urfu.inspection.xrm.reportutility.interfaces.IReportService;
import ru.urfu.inspection.xrm.reportutility.models.DataRow;
import ru.urfu.inspection.xrm.reportutility.models.Report;
import ru.urfu.inspection.xrm.reportutility.models.ReportConfig;

public abstract class ReportServiceBase implements IReportService {

    private final String[] _args;

    protected ReportServiceBase(String[] args) {
        _args = args;
    }

    @Override
    public Report CreateReport() {

        // Хотя здесь можно также понимать что config и DataTransformerCreator
        // есть контекст и state. И следовательно будет это паттерн State

        ReportConfig config = ParseConfig();
        IDataTransformer dataTransformer = DataTransformerCreator.CreateTransformer(config);

        String fileName = _args[0];
        // TODO
        byte[] result;
        try {
            FileInputStream f = new FileInputStream(fileName);
            try {
                int len = f.available();
                byte[] content = new byte[len];
                if (f.read(content) != content.length) {
                    // Не все данные прочитаны успешно
                    result = new byte[0];
                }
                else {
                    result = content;
                }
            }
            catch (IOException e) {
                System.out.println(e);
                result = new byte[0];
            }
            finally {
                try {
                    if (f != null) {
                        f.close();
                    }
                }
                catch (IOException e) {
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            result = new byte[0];
        }
        String text = null;
        try {
            text = new String(result, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
        // TODO
        DataRow[] data = GetDataRows(text);
        return dataTransformer.TransformData(data);
    }

    protected abstract DataRow[] GetDataRows(String text);

    private ReportConfig ParseConfig() {
        return new ReportConfig(Arrays.asList(_args).contains("-costSum"), Arrays.asList(_args).contains("-countSum"),
                Arrays.asList(_args).contains("-volumeSum"), Arrays.asList(_args).contains("-weightSum"),
                Arrays.asList(_args).contains("-data"), Arrays.asList(_args).contains("-withIndex"),
                Arrays.asList(_args).contains("-withTotalVolume"), Arrays.asList(_args).contains("-withTotalWeight"));
    }
}

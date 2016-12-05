package ru.urfu.inspection.xrm.reportutility.infrastructure.transformers;

import ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.abstractclass.ReportServiceTransformerBase;
import ru.urfu.inspection.xrm.reportutility.interfaces.IDataTransformer;
import ru.urfu.inspection.xrm.reportutility.models.DataRow;
import ru.urfu.inspection.xrm.reportutility.models.Report;
import ru.urfu.inspection.xrm.reportutility.models.ReportRow;

public class CountSumReportTransformer extends ReportServiceTransformerBase {
    public CountSumReportTransformer(IDataTransformer reportService) {
        super(reportService);
    }

    @Override
    public Report TransformData(DataRow[] data) {
        Report report = DataTransformer.TransformData(data);

        double value = 0;
        for (DataRow element : data) {
            value += element.getCost();
        }
        report.getRows().add(new ReportRow("Суммарное количество", value));

        return report;
    }

}

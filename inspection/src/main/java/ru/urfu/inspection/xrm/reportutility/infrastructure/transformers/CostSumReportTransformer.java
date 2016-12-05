package ru.urfu.inspection.xrm.reportutility.infrastructure.transformers;

import ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.abstractclass.ReportServiceTransformerBase;
import ru.urfu.inspection.xrm.reportutility.interfaces.IDataTransformer;
import ru.urfu.inspection.xrm.reportutility.models.DataRow;
import ru.urfu.inspection.xrm.reportutility.models.Report;
import ru.urfu.inspection.xrm.reportutility.models.ReportRow;

public class CostSumReportTransformer extends ReportServiceTransformerBase {

    public CostSumReportTransformer(IDataTransformer dataTransformer) {
        super(dataTransformer);
    }

    @Override
    public Report TransformData(DataRow[] data) {
        Report report = DataTransformer.TransformData(data);

        double value = 0;
        for (DataRow element : data) {
            value += element.getCount() * element.getCost();
        }
        report.getRows().add(new ReportRow("Суммарная стоимость", value));

        return report;
    }
}

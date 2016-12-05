package ru.urfu.inspection.xrm.reportutility.infrastructure.transformers;

import ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.abstractclass.ReportServiceTransformerBase;
import ru.urfu.inspection.xrm.reportutility.interfaces.IDataTransformer;
import ru.urfu.inspection.xrm.reportutility.models.DataRow;
import ru.urfu.inspection.xrm.reportutility.models.Report;

public class WithDataReportTransformer extends ReportServiceTransformerBase {

    public WithDataReportTransformer(IDataTransformer reportService) {
        super(reportService);
    }

    @Override
    public Report TransformData(DataRow[] data) {
        Report report = DataTransformer.TransformData(data);

        report.setData(data);

        return report;
    }

}

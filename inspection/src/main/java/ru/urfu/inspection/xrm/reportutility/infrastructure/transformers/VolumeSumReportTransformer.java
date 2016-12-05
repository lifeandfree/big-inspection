package ru.urfu.inspection.xrm.reportutility.infrastructure.transformers;

import ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.abstractclass.ReportServiceTransformerBase;
import ru.urfu.inspection.xrm.reportutility.interfaces.IDataTransformer;
import ru.urfu.inspection.xrm.reportutility.models.DataRow;
import ru.urfu.inspection.xrm.reportutility.models.Report;
import ru.urfu.inspection.xrm.reportutility.models.ReportRow;

public class VolumeSumReportTransformer extends ReportServiceTransformerBase {

    public VolumeSumReportTransformer(IDataTransformer reportService) {
        super(reportService);
    }

    @Override
    public Report TransformData(DataRow[] data) {
        ru.urfu.inspection.xrm.reportutility.models.Report report = DataTransformer.TransformData(data);

        double value = 0;
        for (DataRow element : data) {
            value += element.getCount() * element.getVolume();
        }

        report.getRows().add(new ReportRow("Суммарный объём", value));

        return report;
    }

}

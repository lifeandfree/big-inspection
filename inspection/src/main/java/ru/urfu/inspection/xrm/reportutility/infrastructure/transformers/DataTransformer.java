package ru.urfu.inspection.xrm.reportutility.infrastructure.transformers;

import java.util.ArrayList;

import ru.urfu.inspection.xrm.reportutility.interfaces.IDataTransformer;
import ru.urfu.inspection.xrm.reportutility.models.DataRow;
import ru.urfu.inspection.xrm.reportutility.models.Report;
import ru.urfu.inspection.xrm.reportutility.models.ReportConfig;
import ru.urfu.inspection.xrm.reportutility.models.ReportRow;

public class DataTransformer implements IDataTransformer {

    private final ReportConfig _config;

    public DataTransformer(ReportConfig config) {
        _config = config;
    }

    @Override
    public Report TransformData(DataRow[] data) {

        return new Report(_config, new DataRow[0], new ArrayList<ReportRow>());

    }
}

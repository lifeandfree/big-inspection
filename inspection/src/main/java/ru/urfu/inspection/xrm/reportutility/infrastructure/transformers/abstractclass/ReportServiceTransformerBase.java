package ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.abstractclass;

import ru.urfu.inspection.xrm.reportutility.interfaces.IDataTransformer;
import ru.urfu.inspection.xrm.reportutility.models.DataRow;
import ru.urfu.inspection.xrm.reportutility.models.Report;

public abstract class ReportServiceTransformerBase implements IDataTransformer {

    protected final IDataTransformer DataTransformer;

    protected ReportServiceTransformerBase(IDataTransformer dataTransformer) {
        DataTransformer = dataTransformer;
    }

    @Override
    public abstract Report TransformData(DataRow[] data);

}

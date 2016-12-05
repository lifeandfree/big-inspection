package ru.urfu.inspection.xrm.reportutility.interfaces;

import ru.urfu.inspection.xrm.reportutility.models.DataRow;
import ru.urfu.inspection.xrm.reportutility.models.Report;

public interface IDataTransformer {

    Report TransformData(DataRow[] data);
}

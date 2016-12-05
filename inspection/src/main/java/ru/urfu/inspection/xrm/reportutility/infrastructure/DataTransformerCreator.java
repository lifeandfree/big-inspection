package ru.urfu.inspection.xrm.reportutility.infrastructure;

import ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.CostSumReportTransformer;
import ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.CountSumReportTransformer;
import ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.DataTransformer;
import ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.VolumeSumReportTransformer;
import ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.WeightSumReportTransfomer;
import ru.urfu.inspection.xrm.reportutility.infrastructure.transformers.WithDataReportTransformer;
import ru.urfu.inspection.xrm.reportutility.interfaces.IDataTransformer;
import ru.urfu.inspection.xrm.reportutility.models.ReportConfig;

// данный класс представляет сорбой использование паттерна декоратора(не он сам), где ReportServiceTransformerBase сам
// декоратор, а ReportServiceTransformerBase, VolumeSumReportTransformer, WeightSumReportTransfomer есть его конкретные
// реализации.s IDataTransformer компонент
public class DataTransformerCreator {
    // построен по типу паттерна Фасад одна точка входа..
    public static IDataTransformer CreateTransformer(ReportConfig config) {
        IDataTransformer service = new DataTransformer(config);

        //
        if (config.isWithData()) {
            service = new WithDataReportTransformer(service);
        }

        if (config.isVolumeSum()) {
            service = new VolumeSumReportTransformer(service);
        }

        if (config.isWeightSum()) {
            service = new WeightSumReportTransfomer(service);
        }

        if (config.isCostSum()) {
            service = new CostSumReportTransformer(service);
        }

        if (config.isCountSum()) {
            service = new CountSumReportTransformer(service);
        }

        return service;
    }
}

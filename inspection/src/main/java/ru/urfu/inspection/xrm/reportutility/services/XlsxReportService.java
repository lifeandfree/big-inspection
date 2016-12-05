package ru.urfu.inspection.xrm.reportutility.services;

import ru.urfu.inspection.xrm.reportutility.models.DataRow;

public class XlsxReportService extends ReportServiceBase {

    public XlsxReportService(String[] args) {
        super(args);
    }

    @Override
    protected DataRow[] GetDataRows(String text) {
        return new DataRow[0];
    }

}

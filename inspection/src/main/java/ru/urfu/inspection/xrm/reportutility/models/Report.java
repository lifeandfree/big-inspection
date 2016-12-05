package ru.urfu.inspection.xrm.reportutility.models;

import java.util.ArrayList;

/**
 * Обрано прямое обращение к переменным. Добавелны методы get и set
 */
public class Report {

    /**
     * Переменный сделанные private.
     */
    private ReportConfig Config;
    private DataRow[] Data;
    private ArrayList<ReportRow> Rows;

    /**
     * Пустой конструктор
     */
    public Report() {
        super();
        this.Config = null;
        this.Data = null;
    }

    /**
     * Добавлено создание объектов через конструктор
     */
    public Report(ReportConfig config, DataRow[] data, ArrayList<ReportRow> rows) {
        super();
        this.Config = config;
        this.Data = data;
        this.Rows = rows;
    }

    /**
     * @return the config
     */
    public ReportConfig getConfig() {
        return Config;
    }

    /**
     * @return the data
     */
    public DataRow[] getData() {
        return Data;
    }

    /**
     * @return the rows
     */
    public ArrayList<ReportRow> getRows() {
        return Rows;
    }

    /**
     * @param config
     *            the config to set
     */
    public void setConfig(ReportConfig config) {
        Config = config;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(DataRow[] data) {
        Data = data;
    }

    /**
     * @param rows
     *            the rows to set
     */
    public void setRows(ArrayList<ReportRow> rows) {
        Rows = rows;
    }
}

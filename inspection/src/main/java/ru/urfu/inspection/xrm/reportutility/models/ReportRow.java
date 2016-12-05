package ru.urfu.inspection.xrm.reportutility.models;

/**
 * Убрано прямое обращение к переменным. Добавелны методы get и set
 */
public class ReportRow {

    /**
     * Переменный сделанные private.
     */
    private String Name;
    private double Value;

    /**
     * Пустой конструктор
     */
    public ReportRow() {
        super();
        Name = null;
        Value = 0;
    }

    /**
     * Добавлено создание объектов через конструктор
     */
    public ReportRow(String name, Double value) {
        super();
        Name = name;
        Value = value;
    }

    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @return the value
     */
    public Double getValue() {
        return Value;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(Double value) {
        Value = value;
    }
}

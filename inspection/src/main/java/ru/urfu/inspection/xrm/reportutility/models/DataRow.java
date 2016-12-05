package ru.urfu.inspection.xrm.reportutility.models;

/**
 * Убрано прямое обращение к переменным. Добавелны методы get и set
 */
public class DataRow {

    /**
     * Переменный сделанные private.
     */
    private double Cost;
    private double Count;
    private String Name;
    private double Volume;
    private double Weight;

    /**
     * Пустой конструктор
     */
    public DataRow() {
        super();
        Cost = 0;
        Count = 0;
        Name = null;
        Volume = 0;
        Weight = 0;
    }

    /**
     * Добавлено создание объектов через конструктор
     */
    public DataRow(double cost, double count, String name, double volume, double weight) {
        super();
        Cost = cost;
        Count = count;
        Name = name;
        Volume = volume;
        Weight = weight;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return Cost;
    }

    /**
     * @return the count
     */
    public double getCount() {
        return Count;
    }

    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @return the volume
     */
    public double getVolume() {
        return Volume;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return Weight;
    }

    /**
     * @param cost
     *            the cost to set
     */
    public void setCost(double cost) {
        Cost = cost;
    }

    /**
     * @param count
     *            the count to set
     */
    public void setCount(double count) {
        Count = count;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @param volume
     *            the volume to set
     */
    public void setVolume(double volume) {
        Volume = volume;
    }

    /**
     * @param weight
     *            the weight to set
     */
    public void setWeight(double weight) {
        Weight = weight;
    }
}

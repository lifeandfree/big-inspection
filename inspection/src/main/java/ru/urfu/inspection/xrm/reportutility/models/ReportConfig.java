package ru.urfu.inspection.xrm.reportutility.models;

/**
 * Убрано прямое обращение к переменным. Добавелны методы get и set
 */
public class ReportConfig {

    /**
     * Переменный сделанные private.
     */
    private boolean CostSum;
    private boolean CountSum;
    private boolean VolumeSum;
    private boolean WeightSum;
    private boolean WithData;
    private boolean WithIndex;
    private boolean WithTotalVolume;
    private boolean WithTotalWeight;

    /**
     * Пустой конструктор
     */
    public ReportConfig() {
        super();
        CostSum = false;
        CountSum = false;
        VolumeSum = false;
        WeightSum = false;
        WithData = false;
        WithIndex = false;
        WithTotalVolume = false;
        WithTotalWeight = false;
    }

    /**
     * Добавлено создание объектов через конструктор
     */
    public ReportConfig(boolean costSum, boolean countSum, boolean volumeSum, boolean weightSum, boolean withData,
            boolean withIndex, boolean withTotalVolume, boolean withTotalWeight) {
        super();
        CostSum = costSum;
        CountSum = countSum;
        VolumeSum = volumeSum;
        WeightSum = weightSum;
        WithData = withData;
        WithIndex = withIndex;
        WithTotalVolume = withTotalVolume;
        WithTotalWeight = withTotalWeight;
    }

    /**
     * @return the costSum
     */
    public boolean isCostSum() {
        return CostSum;
    }

    /**
     * @return the countSum
     */
    public boolean isCountSum() {
        return CountSum;
    }

    /**
     * @return the volumeSum
     */
    public boolean isVolumeSum() {
        return VolumeSum;
    }

    /**
     * @return the weightSum
     */
    public boolean isWeightSum() {
        return WeightSum;
    }

    /**
     * @return the withData
     */
    public boolean isWithData() {
        return WithData;
    }

    /**
     * @return the withIndex
     */
    public boolean isWithIndex() {
        return WithIndex;
    }

    /**
     * @return the withTotalVolume
     */
    public boolean isWithTotalVolume() {
        return WithTotalVolume;
    }

    /**
     * @return the withTotalWeight
     */
    public boolean isWithTotalWeight() {
        return WithTotalWeight;
    }

    /**
     * @param costSum
     *            the costSum to set
     */
    public void setCostSum(boolean costSum) {
        CostSum = costSum;
    }

    /**
     * @param countSum
     *            the countSum to set
     */
    public void setCountSum(boolean countSum) {
        CountSum = countSum;
    }

    /**
     * @param volumeSum
     *            the volumeSum to set
     */
    public void setVolumeSum(boolean volumeSum) {
        VolumeSum = volumeSum;
    }

    /**
     * @param weightSum
     *            the weightSum to set
     */
    public void setWeightSum(boolean weightSum) {
        WeightSum = weightSum;
    }

    /**
     * @param withData
     *            the withData to set
     */
    public void setWithData(boolean withData) {
        WithData = withData;
    }

    /**
     * @param withIndex
     *            the withIndex to set
     */
    public void setWithIndex(boolean withIndex) {
        WithIndex = withIndex;
    }

    /**
     * @param withTotalVolume
     *            the withTotalVolume to set
     */
    public void setWithTotalVolume(boolean withTotalVolume) {
        WithTotalVolume = withTotalVolume;
    }

    /**
     * @param withTotalWeight
     *            the withTotalWeight to set
     */
    public void setWithTotalWeight(boolean withTotalWeight) {
        WithTotalWeight = withTotalWeight;
    }
}

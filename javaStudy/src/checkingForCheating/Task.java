package checkingForCheating;

public class Task {
    private int mModuleNumber;
    private int mTaskNumber;

    /***
     * @param module Номер модуля
     * @param task Номер задания в модуле
     */
    public Task(int module, int task) {
        this.mModuleNumber = module;
        this.mTaskNumber = task;
    }

    /**
     * Возвращается полный номер задания
     * @return номер задания
     */
    public String getNumberOfTask() {
        return mModuleNumber + "." + mTaskNumber;
    }
}

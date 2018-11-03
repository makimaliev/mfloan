package kg.gov.mf.loan.model;

public enum LogAction {

    INSERTED("Добавлен"),
    UPDATED("Обновлен"),
    DELETED("Удален");

    private final String name;

    private LogAction(String value) {
        this.name = value;
    }

    public String value() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}

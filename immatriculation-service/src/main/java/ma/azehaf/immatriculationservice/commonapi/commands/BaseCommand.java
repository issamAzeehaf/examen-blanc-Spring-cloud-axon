package ma.azehaf.immatriculationservice.commonapi.commands;

public class BaseCommand<T> {
    private T id;

    public BaseCommand(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}


package it.intesys.codylab.rookie.project.exception;

import it.intesys.codylab.rookie.project.domain.Doctor;

public class NotFound extends RuntimeException {
    private Long id;
    private Class<?> type;

    public NotFound(Long id, Class<?> doctorClass) {
        this.id = id;
        this.type = doctorClass;
    }

    public Long getId() {
        return id;
    }

    public Class<?> getType() {
        return type;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "NotFound{" +
                "id=" + id +
                ", type=" + type.getSimpleName() +
                '}';
    }
}

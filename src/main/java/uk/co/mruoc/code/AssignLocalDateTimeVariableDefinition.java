package uk.co.mruoc.code;

import java.time.LocalDateTime;

public class AssignLocalDateTimeVariableDefinition implements StatementDefinition {

    private final FieldDefinition field;

    public AssignLocalDateTimeVariableDefinition(FieldDefinition field) {
        this.field = field;
    }

    @Override
    public String getFormat() {
        return "$T $N = $T.of($L, $L, $L, $L, $L, $L, $L)";
    }

    @Override
    public Object[] getArgs() {
        LocalDateTime now = LocalDateTime.now();
        return new Object[] {
                field.getType(),
                field.getName(),
                field.getType(),
                now.getYear(),
                now.getMonthValue(),
                now.getDayOfMonth(),
                now.getHour(),
                now.getMinute(),
                now.getSecond(),
                now.getNano()
        };
    }

}

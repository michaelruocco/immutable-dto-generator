package uk.co.mruoc.code;

import java.time.LocalDate;

public class AssignLocalDateVariableDefinition implements StatementDefinition {

    private final FieldDefinition field;

    public AssignLocalDateVariableDefinition(FieldDefinition field) {
        this.field = field;
    }

    @Override
    public String getFormat() {
        return "$T $N = $T.of($L, $L, $L)";
    }

    @Override
    public Object[] getArgs() {
        LocalDate now = LocalDate.now();
        return new Object[] {
                field.getType(),
                field.getName(),
                field.getType(),
                now.getYear(),
                now.getMonthValue(),
                now.getDayOfMonth()
        };
    }

}

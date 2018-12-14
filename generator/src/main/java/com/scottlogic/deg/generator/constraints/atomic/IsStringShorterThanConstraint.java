package com.scottlogic.deg.generator.constraints.atomic;

import com.scottlogic.deg.generator.Field;

import java.util.Objects;

public class IsStringShorterThanConstraint implements AtomicConstraint {
    public final Field field;
    public final int referenceValue;

    public IsStringShorterThanConstraint(Field field, int referenceValue) {

        this.referenceValue = referenceValue;
        this.field = field;
    }

    @Override
    public String toDotLabel(){
        return String.format("%s length < %s", field.name, referenceValue);
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsStringShorterThanConstraint constraint = (IsStringShorterThanConstraint) o;
        return Objects.equals(field, constraint.field) && Objects.equals(referenceValue, constraint.referenceValue);
    }

    @Override
    public int hashCode(){
        return Objects.hash(field, referenceValue);
    }

    @Override
    public String toString() { return String.format("`%s` length < %d", field.name, referenceValue); }
}
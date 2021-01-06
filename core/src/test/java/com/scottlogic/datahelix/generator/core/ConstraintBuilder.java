/*
 * Copyright 2019 Scott Logic Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scottlogic.datahelix.generator.core;

import com.scottlogic.datahelix.generator.common.profile.Field;
import com.scottlogic.datahelix.generator.core.builders.TestAtomicConstraintBuilder;
import com.scottlogic.datahelix.generator.core.profile.constraints.Constraint;
import com.scottlogic.datahelix.generator.core.profile.constraints.atomic.InSetConstraint;
import com.scottlogic.datahelix.generator.core.profile.constraints.atomic.IsNullConstraint;
import com.scottlogic.datahelix.generator.core.profile.constraints.grammatical.AndConstraint;
import com.scottlogic.datahelix.generator.core.profile.constraints.grammatical.ConditionalConstraint;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstraintBuilder {
    private final List<Constraint> constraints = new ArrayList<>();
    private final Map<String, Field> fields;

    public ConstraintBuilder(List<Field> fields) {
        this.fields = fields.stream().collect(Collectors.toMap(f -> f.getName(), f -> f));
    }

    public List<Constraint> build() {
        return constraints;
    }

    public ConstraintBuilder addInSetConstraint(String fieldname, List<Object> values) {
        constraints.add(new InSetConstraint(fields.get(fieldname),
            TestAtomicConstraintBuilder.inSetRecordsFromList(values)));
        return this;
    }

    public ConstraintBuilder addEqualToConstraint(String fieldname, Object value) {
        constraints.add(new InSetConstraint(
            fields.get(fieldname),
            TestAtomicConstraintBuilder.inSetRecordsFrom(value)));
        return this;
    }

    public ConstraintBuilder addConditionalConstraint(List<Constraint> predicates, List<Constraint> consequences) {
        constraints.add(new ConditionalConstraint(new AndConstraint(predicates), new AndConstraint(consequences)));
        return this;
    }

    public ConstraintBuilder addNullConstraint(String fieldName) {
        constraints.add(new IsNullConstraint(fields.get(fieldName)));
        return this;
    }
}

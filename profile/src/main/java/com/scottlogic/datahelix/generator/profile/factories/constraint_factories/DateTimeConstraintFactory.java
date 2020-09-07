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


package com.scottlogic.datahelix.generator.profile.factories.constraint_factories;

import com.scottlogic.datahelix.generator.common.profile.DateTimeGranularity;
import com.scottlogic.datahelix.generator.common.profile.Field;
import com.scottlogic.datahelix.generator.core.profile.constraints.atomic.*;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.GranularToConstraintDTO;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.integer.LongerThanConstraintDTO;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.integer.OfLengthConstraintDTO;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.integer.ShorterThanConstraintDTO;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.numeric.*;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.temporal.AfterConstraintDTO;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.temporal.AfterOrAtConstraintDTO;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.temporal.BeforeConstraintDTO;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.temporal.BeforeOrAtConstraintDTO;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.textual.ContainsRegexConstraintDTO;
import com.scottlogic.datahelix.generator.profile.dtos.constraints.atomic.textual.MatchesRegexConstraintDTO;
import com.scottlogic.datahelix.generator.profile.factories.DateTimeFactory;

public class DateTimeConstraintFactory extends AtomicConstraintFactory {
    @Override
    Object parseValue(Object value)
    {
        return DateTimeFactory.create((String) value);
    }

    @Override
    MatchesRegexConstraint createMatchesRegexConstraint(MatchesRegexConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    ContainsRegexConstraint createContainsRegexConstraint(ContainsRegexConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    OfLengthConstraint createOfLengthConstraint(OfLengthConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    ShorterThanConstraint createShorterThanConstraint(ShorterThanConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    LongerThanConstraint createLongerThanConstraint(LongerThanConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    GreaterThanConstraint createGreaterThanConstraint(GreaterThanConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    GreaterThanOrEqualToConstraint createGreaterThanOrEqualToConstraint(GreaterThanOrEqualToConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    LessThanConstraint createLessThanConstraint(LessThanConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    LessThanOrEqualToConstraint createLessThanOrEqualToConstraint(LessThanOrEqualToConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    AfterOrAtConstraint createAfterOrAtConstraint(AfterOrAtConstraintDTO dto, Field field) {
        return new AfterOrAtConstraint(field, DateTimeFactory.create(dto.value));
    }

    @Override
    AfterConstraint createAfterConstraint(AfterConstraintDTO dto, Field field) {
        return new AfterConstraint(field, DateTimeFactory.create(dto.value));
    }

    @Override
    BeforeOrAtConstraint createBeforeOrAtConstraint(BeforeOrAtConstraintDTO dto, Field field) {
        return new BeforeOrAtConstraint(field, DateTimeFactory.create(dto.value));
    }

    @Override
    BeforeConstraint createBeforeConstraint(BeforeConstraintDTO dto, Field field) {
        return new BeforeConstraint(field, DateTimeFactory.create(dto.value));
    }

    @Override
    AtomicConstraint createGranularToConstraint(GranularToConstraintDTO dto, Field field) {
        return new GranularToDateConstraint(field, DateTimeGranularity.create((String) dto.value));
    }

}
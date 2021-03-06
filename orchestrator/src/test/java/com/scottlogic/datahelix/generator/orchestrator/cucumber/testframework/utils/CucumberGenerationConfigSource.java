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

package com.scottlogic.datahelix.generator.orchestrator.cucumber.testframework.utils;

import com.google.inject.Inject;
import com.scottlogic.datahelix.generator.core.config.detail.CombinationStrategyType;
import com.scottlogic.datahelix.generator.core.config.detail.DataGenerationType;
import com.scottlogic.datahelix.generator.core.config.detail.MonitorType;
import com.scottlogic.datahelix.generator.core.config.detail.VisualiserLevel;
import com.scottlogic.datahelix.generator.orchestrator.guice.AllConfigSource;
import com.scottlogic.datahelix.generator.common.output.OutputFormat;

import java.io.File;
import java.nio.file.Path;

public class CucumberGenerationConfigSource implements AllConfigSource {
    private final CucumberTestState state;

    @Inject
    public CucumberGenerationConfigSource(CucumberTestState state) {
        this.state = state;
    }

    @Override
    public DataGenerationType getGenerationType() {
        return state.dataGenerationType;
    }

    @Override
    public CombinationStrategyType getCombinationStrategyType() {
        return state.combinationStrategyType;
    }

    @Override
    public MonitorType getMonitorType() {
        return MonitorType.QUIET;
    }

    @Override
    public Long getMaxRows() {
        return state.maxRows;
    }

    @Override
    public boolean getInfiniteOutput() {
        return false;
    }

    @Override
    public Path getOutputPath() {
        return new File("mockFilePath").toPath();
    }

    @Override
    public File getProfileFile() {
        return new File("mockFilePath");
    }

    @Override
    public boolean overwriteOutputFiles() {
        return false;
    }

    @Override
    public boolean useStdOut() {
        return false;
    }

    @Override
    public OutputFormat getOutputFormat() {
        return OutputFormat.JSON;
    }

    @Override
    public String fromFilePath() {
        return "";
    }

    @Override
    public VisualiserLevel getVisualiserLevel() {
        return VisualiserLevel.OFF;
    }

    @Override
    public Path getVisualiserOutputFolder() {
        return new File("mockFolderPath").toPath();
    }
}

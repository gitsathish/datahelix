package com.scottlogic.deg.generator.cucumber.utils;

import com.google.inject.Inject;
import com.scottlogic.deg.generator.ProfileFields;
import com.scottlogic.deg.generator.outputs.GeneratedObject;
import com.scottlogic.deg.generator.outputs.targets.OutputTarget;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Defines an output target which stores the output data into the test state.
 */
public class InMemoryOutputTarget implements OutputTarget {

    private TestState testState;

    @Inject
    public InMemoryOutputTarget(TestState testState) {
        this.testState = testState;
    }

    @Override
    public void outputDataset(Stream<GeneratedObject> generatedObjects, ProfileFields profileFields) throws IllegalStateException{
        this.testState.generatedObjects = getRows(generatedObjects);
    }

    //TODO: Don't Want This
    @Override
    public OutputTarget withFilename(String filename) {
        return this;
    }

    private List<List<Object>> getRows(Stream<GeneratedObject> generatedObjects) throws IllegalStateException {
        return generatedObjects
            .collect(Collectors.toList())
            .stream()
            .map(genObj ->{

                if (genObj == null){
                    throw new IllegalStateException("GeneratedObject is null");
                }

                return genObj.values
                    .stream()
                    .map(obj -> {
                        if (obj.value != null && obj.format != null) {
                            return String.format(obj.format, obj.value);
                        }
                        return obj.value;
                    })
                    .collect(Collectors.toList());
            }).collect(Collectors.toList());
    }
}

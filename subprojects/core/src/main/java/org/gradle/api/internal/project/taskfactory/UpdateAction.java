/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.internal.project.taskfactory;

import org.gradle.api.internal.TaskOutputsInternal;
import org.gradle.api.tasks.InputPropertyRegistration;
import org.gradle.api.tasks.TaskDestroyables;

import java.util.concurrent.Callable;

public abstract class UpdateAction {
    public static final UpdateAction NO_OP_CONFIGURATION_ACTION = new UpdateAction() {};


    public void updateInputs(InputPropertyRegistration inputs, String propertyName, Callable<Object> futureValue) {
    }

    public void updateOutputs(TaskOutputsInternal outputs, String propertyName, Callable<Object> futureValue) {
    }

    public void updateDestroyables(TaskDestroyables destroyables, String propertyName, Callable<Object> futureValue) {
    }
}

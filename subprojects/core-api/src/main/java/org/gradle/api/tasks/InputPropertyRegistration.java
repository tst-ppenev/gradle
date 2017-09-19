/*
 * Copyright 2017 the original author or authors.
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

package org.gradle.api.tasks;

import org.gradle.api.NonNullApi;

import javax.annotation.Nullable;
import java.util.Map;

@NonNullApi
public interface InputPropertyRegistration {
    /**
     * Returns true if this task has declared the inputs that it consumes.
     *
     * @return true if this task has declared any inputs.
     */
    boolean getHasInputs();

    /**
     * Registers some input files for this task.
     *
     * @param paths The input files. The given paths are evaluated as per {@link org.gradle.api.Project#files(Object...)}.
     * @return a property builder to further configure the property.
     */
    TaskInputFilePropertyBuilder files(Object... paths);

    /**
     * Registers some input file for this task.
     *
     * @param path The input file. The given path is evaluated as per {@link org.gradle.api.Project#files(Object...)}.
     * @return a property builder to further configure the property.
     */
    TaskInputFilePropertyBuilder file(Object path);

    /**
     * Registers an input directory hierarchy. All files found under the given directory are treated as input files for
     * this task.
     *
     * @param dirPath The directory. The path is evaluated as per {@link org.gradle.api.Project#file(Object)}.
     * @return a property builder to further configure the property.
     */
    TaskInputFilePropertyBuilder dir(Object dirPath);

    /**
     * <p>Registers an input property for this task. This value is persisted when the task executes, and is compared
     * against the property value for later invocations of the task, to determine if the task is up-to-date.</p>
     *
     * <p>The given value for the property must be Serializable, so that it can be persisted. It should also provide a
     * useful {@code equals()} method.</p>
     *
     * <p>You can specify a closure or {@code Callable} as the value of the property. In which case, the closure or
     * {@code Callable} is executed to determine the actual property value.</p>
     *
     * @param name The name of the property. Must not be null.
     * @param value The value for the property. Can be null.
     */
    @Nullable
    TaskInputs property(String name, @Nullable Object value);

    /**
     * Registers a set of input properties for this task. See {@link #property(String, Object)} for details.
     *
     * @param properties The properties.
     */
    @Nullable
    TaskInputs properties(Map<String, ?> properties);

}

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

package org.gradle.api.internal.tasks;

import org.gradle.api.file.FileCollection;
import org.gradle.api.internal.tasks.properties.PropertyVisitor;
import org.gradle.api.tasks.TaskDestroyables;

/**
 * Note: this is currently not visible on {@link org.gradle.api.internal.TaskInternal} to avoid it leaking onto {@link org.gradle.api.internal.AbstractTask} and so on to the public API.
 */
public interface TaskDestroyablesInternal extends TaskDestroyables {

    /**
     * Calls the corresponding visitor methods for all destroyables added via the runtime API.
     */
    void visitRegisteredProperties(PropertyVisitor visitor);

    FileCollection getFiles();

    GetFilesVisitor getFilesVisitor();

    interface GetFilesVisitor extends PropertyVisitor {
        FileCollection getFiles();
    }

}

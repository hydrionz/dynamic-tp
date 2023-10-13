/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.dynamictp.starter.adapter.webserver.jetty;

import org.dromara.dynamictp.core.aware.AwareManager;
import org.dromara.dynamictp.core.support.task.runnable.EnhancedRunnable;
import org.eclipse.jetty.util.thread.ExecutionStrategy;
import java.util.Objects;
import java.util.concurrent.Executor;

/**
 * @author kyao
 * @since 1.1.5
 */
public class SelectorProducerProxy implements ExecutionStrategy.Producer {

    private final ExecutionStrategy.Producer producer;

    private final Executor executor;

    public SelectorProducerProxy(ExecutionStrategy.Producer producer, Executor executor) {
        this.producer = producer;
        this.executor = executor;
    }

    @Override
    public Runnable produce() {
        Runnable task = producer.produce();
        if (Objects.isNull(task)) {
            return task;
        }
        EnhancedRunnable enhancedTask = EnhancedRunnable.of(task, executor);
        AwareManager.execute(executor, enhancedTask);
        return enhancedTask;
    }
}
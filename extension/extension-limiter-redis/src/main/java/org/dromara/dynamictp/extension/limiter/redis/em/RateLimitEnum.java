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

package org.dromara.dynamictp.extension.limiter.redis.em;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * RateLimitEnum related
 *
 * @author yanhom
 * @since 1.0.8
 **/
@Getter
@AllArgsConstructor
public enum RateLimitEnum {

    /**
     * rate limit
     */
    SLIDING_WINDOW("sw_rt", "sliding_window_rate_limiter.lua"),;

    private final String keyName;

    private final String scriptName;

}

/*
 * Copyright 2018 xingyunzhi.
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
package com.github.xincao9.localcache.method;

import com.github.xincao9.benchmark.core.annotation.Test;
import com.github.xincao9.benchmark.core.interfaces.Method;
import com.github.xincao9.localcache.GuavaCacheSupport;
import com.github.xincao9.localcache.JCSSupport;
import com.github.xincao9.localcache.XBenchmarkLocalcache;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author xincao9@gmail.com
 */
@Test(name = "set")
public class SetMethod extends Method {

    @Override
    public void exec(Object params) throws Exception {
        String key = String.valueOf(params);
        String value = RandomStringUtils.randomAscii(128);
        if ("jcs".equalsIgnoreCase(XBenchmarkLocalcache.getType())) {
            JCSSupport.put(key, value);
        } else if ("guava".equalsIgnoreCase(XBenchmarkLocalcache.getType())) {
            GuavaCacheSupport.put(key, value);
        }
    }

}

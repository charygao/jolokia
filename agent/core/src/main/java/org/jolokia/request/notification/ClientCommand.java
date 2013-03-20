/*
 * Copyright 2009-2013 Roland Huss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jolokia.request.notification;

import java.util.Map;
import java.util.Stack;

/**
 * @author roland
 * @since 19.03.13
 */
abstract public class ClientCommand extends Command {

    private String client;

    protected ClientCommand(CommandType pType, Stack<String> pStack) {
        super(pType);
        if (pStack.isEmpty()) {
            throw new IllegalArgumentException("No notification client given for '" + pType + "'");
        }
        client = pStack.pop();
    }

    protected ClientCommand(CommandType pType, Map<String, ?> pMap) {
        super(pType);
        client = (String) pMap.get("client");
        if (client == null) {
            throw new IllegalArgumentException("No notification client given for '" + pType + "'");
        }
    }

    public String getClient() {
        return client;
    }
}
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hdds.server.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.CustomRequestLog;
import org.eclipse.jetty.server.RequestLog;
import org.junit.jupiter.api.Test;

/**
 * Testing HttpRequestLog.
 */
public class TestHttpRequestLog {

  @Test
  public void testAppenderUndefined() {
    RequestLog requestLog = HttpRequestLog.getRequestLog("test");
    assertNull(requestLog, "RequestLog should be null");
  }

  @Test
  public void testAppenderDefined() {
    HttpRequestLogAppender requestLogAppender = new HttpRequestLogAppender();
    requestLogAppender.setName("testrequestlog");
    Logger.getLogger("http.requests.test").addAppender(requestLogAppender);
    RequestLog requestLog = HttpRequestLog.getRequestLog("test");
    Logger.getLogger("http.requests.test").removeAppender(requestLogAppender);
    assertNotNull(requestLog, "RequestLog should not be null");
    assertEquals(CustomRequestLog.class, requestLog.getClass(),
        "Class mismatch");
  }
}

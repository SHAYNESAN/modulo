/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pinot.common.function;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TransformFunctionTypeTest {

  @Test
  public void testSimpleLookupFunction() {
    assertEquals(TransformFunctionType.getTransformFunctionType("add"), TransformFunctionType.ADD);
  }

  @Test
  public void testScalarFunction() {
    assertEquals(TransformFunctionType.getTransformFunctionType("toEpochSeconds"), TransformFunctionType.SCALAR);
  }

  @Test
  public void testJsonScalarFunction() {
    assertEquals(TransformFunctionType.getTransformFunctionType("jsonpath"), TransformFunctionType.SCALAR);
    assertEquals(TransformFunctionType.getTransformFunctionType("jsonpathString"), TransformFunctionType.SCALAR);
    assertEquals(TransformFunctionType.getTransformFunctionType("json_path_LONG"), TransformFunctionType.SCALAR);
  }

  @Test
  public void testSnakeCaseLookupFunction() {
    assertEquals(TransformFunctionType.getTransformFunctionType("json_extract_scalar"), TransformFunctionType.JSONEXTRACTSCALAR);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void invalidLookup() {
    TransformFunctionType.getTransformFunctionType("foo_bar");
  }
}
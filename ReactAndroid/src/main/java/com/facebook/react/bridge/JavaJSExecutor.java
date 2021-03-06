/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

/**
 * This is class represents java version of native js executor interface. When set through
 * {@link ProxyJavaScriptExecutor} as a {@link CatalystInstance} executor, native code will
 * delegate js calls to the given implementation of this interface.
 */
@DoNotStrip
public interface JavaJSExecutor {
  public static class ProxyExecutorException extends Exception {
    public ProxyExecutorException(Throwable cause) {
      super(cause);
    }
  }

  /**
   * Close this executor and cleanup any resources that it was using. No further calls are
   * expected after this.
   */
  void close();

  /**
   * Load javascript into the js context
   * @param script script contet to be executed
   * @param sourceURL url or file location from which script content was loaded
   */
  @DoNotStrip
  void executeApplicationScript(String script, String sourceURL) throws ProxyExecutorException;

  /**
   * Execute javascript method within js context
   * @param modulename name of the common-js like module to execute the method from
   * @param methodName name of the method to be executed
   * @param jsonArgsArray json encoded array of arguments provided for the method call
   * @return json encoded value returned from the method call
   */
  @DoNotStrip
  String executeJSCall(String modulename, String methodName, String jsonArgsArray)
      throws ProxyExecutorException;

  @DoNotStrip
  void setGlobalVariable(String propertyName, String jsonEncodedValue);
}

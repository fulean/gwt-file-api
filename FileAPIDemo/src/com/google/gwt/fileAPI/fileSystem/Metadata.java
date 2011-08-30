/*
 * Copyright 2009 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.fileAPI.fileSystem;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This interface supplies information about the state of a file or directory
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a
 *      href="http://www.w3.org/TR/file-system-api/#idl-def-Metadata">http://www.w3.org/TR/file-system-api/#idl-def-Metadata</a>
 */
public class Metadata extends JavaScriptObject {

  protected Metadata() {
  }

  /**
   * @return This is the time at which the file or directory was last modified
   */
  public final native String getModificationTime()/*-{
		return this.modificationTime.toString();
  }-*/;

}

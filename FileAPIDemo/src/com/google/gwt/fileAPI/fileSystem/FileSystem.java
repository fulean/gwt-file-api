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
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a href=""></a>
 */
public class FileSystem extends JavaScriptObject {

  protected FileSystem() {

  }

  /**
   * @return This is the name of the file system. The specifics of naming
   *         filesystems is unspecified, but a name must be unique across the
   *         list of exposed file systems.
   * @see <a
   *      href="http://www.w3.org/TR/file-system-api/#widl-FileSystem-name">http://www.w3.org/TR/file-system-api/#widl-FileSystem-name</a>
   */
  public final native String getName()/*-{
		return this.name;
  }-*/;

  /**
   * @return The root directory of the file system.
   * @see <a
   *      href="http://www.w3.org/TR/file-system-api/#widl-FileSystem-root">http://www.w3.org/TR/file-system-api/#widl-FileSystem-root</a>
   */
  public final native DirectoryEntry getRoot()/*-{
		return this.root;
  }-*/;

}

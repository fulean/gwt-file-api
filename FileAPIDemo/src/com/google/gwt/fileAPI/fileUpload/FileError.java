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

package com.google.gwt.fileAPI.fileUpload;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This interface is used to report errors asynchronously. The FileReader
 * object's error attribute is a FileError object, and is accessed
 * asynchronously through the onerror event handler when error events are
 * generated.
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a href="http://www.w3.org/TR/file-upload/#dfn-fileerror">W3C
 *      file-upload/#dfn-fileerror</a>
 */

public class FileError extends JavaScriptObject {

  protected FileError() {
  }

  public final ErrorCode getCode() {
    return ErrorCode.fromValue(getCode_());
  }

  public final native short getCode_() /*-{
		return this.code;
  }-*/;
}

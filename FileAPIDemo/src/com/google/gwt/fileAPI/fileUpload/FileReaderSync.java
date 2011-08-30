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
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a href=""></a>
 */
public class FileReaderSync extends JavaScriptObject {

  protected FileReaderSync() {
  }

  /**
   * @param blob
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-readAsArrayBuffer">W3C
   *      file-upload/#dfn-readAsArrayBuffer</a>
   */
  public final native ArrayBuffer readAsArrayBuffer(Blob blob)/*-{
		this.readAsArrayBuffer(blob);
  }-*/;

  /**
   * @param blob
   * @see <a
   *      href="http://www.w3.org/TR/file-upload/#dfn-readAsBinaryStringAsync">W3C
   *      file-upload/#dfn-readAsBinaryStringAsync</a>
   */
  public final native String readAsBinaryString(Blob blob)/*-{
		return this.readAsBinaryString(blob);
  }-*/;

  /**
   * @param blob
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-readAsDataURL">W3C
   *      file-upload/#dfn-readAsDataURL</a>
   */
  public final native String readAsDataURL(Blob blob)/*-{
		return this.readAsDataURL(blob);
  }-*/;

  /**
   * @param blob
   * @param encoding
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-readAsText">W3C
   *      file-upload/#dfn-readAsText</a>
   */
  public final native String readAsText(Blob blob, String encoding)/*-{
		return this.readAsText(blob, encoding);
  }-*/;

}

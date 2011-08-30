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
package com.google.gwt.fileAPI.fileWriter;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.fileAPI.fileUpload.Blob;

/**
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a href=""></a>
 */
public class BlobBuilder extends JavaScriptObject {

  protected BlobBuilder() {
  }

  public final static native BlobBuilder create() /*-{
    return new $wnd.WebKitBlobBuilder();
  }-*/;

  /**
   * @param data The data to append to the {@link Blob} being constructed
   * @see <a
   *      href="http://www.w3.org/TR/file-writer-api/#the-blobbuilder-interface">http://www.w3.org/TR/file-writer-api/#the-blobbuilder-interface</a>
   */
  public final native <T> void append(T data) /*-{
		this.append(data);
  }-*/;
  

  /**
   * @param data The data to append to the {@link Blob} being constructed
   * @see <a
   *      href="http://www.w3.org/TR/file-writer-api/#the-blobbuilder-interface">http://www.w3.org/TR/file-writer-api/#the-blobbuilder-interface</a>
   */
  public final native void append(String data) /*-{
    this.append(data);
  }-*/;


  /**
   * @param data The data to append to the {@link Blob} being constructed
   * @param endings Specifies how strings containing \n are to be written out.
   *        This can be "transparent" (endings unchanged) or "native" (endings
   *        changed to match host OS filesystem convention). The default value
   *        is "transparent".
   */
  public final native void append(String data, String endings)/*-{
		this.append(data, endings);
  }-*/;

  public final native Blob getBlob() /*-{
		return this.getBlob();
  }-*/;

  /**
   * @param contentType The MIME type of the data to be returned in the Blob.
   *        This will be the value of the Blob object's type property
   * @return A Blob object containing all of the data passed to any calls to
   *         append() made since the BlobBuilder was created. This also resets
   *         the BlobBuilder so that the next call to append() is starting a
   *         new, empty blob.
   */
  public final native Blob getBlob(String contentType) /*-{
		return this.getBlob(contentType);
  }-*/;

}

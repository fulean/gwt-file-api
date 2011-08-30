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
 * This interface provides methods to read Files or Blobs into memory, and to
 * access the data from those Files or Blobs using progress events and event
 * handler attributes [DOM3Events]. It is desirable to read data from file
 * systems asynchronously in the main thread of user agents. This interface
 * provides such an asynchronous API, and is specified to be used with the
 * global object (Window [HTML5]).
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a href="http://www.w3.org/TR/file-upload/#FileReader-interface">W3C
 *      file-upload/#FileReader-interface</a>
 */
public class FileReaderImpl extends JavaScriptObject {

  /**
   * The entire File or Blob has been read into memory, or a file error occurred
   * during read, or the read was aborted using abort(). The FileReader is no
   * longer reading a File or Blob.
   */
  public static final int DONE = 2;

  /**
   * The object has been constructed, and there are no pending reads
   */
  public static final int EMPTY = 0;

  /**
   * A File or Blob is being read. One of the read methods is being processed.
   */
  public static final int LOADING = 1;

  protected FileReaderImpl() {
  }

  /**
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-abort">W3C
   *      file-upload/#dfn-abort</a>
   */
  public final native void abort()/*-{
                                  this.abort();
                                  }-*/;

  /**
   * @return a new {@link FileReaderImpl} object
   */
  public final static native FileReaderImpl create()/*-{
                                                    return new $wnd.FileReader();
                                                    }-*/;

  /**
   * @param blob
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-readAsArrayBuffer">W3C
   *      file-upload/#dfn-readAsArrayBuffer</a>
   */
  public final native void readAsArrayBuffer(Blob blob)/*-{
                                                       this.readAsArrayBuffer(blob);
                                                       }-*/;

  /**
   * @param blob
   * @see <a
   *      href="http://www.w3.org/TR/file-upload/#dfn-readAsBinaryStringAsync">W3C
   *      file-upload/#dfn-readAsBinaryStringAsync</a>
   */
  public final native void readAsBinaryString(Blob blob)/*-{
                                                        this.readAsBinaryString(blob);
                                                        }-*/;

  /**
   * @param blob
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-readAsDataURL">W3C
   *      file-upload/#dfn-readAsDataURL</a>
   */
  public final native void readAsDataURL(Blob blob)/*-{
                                                   this.readAsDataURL(blob);
                                                   }-*/;

  /**
   * @param blob
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-readAsText">W3C
   *      file-upload/#dfn-readAsText</a>
   */
  public final native void readAsText(Blob blob)/*-{
                                                this.readAsText(blob);
                                                }-*/;

  /**
   * @param blob
   * @param encoding
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-readAsText">W3C
   *      file-upload/#dfn-readAsText</a>
   */
  public final native void readAsText(Blob blob, String encoding)/*-{
                                                                 this.readAsText(blob, encoding);
                                                                 }-*/;

  /**
   * @return Error
   * @see <a
   *      href="http://www.w3.org/TR/file-upload/#dfn-error">http://www.w3.org/TR/file-upload/#dfn-error</a>
   */
  public final native FileError getError() /*-{
                                           return this.error;
                                           }-*/;

  /**
   * @return The FileReader object can be in one of 3 states. The readyState
   *         attribute, on getting, MUST return the current state
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-readystate">W3C
   *      file-upload/#dfn-readystate</a>
   */
  public final native short getReadyState()/*-{
                                           return this.readyState;
                                           }-*/;

  /**
   * On getting, the result attribute returns a Blob's data as a DOMString, or
   * as an ArrayBuffer [TypedArrays], or null, depending on the read method that
   * has been called on the FileReader, and any errors that may have occurred.
   * It can also return partial Blob data. Partial Blob data is the part of the
   * File or Blob that has been read into memory currently; when processing the
   * read methods readAsBinaryString or readAsText, partial Blob data is a
   * DOMString that is incremented as more bytes are loaded (a portion of the
   * total) [ProgressEvents], and when processing readAsArrayBuffer partial Blob
   * data is an ArrayBuffer [TypedArrays] object consisting of the bytes loaded
   * so far (a portion of the total)
   * 
   * @return {@link ArrayBuffer} or {@link String}
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-result">W3C
   *      file-upload/#dfn-result</a>
   */
  public final native <T> T getResult()/*-{
                                       return this.result;
                                       }-*/;

  public final native void registerEvent(FileReader reader, String eventType) /*-{
                                                                              var handler = function(evt) {
                                                                              reader.@com.google.gwt.fileAPI.fileUpload.FileReader::dispatch(Lcom/google/gwt/dom/client/NativeEvent;)(evt);
                                                                              };
                                                                              this["on" + eventType] = handler;
                                                                              }-*/;

}

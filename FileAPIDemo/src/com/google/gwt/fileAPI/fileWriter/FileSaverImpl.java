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
import com.google.gwt.fileAPI.fileUpload.FileError;

/**
 * This interface provides methods to read Files or Blobs into memory, and to
 * access the data from those Files or Blobs using progress events and event
 * handler attributes [DOM3Events]. It is desirable to read data from file
 * systems asynchronously in the main thread of user agents. This interface
 * provides such an asynchronous API, and is specified to be used with the
 * global object (Window [HTML5]).
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a href="http://www.w3.org/TR/file-writer-api/#idl-def-FileSaver">W3C
 *      file-writer-api/#idl-def-FileSaver</a>
 */
public class FileSaverImpl extends JavaScriptObject {

  /**
   * The entire File or Blob has been read into memory, or a file error occurred
   * during read, or the read was aborted using abort(). The FileReader is no
   * longer reading a File or Blob.
   */
  public static final int DONE = 2;

  /**
   * The object has been constructed, and there are no pending reads
   */
  public static final int INIT = 0;

  /**
   * A File or Blob is being read. One of the read methods is being processed.
   */
  public static final int WRITING = 1;

  protected FileSaverImpl() {
  }

  public final native void abort()/*-{
		this.abort();
  }-*/;

  /**
   * @return a new {@link FileSaverImpl} object
   */
  public final static native FileSaverImpl create()/*-{
		return new $wnd.FileSaver();
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

  public final native void registerEvent(FileSaver saver, String eventType) /*-{
		var handler = function(evt) {
			saver.@com.google.gwt.fileAPI.fileWriter.FileSaver::dispatch(Lcom/google/gwt/dom/client/NativeEvent;)(evt);
		};
		this["on" + eventType] = handler;
  }-*/;

  public final native int getPosition()/*-{
		return impl.position;
  }-*/;

  public final native int getLength()/*-{
		return this.length;
  }-*/;

  public final native void write(Blob data)/*-{
		this.write(data);
  }-*/;

  public final native void seek(int offset) /*-{
		this.seek(offset);
  }-*/;

  public final native void truncate(int size) /*-{
		this.truncate(size);
  }-*/;

}

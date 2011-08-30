/*
 * Copyright 2009 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.fileAPI.fileSystem;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.fileAPI.fileSystem.callback.EntriesCallback;
import com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback;

/**
 * This interface lets a user list files and directories in a directory.
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a href="http://www.w3.org/TR/file-system-api/#idl-def-DirectoryReader">
 *      http://www.w3.org/TR/file-system-api/#idl-def-DirectoryReader</a>
 */
public class DirectoryReader extends JavaScriptObject {

  protected DirectoryReader() {
  }

  /**
   * Read the next block of entries from this directory
   * 
   * @param successCallback Called once per successful call to readEntries to deliver the next
   *          previously-unreported set of Entries in the associated Directory. If all Entries have
   *          already been returned from previous invocations of readEntries, successCallback must
   *          be called with a zero-length array as an argument.
   */
  public final native void readEntries(EntriesCallback successCallback)/*-{
		this
				.readEntries(function(entries) {
					successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntriesCallback::handleEvent(Lcom/google/gwt/core/client/JsArray;)(entries);
				});
  }-*/;

  /**
   * Read the next block of entries from this directory
   * 
   * @param successCallback Called once per successful call to readEntries to deliver the next
   *          previously-unreported set of Entries in the associated Directory. If all Entries have
   *          already been returned from previous invocations of readEntries, successCallback must
   *          be called with a zero-length array as an argument.
   * @param errorCallback A callback that is called when errors happen.
   */
  public final native void readEntries(EntriesCallback successCallback, ErrorCallback errorCallback)/*-{
		this
				.readEntries(
						function(entries) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntriesCallback::handleEvent(Lcom/google/gwt/core/client/JsArray;)(entries);
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

}

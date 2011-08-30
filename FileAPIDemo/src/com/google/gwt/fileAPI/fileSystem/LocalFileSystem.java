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
import com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback;
import com.google.gwt.fileAPI.fileSystem.callback.FileSystemCallback;

/**
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a
 *      href="http://www.w3.org/TR/file-system-api/#using-localfilesystem">http://www.w3.org/TR/file-system-api/#using-localfilesystem</a>
 */
public class LocalFileSystem extends JavaScriptObject {

  public final static int TEMPORARY = 0;
  public final static int PERSISTENT = 1;

  protected LocalFileSystem() {
  }

  public final static native void requestFileSystem(int type, int size,
      FileSystemCallback successCallback)/*-{
		$wnd
				.webkitRequestFileSystem(
						type,
						size,
						function(fileSystem) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.FileSystemCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/FileSystem;)(fileSystem);
						});
  }-*/;

  public final static native void requestFileSystem(int type, int size,
      FileSystemCallback successCallback, ErrorCallback errorCallback)/*-{
		$wnd
				.webkitRequestFileSystem(
						type,
						size,
						function(fileSystem) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.FileSystemCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/FileSystem;)(fileSystem);
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

}

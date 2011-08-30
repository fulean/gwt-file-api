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

import com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback;
import com.google.gwt.fileAPI.fileSystem.callback.FileCallback;
import com.google.gwt.fileAPI.fileSystem.callback.FileWriterCallback;

/**
 * This interface represents a file on a file system
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a
 *      href="http://www.w3.org/TR/file-system-api/#the-fileentry-interface">http://www.w3.org/TR/file-system-api/#the-fileentry-interface</a>
 */
public class FileEntry extends Entry {

  protected FileEntry() {
  }

  /**
   * Creates a new FileWriter associated with the file that this FileEntry represents
   * 
   * @param successCallback A callback that is called with the new FileWriter
   */
  public final native void createWriter(FileWriterCallback successCallback)/*-{
		this
				.createWriter(function(fileSaverImpl) {
					successCallback.@com.google.gwt.fileAPI.fileSystem.callback.FileWriterCallback::handleEvent(Lcom/google/gwt/fileAPI/fileWriter/FileSaverImpl;)(fileSaverImpl);
				});
  }-*/;

  /**
   * Creates a new FileWriter associated with the file that this FileEntry represents
   * 
   * @param successCallback A callback that is called with the new FileWriter
   * @param errorCallback A callback that is called when errors happen
   */
  public final native void createWriter(FileWriterCallback successCallback,
      ErrorCallback errorCallback)/*-{
		this
				.createWriter(
						function(fileSaverImpl) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.FileWriterCallback::handleEvent(Lcom/google/gwt/fileAPI/fileWriter/FileSaverImpl;)(fileSaverImpl);
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

  /**
   * Returns a File that represents the current state of the file that this FileEntry represents
   * 
   * @param successCallback A callback that is called with the new FileWriter
   */
  public final native void file(FileCallback successCallback)/*-{
		this
				.file(function(file) {
					successCallback.@com.google.gwt.fileAPI.fileSystem.callback.FileCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/File;)(file);
				});
  }-*/;

  /**
   * Returns a File that represents the current state of the file that this FileEntry represents
   * 
   * @param successCallback A callback that is called with the new FileWriter
   * @param errorCallback A callback that is called when errors happen
   */
  public final native void file(FileCallback successCallback, ErrorCallback errorCallback)/*-{
		this
				.file(
						function(file) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.FileCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/File;)(file);
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

}

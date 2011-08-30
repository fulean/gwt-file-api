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

import com.google.gwt.fileAPI.fileSystem.callback.EntryCallback;
import com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback;
import com.google.gwt.fileAPI.fileSystem.callback.VoidCallback;

/**
 * This interface represents a directory on a file system
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a
 *      href="http://www.w3.org/TR/file-system-api/#idl-def-DirectoryEntry">http://www.w3.org/TR/file-system-api/#idl-def-DirectoryEntry</a>
 */
public class DirectoryEntry extends Entry {

  protected DirectoryEntry() {
  }

  public final native DirectoryReader createReader()/*-{
		return this.createReader();
  }-*/;

  /**
   * Creates or looks up a file
   * 
   * @param path Either an absolute path or a relative path from this
   *        DirectoryEntry to the file to be looked up or created. It is an
   *        error to attempt to create a file whose immediate parent does not
   *        yet exist
   */
  public final native void getFile(String path)/*-{
		this.getFile(path);
  }-*/;

  /**
   * Creates or looks up a file
   * 
   * @param path Either an absolute path or a relative path from this
   *        DirectoryEntry to the file to be looked up or created. It is an
   *        error to attempt to create a file whose immediate parent does not
   *        yet exist
   * @param options If create and exclusive are both true, and the path already
   *        exists, getFile must fail. If create is true, the path doesn't
   *        exist, and no other error occurs, getFile must create it as a
   *        zero-length file and return a corresponding FileEntry. If create is
   *        not true and the path doesn't exist, getFile must fail. If create is
   *        not true and the path exists, but is a directory, getFile must fail.
   *        Otherwise, if no other error occurs, getFile must return a FileEntry
   *        corresponding to path
   */
  public final native void getFile(String path, Flags options)/*-{
		this.getFile(path, options);
  }-*/;

  /**
   * Creates or looks up a file
   * 
   * @param path Either an absolute path or a relative path from this
   *        DirectoryEntry to the file to be looked up or created. It is an
   *        error to attempt to create a file whose immediate parent does not
   *        yet exist
   * @param options If create and exclusive are both true, and the path already
   *        exists, getFile must fail. If create is true, the path doesn't
   *        exist, and no other error occurs, getFile must create it as a
   *        zero-length file and return a corresponding FileEntry. If create is
   *        not true and the path doesn't exist, getFile must fail. If create is
   *        not true and the path exists, but is a directory, getFile must fail.
   *        Otherwise, if no other error occurs, getFile must return a FileEntry
   *        corresponding to path
   * @param successCallback A callback that is called to return the File
   *        selected or created.
   */
  public final native void getFile(String path, Flags options,
      EntryCallback successCallback)/*-{
		this
				.getFile(
						path,
						options,
						function(entry) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntryCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Entry;)(entry);
						});
  }-*/;

  /**
   * Creates or looks up a file
   * 
   * @param path Either an absolute path or a relative path from this
   *        DirectoryEntry to the file to be looked up or created. It is an
   *        error to attempt to create a file whose immediate parent does not
   *        yet exist
   * @param options If create and exclusive are both true, and the path already
   *        exists, getFile must fail. If create is true, the path doesn't
   *        exist, and no other error occurs, getFile must create it as a
   *        zero-length file and return a corresponding FileEntry. If create is
   *        not true and the path doesn't exist, getFile must fail. If create is
   *        not true and the path exists, but is a directory, getFile must fail.
   *        Otherwise, if no other error occurs, getFile must return a FileEntry
   *        corresponding to path
   * @param successCallback A callback that is called to return the File
   *        selected or created.
   * @param errorCallback A callback that is called when errors happen
   */
  public final native void getFile(String path, Flags options,
      EntryCallback successCallback, ErrorCallback errorCallback)/*-{
		this
				.getFile(
						path,
						options,
						function(entry) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntryCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Entry;)(entry);
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

  /**
   * Creates or looks up a directory
   * 
   * @param path Either an absolute path or a relative path from this
   *        DirectoryEntry to the directory to be looked up or created. It is an
   *        error to attempt to create a directory whose immediate parent does
   *        not yet exist
   */
  public final native void getDirectory(String path)/*-{
		this.getDirectory(path);
  }-*/;

  /**
   * Creates or looks up a directory
   * 
   * @param path Either an absolute path or a relative path from this
   *        DirectoryEntry to the directory to be looked up or created. It is an
   *        error to attempt to create a directory whose immediate parent does
   *        not yet exist
   * @param options If create and exclusive are both true and the path already
   *        exists, getDirectory must fail. If create is true, the path doesn't
   *        exist, and no other error occurs, getDirectory must create and
   *        return a corresponding DirectoryEntry. If create is not true and the
   *        path doesn't exist, getDirectory must fail. If create is not true
   *        and the path exists, but is a file, getDirectory must fail.
   *        Otherwise, if no other error occurs, getDirectory must return a
   *        DirectoryEntry corresponding to path.
   */
  public final native void getDirectory(String path, Flags options)/*-{
		this.getDirectory(path, options);
  }-*/;

  /**
   * Creates or looks up a directory
   * 
   * @param path Either an absolute path or a relative path from this
   *        DirectoryEntry to the directory to be looked up or created. It is an
   *        error to attempt to create a directory whose immediate parent does
   *        not yet exist
   * @param options If create and exclusive are both true and the path already
   *        exists, getDirectory must fail. If create is true, the path doesn't
   *        exist, and no other error occurs, getDirectory must create and
   *        return a corresponding DirectoryEntry. If create is not true and the
   *        path doesn't exist, getDirectory must fail. If create is not true
   *        and the path exists, but is a file, getDirectory must fail.
   *        Otherwise, if no other error occurs, getDirectory must return a
   *        DirectoryEntry corresponding to path.
   * @param successCallbackA callback that is called to return the
   *        DirectoryEntry selected or created
   */
  public final native void getDirectory(String path, Flags options,
      EntryCallback successCallback)/*-{
		this
				.getDirectory(
						path,
						options,
						function(entry) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntryCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Entry;)(entry);
						});
  }-*/;

  /**
   * Creates or looks up a directory
   * 
   * @param path Either an absolute path or a relative path from this
   *        DirectoryEntry to the directory to be looked up or created. It is an
   *        error to attempt to create a directory whose immediate parent does
   *        not yet exist
   * @param options If create and exclusive are both true and the path already
   *        exists, getDirectory must fail. If create is true, the path doesn't
   *        exist, and no other error occurs, getDirectory must create and
   *        return a corresponding DirectoryEntry. If create is not true and the
   *        path doesn't exist, getDirectory must fail. If create is not true
   *        and the path exists, but is a file, getDirectory must fail.
   *        Otherwise, if no other error occurs, getDirectory must return a
   *        DirectoryEntry corresponding to path.
   * @param successCallbackA callback that is called to return the
   *        DirectoryEntry selected or created
   * @param errorCallback A callback that is called when errors happen
   */
  public final native void getDirectory(String path, Flags options,
      EntryCallback successCallback, ErrorCallback errorCallback)/*-{
		this
				.getDirectory(
						path,
						options,
						function(entry) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntryCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Entry;)(entry);
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

  /**
   * Deletes a directory and all of its contents, if any. In the event of an
   * error [e.g. trying to delete a directory that contains a file that cannot
   * be removed], some of the contents of the directory may be deleted. It is an
   * error to attempt to delete the root directory of a filesystem.
   * 
   * @param successCallback A callback that is called on success
   */
  public final native void removeRecursively(VoidCallback successCallback)/*-{
		this
				.removeRecursively(function() {
					successCallback.@com.google.gwt.fileAPI.fileSystem.callback.VoidCallback::handleEvent()();
				});
  }-*/;

  /**
   * Deletes a directory and all of its contents, if any. In the event of an
   * error [e.g. trying to delete a directory that contains a file that cannot
   * be removed], some of the contents of the directory may be deleted. It is an
   * error to attempt to delete the root directory of a filesystem.
   * 
   * @param successCallback A callback that is called on success
   * @param errorCallback A callback that is called when errors happen.
   */
  public final native void removeRecursively(VoidCallback successCallback,
      ErrorCallback errorCallback)/*-{
		this
				.removeRecursively(
						function() {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.VoidCallback::handleEvent()();
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

}

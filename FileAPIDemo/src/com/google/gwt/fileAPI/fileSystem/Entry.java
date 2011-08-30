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
import com.google.gwt.fileAPI.fileSystem.callback.EntryCallback;
import com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback;
import com.google.gwt.fileAPI.fileSystem.callback.MetadataCallback;
import com.google.gwt.fileAPI.fileSystem.callback.VoidCallback;

/**
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a
 *      href="http://www.w3.org/TR/file-system-api/#the-entry-interface">http://www.w3.org/TR/file-system-api/#the-entry-interface</a>
 */
public class Entry extends JavaScriptObject {

  protected Entry() {
  }

  public final native boolean isFile()/*-{
		return this.isFile;
  }-*/;

  public final native boolean isDirectory() /*-{
		return this.isDirectory;
  }-*/;

  /**
   * @return The name of the entry, excluding the path leading to it
   * @see <a
   *      href="http://www.w3.org/TR/file-system-api/#widl-Entry-name">http://www.w3.org/TR/file-system-api/#widl-Entry-name</a>
   */
  public final native String getName()/*-{
		return this.name;
  }-*/;

  public final native String getFullPath()/*-{
		return this.fullPath;
  }-*/;

  public final native FileSystem getFileSystem()/*-{
		return this.filesystem;
  }-*/;

  /**
   * Copy an entry to a different location on the file system. It is an error to
   * try to copy an entry inside itself at any depth if it is a directory, or to
   * copy it into its parent if a name different from its current one isn't
   * provided. Directory copies are always recursive--that is, they copy all
   * contents of the directory.
   * 
   * @param parent The directory to which to move the entry
   */
  public final native void copyTo(DirectoryEntry parent)/*-{
		this.copyTo(parent);
  }-*/;

  /**
   * Copy an entry to a different location on the file system. It is an error to
   * try to copy an entry inside itself at any depth if it is a directory, or to
   * copy it into its parent if a name different from its current one isn't
   * provided. Directory copies are always recursive--that is, they copy all
   * contents of the directory.
   * 
   * @param parent The directory to which to move the entry
   * @param newName The new name of the entry. Defaults to the Entry's current
   *        name if unspecified
   */
  public final native void copyTo(DirectoryEntry parent, String newName)/*-{
		this.copyTo(parent, newName);
  }-*/;

  /**
   * Copy an entry to a different location on the file system. It is an error to
   * try to copy an entry inside itself at any depth if it is a directory, or to
   * copy it into its parent if a name different from its current one isn't
   * provided. Directory copies are always recursive--that is, they copy all
   * contents of the directory.
   * 
   * @param parent The directory to which to move the entry
   * @param newName The new name of the entry. Defaults to the Entry's current
   *        name if unspecified
   * @param successCallback A callback that is called with the Entry for the new
   *        object
   */
  public final native void copyTo(DirectoryEntry parent, String newName,
      EntryCallback successCallback)/*-{
		this
				.copyTo(
						parent,
						newName,
						function(entry) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntryCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Entry;)(entry);
						});
  }-*/;

  /**
   * Copy an entry to a different location on the file system. It is an error to
   * try to copy an entry inside itself at any depth if it is a directory, or to
   * copy it into its parent if a name different from its current one isn't
   * provided. Directory copies are always recursive--that is, they copy all
   * contents of the directory.
   * 
   * @param parent The directory to which to move the entry
   * @param newName The new name of the entry. Defaults to the Entry's current
   *        name if unspecified
   * @param successCallback A callback that is called with the Entry for the new
   *        object
   * @param errorCallback A callback that is called when errors happen
   */
  public final native void copyTo(DirectoryEntry parent, String newName,
      EntryCallback successCallback, ErrorCallback errorCallback)/*-{
		this
				.copyTo(
						parent,
						newName,
						function(entry) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntryCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Entry;)(entry);
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

  /**
   * Move an entry to a different location on the file system.
   * 
   * @param parent The directory to which to move the entry
   */
  public final native void moveTo(DirectoryEntry parent)/*-{
		this.moveTo(parent);
  }-*/;

  /**
   * Move an entry to a different location on the file system.
   * 
   * @param parent The directory to which to move the entry
   * @param newName The new name of the entry. Defaults to the Entry's current
   *        name if unspecified
   */
  public final native void moveTo(DirectoryEntry parent, String newName)/*-{
		this.moveTo(parent, newName);
  }-*/;

  /**
   * Move an entry to a different location on the file system.
   * 
   * @param parent The directory to which to move the entry
   * @param newName The new name of the entry. Defaults to the Entry's current
   *        name if unspecified
   * @param successCallback A callback that is called with the Entry for the new
   *        object
   */
  public final native void moveTo(DirectoryEntry parent, String newName,
      EntryCallback successCallback)/*-{
		this
				.moveTo(
						parent,
						newName,
						function(entry) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntryCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Entry;)(entry);
						});
  }-*/;

  /**
   * Move an entry to a different location on the file system.
   * 
   * @param parent The directory to which to move the entry
   * @param newName The new name of the entry. Defaults to the Entry's current
   *        name if unspecified
   * @param successCallback A callback that is called with the Entry for the new
   *        object
   * @param errorCallback A callback that is called when errors happen
   */
  public final native void moveTo(DirectoryEntry parent, String newName,
      EntryCallback successCallback, ErrorCallback errorCallback)/*-{
		this
				.moveTo(
						parent,
						newName,
						function(entry) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntryCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Entry;)(entry);
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

  /**
   * Look up metadata about this entry
   * 
   * @param successCallback A callback that is called with the time of the last
   *        modification
   */
  public final native void getMetadata(MetadataCallback successCallback)/*-{
		this
				.getMetadata(function(metadata) {
					successCallback.@com.google.gwt.fileAPI.fileSystem.callback.MetadataCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Metadata;)(metadata);
				});
  }-*/;

  /**
   * Look up metadata about this entry
   * 
   * @param successCallback A callback that is called with the time of the last
   *        modification
   * @param errorCallback A callback that is called when errors happen.
   */
  public final native void getMetadata(MetadataCallback successCallback,
      ErrorCallback errorCallback)/*-{
		this
				.getMetadata(
						function(metadata) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.MetadataCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Metadata;)(metadata);
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

  /**
   * Returns a URL that can be used to identify this entry. Unlike the URN
   * defined in [FILE-API], it has no specific expiration; as it describes a
   * location on disk, it should be valid at least as long as that location
   * exists. Users may supply mimeType in order to simulate the optional
   * mime-type header associated with HTTP downloads.
   * 
   * @return the URL
   */
  public final native String toUrl()/*-{
		return this.toUrl();
  }-*/;

  /**
   * Returns a URL that can be used to identify this entry. Unlike the URN
   * defined in [FILE-API], it has no specific expiration; as it describes a
   * location on disk, it should be valid at least as long as that location
   * exists. Users may supply mimeType in order to simulate the optional
   * mime-type header associated with HTTP downloads.
   * 
   * @param mimeType For a FileEntry, the mime type to be used to interpret the
   *        file, when loaded through this URL.
   * @return the URL
   */
  public final native String toUrl(String mimeType)/*-{
		return this.toUrl(mimeType);
  }-*/;

  /**
   * Deletes a file or directory. It is an error to attempt to delete a
   * directory that is not empty. It is an error to attempt to delete the root
   * directory of a filesystem
   * 
   * @param successCallback A callback that is called on success
   * @param errorCallback A callback that is called when errors happen.
   */
  public final native void remove(VoidCallback successCallback)/*-{
		this
				.remove(function() {
					successCallback.@com.google.gwt.fileAPI.fileSystem.callback.VoidCallback::handleEvent()();
				});
  }-*/;

  /**
   * Deletes a file or directory. It is an error to attempt to delete a
   * directory that is not empty. It is an error to attempt to delete the root
   * directory of a filesystem
   * 
   * @param successCallback A callback that is called on success
   * @param errorCallback A callback that is called when errors happen.
   */
  public final native void remove(VoidCallback successCallback,
      ErrorCallback errorCallback)/*-{
		this
				.remove(
						function() {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.VoidCallback::handleEvent()();
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

  /**
   * Look up the parent DirectoryEntry containing this Entry. If this Entry is
   * the root of its filesystem, its parent is itself
   * 
   * @param successCallback A callback that is called to return the parent Entry
   */
  public final native void getParent(EntryCallback successCallback)/*-{
		this
				.getParent(function(entry) {
					successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntryCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Entry;)(entry);
				});
  }-*/;

  /**
   * Look up the parent DirectoryEntry containing this Entry. If this Entry is
   * the root of its filesystem, its parent is itself
   * 
   * @param successCallback A callback that is called to return the parent Entry
   * @param errorCallback A callback that is called when errors happen.
   */
  public final native void getParent(EntryCallback successCallback,
      ErrorCallback errorCallback)/*-{
		this
				.getParent(
						function(entry) {
							successCallback.@com.google.gwt.fileAPI.fileSystem.callback.EntryCallback::handleEvent(Lcom/google/gwt/fileAPI/fileSystem/Entry;)(entry);
						},
						function(err) {
							errorCallback.@com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback::handleEvent(Lcom/google/gwt/fileAPI/fileUpload/FileError;)(err);
						});
  }-*/;

}

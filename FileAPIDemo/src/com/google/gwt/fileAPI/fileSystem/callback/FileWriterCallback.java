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
package com.google.gwt.fileAPI.fileSystem.callback;

import com.google.gwt.fileAPI.fileWriter.FileSaverImpl;


/**
 * This interface is the callback used to create a FileWriter
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a
 *      href="http://www.w3.org/TR/file-system-api/#idl-def-FileWriterCallback">http://www.w3.org/TR/file-system-api/#idl-def-FileWriterCallback</a>
 */
public interface FileWriterCallback {
  /**
   * @param fileWriter Used to supply a FileWriter as a response to a user query
   */
  void handleEvent(FileSaverImpl fileSaverImpl);
}

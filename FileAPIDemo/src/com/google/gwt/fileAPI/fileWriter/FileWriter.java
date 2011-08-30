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

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.fileAPI.fileUpload.Blob;
import com.google.gwt.fileAPI.fileUpload.FileException;

/**
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a
 *      href="http://www.w3.org/TR/file-writer-api/#the-filesaversync-interface">http://www.w3.org/TR/file-writer-api/#the-filesaversync-interface</a>
 */
public class FileWriter extends FileSaver {

  public FileWriter() {
  }
  
  public FileWriter(FileSaverImpl impl) {
    super(impl);
  }
  
  public final int getPosition() {
    return super.impl.getPosition();
  }

  public final int getLength() {
    return super.impl.getLength();
  }

  /**
   * Write the supplied data to the file at position. When the write method is
   * called, user agents must run the steps below (unless otherwise indicated).
   * 
   * @param data The blob to write
   * @throws FileException
   * @see <a
   *      href="http://www.w3.org/TR/file-writer-api/#widl-FileWriter-write">http://www.w3.org/TR/file-writer-api/#widl-FileWriter-write</a>
   */
  public final void write(Blob data) throws FileException {
    try {
      super.impl.write(data);
    } catch (JavaScriptException e) {
      throw new FileException(e.getName(), e);
    }
  }

  /**
   * Seek sets the file position at which the next write will occur. Seek may
   * not be called while the FileWriter is in the WRITING state.
   * 
   * @param offset An absolute byte offset into the file. If offset is greater
   *        than length, length is used instead. If offset is less than zero,
   *        length is added to it, so that it is treated as an offset back from
   *        the end of the file. If it is still less than zero, zero is used.
   * @throws FileException
   * @see <a
   *      href="http://www.w3.org/TR/file-writer-api/#widl-FileWriter-seek">http://www.w3.org/TR/file-writer-api/#widl-FileWriter-seek</a>
   */
  public final void seek(int offset) throws FileException {
    try {
      super.impl.seek(offset);
    } catch (JavaScriptException e) {
      throw new FileException(e.getName(), e);
    }
  }

  /**
   * Changes the length of the file to that specified. If shortening the file,
   * data beyond the new length must be discarded. If extending the file, the
   * existing data must be zero-padded up to the new length.
   * 
   * @param size The size to which the length of the file is to be adjusted,
   *        measured in bytes
   * @throws FileException
   * @see <a
   *      href="http://www.w3.org/TR/file-writer-api/#widl-FileWriter-truncate">http://www.w3.org/TR/file-writer-api/#widl-FileWriter-truncate</a>
   */
  public final void truncate(int size) throws FileException {
    try {
      super.impl.truncate(size);
    } catch (JavaScriptException e) {
      throw new FileException(e.getName(), e);
    }
  }

}

package com.google.gwt.fileAPI.fileUpload;

/**
 * This interface describes a single file in a FileList and exposes its name. It
 * inherits from Blob.
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a href="http://www.w3.org/TR/file-upload/#file">W3C
 *      file-upload/#file</a>
 */
public class File extends Blob {

  protected File() {
  }

  /**
   * @return The name of the file. There are numerous file name variations on
   *         different systems; this is merely the name of the file, without
   *         path information.
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-name">W3C
   *      file-upload/#dfn-name</a>
   */
  public final native String getName() /*-{
		return this.name;
  }-*/;

  /**
   * @return The last modified date of the file; on getting, this returns an
   *         HTML5 valid date string [HTML5]. If user agents cannot make this
   *         information available, they MUST return the emtpy string.
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-lastModifiedDate">W3C
   *      file-upload/#dfn-lastModifiedDate</a>
   */
  public final native String getLastModifiedDate()/*-{
		return this.lastModifiedDate.toString();
  }-*/;

}

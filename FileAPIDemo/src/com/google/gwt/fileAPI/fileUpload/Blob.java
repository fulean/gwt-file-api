/**
 * 
 */
package com.google.gwt.fileAPI.fileUpload;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This interface represents raw data. It provides a method to slice data
 * objects between ranges of bytes into further chunks of raw data. It also
 * provides an attribute representing the size of the chunk of data. The File
 * interface inherits from this interface.
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a href="http://www.w3.org/TR/file-upload/#blob">W3C
 *      file-upload/#blob</a>
 */
public class Blob extends JavaScriptObject {

  protected Blob() {
  }

  /**
   * @return Represents the size of the Blob object in bytes
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-size">W3C
   *      file-upload/#dfn-size</a>
   */
  public final native int getSize() /*-{
                                    return this.size;
                                    }-*/;

  /**
   * @return The ASCII-encoded string in lower case representing the media type
   *         of the Blob, expressed as an RFC2046 MIME type [RFC2046]. User
   *         agents SHOULD return the MIME type of the Blob, if it is known. If
   *         implementations cannot determine the media type of the Blob, they
   *         MUST return the empty string. A string is a valid MIME type if it
   *         matches the media-type token defined in section 3.7 "Media Types"
   *         of RFC 2616 [HTTP].
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-type">W3C
   *      file-upload/#dfn-type</a>
   */
  public final native String getType()/*-{
                                       return this.type;
                                       }-*/;

  /**
   * @param start is a value for the start point of a slice call
   * @param length is a value for the end point of a slice call as byte offsets
   *        from start
   * @param can be used to set a value identical to one that is set with the
   *        HTTP/1.1 Content-Type header [HTTP] on the Blob returned by the
   *        slice call. If this parameter is used, the returned Blob MUST have a
   *        type attribute that, on getting, returns the string used for this
   *        parameter
   * @return Returns a new Blob object between the ranges of bytes specified
   * @see <a href="http://www.w3.org/TR/file-upload/#dfn-slice">W3C
   *      file-upload/#dfn-slice</a>
   */
  public final native Blob webkitSlice(int start, int length, int contentType) /*-{
                                                                               return this.slice(start, length, contentType);
                                                                               }-*/;
}

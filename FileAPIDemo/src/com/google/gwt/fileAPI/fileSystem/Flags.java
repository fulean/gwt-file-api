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
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;

/**
 * This interface is used to supply arguments to methods that look up or create
 * files or directories.
 * 
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a
 *      href="http://www.w3.org/TR/file-system-api/#the-flags-interface">http://www.w3.org/TR/file-system-api/#the-flags-interface</a>
 */
public class Flags extends JavaScriptObject {

  protected Flags() {
  }
  
  public static Flags create(boolean create) {
    JSONObject jsonObject = new JSONObject();
    JSONBoolean jsonValue = JSONBoolean.getInstance(create);
    jsonObject.put("create", jsonValue);
    return (Flags) jsonObject.getJavaScriptObject();
  }
 

  public final native boolean getCreate()/*-{
		return this.create;
  }-*/;

  public final native boolean getExclusive() /*-{
		return this.exclusive;
  }-*/;

  public final native void setCreate(boolean create) /*-{
		this.create = create;
  }-*/;

  public final native void setExclusive(boolean exclusive) /*-{
		this.exclusive = exclusive;
  }-*/;

}

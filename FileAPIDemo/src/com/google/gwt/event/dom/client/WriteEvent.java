/*
 * Copyright 2011 Google Inc.
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
package com.google.gwt.event.dom.client;

/**
 * Represents a native media write event.
 * <p>
 * <span style="color:red">Experimental API: This API is still under development
 * and is subject to change. </span>
 * </p>
 */
public class WriteEvent extends DomEvent<WriteHandler> {

  /**
   * Event type for media write events. Represents the meta-data associated with
   * this event.
   */
  private static final Type<WriteHandler> TYPE = new Type<WriteHandler>(
      "write", new WriteEvent());

  /**
   * Gets the event type associated with media write events.
   * 
   * @return the handler type
   */
  public static Type<WriteHandler> getType() {
    return TYPE;
  }

  /**
   * Protected constructor, use
   * {@link DomEvent#fireNativeEvent(com.google.gwt.dom.client.NativeEvent, com.google.gwt.event.shared.HasHandlers)}
   * to fire media progress events.
   */
  protected WriteEvent() {
  }

  @Override
  public final Type<WriteHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(WriteHandler handler) {
    handler.onWrite(this);
  }
}
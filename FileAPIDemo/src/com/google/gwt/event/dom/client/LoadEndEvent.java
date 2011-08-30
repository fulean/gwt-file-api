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
 * Represents a native LoadEnd event.
 */
public class LoadEndEvent extends DomEvent<LoadEndHandler> {

  /**
   * Event type for LoadEnd events. Represents the meta-data associated with
   * this event.
   */
  private static final Type<LoadEndHandler> TYPE = new Type<LoadEndHandler>(
      "loadend", new LoadEndEvent());

  /**
   * Gets the event type associated with LoadEnd events.
   * 
   * @return the handler type
   */
  public static Type<LoadEndHandler> getType() {
    return TYPE;
  }

  /**
   * Protected constructor, use
   * {@link DomEvent#fireNativeEvent(com.google.gwt.dom.client.NativeEvent, com.google.gwt.event.shared.HasHandlers)}
   * to fire load events.
   */
  protected LoadEndEvent() {
  }

  @Override
  public final Type<LoadEndHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(LoadEndHandler handler) {
    handler.onLoadEnd(this);
  }

}

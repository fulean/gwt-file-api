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
 * Represents a native loadStart event.
 */
public class WriteStartEvent extends DomEvent<WriteStartHandler> {

  /**
   * Event type for loadStart events. Represents the meta-data associated with
   * this event.
   */
  private static final Type<WriteStartHandler> TYPE =
      new Type<WriteStartHandler>("writestart", new WriteStartEvent());

  /**
   * Gets the event type associated with loadStart events.
   * 
   * @return the handler type
   */
  public static Type<WriteStartHandler> getType() {
    return TYPE;
  }

  /**
   * Protected constructor, use
   * {@link DomEvent#fireNativeEvent(com.google.gwt.dom.client.NativeEvent, com.google.gwt.event.shared.HasHandlers)}
   * to fire load events.
   */
  protected WriteStartEvent() {
  }

  @Override
  public final Type<WriteStartHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(WriteStartHandler handler) {
    handler.onWriteStart(this);
  }

}

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

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.AbortEvent;
import com.google.gwt.event.dom.client.AbortHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.HasAbortHandlers;
import com.google.gwt.event.dom.client.HasErrorHandlers;
import com.google.gwt.event.dom.client.HasProgressHandlers;
import com.google.gwt.event.dom.client.HasWriteEndHandlers;
import com.google.gwt.event.dom.client.HasWriteHandlers;
import com.google.gwt.event.dom.client.HasWriteStartHandlers;
import com.google.gwt.event.dom.client.ProgressEvent;
import com.google.gwt.event.dom.client.ProgressHandler;
import com.google.gwt.event.dom.client.WriteEndEvent;
import com.google.gwt.event.dom.client.WriteEndHandler;
import com.google.gwt.event.dom.client.WriteEvent;
import com.google.gwt.event.dom.client.WriteHandler;
import com.google.gwt.event.dom.client.WriteStartEvent;
import com.google.gwt.event.dom.client.WriteStartHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.fileAPI.fileUpload.FileError;
import com.google.gwt.user.client.Element;
//TODO fix comment of this one
/**
 *
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a href=""></a>
 */
public class FileSaver implements HasWriteHandlers, HasWriteStartHandlers,
    HasWriteEndHandlers, HasAbortHandlers, HasProgressHandlers,
    HasErrorHandlers {
  public enum State {
    INIT {
      public short getValue() {
        return FileSaverImpl.INIT;
      }
    },
    WRITING {
      public short getValue() {
        return FileSaverImpl.WRITING;
      }
    },
    DONE {
      public short getValue() {
        return FileSaverImpl.DONE;
      }
    };
    public abstract short getValue();

    public static State fromValue(short value) {
      switch (value) {
        case FileSaverImpl.INIT:
          return INIT;
        case FileSaverImpl.WRITING:
          return WRITING;
        case FileSaverImpl.DONE:
          return DONE;
        default:
          throw new IllegalStateException("Bad readyState value " + value);
      }
    }
  }

  protected FileSaverImpl impl;
  static protected EventBus eventBus = new SimpleEventBus();

  public FileSaver() {
    impl = FileSaverImpl.create();
  }
  
  public FileSaver(FileSaverImpl returnImpl) {
    impl = returnImpl;
  }

  public State getReadyState() {
    return State.fromValue(impl.getReadyState());
  }

  public FileError getError() {
    return impl.getError();
  }

  /**
   * Dispatches the specified event to this node event handlers
   * 
   * @param event The event to dispatch
   */
  public void dispatch(NativeEvent event) {
    // This call wraps the native event into a DomEvent
    // and invokes fireEvent
    DomEvent.fireNativeEvent(event, this, (Element) event
        .getCurrentEventTarget().cast());
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {
    revive(event);
    eventBus.fireEventFromSource(event, impl);
  }

  /**
   * Revive the event. GWT does it by taking advantage of the fact that
   * HandlerManager has package access to GwtEvent. Here we use a JSNI call to
   * bypass scope restrictions
   */
  private static final native void revive(GwtEvent<?> event) /*-{
		event.@com.google.gwt.event.shared.GwtEvent::revive()();
  }-*/;

  protected final <H extends EventHandler> HandlerRegistration addDomHandler(
      final H handler, DomEvent.Type<H> type) {
    assert handler != null : "handler must not be null";
    assert type != null : "type must not be null";
    impl.registerEvent(this, type.getName());
    return eventBus.addHandlerToSource(type, impl, handler);
  }

  /**
   * When the read has failed (see errors).
   * 
   * @param handler
   * @see <a
   *      href="http://www.w3.org/TR/file-upload/#dfn-onerror">http://www.w3.org/TR/file-upload/#dfn-onerror</a>
   */
  @Override
  public HandlerRegistration addErrorHandler(ErrorHandler handler) {
    return addDomHandler(handler, ErrorEvent.getType());
  }

  /**
   * While reading (and decoding) blob, and reporting partial Blob data
   * (progess.loaded/progress.total)
   * 
   * @param handler Progress Event Handler
   * @see <a
   *      href="http://www.w3.org/TR/file-upload/#dfn-progress-event">http://www.w3.org/TR/file-upload/#dfn-progress-event</a>
   */
  @Override
  public HandlerRegistration addProgressHandler(ProgressHandler handler) {
    return addDomHandler(handler, ProgressEvent.getType());
  }

  /**
   * When the read has been aborted. For instance, by invoking the abort()
   * method.
   * 
   * @param abortHandler Progress Event Handler
   * @see <a
   *      href="http://www.w3.org/TR/file-upload/#dfn-abort-event">http://www.w3.org/TR/file-upload/#dfn-abort-event</a>
   */
  @Override
  public HandlerRegistration addAbortHandler(AbortHandler handler) {
    return addDomHandler(handler, AbortEvent.getType());
  }

  /**
   * When the request has completed (either in success or failure).
   * 
   * @param loadEndHandler
   * @see <a
   *      href="http://www.w3.org/TR/file-upload/#dfn-onloadend">http://www.w3.org/TR/file-upload/#dfn-onloadend</a>
   */
  @Override
  public HandlerRegistration addWriteEndHandler(WriteEndHandler handler) {
    return addDomHandler(handler, WriteEndEvent.getType());
  }

  /**
   * @param handler When the write starts
   * @see <a
   *      href="http://www.w3.org/TR/file-upload/#dfn-loadstart-event">http://www.w3.org/TR/file-upload/#dfn-loadstart-event</a>
   */
  @Override
  public HandlerRegistration addWriteStartHandler(WriteStartHandler handler) {
    return addDomHandler(handler, WriteStartEvent.getType());
  }

  /**
   * When the write has successfully completed.
   * 
   * @param handler
   * @see <a
   *      href="http://www.w3.org/TR/file-upload/#dfn-onload">http://www.w3.org/TR/file-upload/#dfn-onload</a>
   */
  @Override
  public HandlerRegistration addWriteHandler(WriteHandler handler) {
    return addDomHandler(handler, WriteEvent.getType());
  }

}

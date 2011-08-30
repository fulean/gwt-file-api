package com.google.gwt.fileAPI.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.dom.client.WriteEvent;
import com.google.gwt.event.dom.client.WriteHandler;
import com.google.gwt.fileAPI.fileSystem.DirectoryEntry;
import com.google.gwt.fileAPI.fileSystem.DirectoryReader;
import com.google.gwt.fileAPI.fileSystem.Entry;
import com.google.gwt.fileAPI.fileSystem.FileEntry;
import com.google.gwt.fileAPI.fileSystem.FileSystem;
import com.google.gwt.fileAPI.fileSystem.Flags;
import com.google.gwt.fileAPI.fileSystem.LocalFileSystem;
import com.google.gwt.fileAPI.fileSystem.StorageInfo;
import com.google.gwt.fileAPI.fileSystem.callback.EntriesCallback;
import com.google.gwt.fileAPI.fileSystem.callback.EntryCallback;
import com.google.gwt.fileAPI.fileSystem.callback.ErrorCallback;
import com.google.gwt.fileAPI.fileSystem.callback.FileCallback;
import com.google.gwt.fileAPI.fileSystem.callback.FileSystemCallback;
import com.google.gwt.fileAPI.fileSystem.callback.FileWriterCallback;
import com.google.gwt.fileAPI.fileSystem.callback.QuotaCallback;
import com.google.gwt.fileAPI.fileSystem.callback.VoidCallback;
import com.google.gwt.fileAPI.fileUpload.Blob;
import com.google.gwt.fileAPI.fileUpload.ErrorCode;
import com.google.gwt.fileAPI.fileUpload.File;
import com.google.gwt.fileAPI.fileUpload.FileError;
import com.google.gwt.fileAPI.fileUpload.FileList;
import com.google.gwt.fileAPI.fileUpload.FileReader;
import com.google.gwt.fileAPI.fileWriter.BlobBuilder;
import com.google.gwt.fileAPI.fileWriter.FileSaverImpl;
import com.google.gwt.fileAPI.fileWriter.FileWriter;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class FileAPIDemo implements EntryPoint {
  HTML log;

  /**
   * this function is used for logging in both eclipse console, on webpage and on chrome's console
   * 
   * @param s a log string
   */
  public void p(String s) {
    System.out.println(s);
    log.setHTML(log.getHTML() + s + "<br/>");
    cp(s);
  }

  public void p(String s, String c) {
    p("<font color=\"" + c + "\">" + s + "</font>");
  }

  private final native void cp(String o)/*-{
		console.log(o);
  }-*/;

  private final void pb() {
    p("----------------------------");
  }

  public FileList fileList;
  public File file;
  public FileReader fileReader;
  public FlowPanel panel;
  public FileSystem filesystem;
  public DirectoryEntry current;
  public Label cursor;
  public DirectoryReader directoryReader;
  public ErrorCallback errorCallback = new ErrorCallback() {

    @Override
    public void handleEvent(FileError err) {
      p("Error: " + err.getCode().name(),"darkred");
    }
  };
  public ErrorHandler errorHandler = new ErrorHandler() {

    @Override
    public void onError(ErrorEvent event) {
      p("Error: " + event.toString(),"darkred");
    }
  };

  // public void testFileBlob(FileUpload fileUpload) {
  // fileList = FileList.getFileList(fileUpload);
  // file = fileList.getItem(0);
  // pb();
  // p("Loaded the file " + file.getName());
  // p("Size: " + file.getSize());
  // p("Modified on " + file.getLastModifiedDate());
  // p("Done!!!");
  // pb();
  // }

  public void onModuleLoad() {
    log = new HTML();
    testCommandPrompt();

    // log.setSize("500px", "500px");
    // RootPanel.get("logContainer").add(log);
    // p("start loading module");
    // testFileSystem();
    // testFileUpload();
    // p("main thread done");
  }

  public void testCommandPrompt() {

    panel = new FlowPanel();
    panel.setSize("750px", "500px");
    RootPanel.get("logContainer").add(panel);
    panel.setStyleName("terminal");

    log.setStyleName("terminaltext");
    panel.add(log);

    HorizontalPanel hpanel = new HorizontalPanel();
    panel.add(hpanel);

    cursor = new Label();
    cursor.setText("$> ");
    cursor.setStyleName("cursor");
    hpanel.add(cursor);

    final TextBox input = new TextBox();
    input.setStyleName("input");
    hpanel.add(input);
    input.setFocus(true);
    input.setWidth("700px");
    input.addChangeHandler(new ChangeHandler() {

      @Override
      public void onChange(ChangeEvent event) {

        p(cursor.getText() + input.getValue(), "white");
        handleCommand(input.getValue());
        input.setValue("");

      }
    });

    requestQuota(100 * 1024 * 1024);
    // p("is charging the flux capacitor... finished!");

  }

  public void printWelcome() {
    p("");
    p("Welcome to the (not really) Super Awesome Web Terminal");
    JsDate date = JsDate.create();
    p(date.toLocaleString());

    p("");
    p("Documentation: type 'help'");
    p("");
  }

  protected void handleCommand(String value) {
    String[] v = value.split(" ");
    String command = v[0];
    if (command.equals("help")) {
      printHelp();
    } else if (command.equals("ls")) {
      ls(current.createReader());
    } else if (command.equals("cls")) {
      log.setText("");
    } else if (command.equals("cd")) {
      cd(v[1]);
    } else if (command.equals("md")) {
      md(v[1]);
    } else if (command.equals("del")) {
      del(v[1]);
    } else if (command.equals("rm")) {
      if (value.indexOf("/r") != -1 || value.indexOf("-r") != -1)
        rm(v[1], true);
      else
        rm(v[1], false);
    } else if (command.equals("ren")) {
      ren(v[1], v[2]);
    } else if (command.equals("mv")) {
      mv(v[1], v[2]);
    } else if (command.equals("cp")) {
      cp(v[1], v[2]);
    } else if (command.equals("cat")) {
      cat(v[1]);
    } else if (command.equals("echo")) {
      echo(v[1], value.substring((v[0] + v[1]).length() + 2));
    } else {
      p("Command not found!");
    }
  }

  private void del(final String path) {
    current.getFile(path, Flags.create(false), new EntryCallback() {

      @Override
      public void handleEvent(Entry entry) {
        entry.remove(new VoidCallback() {

          @Override
          public void handleEvent() {
            p("Successfully delete file " + path);
          }
        }, errorCallback);
      }
    }, errorCallback);
  }

  private void cat(String path) {
    current.getFile(path, Flags.create(false), new EntryCallback() {

      @Override
      public void handleEvent(Entry entry) {
        ((FileEntry) entry).file(new FileCallback() {

          @Override
          public void handleEvent(File file) {
            fileReader = new FileReader();
            fileReader.addLoadHandler(new LoadHandler() {

              @Override
              public void onLoad(LoadEvent event) {
                p(fileReader.getResult());
              }
            });
            fileReader.addErrorHandler(errorHandler);
            fileReader.readAsText(file);
          }
        }, errorCallback);
      }
    }, errorCallback);
  }

  private void echo(final String path, final String content) {
    current.getFile(path, Flags.create(true), new EntryCallback() {

      @Override
      public void handleEvent(Entry entry) {
        FileEntry fileEntry = (FileEntry) entry;
        fileEntry.createWriter(new FileWriterCallback() {

          @Override
          public void handleEvent(FileSaverImpl fileSaverImpl) {
            FileWriter fileWriter = new FileWriter(fileSaverImpl);
            fileWriter.addWriteHandler(new WriteHandler() {

              @Override
              public void onWrite(WriteEvent event) {
                p("Successfully write to the new file " + path);
              }
            });

            fileWriter.addErrorHandler(errorHandler);

            BlobBuilder blobBuilder = BlobBuilder.create();
            blobBuilder.append(content);

            Blob blob = blobBuilder.getBlob();
            fileWriter.write(blob);
          }
        }, errorCallback);

      }
    }, errorCallback);
  }

  private void ren(String oldName, final String newName) {
    current.getFile(oldName, Flags.create(false), new EntryCallback() {

      @Override
      public void handleEvent(Entry entry) {
        entry.moveTo(current, newName);
      }
    }, errorCallback);
  }

  private void cp(final String file, final String parent) {
    final EntryCallback entryCallback = new EntryCallback() {

      @Override
      public void handleEvent(Entry entry) {
        final Entry fileEntry = entry;
        current.getDirectory(parent, Flags.create(false), new EntryCallback() {

          @Override
          public void handleEvent(Entry entry) {
            DirectoryEntry parentEntry = (DirectoryEntry) entry;
            fileEntry.copyTo(parentEntry);
            p("Copied " + file + " to " + parent);
          }
        }, errorCallback);
      }
    };
    current.getDirectory(file, Flags.create(false), entryCallback, new ErrorCallback() {

      @Override
      public void handleEvent(FileError err) {
        if (err.getCode() == ErrorCode.TYPE_MISMATCH_ERR) {
          current.getFile(file, Flags.create(false), entryCallback, errorCallback);
        } else {
          errorCallback.handleEvent(err);
        }
      }
    });
  }

  private void mv(final String file, final String parent) {
    final EntryCallback entryCallback = new EntryCallback() {

      @Override
      public void handleEvent(Entry entry) {
        final Entry fileEntry = entry;
        current.getDirectory(parent, Flags.create(false), new EntryCallback() {

          @Override
          public void handleEvent(Entry entry) {
            DirectoryEntry parentEntry = (DirectoryEntry) entry;
            fileEntry.moveTo(parentEntry);
            p("Moved " + file + " to " + parent);
          }
        }, errorCallback);
      }
    };
    current.getDirectory(file, Flags.create(false), entryCallback, new ErrorCallback() {

      @Override
      public void handleEvent(FileError err) {
        if (err.getCode() == ErrorCode.TYPE_MISMATCH_ERR) {
          current.getFile(file, Flags.create(false), entryCallback, errorCallback);
        } else {
          errorCallback.handleEvent(err);
        }
      }
    });
  }

  private void printHelp() {
    p("Currently suported command:", "yellow");
    p("cd DIR_PATH");
    p("md NEW_DIR_NAME");
    p("rm DIR_NAME");
    p("ls");
    p("cat FILE_NAME");
    p("mv FROM TO");
    p("cp FROM TO");
    p("ren OLD_NAME NEW_NAME");
  }

  private void cd(String path) {
    current.getDirectory(path, Flags.create(false), new EntryCallback() {

      @Override
      public void handleEvent(Entry entry) {
        p(entry.getFullPath());
        updateCursor((DirectoryEntry) entry);
      }
    }, errorCallback);
  }

  private void rm(final String path, final boolean recursively) {
    current.getDirectory(path, Flags.create(false), new EntryCallback() {

      @Override
      public void handleEvent(Entry entry) {
        final VoidCallback successCallback = new VoidCallback() {

          @Override
          public void handleEvent() {
            p("Successfully remove folder " + path + (recursively ? " recursively!" : ""));
          }
        };
        if (recursively)
          ((DirectoryEntry) entry).removeRecursively(successCallback, errorCallback);
        else
          entry.remove(successCallback, errorCallback);
      }
    }, new ErrorCallback() {

      @Override
      public void handleEvent(FileError err) {
        if (err.getCode() == ErrorCode.TYPE_MISMATCH_ERR) {
          current.getFile(path, Flags.create(false), new EntryCallback() {

            @Override
            public void handleEvent(Entry entry) {
              entry.remove(new VoidCallback() {

                @Override
                public void handleEvent() {
                  p("Successfully delete file " + path);
                }
              }, errorCallback);
            }
          }, errorCallback);
        } else {
          errorCallback.handleEvent(err);
        }
      }
    });
  }

  private void md(final String path) {
    current.getDirectory(path, Flags.create(true), new EntryCallback() {

      @Override
      public void handleEvent(Entry entry) {
        p("Successfully create folder " + path);
      }
    }, errorCallback);
  }

  private void ls(final DirectoryReader reader) {
    reader.readEntries(new EntriesCallback() {
      @Override
      public void handleEvent(JsArray<Entry> entries) {
        Entry entry;
        for (int i = 0; i < entries.length(); i++) {
          entry = entries.get(i);
          p(entry.getName());
        }
        if (entries.length() != 0)
          ls(reader);
      }
    }, errorCallback);
  }

  public void updateCursor(DirectoryEntry directoryEntry) {
    current = directoryEntry;
    cursor.setText("$" + current.getFullPath() + "> ");
  }

  public void requestQuota(int reqBytes) {
    StorageInfo.requestQuota(LocalFileSystem.TEMPORARY, reqBytes, new QuotaCallback() {

      @Override
      public void handleEvent(int grantedBytes) {
        p("Successfully request quota! Granted " + grantedBytes + " Bytes");
        LocalFileSystem.requestFileSystem(LocalFileSystem.TEMPORARY, 1024 * 1024,
            new FileSystemCallback() {

              @Override
              public void handleEvent(FileSystem fileSystem) {
                p("Successfully request FileSystem! FileSystemName is " + fileSystem.getName());
                updateCursor(fileSystem.getRoot());
                printWelcome();
              }
            }, errorCallback);
      }
    }, errorCallback);
  }
}

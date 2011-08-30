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
package com.google.gwt.fileAPI.fileUpload;

/**
 * @author Chan Le <gwt /at/ chanvn.com>
 * @see <a
 *      href="http://www.w3.org/TR/file-upload/#ErrorDescriptions">http://www.w3.org/TR/file-upload/#ErrorDescriptions</a>
 */
public enum ErrorCode {
  NOT_FOUND_ERR {
    public short getValue() {
      return 1;
    }
  },
  SECURITY_ERR {
    public short getValue() {
      return 2;
    }
  },
  ABORT_ERR {
    public short getValue() {
      return 3;
    }
  },
  NOT_READABLE_ERR {
    public short getValue() {
      return 4;
    }
  },
  ENCODING_ERR {
    public short getValue() {
      return 5;
    }
  },
  NO_MODIFICATION_ALLOWED_ERR {
    public short getValue() {
      return 6;
    }
  },
  INVALID_STATE_ERR {
    public short getValue() {
      return 7;
    }
  },
  SYNTAX_ERR {
    public short getValue() {
      return 8;
    }
  },
  INVALID_MODIFICATION_ERR {
    public short getValue() {
      return 9;
    }
  },
  QUOTA_EXCEEDED_ERR {
    public short getValue() {
      return 10;
    }
  },
  TYPE_MISMATCH_ERR {
    public short getValue() {
      return 11;
    }
  },
  PATH_EXISTS_ERR {
    public short getValue() {
      return 12;
    }
  };
  public abstract short getValue();

  public static ErrorCode fromValue(short value) {
    switch (value) {
      case 1:
        return NOT_FOUND_ERR;
      case 2:
        return SECURITY_ERR;
      case 3:
        return ABORT_ERR;
      case 4:
        return NOT_READABLE_ERR;
      case 5:
        return ENCODING_ERR;
      case 6:
        return NO_MODIFICATION_ALLOWED_ERR;
      case 7:
        return INVALID_STATE_ERR;
      case 8:
        return SYNTAX_ERR;
      case 9:
        return INVALID_MODIFICATION_ERR;
      case 10:
        return QUOTA_EXCEEDED_ERR;
      case 11:
        return TYPE_MISMATCH_ERR;
      case 12:
        return PATH_EXISTS_ERR;
      default:
        throw new IllegalStateException("Bad error code value " + value);
    }
  }
}

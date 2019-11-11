/*
 *    Copyright 2018-2019 Prebid.org, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.prebid.mobile;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class NativeEventTracker {
    public enum EVENT_TYPE {
        IMPRESSION(1),
        VIEWABLE_MRC50(2),
        VIEWABLE_MRC100(3),
        VIEWABLE_VIDEO50(4),
        CUSTOM(500);
        private int id;

        EVENT_TYPE(final int id) {
            this.id = id;
        }

        public int getID() {
            return this.id;
        }

        public void setID(int id) {
            if (this.equals(CUSTOM) && id >= 500) {
                this.id = id;
            }
        }
    }

    public enum EVENT_TRACKING_METHOD {
        IMAGE(1),
        JS(2),
        CUSTOM(500);
        private int id;

        EVENT_TRACKING_METHOD(final int id) {
            this.id = id;
        }

        public int getID() {
            return this.id;
        }

        public void setID(int id) {
            if (this.equals(CUSTOM) && id >= 500) {
                this.id = id;
            }
        }
    }

    EVENT_TYPE event;
    ArrayList<EVENT_TRACKING_METHOD> methods;
    Object extObject;

    public NativeEventTracker(EVENT_TYPE event, ArrayList<EVENT_TRACKING_METHOD> methods) throws Exception {
        this.event = event;
        if (methods == null || methods.isEmpty()) {
            throw new Exception("Methods are required");
        }
        this.methods = methods;
    }

    public void setExt(Object extObject) {
        if (extObject instanceof JSONObject || extObject instanceof JSONArray) {
            this.extObject = extObject;
        }
    }

    public EVENT_TYPE getEvent() {
        return event;
    }

    public ArrayList<EVENT_TRACKING_METHOD> getMethods() {
        return methods;
    }

    public Object getExtObject() {
        return extObject;
    }
}

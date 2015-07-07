package fu.hao.uidroid_accessibility;

/**
 * Created by watershed2106 on 7/6/15.
 */

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

@SuppressLint("NewApi")
public class MyAccessibility extends AccessibilityService {
    private static final String TAG = "MyAccessibility";
    // String[] PACKAGES = { "com.android.settings" };

    @Override
    protected void onServiceConnected() {
        Log.i(TAG, "config success!");
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        // accessibilityServiceInfo.packageNames = PACKAGES;
        accessibilityServiceInfo.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        accessibilityServiceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;
        accessibilityServiceInfo.notificationTimeout = 1000;
        setServiceInfo(accessibilityServiceInfo);
    }

    @SuppressLint("NewApi")
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // TODO Auto-generated method stub
        int eventType = event.getEventType();
        String eventText = "";
        Log.i(TAG, "==============Start====================");
        switch (eventType) {
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
                eventText = "TYPE_VIEW_CLICKED";
                try {
                    AccessibilityNodeInfo noteInfo = event.getSource();
                    Log.i(TAG, noteInfo.toString());
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                    break;
                }
                break;
            case AccessibilityEvent.TYPE_VIEW_FOCUSED:
                eventText = "TYPE_VIEW_FOCUSED";
                break;
            case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:
                eventText = "TYPE_VIEW_LONG_CLICKED";
                break;
            case AccessibilityEvent.TYPE_VIEW_SELECTED:
                eventText = "TYPE_VIEW_SELECTED";
                break;
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
                eventText = "TYPE_VIEW_TEXT_CHANGED";
                break;
            case AccessibilityEvent.TYPE_ANNOUNCEMENT:
                eventText = "TYPE_ANNOUNCEMENT";
                break;
            case AccessibilityEvent.TYPE_VIEW_SCROLLED:
                eventText = "TYPE_VIEW_SCROLLED";
                break;
            case AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED:
                eventText = "TYPE_VIEW_TEXT_SELECTION_CHANGED";
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                // represents the event of opening a PopupWindow, Menu, Dialog, etc
                eventText = "TYPE_WINDOW_STATE_CHANGED";
                break;
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
                // represents the event of change in the content of a window.
                // This change can be adding/removing view, changing a view size, etc
                eventText = "TYPE_WINDOW_CONTENT_CHANGED";
                break;
            //case AccessibilityEvent.TYPE_WINDOWS_CHANGED:
                // eventText = "TYPE_WINDOW_CHANGED";
                // break;
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                eventText = "TYPE_NOTIFICATION_STATE_CHANGED";
                break;
            case AccessibilityEvent.TYPE_VIEW_HOVER_ENTER:
                eventText = "TYPE_VIEW_HOVER_ENTER";
                break;
            case AccessibilityEvent.TYPE_VIEW_HOVER_EXIT:
                eventText = "TYPE_VIEW_HOVER_EXIT";
                break;
            case AccessibilityEvent.TYPE_TOUCH_INTERACTION_START:
                eventText = "TYPE_TOUCH_INTERACTION_START";
                break;
            case AccessibilityEvent.TYPE_TOUCH_INTERACTION_END:
                eventText = "TYPE_TOUCH_INTERACTION_END";
                break;
            case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START:
                eventText = "TYPE_TOUCH_EXPLORATION_GESTURE_START";
                break;
            case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_END:
                eventText = "TYPE_TOUCH_EXPLORATION_GESTURE_END";
                break;

        }
        eventText = eventText + ":" + eventType;
        Log.i(TAG, eventText);
        Log.i(TAG, "=============END=====================");
    }

    @Override
    public void onInterrupt() {
        // TODO Auto-generated method stub

    }

}

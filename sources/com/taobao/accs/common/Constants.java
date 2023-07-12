package com.taobao.accs.common;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Constants {
    public static final String ACTION_ACCS_CONNECT_INFO = "com.taobao.ACCS_CONNECT_INFO";
    public static final String ACTION_CHANNEL_CONNECTION_CHANGED = "com.taobao.accs.intent.action.CHANNEL_CONNECTION_CHANGED";
    public static final String ACTION_CLOSE_CONNECTION = "com.taobao.accs.intent.action.CLOSE_CONNECTION";
    public static final String ACTION_COMMAND = "com.taobao.accs.intent.action.COMMAND";
    public static final String ACTION_CONNECT_INFO = "com.taobao.accs.intent.action.CONNECTINFO";
    public static final String ACTION_PING = "org.agoo.android.intent.action.PING_V4";
    public static final String ACTION_RECEIVE = "com.taobao.accs.intent.action.RECEIVE";
    public static final String ACTION_RESET_REG_ID = "com.taobao.accs.intent.action.RESET_REG_ID";
    public static final String ACTION_SEND = "com.taobao.accs.intent.action.SEND";
    public static final String ACTION_SENDMESSAGE_INMAIN = "com.taobao.accs.intent.action.SENDMESSAGE_INMAIN";
    public static final String ACTION_START_FROM_AGOO = "com.taobao.accs.intent.action.START_FROM_AGOO";
    public static final String ACTION_START_SERVICE = "com.taobao.accs.intent.action.START_SERVICE";
    public static final String CHANNEL_PROCESS_NAME = "com.taobao.taobao:channel";
    public static final long CLIENT_FLUSH_INTERVAL = 86400000;
    public static final int COMMAND_ANTI_BRUSH = 104;
    public static final int COMMAND_BIND_APP = 1;
    public static final int COMMAND_BIND_SERVICE = 5;
    public static final int COMMAND_BIND_USER = 3;
    public static final int COMMAND_CONNECT_INFO = 103;
    public static final int COMMAND_HANDSHAKE = 200;
    public static final int COMMAND_PING = 201;
    public static final int COMMAND_RECEIVE_DATA = 101;
    public static final int COMMAND_ROUTING_ACK = 106;
    public static final int COMMAND_SEND_DATA = 100;
    public static final int COMMAND_SEND_STATIST = 102;
    public static final int COMMAND_UNBIND_APP = 2;
    public static final int COMMAND_UNBIND_SERVICE = 6;
    public static final int COMMAND_UNBIND_USER = 4;
    public static final int COMPRESS_GZIP = 1;
    public static final int COMPRESS_NONE = 0;
    public static final String DB_NAME = "accs.db";
    public static final int DB_VERSION = 3;
    public static final int DEBUG = 2;
    public static final String IMPAAS = "accs-impaas";
    public static final String KEY_ACCS_TOKEN = "accsToken";
    public static final String KEY_AGOO_CONTROL = "agooControl";
    public static final String KEY_AGOO_TOKEN = "deviceToken";
    public static final String KEY_ANTI_BRUSH_COOKIE = "anti_brush_cookie";
    public static final String KEY_ANTI_BRUSH_RET = "anti_brush_ret";
    public static final String KEY_APP_KEY = "appKey";
    public static final String KEY_APP_SECRET = "app_sercet";
    public static final String KEY_APP_VERSION = "appVersion";
    public static final String KEY_APP_VERSION_CODE = "appVersionCode";
    public static final String KEY_APP_VERSION_NAME = "appVersionName";
    public static final String KEY_BRAND = "brand";
    public static final String KEY_BUSINESSID = "businessId";
    public static final String KEY_CENTER_HOST = "is_center_host";
    public static final String KEY_COMMAND = "command";
    public static final String KEY_CONFIG_TAG = "configTag";
    public static final String KEY_CONNECT_AVAILABLE = "connect_avail";
    public static final String KEY_CONNECT_INFO = "connect_info";
    public static final String KEY_CONN_TYPE = "conn_type";
    public static final String KEY_CONTROL = "control";
    public static final String KEY_CYCLE_CUT_OFF_TIME = "cycleCutOffTime";
    public static final String KEY_CYCLE_INTERVAL = "cycleInterval";
    public static final String KEY_DATA = "data";
    public static final String KEY_DATA_ID = "dataId";
    public static final String KEY_DELAY_CEILING = "delayCeiling";
    public static final String KEY_DEVICE_TOKEN = "deviceToken";
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_ERROR_DETAIL = "errorDetail";
    public static final String KEY_EVENT_COLLECT_CONTROL = "eventCollectControl";
    public static final String KEY_EVENT_COLLECT_EVENT_ID_LIST = "eventIdList";
    public static final String KEY_EVENT_COLLECT_RANDOM_TIME_LIMIT = "randomTimeLimit";
    public static final String KEY_EVENT_COLLECT_REPORT_INTERVAL = "reportInterval";
    public static final String KEY_EVENT_COLLECT_STRATEGY = "eventCollectStrategy";
    public static final String KEY_EVENT_COLLECT_SWITCH = "switch";
    public static final String KEY_EVENT_LIST = "eventList";
    public static final String KEY_EVENT_TIMES = "eventTimes";
    public static final String KEY_EXTS = "exts";
    public static final String KEY_EXT_TAG = "extTag";
    public static final String KEY_FLAGS = "flags";
    public static final String KEY_FOUCE_BIND = "fouce_bind";
    public static final String KEY_FOUCE_DISABLE = "fouce_disable";
    public static final String KEY_HOST = "host";
    public static final String KEY_HTTP_CODE = "code";
    public static final String KEY_IMEI = "imei";
    public static final String KEY_IMSI = "imsi";
    public static final String KEY_LOG_TAG = "logTag";
    public static final String KEY_MD5_PKGS = "md5Pkgs";
    public static final String KEY_MODE = "mode";
    public static final String KEY_MODEL = "model";
    public static final String KEY_MONIROT = "monitor";
    public static final String KEY_NEED_BUSINESS_ACK = "bizAck";
    public static final String KEY_OS_TYPE = "osType";
    public static final String KEY_OS_VERSION = "os";
    public static final String KEY_PACKAGE = "package";
    public static final String KEY_PACKAGES = "packages";
    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_PACKAGE_NAMES = "packageNames";
    public static final String KEY_PROXY_HOST = "proxy_host";
    public static final String KEY_PROXY_PORT = "proxy_port";
    public static final String KEY_PULL_SCENE = "pullScene";
    public static final String KEY_REGID = "regId";
    public static final String KEY_REG_ID = "regId";
    public static final String KEY_SDK_VERSION = "sdkVersion";
    public static final String KEY_SECURITY_SIGN = "sign";
    public static final String KEY_SEND_REQDATA = "reqdata";
    public static final String KEY_SEND_TYPE = "send_type";
    public static final String KEY_SERVICE_ID = "serviceId";
    public static final String KEY_SID = "sid";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_START = "start";
    public static final String KEY_STRATEGY = "strategy";
    public static final String KEY_SUBMIT_APP_RES = "submitAppRes";
    public static final String KEY_TARGET = "target";
    public static final String KEY_TIMES = "times";
    public static final String KEY_TOKEN_REPORT_STATUS = "tokenReportStatus";
    public static final String KEY_TTID = "ttid";
    public static final String KEY_TYPE_INAPP = "type_inapp";
    public static final String KEY_USER_ID = "userInfo";
    public static final String KEY_VENDEROSNAME = "venderOsName";
    public static final String KEY_VENDEROSVERSION = "venderOsVersion";
    public static final String KEY_VERSION = "version";
    public static final String KEY_X_REGID = "x-regid";
    public static final String KYE_MAC_ADDRESS = "macAddress";
    public static final int NODE_REAR = 1;
    public static final int OS_ANDROID = 1;
    public static final int PORT = 443;
    public static final int PREVIEW = 1;
    public static final byte PROTOCOL_VERSION = 2;
    public static final int RELEASE = 0;
    public static final int SDK_VERSION_CODE = 221;
    public static final String SEND_TYPE_RES = "res";
    public static final String SHARED_FOLDER = "accs";
    public static final String SHARED_MESSAGE_ID_FILE = "message";
    public static final String SP_APPKEY_FILE_NAME = "ACCS_SDK_APPKEY";
    public static final String SP_APP_SECRET = "app_sercet";
    public static final String SP_CHANNEL_FILE_NAME = "ACCS_SDK_CHANNEL";
    public static final String SP_CHANNEL_INIT_OPTIMIZE_ENABLE = "channel_init_optimize_enable";
    public static final String SP_CHANNEL_REGISTER_RECEIVER = "channel_register_receiver";
    public static final String SP_COOKIE_FILE_NAME = "ACCS_COOKIE";
    public static final String SP_FILE_NAME = "ACCS_SDK";
    public static final String SP_KEY_ALIAS_ALARM_SWITCH = "alias_alarm_switch";
    public static final String SP_KEY_APPKEY = "appkey";
    public static final String SP_KEY_ASP_ENABLE = "asp_enable";
    public static final String SP_KEY_BACK_INTERVAL = "back_interval";
    public static final String SP_KEY_CONNECT_TIMEOUT = "connect_timeout";
    public static final String SP_KEY_CONN_AUTO_SWITCH = "conn_auto_switch_channel";
    public static final String SP_KEY_CONN_SERVICE_TYPE = "connection_service_type";
    public static final String SP_KEY_COOKIE_SEC = "cookie_sec";
    public static final String SP_KEY_DEBUG_MODE = "debug_mode";
    public static final String SP_KEY_DEFAULT_APPKEY = "defaultAppkey";
    public static final String SP_KEY_ELECTION_ENABLE = "election_enable";
    public static final String SP_KEY_EVENT_TRIGGER_TIMES = "event_trigger_times";
    public static final String SP_KEY_FORE_BG_IN_MESSAGE_SWITCH = "fb_message_state_switch";
    public static final String SP_KEY_FORE_INTERVAL = "fore_interval";
    public static final String SP_KEY_GLOBAL_CHANNEL_ENABLE = "global_channel_enable";
    public static final String SP_KEY_HB_SMART_ENABLE = "smart_hb_enable";
    public static final String SP_KEY_KEEP_ALIVE_INIT_ENABLE = "keep_alive_init_enable";
    public static final String SP_KEY_LAST_EVENT_TRIGGER_TIME = "last_event_trigger_time";
    public static final String SP_KEY_LAST_LAUNCH_TIME = "last_launch_time";
    public static final String SP_KEY_LAST_TRIGGER_TIME = "last_trigger_time";
    public static final String SP_KEY_LOAD_SO_TIMES = "load_so_times";
    public static final String SP_KEY_NATIVE_ACCS_SWITCH = "native_accs_switch";
    public static final String SP_KEY_NORMAL_SWITCH = "accs_normal_switch";
    public static final String SP_KEY_NOTIFICATION_STATE = "notification_state";
    public static final String SP_KEY_REG_ID = "regid";
    public static final String SP_KEY_REG_ID_ENABLE = "regid_enable";
    public static final String SP_KEY_SEND_FORE_STATE_HB_SWITCH = "send_fore_state_in_hb";
    public static final String SP_KEY_SERVICE_END = "service_end";
    public static final String SP_KEY_SERVICE_START = "service_start";
    public static final String SP_KEY_SET_MAX_THREADS_ENABLE = "set_max_threads_enable";
    public static final String SP_KEY_SPDY_CONNECTION_SLEEP_ENABLE = "spdy_connect_sleep_enable";
    public static final String SP_KEY_TRIGGER_TIMES = "trigger_times";
    public static final String SP_KEY_UPDATE_DONE = "update_done";
    public static final String SP_KEY_UPDATE_FOLDER = "update_folder";
    public static final String SP_KEY_UPDATE_VERSION = "update_verion";
    public static final String SP_KEY_UP_RETRY_IDS = "up_retry_ids";
    public static final String SP_KEY_UTDID = "utdid";
    public static final String SP_KEY_VERSION = "version";
    public static final String SP_LOAD_SO_FILE_NAME = "ACCS_LOAD_SO";
    public static final String TARGET_BACK = "4|sal|bg";
    public static final String TARGET_CONTROL = "3|dm|";
    public static final String TARGET_FORE = "4|sal|fg";
    public static final String TARGET_SERVICE = "4|";
    public static final String TARGET_SERVICE_AGOO_CONTROL = "agooControl";
    public static final String TARGET_SERVICE_EVENT_COLLECT = "eventCollect";
    public static final String TARGET_SERVICE_MASS = "accs-mass";
    public static final String TARGET_SERVICE_PRE = "2|";
    public static final String TARGET_SERVICE_ST = "4|sal|st";
    public static final long TIMEOUT_PING = 10000;
    public static final long TIME_ONE_DAY = 86400000;
    public static final String UPDATE_DEX_FILE = "accs.zip";
    public static final boolean UT_OFF = false;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class AB {
        public static final String KEY_ACCS_HEARTBEAT = "accs_owner_heartbeat";
        public static final String KEY_CONN_SERVICE_TYPE_AW = "connection_service_type_aw";
        public static final String KEY_CONN_SERVICE_TYPE_CB = "connection_service_type_combine";
        public static final String KEY_INAPP_PING = "accs_bugfix_inapp_ping";
        public static final String KEY_UP_RETRY_IMPAAS = "up_retry_impaas";
    }
}

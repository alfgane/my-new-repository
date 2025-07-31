package com.quranapp.islamic;

import android.app.Application;
import android.util.Log;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import dagger.hilt.android.HiltAndroidApp;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import javax.inject.Inject;

/**
 * تطبيق Android الرئيسي مع تكوين Hilt و Firebase
 */
@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/quranapp/islamic/QuranApplication;", "Landroid/app/Application;", "Landroidx/work/Configuration$Provider;", "()V", "workManagerConfiguration", "Landroidx/work/Configuration;", "getWorkManagerConfiguration", "()Landroidx/work/Configuration;", "setWorkManagerConfiguration", "(Landroidx/work/Configuration;)V", "initializeAnalytics", "", "initializeCrashlytics", "initializeFirebase", "initializeWorkManager", "onCreate", "Companion", "app_debug"})
public final class QuranApplication extends android.app.Application implements androidx.work.Configuration.Provider {
    @javax.inject.Inject()
    public androidx.work.Configuration workManagerConfiguration;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "QuranApplication";
    private static com.quranapp.islamic.QuranApplication instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.quranapp.islamic.QuranApplication.Companion Companion = null;
    
    public QuranApplication() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.work.Configuration getWorkManagerConfiguration() {
        return null;
    }
    
    public void setWorkManagerConfiguration(@org.jetbrains.annotations.NotNull()
    androidx.work.Configuration p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    /**
     * تهيئة Firebase
     */
    private final void initializeFirebase() {
    }
    
    /**
     * تهيئة Crashlytics لمراقبة الأخطاء
     */
    private final void initializeCrashlytics() {
    }
    
    /**
     * تهيئة Analytics لتتبع الاستخدام
     */
    private final void initializeAnalytics() {
    }
    
    /**
     * تهيئة WorkManager للمهام في الخلفية
     */
    private final void initializeWorkManager() {
    }
    
    /**
     * توفير تكوين WorkManager
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.work.Configuration getWorkManagerConfiguration() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/quranapp/islamic/QuranApplication$Companion;", "", "()V", "TAG", "", "<set-?>", "Lcom/quranapp/islamic/QuranApplication;", "instance", "getInstance", "()Lcom/quranapp/islamic/QuranApplication;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.quranapp.islamic.QuranApplication getInstance() {
            return null;
        }
    }
}
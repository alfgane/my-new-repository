package com.quranapp.islamic.data.database.dao;

import androidx.room.*;
import com.quranapp.islamic.data.database.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007H\'J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/quranapp/islamic/data/database/dao/ReadingProgressDao;", "", "getAllReadingProgress", "", "Lcom/quranapp/islamic/data/database/entities/ReadingProgressEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProgress", "Lkotlinx/coroutines/flow/Flow;", "saveProgress", "", "progress", "(Lcom/quranapp/islamic/data/database/entities/ReadingProgressEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ReadingProgressDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveProgress(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.entities.ReadingProgressEntity progress, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM reading_progress WHERE id = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.quranapp.islamic.data.database.entities.ReadingProgressEntity> getProgress();
    
    @androidx.room.Query(value = "SELECT * FROM reading_progress")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllReadingProgress(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.quranapp.islamic.data.database.entities.ReadingProgressEntity>> $completion);
}
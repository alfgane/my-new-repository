package com.quranapp.islamic.data.database.dao;

import androidx.room.*;
import com.quranapp.islamic.data.database.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u000e\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/quranapp/islamic/data/database/dao/AyahDao;", "", "getAyahsForSurah", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/quranapp/islamic/data/database/entities/AyahEntity;", "surahNumber", "", "getTotalAyahCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "", "ayahs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface AyahDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.quranapp.islamic.data.database.entities.AyahEntity> ayahs, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM ayah WHERE surah_number = :surahNumber ORDER BY ayah_number ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.quranapp.islamic.data.database.entities.AyahEntity>> getAyahsForSurah(int surahNumber);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM ayah")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalAyahCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}
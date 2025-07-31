package com.quranapp.islamic.data.database.dao;

import androidx.room.*;
import com.quranapp.islamic.data.database.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/quranapp/islamic/data/database/dao/NoteDao;", "", "getAllNotes", "", "Lcom/quranapp/islamic/data/database/entities/NoteEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNoteCount", "", "getNoteForAyah", "ayahId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveNote", "", "note", "(Lcom/quranapp/islamic/data/database/entities/NoteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface NoteDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveNote(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.entities.NoteEntity note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM note WHERE ayah_id = :ayahId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNoteForAyah(int ayahId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.quranapp.islamic.data.database.entities.NoteEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM note")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllNotes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.quranapp.islamic.data.database.entities.NoteEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM note")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNoteCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}
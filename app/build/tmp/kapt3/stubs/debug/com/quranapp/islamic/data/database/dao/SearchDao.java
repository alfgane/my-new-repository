package com.quranapp.islamic.data.database.dao;

import androidx.room.*;
import com.quranapp.islamic.data.database.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\b"}, d2 = {"Lcom/quranapp/islamic/data/database/dao/SearchDao;", "", "searchAyahs", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/quranapp/islamic/data/database/entities/AyahEntity;", "query", "", "app_debug"})
@androidx.room.Dao()
public abstract interface SearchDao {
    
    @androidx.room.Query(value = "SELECT * FROM ayah WHERE id IN (SELECT docid FROM ayah_fts WHERE ayah_fts MATCH :query)")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.quranapp.islamic.data.database.entities.AyahEntity>> searchAyahs(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
}
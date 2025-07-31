package com.quranapp.islamic.data.database;

import com.quranapp.islamic.data.database.dao.NoteDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DatabaseModule_ProvideNoteDaoFactory implements Factory<NoteDao> {
  private final Provider<QuranDatabase> databaseProvider;

  public DatabaseModule_ProvideNoteDaoFactory(Provider<QuranDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public NoteDao get() {
    return provideNoteDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideNoteDaoFactory create(
      Provider<QuranDatabase> databaseProvider) {
    return new DatabaseModule_ProvideNoteDaoFactory(databaseProvider);
  }

  public static NoteDao provideNoteDao(QuranDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideNoteDao(database));
  }
}

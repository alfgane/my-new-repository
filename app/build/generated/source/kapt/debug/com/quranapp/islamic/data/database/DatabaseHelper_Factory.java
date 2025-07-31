package com.quranapp.islamic.data.database;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseHelper_Factory implements Factory<DatabaseHelper> {
  private final Provider<QuranDatabase> databaseProvider;

  public DatabaseHelper_Factory(Provider<QuranDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public DatabaseHelper get() {
    return newInstance(databaseProvider.get());
  }

  public static DatabaseHelper_Factory create(Provider<QuranDatabase> databaseProvider) {
    return new DatabaseHelper_Factory(databaseProvider);
  }

  public static DatabaseHelper newInstance(QuranDatabase database) {
    return new DatabaseHelper(database);
  }
}

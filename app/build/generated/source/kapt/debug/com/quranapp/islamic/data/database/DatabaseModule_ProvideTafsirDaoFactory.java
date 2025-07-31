package com.quranapp.islamic.data.database;

import com.quranapp.islamic.data.database.dao.TafsirDao;
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
public final class DatabaseModule_ProvideTafsirDaoFactory implements Factory<TafsirDao> {
  private final Provider<QuranDatabase> databaseProvider;

  public DatabaseModule_ProvideTafsirDaoFactory(Provider<QuranDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public TafsirDao get() {
    return provideTafsirDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideTafsirDaoFactory create(
      Provider<QuranDatabase> databaseProvider) {
    return new DatabaseModule_ProvideTafsirDaoFactory(databaseProvider);
  }

  public static TafsirDao provideTafsirDao(QuranDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTafsirDao(database));
  }
}

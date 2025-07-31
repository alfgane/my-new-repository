package com.quranapp.islamic;

import androidx.work.Configuration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class ApplicationModule_ProvideWorkManagerConfigurationFactory implements Factory<Configuration> {
  @Override
  public Configuration get() {
    return provideWorkManagerConfiguration();
  }

  public static ApplicationModule_ProvideWorkManagerConfigurationFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Configuration provideWorkManagerConfiguration() {
    return Preconditions.checkNotNullFromProvides(ApplicationModule.INSTANCE.provideWorkManagerConfiguration());
  }

  private static final class InstanceHolder {
    private static final ApplicationModule_ProvideWorkManagerConfigurationFactory INSTANCE = new ApplicationModule_ProvideWorkManagerConfigurationFactory();
  }
}

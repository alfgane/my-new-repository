package com.quranapp.islamic;

import androidx.work.Configuration;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class QuranApplication_MembersInjector implements MembersInjector<QuranApplication> {
  private final Provider<Configuration> workManagerConfigurationProvider;

  public QuranApplication_MembersInjector(
      Provider<Configuration> workManagerConfigurationProvider) {
    this.workManagerConfigurationProvider = workManagerConfigurationProvider;
  }

  public static MembersInjector<QuranApplication> create(
      Provider<Configuration> workManagerConfigurationProvider) {
    return new QuranApplication_MembersInjector(workManagerConfigurationProvider);
  }

  @Override
  public void injectMembers(QuranApplication instance) {
    injectWorkManagerConfiguration(instance, workManagerConfigurationProvider.get());
  }

  @InjectedFieldSignature("com.quranapp.islamic.QuranApplication.workManagerConfiguration")
  public static void injectWorkManagerConfiguration(QuranApplication instance,
      Configuration workManagerConfiguration) {
    instance.workManagerConfiguration = workManagerConfiguration;
  }
}

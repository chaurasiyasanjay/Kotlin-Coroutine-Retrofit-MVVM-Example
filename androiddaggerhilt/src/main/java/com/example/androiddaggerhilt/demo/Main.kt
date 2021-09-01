package com.example.androiddaggerhilt.demo

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier

class Main @Inject constructor(@FName private val fName: String, @LName private val lName: String) {
    fun getName() {
        Log.e("main", "my name is $fName $lName")
    }
}

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @FName
    fun getFirstName(): String = "sanjay"

    @Provides
    @LName
    fun getLastName(): String = "chaurasiya"

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LName

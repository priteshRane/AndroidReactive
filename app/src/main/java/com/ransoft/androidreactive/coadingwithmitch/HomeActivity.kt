package com.ransoft.androidreactive.coadingwithmitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.ransoft.androidreactive.R
import com.ransoft.androidreactive.coadingwithmitch.data.DataSource
import com.ransoft.androidreactive.coadingwithmitch.data.modal.Task
import com.ransoft.androidreactive.databinding.ActivityHomeBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.functions.Predicate

class HomeActivity : AppCompatActivity() {

    private val TAG = "TASK OBSERVER"

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val taskObservable: Observable<Task> = Observable
            .fromIterable(DataSource().createTaskList())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        // In background
        taskObservable.filter(object : Predicate<Task> {
            override fun test(t: Task?): Boolean {
                Log.d(TAG, "test: " + Thread.currentThread().name)
                Thread.sleep(1000)
                return t?.isCompelete!!
            }
        })

        taskObservable.subscribe(object : Observer<Task> {
            override fun onComplete() {
                Log.d(TAG, "onComplete: called.")
            }

            override fun onSubscribe(d: Disposable?) {
                Log.d(TAG, "onSubscribe: called")
            }

            override fun onNext(t: Task?) {
                Log.d(TAG, "onNext: " + Thread.currentThread().name)
                Log.d(TAG, "onNext: " + t?.description)
                // in Main thread occurs problem to UI
                // Thread.sleep(1000)
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, "onError: ", e)
            }
        })
    }
}
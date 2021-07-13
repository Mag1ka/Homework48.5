package com.pochitaev.homework485

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.core.Observable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    val groupBy = Observable.just(1, 2, 3, 4, -5, -8, -99, 50 )
            .groupBy { it < 0 }
            .flatMapSingle {
                it.toList()
            }
            .subscribe {
                println("!!! $it")
            }
    val skipUntil = Observable.just(-1, -2, 3, -4, 5)
            .skipWhile { it < 0 }
            .subscribe {
                println("!!! $it")
            }
    val takeWhile = Observable.just("Мама", "Папа", "Брат", "Дерево", "Сестра", "Ребёнок")
            .takeWhile { it.length < 6 }
            .subscribe {
                println("!!! $it")
            }
    val takeuntil = Observable.just("Мама", "Папа", "Брат", "Дерево", "stop", "Ребёнок")
            .takeUntil { it == "stop" }
            .subscribe {
                println("!!! $it")
            }
}




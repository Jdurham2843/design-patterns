package creational

/*
There are a couple of ways to do this

In Kotlin we could just declare an object which will allow only a single instance.
In Java, we could create a class with static factory method and a private constructor. To protect against java reflection,
the programmer could throw an exception if a second invocation of the private constructor is called.

In both languages we could also just use enums.
 */

enum class SingletonOne(name: String) {
    Greet("Hello friend!")
}

object SingletonTwo {
    private val hello = "hello "

    fun greet(name: String) {
        println(hello + name)
    }
}

class SingletonThree private constructor(val greeting: String) {
    companion object {
        lateinit var singletonThree: SingletonThree
        fun Instance(): SingletonThree {
            if (singletonThree == null) {
                singletonThree = SingletonThree("hello there, ")
            }

            return singletonThree
        }
    }

    fun greet(name: String) {
        println(greeting + name)
    }
}
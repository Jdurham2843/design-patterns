package structural

// https://java-design-patterns.com/patterns/adapter/

interface RowingBoat {
    fun row()
}

// Adaptee
class FishingBoat {
    fun sail() {
        println("The fishing boat is sailing")
    }
}

class Captain(private val rowingBoat: RowingBoat) : RowingBoat {
    override fun row() {
        rowingBoat.row()
    }
}

/**
 * This an example of a Class based adapter.
 */
class FishingBoatAdapter() : RowingBoat {
    private val boat: FishingBoat = FishingBoat()

    override fun row() {
        boat.sail()
    }
}

fun runAdapter() {
    val captain = Captain(FishingBoatAdapter())

    captain.row()
}
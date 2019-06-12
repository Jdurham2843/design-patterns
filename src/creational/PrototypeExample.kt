package creational

// https://www.dofactory.com/net/prototype-design-pattern

fun runProto() {
    val colorManager = ColorManager()

    val colorMap = mapOf<String, ColorPrototype>(
        "red" to Color(255, 0, 0),
        "green" to Color(0, 255, 0),
        "blue" to Color(0, 0, 255),
        "angry" to Color(255, 54, 0),
        "peace" to Color(128, 211, 128),
        "flame" to Color(211, 34, 20)
    )

    colorMap.entries.forEach {
        colorManager.set(it.key, it.value)
    }

    val color1 = colorManager["red"]?.clone() as Color
    val color2 = colorManager["peace"]?.clone() as Color
    val color3 = colorManager["flame"]?.clone() as Color
}

interface ColorPrototype {
    fun clone() : ColorPrototype
}

class Color(val red: Int, val green: Int, val blue: Int) : ColorPrototype {
    override fun clone(): ColorPrototype {
        println("Cloning color RGB: $red, $green, $blue")

        return Color(red, green, blue)
    }
}

class ColorManager{
    private val colors = HashMap<String, ColorPrototype>()

    operator fun get(key: String) : ColorPrototype? {
        return colors[key]
    }

    fun set(key: String, value: ColorPrototype) {
        colors.put(key, value)
    }
}


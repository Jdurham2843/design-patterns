package structural

import java.util.*

/**
 * https://java-design-patterns.com/patterns/flyweight/
 */

interface Potion {
    fun drink()
}

class HealingPotion : Potion {
    override fun drink() {
        println("You feel healed. (Potion=${this.hashCode()}")
    }
}

class HolyWaterPotion : Potion {
    override fun drink() {
        println("You feel blessed. (Potion=${this.hashCode()}")
    }
}

class InvisibilityPotion : Potion {
    override fun drink() {
        println("You become invisible. (Potion=${this.hashCode()}")
    }
}

enum class PotionType {
    Healing,
    HolyWater,
    Invisibility;
}

class PotionFactory {
    private var potions = EnumMap<PotionType, Potion>(PotionType::class.java)

    fun createPotion(type: PotionType) : Potion {
        var potion = potions.get(type)
        if (potion == null) {
            when(type) {
                PotionType.Healing -> {
                    potion = HealingPotion()
                    potions.put(type, potion)
                }
                PotionType.HolyWater -> {
                    potion = HolyWaterPotion()
                    potions.put(type, potion)
                }
                PotionType.Invisibility -> {
                    potion = InvisibilityPotion()
                    potions.put(type, potion)
                }
            }
        }
        return potion
    }
}

fun runFlyweight() {
    val factory = PotionFactory()
    factory.createPotion(PotionType.Invisibility).drink()
    factory.createPotion(PotionType.Healing).drink()
    factory.createPotion(PotionType.Invisibility).drink()
    factory.createPotion(PotionType.HolyWater).drink()
    factory.createPotion(PotionType.HolyWater).drink()
    factory.createPotion(PotionType.Healing).drink()
}